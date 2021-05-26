package com.example.lab5app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab5app.Users;

public class MainActivity extends AppCompatActivity  {

    Users user;
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        Intent i = getIntent();
        Users user = (Users)i.getSerializableExtra("Users");
        tvDisplay = (TextView) findViewById(R.id.tb_display);
        try {
            tvDisplay.setText("Hello " + user.getName()+ "!");
        }
        catch (Exception ex )
        {
            tvDisplay.setText(ex.toString());
        }


    }
}