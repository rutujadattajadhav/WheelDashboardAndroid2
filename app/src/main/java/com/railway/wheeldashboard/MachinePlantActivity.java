package com.railway.wheeldashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.railway.wheeldashboard.client.RetrofitClientInstance;
import com.railway.wheeldashboard.machine.Machine;
import com.railway.wheeldashboard.machine.MachineApiService;
import com.railway.wheeldashboard.machine.MachineTableAdapter;
import com.railway.wheeldashboard.machine.TableResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MachinePlantActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MachineTableAdapter adapter;
    private TextView totalPagesTextView, pageIndicator;
    private int currentPage = 0;
    private int totalPages = 1;
    private String search = "";
    private Button prevButton, nextButton;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_plant);

        recyclerView = findViewById(R.id.recyclerView);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        pageIndicator = findViewById(R.id.pageIndicator);
        searchView = findViewById(R.id.searchView);
        totalPagesTextView = findViewById(R.id.totalPagesTextView);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        adapter = new MachineTableAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // Load initial data
        loadData(currentPage, search);

        // Search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search = query;
                currentPage = 0; // Reset to first page on new search
                loadData(currentPage, search);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false; // No action needed on text change
            }
        });

        // Next page button
        nextButton.setOnClickListener(v -> {
            if (currentPage < totalPages - 1) {
                currentPage++;
                loadData(currentPage, search);
            } else {
                Toast.makeText(MachinePlantActivity.this, "No more pages", Toast.LENGTH_SHORT).show();
            }
        });

        // Previous page button
        prevButton.setOnClickListener(v -> {
            if (currentPage > 0) {
                currentPage--;
                loadData(currentPage, search);
            } else {
                Toast.makeText(MachinePlantActivity.this, "Already on first page", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadData(int page, String search) {
        MachineApiService apiService = RetrofitClientInstance.getRetrofitInstance().create(MachineApiService.class);
        apiService.getTableData(page, 10, search).enqueue(new Callback<TableResponse>() {
            @Override
            public void onResponse(@NonNull Call<TableResponse> call, @NonNull Response<TableResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TableResponse tableResponse = response.body();
                    List<Machine> items = tableResponse.getContent();
                    totalPages = tableResponse.getTotalPages() > 0 ? tableResponse.getTotalPages() : 1;
                    totalPagesTextView.setText("Total Pages: " + totalPages);

                    Log.d("API Response", "Data: " + new Gson().toJson(items));

                    if (items != null && !items.isEmpty()) {
                        adapter.updateData(items);
                    } else {
                        Toast.makeText(MachinePlantActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                    pageIndicator.setText("Page " + (currentPage + 1) + " of " + totalPages);
                } else {
                    Log.d("API Response", "Response not successful");
                    Toast.makeText(MachinePlantActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<TableResponse> call, @NonNull Throwable t) {
                Log.d("API Error", "Failed to call API", t);
                Toast.makeText(MachinePlantActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
