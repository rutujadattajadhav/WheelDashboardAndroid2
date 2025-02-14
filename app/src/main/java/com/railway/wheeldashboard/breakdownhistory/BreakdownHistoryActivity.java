package com.railway.wheeldashboard.breakdownhistory;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.railway.wheeldashboard.BreakdownHistoryPagedAdapter;
import com.railway.wheeldashboard.R;
import com.railway.wheeldashboard.axleRejection.AxleRejectionActivity;
import com.railway.wheeldashboard.axleRejection.AxleRejectionAdapter;
import com.railway.wheeldashboard.axleRejection.AxleRejectionModel;
import com.railway.wheeldashboard.axleRejection.AxleRejectionResponse;
import com.railway.wheeldashboard.axleRejection.AxleRejectionService;
import com.railway.wheeldashboard.client.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreakdownHistoryActivity extends ComponentActivity {
    private RecyclerView recyclerView;
    private BreakdownAdapter adapter;
    private TextView totalPagesTextView;
    private int currentPage = 0;
    private String search="";
    private int totalPages = 1;
    private Button prevButton, nextButton;
    private TextView pageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown_history);


    }

    private void loadData(int page,String search) {
        BreakdownHistoryService apiService = RetrofitClientInstance.getRetrofitInstance().create(BreakdownHistoryService.class);
        apiService.getTableData(page, 10, search).enqueue(new Callback<BreakdownResponse>() {
            @Override
            public void onResponse(@NonNull Call<BreakdownResponse> call, @NonNull Response<BreakdownResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    BreakdownResponse tableResponse = response.body();
                    List<BreakdownHistory> items = tableResponse.getContent();
                    totalPagesTextView.setText(new StringBuilder().append("Total Pages ").append(tableResponse.getTotalPages() != 0 ? String.valueOf(tableResponse.getTotalPages()) : "1").toString());
                    totalPages = tableResponse.getTotalPages();

                    Log.d("API Response", "Data: " + new Gson().toJson(items)); // Debugging

                    if (items != null && !items.isEmpty()) {
                        adapter.updateData(items);
                    } else {
                        Toast.makeText(BreakdownHistoryActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                    pageIndicator.setText("Page " + page);
                } else {
                    Log.d("API Response", "Response not successful");
                    Toast.makeText(BreakdownHistoryActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BreakdownResponse> call, @NonNull Throwable t) {
                Log.d("error at the time call API", "Error at the time api call", t);
                Toast.makeText(BreakdownHistoryActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}