package com.example.bomin_project;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Myinsure extends AppCompatActivity {
    USER user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        user = (USER) intent.getSerializableExtra("User");

        int product_index = user.getCurrent_product();


        if(product_index == 0)
        {
            setContentView(R.layout.activity_emptymyinsure);
        }
        else {
            if (product_index == 1) {
                setContentView(R.layout.activity_myinsure);
                TextView price = (TextView) findViewById(R.id.price);
                price.setText("8,000원");
                TextView term = (TextView) findViewById(R.id.term);
                term.setText("1달");
            } else if (product_index == 2) {
                setContentView(R.layout.activity_myinsure);
                TextView price = (TextView) findViewById(R.id.price);
                price.setText("200원");
                TextView term = (TextView) findViewById(R.id.term);
                term.setText("10분");
            }

            //보험 약관 확인
            RelativeLayout information = (RelativeLayout)findViewById(R.id.information);
            information.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(Myinsure.this);
                    dialog.setContentView(R.layout.insure_info);
                    dialog.setTitle("'보험의 민족' 보험 안내문");
                    dialog.show();
                }
            });
            RelativeLayout termsview = (RelativeLayout)findViewById(R.id.termsview);
            termsview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(Myinsure.this);
                    dialog.setContentView(R.layout.privacy);
                    dialog.setTitle("개인정보취급약관");
                    dialog.show();
                }
            });

            //사고 접수
            RelativeLayout accident = (RelativeLayout)findViewById(R.id.accident);
            accident.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Accident.class);
                    intent.putExtra("User", user);
                    startActivity(intent);
                }
            });

        }

        LinearLayout my_insure = (LinearLayout) findViewById (R.id.my_insure);
        my_insure.setBackgroundColor(Color.LTGRAY);


        //보험 가입
        LinearLayout insurance = (LinearLayout) findViewById (R.id.insurance);
        insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Insurance.class);
                intent.putExtra("User", user);
                startActivity(intent);
            }
        });

        //나의 보험
        my_insure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Myinsure.class);
                intent.putExtra("User", user);
                startActivity(intent);
            }
        });

        //마이페이지
        LinearLayout mypage = (LinearLayout) findViewById (R.id.mypage);
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mypage.class);
                intent.putExtra("User", user);
                startActivity(intent);
            }
        });

    }
}