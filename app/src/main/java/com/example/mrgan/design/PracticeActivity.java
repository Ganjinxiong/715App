package com.example.mrgan.design;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mrgan.design.R;

//口算练习模块
public class PracticeActivity extends AppCompatActivity {

    private Intent intent;
    private String grade,type;
    private int maxLevel,minLevel,nowLevel,firstNum,secondNum;
    private IntergerNumber intergerNumber;
    private TextView typeTextView,firstTextView,secondTextView;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        intent = getIntent();

        grade = intent.getStringExtra("grade");
        type = intent.getStringExtra("type");
        switch (grade){
            case "一年级":
                maxLevel = 3;
                minLevel = 0;
                nowLevel = minLevel;
                break;
                default:
                    break;
        }
        intergerNumber =new IntergerNumber(0);
        firstNum = intergerNumber.createNumber();
        secondNum = intergerNumber.createNumber();

        Log.d("aaaaa",type);
        firstTextView= findViewById(R.id.firstTextView);
        secondTextView= findViewById(R.id.secondTextView);
        firstTextView.setText(firstNum+"");
        secondTextView.setText(secondNum+"");


        typeTextView = findViewById(R.id.typeTextView);
        switch (type){
            case "加法":
                typeTextView.setText("+");
                break;
            case "减法":
                typeTextView.setText("-");
                break;
        }
    }
}
