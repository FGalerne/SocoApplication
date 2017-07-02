package com.flo.socoapplication;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    public TextInputEditText login;
    public TextInputEditText password;
    public Button connect;
    public TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        login = (TextInputEditText) findViewById(R.id.login);
        password = (TextInputEditText) findViewById(R.id.password);
        connect = (Button) findViewById(R.id.connect);
        register = (TextView) findViewById(R.id.register);


        connect.setOnClickListener(btnConnectListener);
        register.setOnClickListener(txtRegisterListener);



    }

    private View.OnClickListener btnConnectListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private View.OnClickListener txtRegisterListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.registration);

        }
    };
}
