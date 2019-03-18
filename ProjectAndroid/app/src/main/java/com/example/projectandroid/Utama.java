package com.example.projectandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Utama extends AppCompatActivity {
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        hasil = findViewById(R.id.tvHasil2);


        hasil.setText("Luas Lingkaran= " + getIntent().getDoubleExtra("HASIL", 0));
    }
}
