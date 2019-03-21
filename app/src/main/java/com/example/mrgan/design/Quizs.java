package com.example.mrgan.design;

import java.text.DecimalFormat;

public class Quizs{

    String quiz = "";
    private int num1 = 0, num2 = 0, num3 = 0, tmp = 0, ran, answer;
    private double answer2;
    double dbl1 = 0.00, dbl2 = 0.00, dbl3 = 0.00;
    DecimalFormat decimalFormat;

    public Quizs(){
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


    public double getDoubleInRange(double min, double max) {//获得[min,max]内的随机两位小数
        int minTemp = (int) (min * 100);
        int maxTemp = (int) (max * 100);
        int temp = (int) (minTemp + Math.random() * (maxTemp - minTemp + 1));
        double result = temp;
        return result / 100;
    String fraction1,fraction2,fraction3,fraction4,answerStr;
    FractionCal f=new FractionCal();

    public String setFraction(int a, int b){//设置分子和分母，可约分则进行约分
        String fraction;
        int c=getGCD(Math.abs(a),Math.abs(b));//得出最大公约数
        int numerator=a/c;
        int denominator=b/c;
        if(numerator<0 && denominator<0){//分子分母同为负则转为正数
            numerator = - numerator;
            denominator = - denominator;
        }
        fraction=numerator+"/"+denominator;
        return fraction;
    }

    int getGCD(int a,int b){//计算最大公约数
        int c;
        if(a<b){
            c=a;
            a=b;
            b=c;
        }
        int r=a%b;
        while(r!=0){
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }

    public int getNumInRange(int min, int max) {//获得[min,max]内的随机数
        int result = (int) (min + Math.random() * (max - min + 1));
        return result;
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
    public double getDoubleInRange1(double min,double max){//获得[min,max]内的随机一位小数
        int minTemp=(int)(min*10);
        int maxTemp=(int)(max*10);
        int temp=(int)(minTemp+Math.random()*(maxTemp-minTemp+1));
        double result=temp;
        return result/10;
    }

    public double getDoubleInRange2(double min,double max){//获得[min,max]内的随机两位小数
        int minTemp=(int)(min*100);
        int maxTemp=(int)(max*100);
        int temp=(int)(minTemp+Math.random()*(maxTemp-minTemp+1));
        double result=temp;
        return result/100;
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


    ///三年级
    public String GradeThreePlus0() {//几百几十加几百几十
        num1 = getNumInRange(11, 99) * 10;
        num2 = getNumInRange(11, 99) * 10;
        answer = num1 + num2;
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreePlus1() {//任意三位数加几百几十
        num1 = getNumInRange(100, 999);
        num2 = getNumInRange(11, 99) * 10;
        swap();
        answer = num1 + num2;
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreePlus2() {//任意三位数加任意三位数
        num1 = getNumInRange(100, 999);
        num2 = getNumInRange(100, 999);
        answer = num1 + num2;
        quiz = num1 + "+" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreeMinus0() {//几百几十减几百几十
        num1 = getNumInRange(11, 99) * 10;
        num2 = getNumInRange(11, 99) * 10;
        if (num2 > num1) {
            tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        answer = num1 - num2;
        quiz = num1 + "-" + num2 + "=" + answer;
        return quiz;
    }


    public String GradeThreeMinus1() {//三位数减几百几十
        num1 = getNumInRange(101, 999);
        num2 = getNumInRange(10, 99) * 10;
        while (num2 > num1) {
            num2 = getNumInRange(10, 99) * 10;
        }
        answer = num1 - num2;
        quiz = num1 + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreeMinus2() {//任意三位数减任意三位数
        num1 = getNumInRange(100, 999);
        num2 = getNumInRange(100, 999);
        if (num2 > num1) {
            tmp = num2;
            num2 = num1;
            num1 = tmp;
        }
        answer = num1 - num2;
        quiz = num1 + "-" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreeMul0() {//整十数乘一位数
        num1 = getNumInRange(1, 9) * 10;
        num2 = getNumInRange(2, 9);
        answer = num1 * num2;
        swap();
        quiz = num1 + "×" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreeMul1() {//两位数乘一位数
        num1 = getNumInRange(11, 99);
        num2 = getNumInRange(2, 9);
        answer = num1 * num2;
        swap();
        quiz = num1 + "×" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreeMul2() {//两位数乘整十数
        num1 = getNumInRange(11, 99);
        num2 = getNumInRange(1, 9) * 10;
        answer = num1 * num2;
        swap();
        quiz = num1 + "×" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreeDiv0() {//整十数除以一位数
        num1 = getNumInRange(1, 9) * 10;
        num2 = getNumInRange(1, 9);
        while (num1 % num2 != 0) {
            num2 = getNumInRange(1, 9);
        }
        answer = num1 / num2;
        quiz = num1 + "÷" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreeDiv1() {//两位数除以一位数
        num1 = getNumInRange(10, 99);
        num2 = getNumInRange(1, 9);
        while (num1 % num2 != 0) {
            num2 = getNumInRange(1, 9);
        }
        answer = num1 / num2;
        quiz = num1 + "÷" + num2 + "=" + answer;
        return quiz;
    }

    public String GradeThreeDiv2() {//几百几十除以一位数
        num1 = getNumInRange(10, 99) * 10;
        num2 = getNumInRange(1, 9);
        while (num1 % num2 != 0) {
            num2 = getNumInRange(1, 9);
        }
        answer = num1 / num2;
        quiz = num1 + "÷" + num2 + "=" + answer;
        return quiz;
    }


    ////////四年级
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

    public String GradeFivePlus0(){//同分母分数加法
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction1=setFraction(num1,num2);
        num1=getNumInRange(1,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction2=setFraction(num1,num2);
        fraction3=f.compute(fraction1,"+",fraction2);
        quiz=fraction1+"+"+fraction2+"="+fraction3;
        return quiz;
    }

    public String GradeFivePlus1(){//分子为1的分数加法
        num1=1;
        num2=getNumInRange(2,9);
        fraction1=num1+"/"+num2;
        num2=getNumInRange(2,9);
        fraction2=num1+"/"+num2;
        fraction3=f.compute(fraction1,"+",fraction2);
        quiz=fraction1+"+"+fraction2+"="+fraction3;
        return quiz;
    }

    public String GradeFivePlus2(){//异分母真分数加法
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>num2){
            num2=getNumInRange(2,9);
        }
        fraction1=setFraction(num1,num2);
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>num2||fraction1.equals(num1+"/"+num2)){
            num2=getNumInRange(2,9);
        }
        fraction2=setFraction(num1,num2);//num1+"/"+num2;
        fraction3=f.compute(fraction1,"+",fraction2);
        quiz=fraction1+"+"+fraction2+"="+fraction3;
        return quiz;
    }

    public String GradeFiveMinus0(){//同分母分数减法
        num1=getNumInRange(1,9);
        num2=getNumInRange(1,9);
        num3=getNumInRange(2,9);
        if(num1<num2){
            tmp=num1;
            num1=num2;
            num2=tmp;
        }
        fraction1=num1+"/"+num3;
        fraction2=num2+"/"+num3;
        fraction3=f.compute(fraction1,"-",fraction2);
        quiz=fraction1+"-"+fraction2+"="+fraction3;
        return quiz;
    }

    public String GradeFiveMinus1(){//分子为1的分数减法
        num1=getNumInRange(2,9);
        num2=getNumInRange(2,9);
        if(num1>num2){
            tmp=num1;
            num1=num2;
            num2=tmp;
        }
        fraction1="1"+"/"+num1;
        fraction2="1"+"/"+num2;
        fraction3=f.compute(fraction1,"-",fraction2);
        quiz=fraction1+"-"+fraction2+"="+fraction3;
        return quiz;
    }

    public String GradeFiveMinus2(){//异分母分数减法
        num1=getNumInRange(1,9);//分子1
        num2=getNumInRange(1,9);//分子2
        num3=getNumInRange(2,9);//分母1
        num4=getNumInRange(2,9);//分母2
        while(num4*num1<num2*num3){
            tmp=num1;
            num1=num2;
            num2=tmp;
            tmp=num3;
            num3=num4;
            num4=tmp;
        }
        fraction1=num1+"/"+num3;
        fraction2=num2+"/"+num4;
        fraction3=f.compute(fraction1,"-",fraction2);
        quiz=fraction1+"-"+fraction2+"="+fraction3;
        return quiz;
    }

    public String GradeFiveMul0(){//小数乘整数
        dbl1=getDoubleInRange2(0.01,9.99);
        num1=getNumInRange(2,9);
        answerDbl=dbl1*num1;
        quiz=dbl1+"*"+num1+"="+answerDbl;
        return quiz;
    }

    public String GradeFiveMul1(){//小数点右移
        dbl1=getDoubleInRange1(0.1,9.9);
        num1=getNumInRange(1,3);
        num1=10^num1;
        answer=(int)(dbl1*num1);
        quiz=dbl1+"*"+num1+"="+answerDbl;
        return quiz;
    }

    public String GradeFiveMul2(){//小数乘小数,答案保留两位小数
        dbl1=getDoubleInRange1(0.1,0.9);
        dbl2=getDoubleInRange1(0.1,0.9);
        answerDbl=dbl1*dbl2;
        decimalFormat=new DecimalFormat("#.00");
        answerStr=decimalFormat.format(answerDbl);
        quiz=dbl1+"*"+dbl2+"="+answerStr;
        return quiz;
    }

    public String GradeFiveDiv0(){//小数除以整数
        num1=getNumInRange(1,9);//除数
        dbl1=getDoubleInRange1(0.1,0.9);//商
        dbl2=num1*dbl1;//被除数
        quiz=dbl2+"/"+num1+"="+dbl1;
        return quiz;
    }

    public String GradeFiveDiv1(){//小数点左移
        dbl1=getDoubleInRange1(0.1,0.9);
        num1=10^getNumInRange(1,3);
        switch (num1){
            case 10:
                decimalFormat=new DecimalFormat("#.00");
                break;
            case 100:
                decimalFormat=new DecimalFormat("#.000");
                break;
            case 1000:
                decimalFormat=new DecimalFormat("#.0000");
                break;
        }
        answerDbl=dbl1/num1;
        answerStr=decimalFormat.format(answerDbl);
        quiz=dbl1+"/"+num1+"="+answerStr;
        return quiz;
    }

    public String GradeFiveDiv2(){//小数除以小数
        dbl1=getDoubleInRange1(0.1,0.9);
        dbl2=getDoubleInRange1(0.1,0.9);
        dbl3=dbl1*dbl2;
        decimalFormat=new DecimalFormat("#.00");
        answerStr=decimalFormat.format(dbl3);
        quiz=dbl3+"/"+dbl1+"="+dbl2;
        return quiz;
    }

    public String GradeSixPlus0(){//分数加法交换律a+b+c=a+c+b
        fraction1=1+"/"+1;//a+c
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction2=num1+"/"+num2;//a
        fraction3=f.compute(fraction1,"-",fraction2);//c
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction4=num1+"/"+num2;//b
        answerStr=f.compute((f.compute(fraction2,"+",fraction4)),"+",fraction3);
        quiz=fraction2+"+"+fraction4+"+"+fraction3+"="+answerStr;
        return quiz;
    }

    public String GradeSixPlus1(){//分数加法结合律a+b+c=a+(b+c)
        fraction1=1+"/"+1;//b+c
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction2=num1+"/"+num2;//b
        fraction3=f.compute(fraction1,"-",fraction2);//c
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction4=num1+"/"+num2;//a
        answerStr=f.compute((f.compute(fraction2,"+",fraction4)),"+",fraction3);
        quiz=fraction4+"+"+fraction2+"+"+fraction3+"="+answerStr;
        return quiz;
    }

    public String GradeSixPlus2(){//负数加法
        num1=getNumInRange(1,20)*(-1);
        num2=getNumInRange(1,2);
        if(num2==1){
            num2=-1;
        }
        else {
            num2=1;
        }
        num3=getNumInRange(1,20)*num2;
        answer=num1+num3;
        quiz=num1+"+"+num3+"="+answer;
        return quiz;
    }

    public String GradeSixMinus0(){//分数减法性质a-b-c=a-c-b
        fraction1=1+"/"+1;//a-c
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction2=num1+"/"+num2;//c
        fraction3=f.compute(fraction1,"+",fraction2);//a
        num3=getNumInRange(1,9);
        num4=getNumInRange(2,9);
        while(num3>=num4){
            num3=getNumInRange(1,9);
        }
        fraction4=num3+"/"+num4;//b
        answerStr=f.compute((f.compute(fraction3,"-",fraction4)),"-",fraction2);
        quiz=fraction3+"-"+fraction4+"-"+fraction2+"="+answerStr;
        return quiz;
    }

    public String GradeSixMinus1(){//分数减法性质a-b-c=a-(b+c)
        fraction1=1+"/"+1;//b+c
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction2=num1+"/"+num2;//c
        fraction3=f.compute(fraction1,"-",fraction2);//b
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1<num2){
            num1=getNumInRange(1,9);
        }
        fraction4=num1+"/"+num2;//a
        answerStr=f.compute((f.compute(fraction4,"-",fraction3)),"-",fraction2);
        quiz=fraction4+"-"+fraction3+"-"+fraction2+"="+answerStr;
        return quiz;
    }

    public String GradeSixMinus2(){//负数减法
        num1=getNumInRange(1,20)*(-1);
        num2=getNumInRange(1,2);
        if(num2==1){
            num2=-1;
        }
        else {
            num2=1;
        }
        num3=getNumInRange(1,20)*num2;
        answer=num2-num1;
        quiz=num2+"-("+num1+")="+answer;
        return quiz;
    }

    public String GradeSixMul0(){//分数乘整数
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction1=setFraction(num1,num2);
        num1=getNumInRange(2,5);//整数
        fraction2=num1*num2+"/"+num2;//整数化为分数
        answerStr=f.compute(fraction1,"*",fraction2);
        quiz=fraction1+"*"+num1+"="+answerStr;
        return quiz;
    }

    public String GradeSixMul1(){//分数乘分数
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction1=setFraction(num1,num2);
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction2=setFraction(num1,num2);
        answerStr=f.compute(fraction1,"*",fraction2);
        quiz=fraction1+"*"+fraction2+"="+answerStr;
        return quiz;
    }

    public String GradeSixMul2(){//分数乘小数
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction1=setFraction(num1,num2);
        num3=getNumInRange(1,9);
        dbl1=num3*0.1;
        fraction2=setFraction(num3,10);//小数化为分数
        answerStr=f.compute(fraction1,"*",fraction2);
        quiz=fraction1+"*"+dbl1+"="+answerStr;
        return quiz;
    }

    public String GradeSixDiv0(){//分数除整数
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction1=setFraction(num1,num2);//商
        num1=getNumInRange(2,5);//整数
        fraction2=num1*num2+"/"+num2;//整数化为分数
        fraction3=f.compute(fraction1,"*",fraction2);//被除数
        quiz=fraction3+"/"+num1+"="+fraction1;
        return quiz;
    }

    public String GradeSixDiv1(){//分数除分数
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction1=setFraction(num1,num2);
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction2=setFraction(num1,num2);
        answerStr=f.compute(fraction1,"/",fraction2);
        quiz=fraction1+"/"+fraction2+"="+answerStr;
        return quiz;
    }

    public String GradeSixDiv2(){//分数除小数
        num1=getNumInRange(1,9);
        num2=getNumInRange(2,9);
        while(num1>=num2){
            num1=getNumInRange(1,9);
        }
        fraction1=setFraction(num1,num2);
        num3=getNumInRange(1,9);
        dbl1=num3*0.1;
        fraction2=setFraction(num3,10);//小数化为分数
        answerStr=f.compute(fraction1,"/",fraction2);
        quiz=fraction1+"/"+dbl1+"="+answerStr;
        return quiz;
    }

}

