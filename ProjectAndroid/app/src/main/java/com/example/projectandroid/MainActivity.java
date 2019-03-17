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
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etUsername);
        pass = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnlogin);
        info = findViewById(R.id.tvLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyLogin(user.getText().toString(), pass.getText().toString());
            }
        });

    }

    private void verifyLogin(String username, String password){
        if (username.equals("") && password.equals("")){
            Intent intent = new Intent(MainActivity.this, HalamanUtama.class);
            startActivity(intent);
        }else{
            counter--;
            info.setText("Batas Login Sisa: " + String.valueOf(counter));
            if (counter == 0){
                login.setEnabled(false);
            }

        }
    }

}
