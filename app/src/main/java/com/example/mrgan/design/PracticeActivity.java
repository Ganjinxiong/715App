package com.example.mrgan.design;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

//口算练习模块
public class PracticeActivity extends AppCompatActivity {

    private Intent intent;
    private String grade, type;
    private int maxLevel, minLevel, nowLevel, firstNum, secondNum, result, answer;
    private IntergerNumber intergerNumber;
    private TextView nowTextView, lastTextView, nextTextView;
    private EditText answerEditText;
    private ImageView judgeImage;
    private Button exitButton, skipButton;
    private MyHandler handler;
    private ActionBar actionBar;
    private Boolean isfirst;


    public void createQuestion() {


        answerEditText.setText("");
        intergerNumber = new IntergerNumber(0);

        //是否第一次出题，是就不显示上次的题目
        if (isfirst) {
            firstNum = intergerNumber.createNumber();
            secondNum = intergerNumber.createNumber();
            switch (type) {
                case "加法":
                    nowTextView.setText(firstNum + "+" + secondNum + "=");
                    result = firstNum + secondNum;
                    break;
                case "减法":
                    while (firstNum < secondNum)
                        secondNum = intergerNumber.createNumber();
                    nowTextView.setText(firstNum + "-" + secondNum + "=");
                    result = firstNum - secondNum;
                    break;
            }
            isfirst = false;
        } else {
            judgeImage.setImageResource(R.drawable.xie2);
            lastTextView.setText(nowTextView.getText().toString() + result);
            nowTextView.setText(nextTextView.getText().toString().substring(0, nextTextView.getText().toString().length() - 1));
            switch (type) {
                case "加法":
                    result = firstNum + secondNum;
                    break;
                case "减法":
                    result = firstNum - secondNum;
                    break;
            }
        }

        //下一题
        firstNum = intergerNumber.createNumber();
        secondNum = intergerNumber.createNumber();
        switch (type) {
            case "加法":
                nextTextView.setText(firstNum + "+" + secondNum + "=?");
                break;
            case "减法":
                while (firstNum < secondNum)
                    secondNum = intergerNumber.createNumber();
                nextTextView.setText(firstNum + "-" + secondNum + "=?");
                break;
        }

    }

    static class MyHandler extends Handler {
        WeakReference<PracticeActivity> mActivity;

        MyHandler(PracticeActivity activity) {
            mActivity = new WeakReference<PracticeActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            PracticeActivity theActivity = mActivity.get();
            switch (msg.what) {
                case 0:
                    theActivity.createQuestion();
                    break;
                case 1:
                    SystemClock.sleep(1000);
                    theActivity.createQuestion();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        judgeImage = findViewById(R.id.judge);
        answerEditText = findViewById(R.id.answer);
        exitButton = findViewById(R.id.exit);
        skipButton = findViewById(R.id.skip);
        nowTextView = findViewById(R.id.now);
        lastTextView = findViewById(R.id.last);
        nextTextView = findViewById(R.id.next);


        //接收数据
        intent = getIntent();
        grade = intent.getStringExtra("grade");
        type = intent.getStringExtra("type");
        switch (grade) {
            case "一年级":
                maxLevel = 3;
                minLevel = 0;
                nowLevel = minLevel;
                break;
            default:
                break;
        }


        //隐藏标题栏
        actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        //初始化题目
        handler = new MyHandler(this);
        isfirst = true;
        Message message = new Message();
        message.what = 0;
        handler.sendMessage(message);


        //判断对错，进行下一题
        answerEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                if (!answerEditText.getText().toString().equals("")) {
                    answer = Integer.parseInt(s.toString());
                    if (answer == result) {
                        judgeImage.setImageResource(R.drawable.dui);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Message message = new Message();
                                message.what = 1;
                                handler.sendMessage(message);
                            }
                        }).start();
                    } else {
                        judgeImage.setImageResource(R.drawable.cuo);
                    }
                }
            }
        });


        //跳过这题
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createQuestion();
            }
        });

        //退出
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
