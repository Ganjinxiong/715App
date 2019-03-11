package com.example.mrgan.design;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

//口算练习模块
public  class PracticeActivity extends AppCompatActivity {

    private Intent intent;
    private String grade,type;
    private int maxLevel,minLevel,nowLevel,firstNum,secondNum,result,answer;
    private IntergerNumber intergerNumber;
    private TextView typeTextView,firstTextView,secondTextView;
    private EditText answerEditText;
    private ImageView judgeImage;
    private MyHandler handler;
    private ActionBar actionBar;

    public void createQuestion(){
        judgeImage.setVisibility(View.INVISIBLE);
        answerEditText.setText("");
        intergerNumber = new IntergerNumber(0);
        firstNum = intergerNumber.createNumber();
        secondNum = intergerNumber.createNumber();
        switch (type) {
            case "加法":
                typeTextView.setText("+");
                result = firstNum+secondNum;
                break;
            case "减法":
                typeTextView.setText("-");
                while (firstNum<secondNum)
                    secondNum = intergerNumber.createNumber();
                result = firstNum-secondNum;
                break;
        }
        firstTextView.setText(firstNum + "");
        secondTextView.setText(secondNum + "");
    }

    static class MyHandler extends Handler {
        WeakReference<PracticeActivity> mActivity;

        MyHandler(PracticeActivity activity) {
            mActivity = new WeakReference<PracticeActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            PracticeActivity theActivity = mActivity.get();
            switch (msg.what){
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

        firstTextView = findViewById(R.id.firstTextView);
        secondTextView = findViewById(R.id.secondTextView);
        typeTextView = findViewById(R.id.typeTextView);
        judgeImage = findViewById(R.id.judge);
        answerEditText = findViewById(R.id.answer);
        handler =new MyHandler(this);
        Message message = new Message();
        message.what = 1;
        handler.sendMessage(message);
        createQuestion();

        actionBar=getSupportActionBar();
        if (actionBar!=null)
            actionBar.hide();

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
                        judgeImage.setVisibility(View.VISIBLE);
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
                          judgeImage.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


    }
}
