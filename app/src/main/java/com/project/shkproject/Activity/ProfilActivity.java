package com.project.shkproject.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.project.shkproject.ApiClient.RetrofitClient;
import com.project.shkproject.ApiService.ApiService;
import com.project.shkproject.Entity.UpdateProfileRequest;
import com.project.shkproject.Entity.User;
import com.project.shkproject.R;
import com.project.shkproject.Utils.TokenManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends AppCompatActivity {

    private View editProfileDialog;
    private TextView namaField, nipField;
    private Button editProfileBtn, deleteAccountBtn, logoutBtn;
    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        namaField = findViewById(R.id.nama_txt);
        nipField = findViewById(R.id.nip_txt);
        editProfileBtn = findViewById(R.id.edit_profile_btn);
        deleteAccountBtn = findViewById(R.id.delete_account_btn);
        logoutBtn = findViewById(R.id.logout_btn);

        Long userId = getUserIdFromPreferences();

        // Buat instance ApiService
        String token = TokenManager.getInstance(this).getToken();
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        // Panggil metode untuk mendapatkan data pengguna berdasarkan ID
        Call<User> call = apiService.getUserById("Bearer " + token, userId);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user != null) {
                        namaField.setText(user.getName());
                        nipField.setText(user.getEmail());
                    } else {
                        Toast.makeText(ProfilActivity.this, "Data pengguna kosong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ProfilActivity.this, "masuk onResponse()", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(ProfilActivity.this, "masuk onFailure()", Toast.LENGTH_SHORT).show();
            }
        });

        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditProfileDialog();
            }
        });

        deleteAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLogin();
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLogin();
            }
        });
    }

    public void moveToHome(View view)  {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void showEditProfileDialog() {
        editProfileDialog = LayoutInflater.from(this).inflate(R.layout.edit_profile_dialog, null);
        TextView newNama = editProfileDialog.findViewById(R.id.new_nama_txt);
        TextView newEmail = editProfileDialog.findViewById(R.id.new_email_txt);
        token = TokenManager.getInstance(this).getToken();

        AlertDialog alertDialog = new MaterialAlertDialogBuilder(this)
                .setView(editProfileDialog)
                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        UpdateProfileRequest request = new UpdateProfileRequest();
                        request.setName(newNama.getText().toString());
                        request.setEmail(newEmail.getText().toString());

                        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
                        Call<User> call = apiService.updateProfile("Bearer " + token, request);

                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                recreate();
                                showToast("Update Profil Berhasil!");
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                t.printStackTrace();
                                Log.e("ProfileActivity", "onFailure: ", t);
                                showToast("Update Profil Berhasil!");
                            }
                        });
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        showToast("data gagal tersimpan");
                    }
                })
                .show();

        int blackColor = ContextCompat.getColor(this, R.color.white);
        int primary = ContextCompat.getColor(this, R.color.primary);

        alertDialog.getButton(alertDialog.BUTTON_NEGATIVE).setTextColor(blackColor);
        alertDialog.getButton(alertDialog.BUTTON_POSITIVE).setTextColor(blackColor);
        alertDialog.getButton(alertDialog.BUTTON_POSITIVE).setBackgroundColor(primary);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private Long getUserIdFromPreferences() {
        SharedPreferences preferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        return preferences.getLong("user_id", -1L);
    }

    public void moveToLogin()  {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}