package com.example.mrgan.design;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ExamActivity extends AppCompatActivity {

    private Intent intent;
    private String grade,type,question,answerStr;
    private String[] questionItem;
    private int nowLevel,ran,firstNum,secondNum,result,answer,trueCount,totalCount,mark;
    private QuizGive quizGive;
    private TextView questionTextView,numTextView,nextTextView;
    private EditText answerEditText;
    private ActionBar actionBar;
    private Button exitButton, skipButton;

    //随机出题类型
    public String randomType(String grade){
        if (grade.equals("一年级")) {
            ran =(int)(Math.random()*2);
            switch (ran){
                case 0:
                    return "加法";
                default:
                    return "减法";
            }
        }else {
            ran =(int)(Math.random()*4);
            switch (ran){
                case 0:
                    return "加法";
                case 1:
                    return "减法";
                case 2:
                    return "乘法";
                    default:
                        return "除法";
            }
        }
    }

    private void createQuestion(){
        if (totalCount>20){
            nowLevel = 4;
        }else if (totalCount>15){
            nowLevel = 3;
        }else if (totalCount>10){
            nowLevel = 2;
        }else if (totalCount>5){
            nowLevel = 1;
        }
        type = randomType(grade);
        quizGive = new QuizGive(grade,type,nowLevel);
        question = quizGive.give();
        answerEditText.setText("");
        questionTextView.setText(question);
        numTextView.setText(totalCount+"");
        answer = 9999;
        //算出本题答案
        switch (type) {
            case "加法":
                questionItem = question.substring(0,question.length()-1).split("\\+");
                firstNum = Integer.parseInt(questionItem[0]);
                secondNum = Integer.parseInt(questionItem[1]);
                result = firstNum + secondNum;
                break;
            case "减法":
                questionItem = question.substring(0,question.length()-1).split("-");
                firstNum = Integer.parseInt(questionItem[0]);
                secondNum = Integer.parseInt(questionItem[1]);
                result = firstNum - secondNum;
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        //隐藏标题栏
        actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        //接收数据
        intent = getIntent();
        grade = intent.getStringExtra("grade");
        //难度
        nowLevel = 0;
        //做对了多少
        trueCount = 0;
        //第几题
        totalCount = 1;
        questionTextView = findViewById(R.id.now2);
        nextTextView = findViewById(R.id.next2);
        answerEditText = findViewById(R.id.answer2);
        numTextView = findViewById(R.id.questionNum);
        exitButton = findViewById(R.id.exit2);
        skipButton = findViewById(R.id.skip2);

        switch (grade){
            case "一年级":
                createQuestion();
                break;
                default:
                    break;
        }

        nextTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerStr = answerEditText.getText().toString();
                if (!answerStr.equals("")) {
                    answer = Integer.parseInt(answerStr);
                    if (answer == result)
                        trueCount++;
                }
                Log.d("aaa",trueCount+"");
                Log.d("aaaa",answer+"");
                Log.d("aaaaa",result+"");
                if (totalCount == 25) {
                        mark = trueCount*4;
                    new SweetAlertDialog(ExamActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText(mark+"分")
                            .setConfirmText("退出测验")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    finish();
                                }
                            })
                            .show();
                }else {
                    totalCount++;
                    createQuestion();
                }
            }
        });


        //跳过这题
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalCount == 25) {
                    mark = trueCount*4;
                    new SweetAlertDialog(ExamActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText(mark+"分")
                            .setConfirmText("退出测验")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    finish();
                                }
                            })
                            .show();
                } else {
                    totalCount++;
                    createQuestion();
                }
            }
        });


        //退出
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(ExamActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("要退出模拟测验吗？")
                        .setCancelText("是，退出测验")
                        .setConfirmText("不，继续测验")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.cancel();
                                finish();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();

            }
        });
    }

}
