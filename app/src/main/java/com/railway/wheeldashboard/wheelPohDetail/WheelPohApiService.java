package com.railway.wheeldashboard.wheelPohDetail;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface WheelPohApiService {

    @GET("wheelinspection/api/wheel-poh")
    Call<List<WheelPoh>> getAllWheelPohDetails();

    @GET("api/wheel-poh-details/{id}")
    Call<WheelPoh> getWheelPohDetailById(@Path("id") Long id);

    @POST("api/wheel-poh-details")
    Call<WheelPoh> createWheelPohDetail(@Body WheelPoh wheelPoh);

    @PUT("api/wheel-poh-details/{id}")
    Call<WheelPoh> updateWheelPohDetail(@Path("id") Long id, @Body WheelPoh wheelPoh);

    @DELETE("api/wheel-poh-details/{id}")
    Call<Void> deleteWheelPohDetail(@Path("id") Long id);
}
