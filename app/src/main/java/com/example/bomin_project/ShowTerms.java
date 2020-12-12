package com.example.bomin_project;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShowTerms extends AppCompatActivity {

    // 다음진행 버튼
    public Button join;

    // 체크박스 체크여부
    public int TERMS_AGREE_1 = 0; // No Check = 0, Check = 1
    public int TERMS_AGREE_2 = 0; // No Check = 0, Check = 1
    public int TERMS_AGREE_3 = 0; // No Check = 0, Check = 1

    // 체크박스
    CheckBox check1; // 첫번쨰 동의
    CheckBox check2; // 두번쨰 동의
    CheckBox check3; // 전체 동의

    Button show1;
    Button show2;

    int product_index;
    USER user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_showterms);

        Intent intent = getIntent();
        user = (USER) intent.getSerializableExtra("User");
        product_index = intent.getIntExtra("Product", 0);
        Log.d("showterms: user", user.getName());

        join = (Button)findViewById(R.id.join);
        check1 = (CheckBox)findViewById(R.id.check1);
        check2 = (CheckBox)findViewById(R.id.check2);
        check3 = (CheckBox)findViewById(R.id.check3);
        show1 = (Button)findViewById(R.id.show1);
        show2 = (Button)findViewById(R.id.show2);

        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(ShowTerms.this);
                dialog.setContentView(R.layout.insure_info);
                dialog.setTitle("'보험의 민족' 보험 안내문");
                dialog.show();
            }
        });
        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(ShowTerms.this);
                dialog.setContentView(R.layout.privacy);
                dialog.setTitle("개인정보취급약관");
                dialog.show();
            }
        });

        // 초항동의
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TERMS_AGREE_1 = 1;
                }
                else {
                    TERMS_AGREE_1 = 0;
                }
            }
        });
        // 2항동의
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                              @Override
                                              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                  if (isChecked) {
                                                      TERMS_AGREE_2 = 1;
                                                  } else {
                                                      TERMS_AGREE_2 = 0;
                                                  }
                                              }
                                          }
        );

        // 전체동의
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                              @Override
                                              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                  if (isChecked) {
                                                      check1.setChecked(true);
                                                      check2.setChecked(true);
                                                      TERMS_AGREE_3 = 1;
                                                  } else {
                                                      check1.setChecked(false);
                                                      check2.setChecked(false);
                                                      TERMS_AGREE_3 = 0;
                                                  }
                                              }
                                          }
        );

        join.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("check", "약관 동의 완료");
                // 전체 약관 체크여부
                if (TERMS_AGREE_3 != 1) {
                    // 첫번째 약관 체크여부
                    if (TERMS_AGREE_2 == 1) {
                        // 두번쨰 약관 체크 여부
                        if (TERMS_AGREE_1 == 1) {
                            startActivity(new Intent(ShowTerms.this, TermsConditions.class));
                        }
                        else {
                            Toast.makeText(ShowTerms.this, "약관을 체크해주세요", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    else {
                        Toast.makeText(ShowTerms.this, "약관을 체크해주세요", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                // 전체 약관 체크된경우
                else {
                    Log.d("check", "전체 약관 동의");
                    Intent intent = new Intent(ShowTerms.this, TermsConditions.class);
                    intent.putExtra("User", user);
                    intent.putExtra("Product", product_index);
                    intent.putExtra("Check", true);
                    startActivity(intent);
                }
            }
        });

    }



}
