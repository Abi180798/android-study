package com.example.tugasgrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class daftrabarang_activity extends AppCompatActivity {
    TextView databrg;
    TextView dataid;
    TextView deskripsi;
    ImageView imgprofil;
    int getposisi;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftrabarang_activity);

        databrg = findViewById(R.id.itembarang);
        dataid = findViewById(R.id.itemid);
        deskripsi = findViewById(R.id.deskripsion);
        imgprofil = findViewById(R.id.itemProfil);
        btn = findViewById(R.id.btnedit);

        Intent intent = getIntent();
        getposisi = intent.getIntExtra("Posisi", 0);
        String getDataBrg = intent.getStringExtra("nama");
        String getDataId = intent.getStringExtra("id");
        String getDesc = intent.getStringExtra("desc");
        int getDataImg = intent.getIntExtra("image", 0);

        databrg.setText("Nama: "+ getDataBrg);
        dataid.setText("ID: " + getDataId);
        deskripsi.setText(getDesc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), editbarang_activity.class);
                intent1.putExtra("posisi", getposisi);
                intent1.putExtra("nama", databrg.getText());
                intent1.putExtra("id", dataid.getText());
                startActivity(intent1);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
