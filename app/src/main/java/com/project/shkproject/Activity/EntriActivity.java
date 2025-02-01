package com.project.shkproject.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.project.shkproject.Adapter.HK11Adapter;
import com.project.shkproject.ApiClient.RetrofitClient;
import com.project.shkproject.ApiService.ApiService;
import com.project.shkproject.R;
import com.project.shkproject.Request.HK11Request;
import com.project.shkproject.Response.DefaultResponse;
import com.project.shkproject.Response.HK11Response;
import com.project.shkproject.Utils.ListUtils;
import com.project.shkproject.Utils.TokenManager;
import com.project.shkproject.databinding.ActivityEntriBinding;

import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntriActivity extends AppCompatActivity {
    LinearLayout homeButton, entriButton, kualitasButton, respondenButton;
    private View entriDialog;
    private ActivityEntriBinding binding;
    Button submitButton, addRowButton;
    private TableLayout tableLayout;
    int rowCount = 0;
    private String token;
    private RecyclerView entriTable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entri);

        homeButton = findViewById(R.id.homeButton);
        entriButton = findViewById(R.id.entriButton);
        kualitasButton = findViewById(R.id.kualitasButton);
        respondenButton = findViewById(R.id.respondenButton);
        tableLayout = findViewById(R.id.tableLayoutEntri);
        addRowButton = findViewById(R.id.addRowButton);
        entriTable = findViewById(R.id.entriTable);
        initRecyclerView();

        addRowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRow();
            }
        });
        //Menetapkan OnClickListener untuk setiap Layout
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntriActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        entriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntriActivity.this, DaftarEntriActivity.class);
                startActivity(intent);
            }
        });

        kualitasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntriActivity.this, KualitasActivity.class);
                startActivity(intent);
            }
        });

        respondenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntriActivity.this, RespondenActivity.class);
                startActivity(intent);
            }
        });

    }

    public void initRecyclerView(){
        token = TokenManager.getInstance(this).getToken();
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        Call<DefaultResponse> call = apiService.getAllHK11("Bearer " + token);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.isSuccessful()) {
                    DefaultResponse hk11s = response.body();
                    List<HK11Response> hk11Responses = hk11s.getEmbedded().getHK1_1s();
                    updateRecyclerView(hk11Responses);
                    for (HK11Response res : hk11Responses){
                        Log.e("EntriActivity", "kode: " + res.getResponden() );
                    }
                    showToast("Success to fetch HK11");
                } else {
                    showToast("Failed to fetch HK11");
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                showToast("Masuk onFailure");
                t.printStackTrace();
                Log.e("EntriActivity", "Fetch error: " + t.getMessage());
            }
        });
    }

    private void updateRecyclerView(List<HK11Response> listResponse) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        if (entriTable != null) {
            HK11Adapter adapter = new HK11Adapter(ListUtils.ToArrayList(listResponse));
            entriTable.setLayoutManager(layoutManager);
            entriTable.setAdapter(adapter);
            showToast("Success load HK11");
        } else {
            showToast("Cannot load HK11");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void addRow() {
        entriDialog = LayoutInflater.from(this).inflate(R.layout.popup_entri, null);
        EditText kodeKualitas = entriDialog.findViewById(R.id.editTextKodeKualitas);
        EditText komoditas = entriDialog.findViewById(R.id.editTextKomoditas);
        EditText kualitas = entriDialog.findViewById(R.id.editTextKualitas);
        EditText hargaSebelum = entriDialog.findViewById(R.id.editTextHargaSebelum);
        EditText hargaSekarang = entriDialog.findViewById(R.id.editTextHargaSekarang);
        token = TokenManager.getInstance(this).getToken();

        AlertDialog alertDialog = new MaterialAlertDialogBuilder(this)
                .setView(entriDialog)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String kodeKualitasStr = kodeKualitas.getText().toString();
                        Long kodeKualitasLong = Long.parseLong(kodeKualitasStr);

                        String komoditasStr = komoditas.getText().toString();
                        String kualitasStr = kualitas.getText().toString();
                        String hargaSebelumStr = hargaSebelum.getText().toString();
                        Integer hargaSebelumInt = Integer.parseInt(hargaSebelumStr);

                        String hargasSekarangStr = hargaSekarang.getText().toString();
                        Integer hargaSekarangInt = Integer.parseInt(hargasSekarangStr);

                        HK11Request request = new HK11Request();
                        request.setResponden("SUNARTI");
                        request.setKodeKualitas(kodeKualitasLong);
                        request.setKomoditas(komoditasStr);
                        request.setKualitas(kualitasStr);
                        request.setHargaSebelum(hargaSebelumInt);
                        request.setHargaSekarang(hargaSekarangInt);

                        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
                        Call<HK11Response> call = apiService.createHK11("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZWl6cmFhdWxpYUBnbWFpbC5jb20iLCJyb2xlcyI6WyJST0xFX1BFTkNBQ0FIIl0sImlzcyI6IlBvbHN0YXQiLCJpYXQiOjE3MDI4ODU1ODYsImV4cCI6MTcwMjk3MTk4Nn0.v6HMrgx1_pytmzzyWd15HtmTPaf1geyUZ-n3no7Hn9Zpa4eqW8HYL2xDm7TWNI19LNjLivqju1VEWnBNGYBUTw", request);
                        call.enqueue(new Callback<HK11Response>() {
                            @Override
                            public void onResponse(Call<HK11Response> call, Response<HK11Response> response) {
                                if (response.isSuccessful()) {
                                    HK11Response createdResponse = response.body();
                                    recreate();
                                } else {
                                    try {
                                        String errorBody = response.errorBody().string();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<HK11Response> call, Throwable t) {
                                t.printStackTrace();
                                Log.e("EntriActivity", "Fetch error: " + t.getMessage());
                                recreate();
                            }
                        });
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();

    }


}
