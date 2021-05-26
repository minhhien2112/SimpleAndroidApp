package com.example.lab5app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    Button btnRegister;
    EditText etUsername;
    EditText etPassword;
    EditText etEmail;
    Users user;
    SQLiteConnector sqLiteConnector;
    private final AppCompatActivity activity = SignUp.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sqLiteConnector = new SQLiteConnector(activity);

        getSupportActionBar().hide();

        etUsername = (EditText) findViewById(R.id.tb_username);
        etEmail = (EditText) findViewById(R.id.tb_email);
        etPassword = (EditText) findViewById(R.id.tb_password);

        btnRegister = (Button) findViewById(R.id.btn_signup_link);

        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.btn_signup_link:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();

                user = new Users(username,password,email);

                if (!sqLiteConnector.checkUser(email) && !sqLiteConnector.checkUser(username,password))
                {
                    sqLiteConnector.addUser(user);
                    finish();
                }
                break;
        }
    }
}