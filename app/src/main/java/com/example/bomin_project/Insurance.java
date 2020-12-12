package com.example.bomin_project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Insurance extends AppCompatActivity {
    USER user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        user = (USER) intent.getSerializableExtra("User");

        //get user info
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject( response );
                    boolean success = jsonObject.getBoolean( "success" );

                    if(success){
                        Log.d("Insurance", "get user info");
                        user.setEmail(jsonObject.getString( "UserEmail" ));
                        user.setName(jsonObject.getString( "UserName" ));
                        user.setCurrent_product(Integer.parseInt(jsonObject.getString( "CurrentProduct" )));
                        user.setSafety_score(Integer.parseInt(jsonObject.getString( "SafetyScore" )));
                    }

                } catch (JSONException e) {
                    Log.d("Insurance", "get user info fail");
                    e.printStackTrace();
                }

            }
        };
        String email = user.getEmail();

        GetUserRequest updateRequest = new GetUserRequest(email, responseListener);
        RequestQueue queue = Volley.newRequestQueue( Insurance.this );
        queue.add( updateRequest );

        Log.d("check", "Insurance Class");
        Log.d("name", user.getName());
        Log.d("currentproduct", Integer.toString(user.getCurrent_product()));
        setContentView(R.layout.activity_insurance);

        LinearLayout insurance = (LinearLayout) findViewById (R.id.insurance);
        insurance.setBackgroundColor(Color.LTGRAY);

        //보험 가입
        insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Insurance.class);
                intent.putExtra("User", user);
                startActivity(intent);
            }
        });

        //나의 보험
        LinearLayout myinsure = (LinearLayout) findViewById (R.id.myinsure);
        myinsure.setOnClickListener(new View.OnClickListener() {
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



        //1달 단위 보험
        LinearLayout product1 = (LinearLayout) findViewById (R.id.product1);
        product1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getCurrent_product() == 0) {
                    Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                    intent.putExtra("User", user);
                    intent.putExtra("Product", 1);
                    startActivity(intent);
                }
                else
                {
                    AlertDialog.Builder ad = new AlertDialog.Builder(Insurance.this);
                    ad.setTitle("").setMessage("이미 가입된 보험이 존재합니다.").setNeutralButton("확인", null).create().show();
                }

            }
        });

        //10분 단위 보험
        LinearLayout product2 = (LinearLayout) findViewById (R.id.product2);
        product2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getCurrent_product() == 0) {
                    Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                    intent.putExtra("User", user);
                    intent.putExtra("Product", 2);
                    startActivity(intent);
                }
                else
                {
                    AlertDialog.Builder ad = new AlertDialog.Builder(Insurance.this);
                    ad.setTitle("").setMessage("이미 가입된 보험이 존재합니다.").setNeutralButton("확인", null).create().show();
                }
            }
        });
    }
}