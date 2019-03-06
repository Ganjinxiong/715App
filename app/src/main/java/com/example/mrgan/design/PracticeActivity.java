package com.example.mrgan.design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mrgan.design.R;

//口算练习模块
public class PracticeActivity extends AppCompatActivity {

    private Intent intent;
    private String grade,type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        intent = getIntent();
        grade = intent.getStringExtra("grade");
        type = intent.getStringExtra("type");

    }
}
