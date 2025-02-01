package com.project.shkproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.project.shkproject.R;

public class SplashActivity extends AppCompatActivity {

    Button mulaiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mulaiButton = findViewById(R.id.mulaiButton);
        mulaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLogin();
            }
        });
    }

    public void moveToLogin()  {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
