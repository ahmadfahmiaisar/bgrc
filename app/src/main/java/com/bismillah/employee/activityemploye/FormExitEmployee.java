package com.bismillah.employee.activityemploye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bismillah.employee.R;

import org.w3c.dom.Text;

public class FormExitEmployee extends AppCompatActivity {

    private TextView tvnama,tvlevel;
    private RadioButton rbOfficial, rbPersonal;
    private EditText etTujuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_form_exit);

        tvnama = findViewById(R.id.tv_namaEmploye);
        tvlevel = findViewById(R.id.tv_namaDepart);
        rbOfficial = findViewById(R.id.rb_official);
        rbPersonal = findViewById(R.id.rb_personal);
        etTujuan = findViewById(R.id.et_tujuanExit);

       /* Bundle b = getIntent().getExtras();
        String nama = b.getString("username");
        String level = b.getString("departmen");

        tvnama.setText(nama);
        tvlevel.setText(level);*/
    }

    public void submitform(View view) {
        Intent intent = new Intent(FormExitEmployee.this, NavEmployee.class);
        Bundle bundle = new Bundle();

        /*String nama = bundle.getString("username");
        String level = bundle.getString("departmen");*/
        String nama = tvnama.getText().toString();
        String level = tvlevel.getText().toString();
        String official = rbOfficial.getText().toString();
        String personal = rbPersonal.getText().toString();
        String tujuan = etTujuan.getText().toString();

        bundle.putString("username", nama);
        bundle.putString("departmen", level);
        bundle.putString("official", official);
        bundle.putString("personal", personal);
        bundle.putString("tujuan", tujuan);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
