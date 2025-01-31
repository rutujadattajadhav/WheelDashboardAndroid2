package com.railway.wheeldashboard.breakdownhistory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingLiveData;
import androidx.paging.PagingData;

public class BreakdownHistoryViewModel extends ViewModel {
    private final LiveData<PagingData<BreakdownHistory>> pagedBreakdownHistory;

    public BreakdownHistoryViewModel(String searchQuery) {
        BreakdownHistoryDataSourceFactory factory = new BreakdownHistoryDataSourceFactory(searchQuery);

        Pager<Integer, BreakdownHistory> pager = new Pager<>(
                new PagingConfig(10), // Page size = 10
                factory::create // Use factory method to create PagingSource
        );

        pagedBreakdownHistory = PagingLiveData.getLiveData(pager);
    }

    public LiveData<PagingData<BreakdownHistory>> getPagedBreakdownHistory() {
        return pagedBreakdownHistory;
    }
}
