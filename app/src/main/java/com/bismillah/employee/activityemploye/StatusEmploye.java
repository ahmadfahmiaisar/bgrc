package com.bismillah.employee.activityemploye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bismillah.employee.R;

public class StatusEmploye extends AppCompatActivity {

    TextView tvNama, tvDepart, tvJenis, tvTujuan, tvStatus;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_employe);

        tvNama = findViewById(R.id.tv_namaEmployStatus);
        tvDepart = findViewById(R.id.tv_namaDepartStatus);
        tvJenis = findViewById(R.id.tv_jenis);
        tvTujuan = findViewById(R.id.tv_tujuan);
        tvStatus = findViewById(R.id.tv_status);

        if (getIntent().getExtras() != null){
            bundle = getIntent().getExtras();
            String nama = bundle.getString("username");
            String depart = bundle.getString("departmen");
            String jenisO = bundle.getString("official");
            String jenisP = bundle.getString("personal");
            String tujuan = bundle.getString("tujuan");

            tvNama.setText(nama);
            tvDepart.setText(depart);
            tvJenis.setText(jenisO);
            /*tvJenis.setText(jenisP);*/
            tvTujuan.setText(tujuan);
        }

    }
}