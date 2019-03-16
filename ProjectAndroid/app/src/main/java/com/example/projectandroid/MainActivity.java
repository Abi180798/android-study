package com.example.projectandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText user;
    private EditText pass;
    private TextView info;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void verifyLogin(View view){
        user = findViewById(R.id.etUsername);
        pass = findViewById(R.id.etPassword);
        info = findViewById(R.id.tvLogin);
        login = findViewById(R.id.btnlogin);
        if (user == "admin" && pass == "pass"){
            Intent intent = new Intent(MainActivity.this, HalamanUtama.class);
        }
    }
}
