package com.railway.wheeldashboard.breakdownhistory;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface BreakdownHistoryService {

    @GET("wheelinspection/api/breakdown")
    Call<List<BreakdownHistory>> getAllHistory();

    @GET("wheelinspection/api/breakdown/{id}")
    Call<BreakdownHistory> getHistoryById(@Path("id") int id);

    @POST("wheelinspection/api/breakdown")
    Call<BreakdownHistory> createHistory(@Body BreakdownHistory history);

    @PUT("wheelinspection/api/breakdown/{id}")
    Call<BreakdownHistory> updateHistory(@Path("id") int id, @Body BreakdownHistory history);

    @DELETE("wheelinspection/api/breakdown/{id}")
    Call<Void> deleteHistory(@Path("id") int id);
    @GET("wheelinspection/api/breakdown")
    Call<BreakdownResponse> getTableData(@Query("page") int page,
                                          @Query("size") int size,
                                          @Query("search") String search) ;
}
