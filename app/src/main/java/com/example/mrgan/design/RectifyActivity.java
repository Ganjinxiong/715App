package com.example.mrgan.design;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.LitePal;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RectifyActivity extends AppCompatActivity {

    private Intent intent;
    private String grade, answer, result;
    private ActionBar actionBar;
    private Button exitButton, skipButton;
    private EditText answerEditText;
    private ImageView judgeImage,judgeImage2;
    private TextView oldquestionTextView, oldanswerTextView;
    private Handler handler;
    private Message message;
    private List<Question> questionList,questionList2;
    private Iterator iterator,iterator2;

    private void createQuestion() {
        if (iterator.hasNext()) {
            answerEditText.setText("");
            judgeImage.setImageResource(R.drawable.xie2);
            Question question = (Question) iterator.next();
            oldquestionTextView.setText(question.getqString());
            oldanswerTextView.setText(question.getAnswer());
            if (question.getAnswer().equals("?"))
                judgeImage2.setVisibility(View.GONE);
            else judgeImage2.setVisibility(View.VISIBLE);
            result = question.getResult();
        } else {
            questionList = LitePal.where("grade like ?", grade).find(Question.class);
            iterator = questionList.iterator();
            if (iterator.hasNext()) {
               createQuestion();
            }else {
                new SweetAlertDialog(RectifyActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("该年级的错题已纠正")
                        .setConfirmText("退出纠正")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                finish();
                            }
                        })
                        .show();
            }
        }
    }

    static class MyHandler extends Handler {
        WeakReference<RectifyActivity> mActivity;

        MyHandler(RectifyActivity activity) {
            mActivity = new WeakReference<RectifyActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            RectifyActivity theActivity = mActivity.get();
            switch (msg.what) {
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
        setContentView(R.layout.activity_rectify);

        intent = getIntent();
        grade = intent.getStringExtra("grade");

        //隐藏标题栏
        actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        exitButton = findViewById(R.id.exit3);
        skipButton = findViewById(R.id.skip3);
        answerEditText = findViewById(R.id.answer3);
        judgeImage = findViewById(R.id.judge3);
        judgeImage2 = findViewById(R.id.judge4);
        oldquestionTextView = findViewById(R.id.oldquestion);
        oldanswerTextView = findViewById(R.id.oldanswer);

        handler = new MyHandler(this);
        questionList = LitePal.where("grade like ?", grade).find(Question.class);
        iterator = questionList.iterator();
        createQuestion();


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
                    answer = s.toString();
                    if (answer.equals(result)) {
                        judgeImage.setImageResource(R.drawable.dui);
                        LitePal.deleteAll(Question.class, "qString = ?", oldquestionTextView.getText().toString());
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                message = new Message();
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
                questionList2 = LitePal.where("grade like ?", grade).find(Question.class);
                iterator2 = questionList.iterator();
                iterator2.next();
                if (iterator2.hasNext())
                createQuestion();
                else {
                    new SweetAlertDialog(RectifyActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("这是最后一题了")
                            .setConfirmText("继续纠正")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    questionList = LitePal.where("grade like ?", grade).find(Question.class);
                                    iterator = questionList.iterator();
                                    createQuestion();
                                }
                            })
                            .show();
                }
            }
        });

        //退出
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(RectifyActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("要退出错题纠正吗？")
                        .setCancelText("是，退出纠正")
                        .setConfirmText("不，继续纠正")
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

    //重写onKeyDown()方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //点击返回键调用方法
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new SweetAlertDialog(RectifyActivity.this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("要退出错题纠正吗？")
                    .setCancelText("是，退出纠正")
                    .setConfirmText("不，继续纠正")
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
        return false;
    }
}
