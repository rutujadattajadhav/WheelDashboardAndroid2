package com.railway.wheeldashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.railway.wheeldashboard.client.RetrofitClientInstance;
import com.railway.wheeldashboard.login.ApplicationResponce;
import com.railway.wheeldashboard.login.LoginRequest;
import com.railway.wheeldashboard.login.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    private LoginService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Retrofit
        LoginService userService = RetrofitClientInstance.getRetrofitInstance().create(LoginService.class);
        // Initialize UI Components
        EditText emailEditText = findViewById(R.id.email);
        EditText passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);

        // Handle Login Button Click
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate Inputs
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create LoginRequest
                LoginRequest loginRequest = new LoginRequest(email, password);

                // Call Login API
                userService.loginUser(loginRequest).enqueue(new Callback<ApplicationResponce>() {
                    @Override
                    public void onResponse(Call<ApplicationResponce> call, Response<ApplicationResponce> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ApplicationResponce loginResponse = response.body();
                            Toast.makeText(LoginActivity.this, "Login Successful! Token: " + loginResponse.getData(), Toast.LENGTH_SHORT).show();

                             //Navigate to another activity if needed
                             Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                             startActivity(intent);
                             finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Login Failed: " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ApplicationResponce> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}
