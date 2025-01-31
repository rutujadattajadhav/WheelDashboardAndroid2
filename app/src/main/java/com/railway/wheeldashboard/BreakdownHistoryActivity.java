package com.railway.wheeldashboard;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.railway.wheeldashboard.breakdownhistory.BreakdownHistoryViewModel;
import com.railway.wheeldashboard.breakdownhistory.BreakdownHistoryViewModelFactory;

public class BreakdownHistoryActivity extends ComponentActivity {
    private BreakdownHistoryPagedAdapter adapter;
    private BreakdownHistoryViewModel viewModel;
    private EditText searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown_history);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BreakdownHistoryPagedAdapter();
        recyclerView.setAdapter(adapter);

        // Search functionality
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loadPagedData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        loadPagedData(""); // Load default data
    }

    private void loadPagedData(String searchQuery) {
        // ✅ Initialize ViewModel using Factory
        viewModel = new ViewModelProvider(this, new BreakdownHistoryViewModelFactory(searchQuery))
                    .get(BreakdownHistoryViewModel.class);

        viewModel.getPagedBreakdownHistory().observe(this, pagingData -> {
            adapter.submitData(getLifecycle(), pagingData);
        });
    }
}
