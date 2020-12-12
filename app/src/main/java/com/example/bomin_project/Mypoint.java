package com.example.bomin_project;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Mypoint extends AppCompatActivity {
    USER user;
    private ArrayList<RideData> DataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        user = (USER) intent.getSerializableExtra("User");

        setContentView(R.layout.activity_mypoint);

        LinearLayout mypage = (LinearLayout) findViewById (R.id.mypage);
        mypage.setBackgroundColor(Color.LTGRAY);

        //포인트와 쿠폰 서버에서 받아오는 과정 필요//
        TextView point = (TextView)findViewById(R.id.point);
        point.setText("1,080");

        TextView coupon = (TextView)findViewById(R.id.coupon);
        coupon.setText("2");

        //포인트 기록 받아오기//

        this.InitializeMovieData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this, DataList);

        listView.setAdapter(myAdapter);

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
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mypage.class);
                intent.putExtra("User", user);
                startActivity(intent);
            }
        });

    }

    public void InitializeMovieData()
    {
        DataList = new ArrayList<RideData>();

        DataList.add(new RideData("시간제 이용", "+ 810P","20년 10월 13일", "포인트 적립"));
        DataList.add(new RideData("월 단위 이용", "+ 8,000P","20년 05월 13일", "포인트 적립"));
    }
}