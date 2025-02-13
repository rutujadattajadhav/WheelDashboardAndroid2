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
import com.railway.wheeldashboard.axleRejection.ApiService;
import com.railway.wheeldashboard.axleRejection.AxleRejectionModel;
import com.railway.wheeldashboard.axleRejection.TableAdapter;
import com.railway.wheeldashboard.axleRejection.TableResponse;
import com.railway.wheeldashboard.client.RetrofitClientInstance;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AxleRejectionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TableAdapter adapter;
private TextView totalPagesTextView;
    private int currentPage = 0;
    private String search="";
    private int totalPages = 1;
    private Button prevButton, nextButton;
    private TextView pageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        recyclerView = findViewById(R.id.recyclerView);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        pageIndicator = findViewById(R.id.pageIndicator);
        SearchView searchView = findViewById(R.id.searchView);
        totalPagesTextView =findViewById(R.id.totalPagesTextView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter = new TableAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        loadData(currentPage,search);

        prevButton.setOnClickListener(v -> {
            if (currentPage > 0) {
                loadData(--currentPage,search);
            }
        });

        nextButton.setOnClickListener(v -> {
            if (currentPage < totalPages) {
                loadData(++currentPage,search);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                    search=query;
                    currentPage=0;
                    loadData(currentPage,search);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void loadData(int page,String search) {
        ApiService apiService = RetrofitClientInstance.getRetrofitInstance().create(ApiService.class);
        apiService.getTableData(page, 10,search).enqueue(new Callback<TableResponse>() {
          @Override
            public void onResponse(@NonNull Call<TableResponse> call, @NonNull Response<TableResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TableResponse tableResponse = response.body();
                    List<AxleRejectionModel> items = tableResponse.getContent();
                    totalPagesTextView.setText(new StringBuilder().append("Total Pages ").append(tableResponse.getTotalPages() != 0 ? String.valueOf(tableResponse.getTotalPages()) : "1").toString());
                    totalPages = tableResponse.getTotalPages();

                    Log.d("API Response", "Data: " + new Gson().toJson(items)); // Debugging

                    if (items != null && !items.isEmpty()) {
                        adapter.updateData(items);
                    } else {
                        Toast.makeText(AxleRejectionActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                    pageIndicator.setText("Page " + page);
                } else {
                    Log.d("API Response", "Response not successful");
                    Toast.makeText(AxleRejectionActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<TableResponse> call, @NonNull Throwable t) {
                 Log.d("error at the time call API","Error at the time api call",t);
                Toast.makeText(AxleRejectionActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
