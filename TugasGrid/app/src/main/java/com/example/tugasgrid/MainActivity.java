package com.example.tugasgrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] daftarBarang = {"Pop Mie", "Susu", "Energen", "Kopi"};
    String[] idBarang = {"p01", "p02", "p03", "p04", "p05"};
    String[] deskripsiBarang = {
            "Harga= 5k",
            "Harga= 4k",
            "Harga= 3k",
            "Harga= 2k",
            "Harga= 1k",
    };
    int[] profilBarang = {
        R.drawable.popmie,R.drawable.susu,R.drawable.energen,R.drawable.kopiabc
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        CustomAdapter customAdapter = new CustomAdapter();
        lv.setAdapter(customAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        daftarBarang[position],
                        Toast.LENGTH_LONG
                ).show();
                Intent intent = new Intent(getApplicationContext(), daftrabarang_activity.class);
                intent.putExtra("Posisi", position);
                intent.putExtra("nama", daftarBarang[position]);
                intent.putExtra("id", idBarang[position]);
                intent.putExtra("desc", deskripsiBarang[position]);
                intent.putExtra("image", profilBarang[position]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount(){
            return daftarBarang.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView brg = view.findViewById(R.id.namabarang);
            TextView idbrg = view.findViewById(R.id.idbarang);
            ImageView imgprofil = view.findViewById(R.id.image);

            Intent intent2 = getIntent();
            String updateBarang = intent2.getStringExtra("nama");
            String updateId = intent2.getStringExtra("id");
            int updatedata = intent2.getIntExtra("lokasi", 0);
            int param = intent2.getIntExtra("par", 0);

            if(param==1){
                daftarBarang[updatedata] = updateBarang;
                idBarang[updatedata] = updateId;
            }

            brg.setText(daftarBarang[position]);
            idbrg.setText(idBarang[position]);
            imgprofil.setImageResource(profilBarang[position]);

            return view;
        }
    }
}
