package com.project.shkproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.shkproject.R;

import org.jetbrains.annotations.Nullable;

public class HomeActivity extends AppCompatActivity {

    LinearLayout homeButton, entriButton, kualitasButton, respondenButton;

    ImageView profil;

    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeButton = findViewById(R.id.homeButton);
        entriButton = findViewById(R.id.entriButton);
        kualitasButton = findViewById(R.id.kualitasButton);
        respondenButton = findViewById(R.id.respondenButton);
        profil = findViewById(R.id.imageView3);

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfilActivity.class);
                startActivity(intent);
            }
        });

        //Menetapkan OnClickListener untuk setiap Layout
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Anda berada pada halaman home");
            }
        });

        entriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DaftarEntriActivity.class);
                startActivity(intent);
            }
        });

        kualitasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, KualitasActivity.class);
                startActivity(intent);
            }
        });

        respondenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RespondenActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
