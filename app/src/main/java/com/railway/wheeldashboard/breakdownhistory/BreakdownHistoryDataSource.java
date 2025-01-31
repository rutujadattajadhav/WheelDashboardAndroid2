package com.railway.wheeldashboard.breakdownhistory;

import androidx.annotation.NonNull;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;

import com.railway.wheeldashboard.client.RetrofitClientInstance;

import java.io.IOException;

import kotlin.coroutines.Continuation;
import retrofit2.Response;

public class BreakdownHistoryDataSource extends PagingSource<Integer, BreakdownHistory> {
    private final BreakdownHistoryApi apiService;
    private final String searchQuery;

    public BreakdownHistoryDataSource(String searchQuery) {

        apiService = RetrofitClientInstance.getRetrofitInstance().create(BreakdownHistoryApi.class);
        this.searchQuery = searchQuery;
    }

    @NonNull
    @Override
    public LoadResult<Integer, BreakdownHistory> load(@NonNull LoadParams<Integer> params, @NonNull Continuation<? super LoadResult<Integer, BreakdownHistory>> continuation) {
        try {
            int page = params.getKey() == null ? 0 : params.getKey(); // Default to page 0 if null

            Response<BreakdownHistoryResponse> response = apiService.getBreakdowns(searchQuery, page, 10).execute();

            if (response.isSuccessful() && response.body() != null) {
                return new LoadResult.Page<>(
                    response.body().getContent(),
                    page == 0 ? null : page - 1,  // Previous page
                    page + 1 < response.body().getTotalPages() ? page + 1 : null // Next page
                );
            } else {
                return new LoadResult.Error<>(new Exception("API Response Failed"));
            }
        } catch (IOException e) {
            return new LoadResult.Error<>(e);
        }
    }



    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, BreakdownHistory> state) {
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition == null) return null;
        LoadResult.Page<Integer, BreakdownHistory> closestPage = state.closestPageToPosition(anchorPosition);
        if (closestPage == null) return null;
        return closestPage.getPrevKey() != null ? closestPage.getPrevKey() + 1 :
               (closestPage.getNextKey() != null ? closestPage.getNextKey() - 1 : null);
    }

}
