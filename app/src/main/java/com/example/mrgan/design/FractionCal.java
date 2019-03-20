package com.example.mrgan.design;

import java.util.StringTokenizer;

public class FractionCal {
    int numerator;  // 分子
    int denominator; // 分母

    FractionCal(){
    }

    FractionCal(int a,int b){
        if(a==0){
            numerator=0;
            denominator=1;
        }
        else {
            setNumeratorAndDenominator(a,b);
        }
    }

    void setNumeratorAndDenominator(int a, int b){//设置分子和分母，可约分则进行约分
        int c=getGCD(Math.abs(a),Math.abs(b));//得出最大公约数
        numerator=a/c;
        denominator=b/c;
        if(numerator<0 && denominator<0){//分子分母同为负则转为正数
            numerator = - numerator;
            denominator = - denominator;
        }
    }

    int getNumerator(){
        return numerator;
    }

    int getDenominator(){
        return denominator;
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

    FractionCal plus(FractionCal f){//加法
        int a=f.getNumerator();
        int b=f.getDenominator();
        int newNumerator=numerator*b + denominator*a;
        int newDenominator=denominator*b;
        FractionCal result=new FractionCal(newNumerator,newDenominator);
        return result;
    }

    FractionCal minus(FractionCal f){//减法
        int a=f.getNumerator();
        int b=f.getDenominator();
        int newNumerator=numerator*b - denominator*a;
        int newDenominator=denominator*b;
        FractionCal result=new FractionCal(newNumerator,newDenominator);
        return result;
    }

    FractionCal mul(FractionCal f){ // 乘法运算
        int a = f.getNumerator();
        int b = f.getDenominator();
        int newNumerator = numerator * a;
        int newDenominator = denominator * b;
        FractionCal result = new FractionCal(newNumerator,newDenominator);
        return result;
    }

    FractionCal div(FractionCal f){  // 除法运算
        int a = f.getNumerator();
        int b = f.getDenominator();
        int newNumerator = numerator * b;
        int newDenominator = denominator * a;
        FractionCal result = new FractionCal(newNumerator,newDenominator);
        return result;
    }

    public static void compute(String data1,String operation,String data2){//判断运算符号并进行运算
        StringTokenizer createFraction = new StringTokenizer(data1,"/");
        int data1_1 = Integer.parseInt(createFraction.nextToken());
        int data1_2 = Integer.parseInt(createFraction.nextToken());
        createFraction = new StringTokenizer(data2,"/");
        int data2_1 = Integer.parseInt(createFraction.nextToken());
        int data2_2 = Integer.parseInt(createFraction.nextToken());

        FractionCal f1 = new FractionCal(data1_1,data1_2);
        FractionCal f2 = new FractionCal(data2_1,data2_2);

        FractionCal result;
        int a,b;
        if(operation.equals("+")){
            result = f1.plus(f2);
            a = result.getNumerator();
            b = result.getDenominator();
            System.out.println(data1+" "+operation+" " +data2+" = " + a + "/" + b);
        }

        if(operation.equals("-")){
            result = f1.minus(f2);
            a = result.getNumerator();
            b = result.getDenominator();
            System.out.println(data1+" "+operation+" " +data2+" = " + a + "/" + b);
        }

        if(operation.equals("*")){
            result = f1.mul(f2);
            a = result.getNumerator();
            b = result.getDenominator();
            System.out.println(data1+" "+operation+" " +data2+" = " + a + "/" + b);
        }

        if(operation.equals("/")){
            result = f1.div(f2);
            a = result.getNumerator();
            b = result.getDenominator();
            System.out.println(data1+" "+operation+" " +data2+" = " + a + "/" + b);
        }
    }
}

