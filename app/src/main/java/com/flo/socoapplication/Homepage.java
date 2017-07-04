package com.flo.socoapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Homepage extends AppCompatActivity {

    public TextInputEditText etLogin;
    public TextInputEditText etPassword;
    public Button bConnect;
    public TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        etLogin = (TextInputEditText) findViewById(R.id.etLogin);
        etPassword = (TextInputEditText) findViewById(R.id.etPassword);
        bConnect = (Button) findViewById(R.id.bConnect);
        tvRegister = (TextView) findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Homepage.this, Registration.class);
                Homepage.this.startActivity(registerIntent);

            }
        });

        bConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = etLogin.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                String email = jsonResponse.getString("email");
                                String employeeNumber = jsonResponse.getString("employeeNumber");

                                Intent intent = new Intent(Homepage.this, Main.class);
                                intent.putExtra("username", username);
                                intent.putExtra("email", email);
                                intent.putExtra("employeeNumber", employeeNumber);

                                Homepage.this.startActivity(intent);


                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Homepage.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };


                LoginRequest loginRequest = new LoginRequest(username, password, responseListener );

                RequestQueue queue = Volley.newRequestQueue(Homepage.this);
                queue.add(loginRequest);
            }
        });







    }


}
