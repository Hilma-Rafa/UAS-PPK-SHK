package com.project.shkproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.shkproject.ApiClient.RetrofitClient;
import com.project.shkproject.ApiService.ApiService;
import com.project.shkproject.R;
import com.project.shkproject.Request.RegisterRequest;

import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText email, nama, nipnik, password;
    private Spinner spinnerStatus;
    private Button loginButton, signUpButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.email);
        nama = findViewById(R.id.nama);
        nipnik = findViewById(R.id.nipnik);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLogin();
            }
        });
        signUpButton = findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpAction();
            }
        });
    }

    private void signUpAction() {
        String namas = nama.getText().toString();
        String emails = email.getText().toString();
        String nipniks = nipnik.getText().toString();
        String status = spinnerStatus.getSelectedItem().toString();
        String passwords = password.getText().toString();

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setName(namas);
        registerRequest.setEmail(emails);
        registerRequest.setNip(nipniks);
        registerRequest.setStatus(status);
        registerRequest.setPassword(passwords);
        registerRequest.setLevel("Mitra BPS");

        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        Call<RegisterRequest> call = apiService.registerUser(registerRequest);

        call.enqueue(new Callback<RegisterRequest>() {
            @Override
            public void onResponse(Call<RegisterRequest> call, Response<RegisterRequest> response) {
                if (response.isSuccessful()) {
                    // Handle sukses response
                    RegisterRequest registeredUser = response.body();
                    moveToLogin();
                    showToast("Registrasi berhasil dilakukan");
                } else {
                    // Handle response tidak sukses
                    showToast("Registrasi gagal. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<RegisterRequest> call, Throwable t) {
                // Handle kegagalan panggilan API
                showToast("Gagal melakukan registrasi. " + t.getMessage());
            }
        });
    }

    public void moveToLogin()  {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
