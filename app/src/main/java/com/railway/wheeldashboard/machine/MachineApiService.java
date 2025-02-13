package com.railway.wheeldashboard.machine;



import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MachineApiService {

    @GET("wheelinspection/api/machines/getAllMachine")
    Call<List<Machine>> getAllMachines();

    @GET("api/machines/{id}")
    Call<Machine> getMachineById(@Path("id") Long id);

    @POST("api/machines")
    Call<Machine> createMachine(@Body Machine machine);

    @PUT("api/machines/{id}")
    Call<Machine> updateMachine(@Path("id") Long id, @Body Machine machine);

    @DELETE("api/machines/{id}")
    Call<Void> deleteMachine(@Path("id") Long id);

    @GET("/wheelinspection/api/machines")
    Call<TableResponse> getTableData(@Query("page") int page,
                                     @Query("size") int size,
                                     @Query("search") String search);

}
