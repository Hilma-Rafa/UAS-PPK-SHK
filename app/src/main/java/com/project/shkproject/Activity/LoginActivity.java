package com.project.shkproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.shkproject.ApiClient.RetrofitClient;
import com.project.shkproject.ApiService.ApiService;
import com.project.shkproject.R;
import com.project.shkproject.Request.LoginRequest;
import com.project.shkproject.Response.LoginResponse;
import com.project.shkproject.Utils.TokenManager;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private TextView gotoCreateTextView;
    private Button signUpButton, loginButton;

//    private TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSignUp();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAction();
            }
        });
    }

    private void loginAction() {
        String emails = email.getText().toString();
        String passwords = password.getText().toString();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(emails);
        loginRequest.setPassword(passwords);

        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        Call<LoginResponse> call = apiService.loginUser(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null) {
                        Long id = loginResponse.getId();
                        String email = loginResponse.getEmail();
                        String accessToken = loginResponse.getAccessToken();

                        // Simpan token ke Shared Preferences menggunakan TokenManager
                        TokenManager.getInstance(LoginActivity.this).saveToken(accessToken);

                        Log.e("LoginActivity", "Access token: " + accessToken);
                        moveToHome();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String errorBody = response.errorBody().string();
                        Toast.makeText(LoginActivity.this, "Login gagal: " + errorBody, Toast.LENGTH_SHORT).show();
                        Log.e("LoginActivity", "Gagal melakukan login: " + errorBody );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    private void moveToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void moveToSignUp()  {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


}
