package com.railway.wheeldashboard.wheelPohDetail;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface WheelPohApiService {

    @GET("wheelinspection/api/wheel-poh")
    Call<List<WheelPohModel>> getAllWheelPohDetails();

    @GET("api/wheel-poh-details/{id}")
    Call<WheelPohModel> getWheelPohDetailById(@Path("id") Long id);

    @POST("api/wheel-poh-details")
    Call<WheelPohModel> createWheelPohDetail(@Body WheelPohModel wheelPoh);

    @PUT("api/wheel-poh-details/{id}")
    Call<WheelPohModel> updateWheelPohDetail(@Path("id") Long id, @Body WheelPohModel wheelPoh);

    @DELETE("api/wheel-poh-details/{id}")
    Call<Void> deleteWheelPohDetail(@Path("id") Long id);

    @GET("wheelinspection/api/wheel-poh")
    Call<WheelPohResponse> getTableData(@Query("page") int page,
                                        @Query("size") int size,
                                        @Query("search") String search);
}
