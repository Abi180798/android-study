package com.example.tugasgrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class editbarang_activity extends AppCompatActivity {
    TextView brgnya;
    TextView idnya;
    Button btnSave;
    int getposisi;
    TextView editposisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editbarang_activity);

        brgnya = findViewById(R.id.editbarang);
        idnya = findViewById(R.id.editid);
        btnSave = findViewById(R.id.btnSaved);
        editposisi = findViewById(R.id.editposisi);

        final Intent intent = getIntent();
        getposisi = intent.getIntExtra("posisi", 0);
        String getbrg = intent.getStringExtra("nama");
        String getid = intent.getStringExtra("id");

        editposisi.setText("posisi" + getposisi);
        brgnya.setText(getbrg);
        idnya.setText(getid);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "Data terupdate",
                        Toast.LENGTH_SHORT
                ).show();
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                intent1.putExtra("name", brgnya.getText());
                intent1.putExtra("id", idnya.getText());
                intent1.putExtra("pos", getposisi);
                intent1.putExtra("par", 1);
                startActivity(intent1);
            }
        });
    }
}