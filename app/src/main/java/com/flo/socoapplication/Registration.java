package com.flo.socoapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by florian on 02/07/17.
 */

public class Registration extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        final TextInputEditText etUsername = (TextInputEditText) findViewById(R.id.etUsername);
        final TextInputEditText etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        final TextInputEditText etEmployeeNumber = (TextInputEditText) findViewById(R.id.etEmployeeNumber);
        final TextInputEditText etPassword = (TextInputEditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String email = etEmail.getText().toString();
                final String employeeNumber = etEmployeeNumber.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(Registration.this, Homepage.class);
                                Registration.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                            AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                            builder.setMessage("Connect to database failed")
                                    .setTitle("Fatal Error")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();

                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(username, email, employeeNumber, password, responseListener);

                RequestQueue queue = Volley.newRequestQueue(Registration.this);
                queue.add(registerRequest);

            }
        });







    }
}

