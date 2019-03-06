package com.example.mrgan.listviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private View item1,item1_1,item1_2,item1_3;
    private TextView dateText;
    private Spinner spinner1,spinner2;
    private int year,month,day,week;
    private String grade,type;
    private Button startPracticeBt;
    private List<CharSequence> list1,list2;
    private ArrayAdapter<CharSequence> adapter1,adapter2;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner数据绑定
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2= (Spinner)findViewById(R.id.spinner2);
        list1 = new ArrayList<>();
        list1.add("加法");
        list1.add("减法");
        list1.add("乘法");
        list1.add("除法");
        adapter1 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list2 = new ArrayList<>();
        list2.add("加法");
        list2.add("减法");
        adapter2 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                     spinner2.setAdapter(adapter1);
                }
                else spinner2.setAdapter(adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //选项扩展
        item1 = (View)findViewById(R.id.item1);
        item1_1 = (View)findViewById(R.id.item1_1);
        item1_2 = (View)findViewById(R.id.item1_2);
        item1_3 = (View)findViewById(R.id.item1_3);
        item1_1.setVisibility(View.GONE);
        item1_2.setVisibility(View.GONE);
        item1_3.setVisibility(View.GONE);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item1_1.getVisibility()==View.VISIBLE){
                    item1_1.setVisibility(View.GONE);
                    item1_2.setVisibility(View.GONE);
                    item1_3.setVisibility(View.GONE);
                }
                else {
                    item1_1.setVisibility(View.VISIBLE);
                    item1_2.setVisibility(View.VISIBLE);
                    item1_3 .setVisibility(View.VISIBLE);
                }
            }
        });
        //显示当前日期
        dateText = (TextView)findViewById(R.id.textView8);
        Date now = new Date();
        Calendar calendar =Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;//获取月份，0-11要加1
        day = calendar.get(Calendar.DAY_OF_MONTH);
        week = calendar.get(Calendar.DAY_OF_WEEK)-1;//从星期天算起
        String weekStr ;
        switch (week){
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
                weekStr= "日";
        }
        dateText.setText(year+"年"+month+"月"+day+"日  星期"+weekStr);

        //口算练习模块
        startPracticeBt = (Button)findViewById(R.id.button1);
        grade = spinner1.getSelectedItem().toString();
        type = spinner2.getSelectedItem().toString();
        startPracticeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PracticeActivity.class);
                intent.putExtra("grade",grade);
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });
    }
}
