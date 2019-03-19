package com.example.mrgan.design;


import android.util.Log;

import java.text.DecimalFormat;

public class Quizs {

    String quiz = "";
    private int num1 = 0, num2 = 0, num3 = 0, tmp = 0, ran, answer;
    private double answer2;
    double dbl1 = 0.00, dbl2 = 0.00, dbl3 = 0.00;
    DecimalFormat decimalFormat;

    public Quizs() {
        decimalFormat = new DecimalFormat("0.00");
    }

    //加法随机交换数字位置
    public void swap() {
        ran = (int) (Math.random() * 2);
        if (ran == 1) {
            num1 = num1 + num2;
            num2 = num1 - num2;
            num1 = num1 - num2;
        }
    }

    public int getNumInRange(int min, int max) {//获得[min,max]内的随机数
        int result = (int) (min + Math.random() * (max - min + 1));
        return result;
    }


    public double getDoubleInRange(double min, double max) {//获得[min,max]内的随机两位小数
        int minTemp = (int) (min * 100);
        int maxTemp = (int) (max * 100);
        int temp = (int) (minTemp + Math.random() * (maxTemp - minTemp + 1));
        double result = temp;
        return result / 100;
    }

    ////////////////一年级
    public String GradeOnePlus0() {//一位数加法
        num1 = getNumInRange(0, 9);
        num2 = getNumInRange(0, 9);
        swap();
        answer = num1 + num2;
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOnePlus1() {//十加几
        num1 = 10;
        num2 = getNumInRange(0, 9);
        swap();
        answer = num1 + num2;
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOnePlus2() {//十几加几
        num1 = getNumInRange(11, 20);
        num2 = getNumInRange(1, 9);
        swap();
        answer = num1 + num2;
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOnePlus3() {//整十加法
        num1 = getNumInRange(1, 9) * 10;
        num2 = getNumInRange(1, 9) * 10;
        swap();
        answer = num1 + num2;
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOnePlus4() {//两位数加整十
        num1 = getNumInRange(11, 99);
        num2 = getNumInRange(1, 9) * 10;
        swap();
        answer = num1 + num2;
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOneMinus0() {//一位数减法
        num1 = getNumInRange(0, 9);
        num2 = getNumInRange(0, 9);
        if (num2 > num1) {
            num2 = num2 - num1;
            num1 = num1 + num2;
            num2 = num1 - num2;
        }
        answer = num1 - num2;
        quiz = num1 + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOneMinus1() {//十减一位数
        num1 = 10;
        num2 = getNumInRange(0, 9);
        answer = num1 - num2;
        quiz = num1 + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOneMinus2() {//十几减几
        num1 = getNumInRange(11, 19);
        num2 = getNumInRange(1, 9);
        answer = num1 - num2;
        quiz = num1 + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOneMinus3() {//整十数减一位数
        num1 = getNumInRange(2, 9) * 10;
        num2 = getNumInRange(1, 9);
        answer = num1 - num2;
        quiz = num1 + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeOneMinus4() {//两位数减整十数
        num1 = getNumInRange(11, 99);
        num2 = getNumInRange(1, 9) * 10;
        while (num2 > num1) {
            num2 = getNumInRange(1, 9) * 10;
        }
        answer = num1 - num2;
        quiz = num1 + "-" + num2 + "=" + answer;
        return quiz;
    }

    /////////////二年级

    public String GradeTwoPlus0() {//一位数连加
        num1 = getNumInRange(0, 9);
        num2 = getNumInRange(0, 9);
        num3 = getNumInRange(0, 9);
        answer = num1 + num2 + num3;
        quiz = num1 + "+" + num2 + "+" + num3 + "=" + answer;
        return quiz;
    }

    public String GradeTwoPlus1() {//两位数加两位数（不进位）
        num1 = getNumInRange(11, 99);
        num2 = getNumInRange(11, 99);
        while ((num1 % 10) + (num2 % 10) >= 10) {
            num2 = getNumInRange(11, 99);
        }
        answer = num1 + num2;
        swap();
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeTwoPlus2() {//两位数加两位数（进位）
        num1 = getNumInRange(11, 99);
        num2 = getNumInRange(11, 99);
        while ((num1 % 10) + (num2 % 10) < 10) {
            num2 = getNumInRange(11, 99);
        }
        answer = num1 + num2;
        swap();
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeTwoMinus0() {//一位数连减
        num1 = getNumInRange(0, 9);
        num2 = getNumInRange(0, 9);
        num3 = getNumInRange(0, 9);
        tmp = num1 + num2 + num3;
        answer = tmp - num1 - num2;
        quiz = tmp + "-" + num1 + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeTwoMinus1() {//两位数减两位数（不退位）
        num1 = getNumInRange(11, 99);
        num2 = getNumInRange(11, 99);
        while ((num1 % 10) + (num2 % 10) >= 10) {
            num2 = getNumInRange(11, 99);
        }
        tmp = num1 + num2;
        answer = tmp - num2;
        quiz = tmp + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeTwoMinus2() {//两位数减两位数（退位）
        num1 = getNumInRange(11, 99);
        num2 = getNumInRange(11, 99);
        while ((num1 % 10) + (num2 % 10) < 10) {
            num2 = getNumInRange(11, 99);
        }
        tmp = num1 + num2;
        answer = tmp - num2;
        quiz = tmp + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeTwoMul0() {//一位数乘一位数
        num1 = getNumInRange(0, 9);
        num2 = getNumInRange(0, 9);
        answer = num1 * num2;
        quiz = num1 + "×" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeTwoMul1() {//一位数乘一位数加一位数
        num1 = getNumInRange(0, 9);
        num2 = getNumInRange(0, 9);
        num3 = getNumInRange(1, 9);
        answer = num1 * num2 + num3;
        quiz = num1 + "×" + num2 + "+" + num3 + "=" + answer;
        return quiz;
    }

    public String GradeTwoMul2() {//一位数乘一位数减一位数
        num1 = getNumInRange(0, 9);
        num2 = getNumInRange(0, 9);
        num3 = getNumInRange(1, 9);
        if ((num1 * num2) < num3) {
            num3 = getNumInRange(1, 9);
        }
        answer = num1 * num2 - num3;
        quiz = num1 + "×" + num2 + "-" + num3 + "=" + answer;
        return quiz;
    }

    public String GradeTwoDiv0() {//乘法口诀范围内的除法
        num1 = getNumInRange(1, 9);//除数
        num2 = getNumInRange(1, 9);//商
        tmp = num1 * num2;//被除数
        answer = tmp / num1;
        quiz = tmp + "÷" + num1 + "=" + answer;
        return quiz;
    }

    public String GradeTwoDiv1() {//除完后加一个数
        num1 = getNumInRange(1, 9);//除数
        num2 = getNumInRange(1, 9);//商
        tmp = num1 * num2;//被除数
        num3 = getNumInRange(1, 9);//加数
        answer = tmp / num1 + num3;
        quiz = tmp + "÷" + num1 + "+" + num3 + "=" + answer;
        return quiz;
    }

    public String GradeTwoDiv2() {//除完后减一位数
        num1 = getNumInRange(1, 9);//除数
        num2 = getNumInRange(1, 9);//商
        tmp = num1 * num2;//被除数
        num3 = getNumInRange(1, 9);//减数
        while (num3 > num2) {
            num3 = getNumInRange(1, 9);
        }
        answer = tmp / num1 - num3;
        quiz = tmp + "÷" + num1 + "-" + num3 + "=" + answer;
        return quiz;
    }


    //////////四年级
    public String GradeFourPlus0() {//加法交换律a+b+c=a+c+b
        num1 = getNumInRange(11, 99);//b
        num2 = getNumInRange(2, 10) * 10;//a+c
        num3 = getNumInRange(1, 89);//a
        while (num2 < num3) {
            num3 = getNumInRange(1, 89);
        }
        tmp = num2 - num3;//c
        answer = num3 + num1 + tmp;
        quiz = num3 + "+" + num1 + "+" + tmp + "=" + answer;
        return quiz;
    }

    public String GradeFourPlus1() {//加法结合律a+b+c=a+(b+c)
        num1 = getNumInRange(11, 99);//a
        num2 = getNumInRange(2, 10) * 10;//b+c
        num3 = getNumInRange(1, 89);//b
        while (num2 < num3) {
            num3 = getNumInRange(1, 89);
        }
        tmp = num2 - num3;//c
        answer = num1 + num3 + tmp;
        quiz = num1 + "+" + num3 + "+" + tmp + "=" + answer;
        return quiz;
    }

    public String GradeFourPlus2() {//小数加法
        dbl1 = getDoubleInRange(0.01, 9.99);
        dbl2 = getDoubleInRange(0.01, 9.99);
        answer2 = dbl1 + dbl2;
        quiz = dbl1 + "+" + dbl2 + "=" + decimalFormat.format(answer2);
        return quiz;
    }

    public String GradeFourMinus0() {//减法性质a-b-c=a-c-b
        num1 = getNumInRange(11, 99);//c
        num2 = getNumInRange(1, 9) * 10;//a-c
        num3 = getNumInRange(11, 99);//b
        while (num2 < num3) {
            num3 = getNumInRange(11, 99);
        }
        tmp = num1 + num2;//a
        answer = tmp - num3 - num1;
        quiz = tmp + "-" + num3 + "-" + num1 + "=" + answer;
        return quiz;
    }

    public String GradeFourMinus1() {//减法性质a-b-c=a-(b+c)
        num1 = getNumInRange(21, 99);//a
        num2 = getNumInRange(2, 9) * 10;//b+c
        while (num1 < num2) {
            num2 = getNumInRange(2, 9) * 10;
        }
        num3 = getNumInRange(11, 89);//b
        while (num2 < num3) {
            num3 = getNumInRange(11, 89);
        }
        tmp = num2 - num3;//c
        answer = num1 - num3 - tmp;
        quiz = num1 + "-" + num3 + "-" + tmp + "=" + answer;
        return quiz;
    }

    public String GradeFourMinus2() {//小数减法
        dbl1 = getDoubleInRange(0.01, 9.99);
        dbl2 = getDoubleInRange(0.01, 9.99);
        while (dbl1 < dbl2) {
            dbl2 = getDoubleInRange(0.01, 9.99);
        }
        answer2 = dbl1 - dbl2;
        quiz = dbl1 + "-" + dbl2 + "=" + decimalFormat.format(answer2);
        return quiz;
    }

    public String GradeFourMul0() {//乘法交换律a*b*c=a*c*b
        num1 = getNumInRange(11, 19);//b
        num2 = getNumInRange(1, 5) * 5;//a
        num3 = getNumInRange(1, 4) * 2;//c
        answer = num1 * num2 * num3;
        quiz = num2 + "×" + num1 + "×" + num3 + "=" + answer;
        return quiz;
    }

    public String GradeFourMul1() {//乘法结合律a*b*c=a*(b*c)
        num1 = getNumInRange(11, 19);//a
        num2 = getNumInRange(1, 5) * 5;//b
        num3 = getNumInRange(1, 4) * 2;//c
        answer = num1 * num2 * num3;
        quiz = num1 + "×" + num2 + "×" + num3 + "=" + answer;
        return quiz;
    }

    public String GradeFourMul2() {//乘法分配律a*b+a*c=a*(b+c)
        num1 = getNumInRange(11, 59);//a
        num2 = getNumInRange(1, 9) * 10;//b+c
        num3 = getNumInRange(11, 59);//c
        while (num3 > num2) {
            num3 = getNumInRange(11, 59);
        }
        tmp = num2 - num3;//b
        answer = num1 * tmp + num1 * num3;
        quiz = num1 + "×" + tmp + "+" + num1 + "×" + num3 + "=" + answer;
        return quiz;
    }

    public String GradeFourDiv0() {//除数为一位数，商为两位数
        num1 = getNumInRange(1, 9);//除数
        num2 = getNumInRange(11, 99);//商
        tmp = num1 * num2;//被除数
        answer = tmp / num1;
        quiz = tmp + "÷" + num1 + "=" + answer;
        return quiz;
    }

    public String GradeFourDiv1() {//除数为整十数，商为一位数
        num1 = getNumInRange(1, 9);//商
        num2 = getNumInRange(1, 9) * 10;//除数
        tmp = num1 * num2;//被除数
        answer = tmp / num2;
        quiz = tmp + "÷" + num2 + "=" + answer;
        return quiz;
    }


    public String GradeFourDiv2() {//除数为两位数，商为一位数
        num1 = getNumInRange(1, 9);//商
        num2 = getNumInRange(11, 99);//除数
        tmp = num1 * num2;//被除数
        answer = tmp / num2;
        quiz = tmp + "÷" + num2 + "=" + answer;
        return quiz;
    }

}
