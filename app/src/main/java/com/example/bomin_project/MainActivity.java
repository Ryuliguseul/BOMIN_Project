package com.example.bomin_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Log.d("check", "MainActivity 진입");
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        String email = intent.getStringExtra("UserEmail");
        String name = intent.getStringExtra("UserName");
        int safety_score = Integer.parseInt(intent.getStringExtra("SafetyScore"));
        int current_product = Integer.parseInt(intent.getStringExtra("CurrentProduct"));

        USER user = new USER(name, email, current_product, safety_score);

        Intent intent_ = new Intent(getApplicationContext(), Insurance.class);
        intent_.putExtra("User", user);
        startActivity(intent_);
    }
}
