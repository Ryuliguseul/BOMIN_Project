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

import com.dinuscxj.progressbar.CircleProgressBar;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MySafetyScore extends AppCompatActivity {

    USER user;
    CircleProgressBar circleProgressBar;
    private ArrayList<RideData> DataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        user = (USER) intent.getSerializableExtra("User");

        setContentView(R.layout.activity_mysafetyscore);

        circleProgressBar=findViewById(R.id.cpb_circlebar);
        circleProgressBar.setProgress(user.getSafety_score());

        LinearLayout mypage = (LinearLayout) findViewById (R.id.mypage);
        mypage.setBackgroundColor(Color.LTGRAY);

        //라이딩 기록 받아오기//

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

        DataList.add(new RideData("Lime", "1.6Km","20년 10월 31일", "27분"));
        DataList.add(new RideData("킥고잉", "0.5Km","20년 05월 13일", "10분"));
    }
}

class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<RideData> sample;

    public MyAdapter(Context context, ArrayList<RideData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public RideData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.list_riderinfo, null);

        TextView pm_date = (TextView)view.findViewById(R.id.pm_date);
        TextView pm_distance = (TextView)view.findViewById(R.id.pm_distance);
        TextView pm_name = (TextView)view.findViewById(R.id.pm_name);
        TextView pm_time = (TextView)view.findViewById(R.id.pm_time);

        pm_date.setText(sample.get(position).getPm_date());
        pm_distance.setText(sample.get(position).getPm_distance());
        pm_name.setText(sample.get(position).getPm_name());
        pm_time.setText(sample.get(position).getPm_time());

        return view;
    }
}