package com.example.mrgan.design;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ExamActivity extends AppCompatActivity {

    private Intent intent;
    private String grade, type, question, showStr, questionStr, result, answer;
    private String[] questionItem;
    private int nowLevel, ran, trueCount, totalCount, mark;
    private QuizGive quizGive;
    private TextView questionTextView, numTextView,lastTextView, lastResultTextView;
    private ImageView judgeImageView, judgeImageView2,nextView;
    private EditText answerEditText;
    private ActionBar actionBar;
    private Button exitButton, skipButton;
    private Long startTime, endTime, usedTime, usedMin, usedSec;
    private Boolean wrong;


    //显示得分和用时
    private void showResult() {
        mark = trueCount * 4;
        endTime = System.currentTimeMillis();
        usedTime = (endTime - startTime) / 1000;
        usedMin = usedTime / 60;
        usedSec = usedTime % 60;
        if (usedTime >= 60)
            showStr = "用时" + usedMin + "分" + usedSec + "秒";
        else
            showStr = "用时" + usedSec + "秒";
        new SweetAlertDialog(ExamActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(mark + "分")
                .setContentText(showStr)
                .setConfirmText("退出测验")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                        finish();
                    }
                })
                .show();
    }

    //显示错误的题
    @SuppressLint("SetTextI18n")
    private void showWrong() {
        lastTextView.setText(questionStr + answer);
        lastResultTextView.setText(result);
        judgeImageView.setVisibility(View.VISIBLE);
        judgeImageView2.setVisibility(View.VISIBLE);
    }

    //隐藏过时的错题
    @SuppressLint("SetTextI18n")
    private void disWrong() {
        lastTextView.setText("");
        lastResultTextView.setText("");
        judgeImageView.setVisibility(View.INVISIBLE);
        judgeImageView2.setVisibility(View.INVISIBLE);
    }

    //随机出题类型
    private String randomType(String grade) {
        if (grade.equals("一年级")) {
            ran = (int) (Math.random() * 2);
            switch (ran) {
                case 0:
                    return "加法";
                default:
                    return "减法";
            }
        } else {
            ran = (int) (Math.random() * 4);
            switch (ran) {
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


    //出题
    @SuppressLint("SetTextI18n")
    private void createQuestion() {
        //难度调整
        if (grade.equals("一年级")) {
            if (totalCount > 20) {
                nowLevel = 4;
            } else if (totalCount > 15) {
                nowLevel = 3;
            } else if (totalCount > 10) {
                nowLevel = 2;
            } else if (totalCount > 5) {
                nowLevel = 1;
            }
        } else {
            if (totalCount > 17) {
                nowLevel = 2;
            } else if (totalCount > 9) {
                nowLevel = 1;
            }
        }
        //随机类型
        type = randomType(grade);
        answerEditText.setText("");
        quizGive = new QuizGive(grade, type, nowLevel);
        question = quizGive.give();
        questionItem = question.split("=");
        questionStr = questionItem[0] + "=";
        questionTextView.setText(questionStr);
        numTextView.setText(totalCount + "");
        //本题答案
        result = questionItem[1];
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

        questionTextView = findViewById(R.id.now2);
        nextView =findViewById(R.id.imageView4);
        lastTextView = findViewById(R.id.last2);
        lastResultTextView = findViewById(R.id.last3);
        answerEditText = findViewById(R.id.answer2);
        numTextView = findViewById(R.id.questionNum);
        exitButton = findViewById(R.id.exit2);
        skipButton = findViewById(R.id.skip2);
        judgeImageView = findViewById(R.id.judge2);
        judgeImageView2 = findViewById(R.id.judge3);

        //难度
        nowLevel = 0;
        //做对了多少
        trueCount = 0;
        //第几题
        totalCount = 1;
        createQuestion();
        wrong = false;
        startTime = System.currentTimeMillis();


        //下一题
        nextView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                answer = answerEditText.getText().toString();
                if (answer.equals(result)) {
                    if (wrong) {
                        disWrong();
                        wrong =false;
                    }
                    trueCount++;
                } else if (answer.equals("")) {
                    if (wrong) {
                       disWrong();
                        wrong =false;
                    }
                } else {
                    showWrong();
                    wrong =true;
                }

                if (totalCount == 25) {
                    showResult();
                } else {
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
                   showResult();
                } else {
                    if (wrong) {
                        disWrong();
                        wrong =false;
                    }
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
