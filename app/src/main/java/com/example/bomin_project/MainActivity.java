package com.example.bomin_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button three, myinsure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        Log.d("check", "MainActivity 진입");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tmp1);
        three  = findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), tmp.class);
                startActivity(intent1);
            }
        });

        myinsure  = findViewById(R.id.myinsure);
        myinsure.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), tmp2.class);
                startActivity(intent2);
            }
        });
    }
}