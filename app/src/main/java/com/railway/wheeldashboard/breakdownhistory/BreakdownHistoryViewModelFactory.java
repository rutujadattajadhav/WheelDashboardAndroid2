package com.railway.wheeldashboard.breakdownhistory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class BreakdownHistoryViewModelFactory implements ViewModelProvider.Factory {
    private final String searchQuery;

    public BreakdownHistoryViewModelFactory(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BreakdownHistoryViewModel.class)) {
            return (T) new BreakdownHistoryViewModel(searchQuery);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
