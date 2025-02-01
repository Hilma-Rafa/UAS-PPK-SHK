package com.project.shkproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.shkproject.R;

public class DaftarEntriActivity extends AppCompatActivity {


    LinearLayout homeButton, entriButton, kualitasButton, respondenButton;

    TableRow tablerow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_entri);

        homeButton = findViewById(R.id.homeButton);
        entriButton = findViewById(R.id.entriButton);
        kualitasButton = findViewById(R.id.kualitasButton);
        respondenButton = findViewById(R.id.respondenButton);
        tablerow = findViewById(R.id.tablerow1);

        //Menetapkan OnClickListener untuk setiap Layout
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarEntriActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        entriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Anda berada pada halaman entri");
            }
        });

        kualitasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarEntriActivity.this, KualitasActivity.class);
                startActivity(intent);
            }
        });

        respondenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarEntriActivity.this, RespondenActivity.class);
                startActivity(intent);
            }
        });

        tablerow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToDaftar();
            }
        });

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Mendapatkan jumlah baris dalam TableLayout
        int rowCount = tableLayout.getChildCount();

        // Iterasi melalui setiap baris dalam TableLayout
        for (int i = 0; i < rowCount; i++) {
            // Mendapatkan referensi ke setiap baris (TableRow) dalam TableLayout
            TableRow row = (TableRow) tableLayout.getChildAt(i);

            // Menambahkan onClickListener untuk setiap baris
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Mengambil teks dari TextView di kolom nama pasar (misalnya, kolom pertama dalam TableRow)
                    TextView textViewNamaPasar = (TextView) row.getChildAt(0); // Menggunakan getChildAt(0) karena kolom nama pasar berada di indeks 0

                    // Mengambil teks dari TextView nama pasar
                    String namaPasar = textViewNamaPasar.getText().toString();

                    // Mengirim teks nama pasar ke activity_daftar
                    Intent intent = new Intent(DaftarEntriActivity.this, DaftarActivity.class);
                    intent.putExtra("NAMA_PASAR", namaPasar);
                    startActivity(intent);
                }
            });
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void moveToDaftar() {
        Intent intent = new Intent(this, DaftarActivity.class);
        startActivity(intent);
    }


}
