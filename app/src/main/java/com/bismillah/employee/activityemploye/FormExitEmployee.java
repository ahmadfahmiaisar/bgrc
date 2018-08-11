package com.bismillah.employee.activityemploye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bismillah.employee.R;

import org.w3c.dom.Text;

public class FormExitEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_form_exit);

        Bundle b = getIntent().getExtras();
        String nama = b.getString("username");
        String level = b.getString("level");

        TextView tvnama = findViewById(R.id.tv_namaEmploye);
        TextView tvlevel = findViewById(R.id.tv_namaDepart);

        tvnama.setText(nama);
        tvlevel.setText(level);
    }
}
