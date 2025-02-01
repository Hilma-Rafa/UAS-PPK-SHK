package com.project.shkproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.shkproject.R;

public class DaftarActivity extends AppCompatActivity {
    View view1;

    LinearLayout homeButton, entriButton, kualitasButton, respondenButton;

    TableRow tablerowEntri1;

    private TextView textViewNamaPasar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        homeButton = findViewById(R.id.homeButton);
        entriButton = findViewById(R.id.entriButton);
        kualitasButton = findViewById(R.id.kualitasButton);
        respondenButton = findViewById(R.id.respondenButton);
        tablerowEntri1 = findViewById(R.id.tabelrowEntri1);


        //Menetapkan OnClickListener untuk setiap Layout
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        entriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarActivity.this, DaftarEntriActivity.class);
                startActivity(intent);
            }
        });

        kualitasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarActivity.this, KualitasActivity.class);
                startActivity(intent);
            }
        });

        respondenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarActivity.this, RespondenActivity.class);
                startActivity(intent);
            }
        });

        tablerowEntri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToEntri();
            }
        });

        // Mengambil data yang dikirimkan melalui intent
        Intent intent = getIntent();
        if (intent != null) {
            String namaPasar = intent.getStringExtra("NAMA_PASAR");

            // Menghubungkan TextView dengan ID namaPasar dari layout activity_daftar
            textViewNamaPasar = findViewById(R.id.namaPasar);

            // Menampilkan nilai nama pasar di TextView
            if (textViewNamaPasar != null) {
                textViewNamaPasar.setText(namaPasar);
            }
        }
    }

    private void moveToEntri() {
        Intent intent = new Intent(this, EntriActivity.class);
        startActivity(intent);
    }

}
