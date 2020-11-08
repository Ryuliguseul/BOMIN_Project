package com.example.bomin_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetail extends AppCompatActivity {

    Button join, terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int product_index = intent.getIntExtra("product", 0);

        //product 1: 1달
        //product 2: 10분
        switch(product_index)
        {
            case 1:
                setContentView(R.layout.activity_product_detail1);
                join = findViewById(R.id.join);

                join.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), TermsConditions.class);
                        intent.putExtra("product", 1);
                        startActivity(intent);
                    }
                });
        }
    }
}
