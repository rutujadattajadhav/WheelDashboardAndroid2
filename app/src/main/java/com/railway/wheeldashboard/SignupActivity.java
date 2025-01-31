package com.railway.wheeldashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.railway.wheeldashboard.client.RetrofitClientInstance;
import com.railway.wheeldashboard.signup.ApplicationResponce;
import com.railway.wheeldashboard.signup.ResistrationBean;
import com.railway.wheeldashboard.signup.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignupActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        UserService userService = RetrofitClientInstance.getRetrofitInstance().create(UserService.class);


        // Initialize Views
        EditText firstName = findViewById(R.id.first_name);
        EditText lastName = findViewById(R.id.last_name);
        EditText email = findViewById(R.id.email);
        EditText mobile = findViewById(R.id.mobile);
        EditText password = findViewById(R.id.password);
        EditText confirmPassword = findViewById(R.id.confirm_password);
        Button signupButton = findViewById(R.id.signup_button);

        // Handle Signup Button Click
        signupButton.setOnClickListener(v -> {
            // Get user inputs
            String fname = firstName.getText().toString();
            String lname = lastName.getText().toString();
            String userEmail = email.getText().toString();
            String mob = mobile.getText().toString();
            String pass = password.getText().toString();
            String confirmPass = confirmPassword.getText().toString();

            // Validate inputs
            if (fname.isEmpty() || lname.isEmpty() || userEmail.isEmpty() ||
                    mob.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pass.equals(confirmPass)) {
                Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // Create user object
            ResistrationBean user = new ResistrationBean();
            user.setFname(fname);
            user.setLname(lname);
            user.setEmail(userEmail);
            user.setMob(mob);
            user.setPassword(pass);
            user.setConfirmpassword(confirmPass);

            // Call API
            userService.registerUser(user).enqueue(new Callback<ApplicationResponce>() {
                @Override
                public void onResponse(Call<ApplicationResponce> call, Response<ApplicationResponce> response) {
                    ApplicationResponce data=response.body();
                    if (response.isSuccessful()) {
                        Toast.makeText(SignupActivity.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                        Log.d("SignupSuccess", "save user successfully");
                        //Navigate to another activity if needed
                        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Log.d("signup failed",data.getData().toString());
                        Toast.makeText(SignupActivity.this, "Signup failed!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ApplicationResponce> call, @NonNull Throwable t) {
                    Log.d("error","");
                    t.getStackTrace();
                    Toast.makeText(SignupActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });
    }
}
