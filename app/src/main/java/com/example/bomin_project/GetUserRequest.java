package com.example.bomin_project;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class GetUserRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://ryuliguseul.dothome.co.kr/GetUser.php";
    private Map<String, String> map;

    public GetUserRequest(String UserEmail, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("UserEmail", UserEmail);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}