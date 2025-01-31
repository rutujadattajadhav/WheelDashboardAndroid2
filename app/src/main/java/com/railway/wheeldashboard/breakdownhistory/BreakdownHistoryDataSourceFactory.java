package com.railway.wheeldashboard.breakdownhistory;

import androidx.paging.PagingSource;

public class BreakdownHistoryDataSourceFactory {
    private final String searchQuery;

    public BreakdownHistoryDataSourceFactory(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public PagingSource<Integer, BreakdownHistory> create() {
        return new BreakdownHistoryDataSource(searchQuery);
    }
}
