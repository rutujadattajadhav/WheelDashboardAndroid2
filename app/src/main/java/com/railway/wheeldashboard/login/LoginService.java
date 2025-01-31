package com.railway.wheeldashboard.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;



public interface LoginService {
    @POST("/userlogin/loginUser") // Adjust the endpoint path to your API
    Call<ApplicationResponce> loginUser(@Body LoginRequest loginRequest);
}
