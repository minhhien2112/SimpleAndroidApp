package com.example.lab5app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    Button btn_login, btn_register;
    EditText etUsername, etPassword;
    TextView tvError;
    Users user;
    SQLiteConnector sqLiteConnector;
    ConnectPHP connectPHP;

    private final AppCompatActivity activity = SignIn.this;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signup_link:
                Intent register = new Intent(this,SignUp.class);
                startActivity(register);
                break;

            case R.id.btn_signin:

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                user = new Users(username,password);
                tvError.setText(user.getName());
                if (sqLiteConnector.checkUser(user.getName(),user.getPassword()))
                {
                    Intent main = new Intent(this, MainActivity.class);
                    main.putExtra("Users", user);
                    startActivity(main);
                }
                else {

                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_register = (Button) findViewById(R.id.btn_signup_link);
        btn_register.setOnClickListener(this);
        btn_login = (Button) findViewById(R.id.btn_signin);
        btn_login.setOnClickListener(this);

        sqLiteConnector = new SQLiteConnector(activity);

        tvError = (TextView) findViewById(R.id.tv_Errot);

        etUsername = (EditText) findViewById(R.id.tb_username);
        etPassword = (EditText) findViewById(R.id.tb_password);
        getSupportActionBar().hide();
    }
}