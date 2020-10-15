package com.example.bomin_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
/*
        public void onClick(View v){
            String email = TextInputEditText_email.getText().toString();
            String password = TextInputEditText_password.getText().toString();

            Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("password", password);
            startActivity(intent);

        }
        */

    }
}