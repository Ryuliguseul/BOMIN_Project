package com.example.bomin_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Success extends AppCompatActivity {

    Button join;
    USER user;
    int product_index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Intent intent = getIntent();
        user = (USER) intent.getSerializableExtra("User");
        product_index = intent.getIntExtra("Product", 0);

        Log.d("check", "success");

        //user info update -> current product
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject( response );
                    boolean success = jsonObject.getBoolean( "success" );

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        String email = user.getEmail();

        UpdateRequest updateRequest = new UpdateRequest(email,product_index, responseListener);
        RequestQueue queue = Volley.newRequestQueue( Success.this );
        queue.add( updateRequest );


        join  = findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d("check", "여길 오긴 하는건가");
                Intent intent = new Intent(getApplicationContext(), Insurance.class);
                intent.putExtra("User", user);
                startActivity(intent);
            }
        });
    }
}
