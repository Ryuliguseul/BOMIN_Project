package com.example.bomin_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TermsConditions extends AppCompatActivity {

    Button terms, join;
    Boolean check;
    int product_index;
    USER user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        user = (USER) intent.getSerializableExtra("User");
        product_index = intent.getIntExtra("Product", 0);
        check = intent.getBooleanExtra("Check", false);
        setContentView(R.layout.activity_termscondition);
        Log.d("termsconditions: user", user.getName());

        //product 1: 1달
        //product 2: 10분

        terms = (Button)findViewById(R.id.terms);
        join = (Button)findViewById(R.id.join);

        terms.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowTerms.class);
                intent.putExtra("User", user);
                intent.putExtra("Product", product_index);
                startActivity(intent);
            }
        });

        join.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(check) {
                    Intent intent = new Intent(getApplicationContext(), Payment.class);

                    intent.putExtra("User", user);
                    intent.putExtra("Product", product_index);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(TermsConditions.this, "보험 약관에 동의해 주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
