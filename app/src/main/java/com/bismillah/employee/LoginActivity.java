package com.bismillah.employee;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bismillah.employee.activityemploye.FormExitEmployee;
import com.bismillah.employee.activityemploye.NavEmployee;
import com.bismillah.employee.retrofit.BaseApiService;
import com.bismillah.employee.retrofit.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    EditText etUsername, etPassword;
    Button btnLogin;
    BaseApiService baseApiService;
    ProgressDialog progressDialog;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        baseApiService = UtilsApi.getApiService();

    }

    public void loginbtn(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        JSONObject level = null;

        if (validateLogin(username, password)) {
            doLogin(username, password, level);
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("sabar loading ...");
        progressDialog.show();
    }

    private boolean validateLogin(String username, String password) {
        if (username == null || username.trim().length() == 0) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password == null || password.trim().length() == 0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doLogin(final String username, final String password, final JSONObject level) {
        baseApiService.loginRequest(etUsername.getText().toString(), etPassword.getText().toString(), level)
                .enqueue(new retrofit2.Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.w(TAG, "onResponse: " + response);
                        if (response.isSuccessful()) {
                            progressDialog.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                if (jsonObject.getString("level").equals("guest")) {
                                    Intent intent = new Intent(LoginActivity.this, NavEmployee.class);
                                    Bundle bundle = new Bundle();

                                    String nama = etUsername.getText().toString();
                                    String depart = jsonObject.getString("level");

                                    bundle.putString("username", nama);
                                    bundle.putString("departmen", depart);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                } else if (jsonObject.getString("level").equals("admin")) {
                                    Toast.makeText(LoginActivity.this, "ini admin", Toast.LENGTH_LONG).show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        progressDialog.dismiss();
                    }
                });
    }


}
