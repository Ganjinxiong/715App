package com.example.mrgan.design;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mrgan.design.R;

import org.litepal.LitePal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {
    private View item1, item1_1, item1_2, item1_3, item2, item2_1, item2_2,item3,item3_1,item3_2;
    private TextView dateText;
    private Spinner spinner1, spinner2, spinner3,spinner4;
    private int year, month, day, week;
    private String grade, type;
    private Button startPracticeBt, startExamBt,startRectifyBt;
    private List<CharSequence> list1, list2;
    private ArrayAdapter<CharSequence> adapter1, adapter2;
    private Intent intent;
    private ActionBar actionBar;
    private List<Question> questionList;
    private Iterator iterator;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏标题栏
        actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        //显示当前日期
        dateText = (TextView) findViewById(R.id.textView8);
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;//获取月份，0-11要加1
        day = calendar.get(Calendar.DAY_OF_MONTH);
        week = calendar.get(Calendar.DAY_OF_WEEK) - 1;//从星期天算起
        String weekStr;
        switch (week) {
            case 1:
                weekStr = "一";
                break;
            case 2:
                weekStr = "二";
                break;
            case 3:
                weekStr = "三";
                break;
            case 4:
                weekStr = "四";
                break;
            case 5:
                weekStr = "五";
                break;
            case 6:
                weekStr = "六";
                break;
            default:
                weekStr = "日";
        }
        dateText.setText(year + "年" + month + "月" + day + "日  星期" + weekStr);

        //spinner数据绑定
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        list1 = new ArrayList<>();
        list1.add("加法");
        list1.add("减法");
        list1.add("乘法");
        list1.add("除法");
        adapter1 = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list2 = new ArrayList<>();
        list2.add("加法");
        list2.add("减法");
        adapter2 = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    spinner2.setAdapter(adapter1);
                } else spinner2.setAdapter(adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //选项扩展
        item1 = (View) findViewById(R.id.item1);
        item1_1 = (View) findViewById(R.id.item1_1);
        item1_2 = (View) findViewById(R.id.item1_2);
        item1_3 = (View) findViewById(R.id.item1_3);
        item1_1.setVisibility(View.GONE);
        item1_2.setVisibility(View.GONE);
        item1_3.setVisibility(View.GONE);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item1_1.getVisibility() == View.VISIBLE) {
                    item1_1.setVisibility(View.GONE);
                    item1_2.setVisibility(View.GONE);
                    item1_3.setVisibility(View.GONE);
                } else {
                    item1_1.setVisibility(View.VISIBLE);
                    item1_2.setVisibility(View.VISIBLE);
                    item1_3.setVisibility(View.VISIBLE);
                }
                item2_1.setVisibility(View.GONE);
                item2_2.setVisibility(View.GONE);
                item3_1.setVisibility(View.GONE);
                item3_2.setVisibility(View.GONE);
            }
        });
        item2 = (View) findViewById(R.id.item2);
        item2_1 = (View) findViewById(R.id.item2_1);
        item2_2 = (View) findViewById(R.id.item2_2);
        item2_1.setVisibility(View.GONE);
        item2_2.setVisibility(View.GONE);
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item2_1.getVisibility() == View.VISIBLE) {
                    item2_1.setVisibility(View.GONE);
                    item2_2.setVisibility(View.GONE);
                } else {
                    item2_1.setVisibility(View.VISIBLE);
                    item2_2.setVisibility(View.VISIBLE);
                }
                item1_1.setVisibility(View.GONE);
                item1_2.setVisibility(View.GONE);
                item1_3.setVisibility(View.GONE);
                item3_1.setVisibility(View.GONE);
                item3_2.setVisibility(View.GONE);
            }
        });
        item3 = (View) findViewById(R.id.item3);
        item3_1 = (View) findViewById(R.id.item3_1);
        item3_2 = (View) findViewById(R.id.item3_2);
        item3_1.setVisibility(View.GONE);
        item3_2.setVisibility(View.GONE);
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item3_1.getVisibility() == View.VISIBLE) {
                    item3_1.setVisibility(View.GONE);
                    item3_2.setVisibility(View.GONE);
                } else {
                    item3_1.setVisibility(View.VISIBLE);
                    item3_2.setVisibility(View.VISIBLE);
                }
                item1_1.setVisibility(View.GONE);
                item1_2.setVisibility(View.GONE);
                item1_3.setVisibility(View.GONE);
                item2_1.setVisibility(View.GONE);
                item2_2.setVisibility(View.GONE);
            }
        });


        //口算练习模块
        startPracticeBt = (Button) findViewById(R.id.button1);
        startPracticeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPracticeBt.setClickable(false);
                intent = new Intent(MainActivity.this, PracticeActivity.class);
                grade = spinner1.getSelectedItem().toString();
                type = spinner2.getSelectedItem().toString();
                intent.putExtra("grade", grade);
                intent.putExtra("type", type);
                startActivity(intent);
            }
        });

        //模拟测验模块
        startExamBt = findViewById(R.id.button2);
        startExamBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startExamBt.setClickable(false);
                intent = new Intent(MainActivity.this, ExamActivity.class);
                grade = spinner3.getSelectedItem().toString();
                intent.putExtra("grade", grade);
                startActivity(intent);
            }
        });

        //错题纠正模块
        startRectifyBt = findViewById(R.id.button3);
        startRectifyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRectifyBt.setClickable(false);
                grade = spinner4.getSelectedItem().toString();
                questionList = LitePal.where("grade like ?", grade).find(Question.class);
                iterator = questionList.iterator();
                if (iterator.hasNext()) {
                    intent = new Intent(MainActivity.this, RectifyActivity.class);
                    intent.putExtra("grade", grade);
                    startActivity(intent);
                }
                else {
                    new SweetAlertDialog(MainActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("该年级的错题已纠正")
                            .setConfirmText("退出纠正")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    startRectifyBt.setClickable(true);
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                }
            }
        });

        LitePal.getDatabase();

    }

    @Override
    protected void onResume() {
        super.onResume();
        startPracticeBt.setClickable(true);
        startExamBt.setClickable(true);
        startRectifyBt.setClickable(true);
    }
}
