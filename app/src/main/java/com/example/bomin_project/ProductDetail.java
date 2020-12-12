package com.example.bomin_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetail extends AppCompatActivity {

    Button join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        final int product_index = intent.getIntExtra("Product", 0);
        final USER user = (USER) intent.getSerializableExtra("User");
        Log.d("productdetail: user", user.getName());
        setContentView(R.layout.activity_product_detail);

        //product 1: 1달
        //product 2: 10분
        if(product_index == 2)
        {
            TextView price = (TextView)findViewById(R.id.price);
            price.setText("200원");
            TextView term = (TextView)findViewById(R.id.term);
            term.setText("10분");
        }

        join = findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TermsConditions.class);
                intent.putExtra("User", user);
                intent.putExtra("Product", product_index);
                startActivity(intent);
            }
        });
    }
}
