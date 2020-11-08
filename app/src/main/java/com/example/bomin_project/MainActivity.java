package com.example.bomin_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        Log.d("check", "MainActivity 진입");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        LinearLayout product1 = (LinearLayout) findViewById (R.id.product1);
        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                intent.putExtra("product", 1);
                startActivity(intent);
            }
        });

        LinearLayout product2 = (LinearLayout) findViewById (R.id.product2);
        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                intent.putExtra("product", 2);
                startActivity(intent);
            }
        });
    }
}