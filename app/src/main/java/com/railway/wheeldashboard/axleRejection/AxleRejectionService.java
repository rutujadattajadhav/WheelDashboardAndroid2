package com.railway.wheeldashboard.axleRejection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface AxleRejectionService {
    @GET("/wheelinspection/api/axle-rejection") // Adjust the endpoint path to your API
    Call<AxleRejectionResponse> getTableData(@Query("page") int page,
                                             @Query("size") int size,
                                             @Query("search") String search);
}
