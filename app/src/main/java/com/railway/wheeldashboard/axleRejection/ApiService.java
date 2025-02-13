package com.railway.wheeldashboard.axleRejection;

import com.railway.wheeldashboard.login.ApplicationResponce;
import com.railway.wheeldashboard.login.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {
    @GET("/wheelinspection/api/axle-rejection") // Adjust the endpoint path to your API
    Call<TableResponse> getTableData( @Query("page") int page,
                                            @Query("size") int size,
                                            @Query("search") String search);
}
