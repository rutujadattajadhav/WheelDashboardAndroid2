package com.railway.wheeldashboard.signup;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("userregistration/saveUser")
    Call<ApplicationResponce> registerUser(@Body ResistrationBean user);
}




