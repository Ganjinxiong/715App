package com.example.mrgan.design;

public class Quizs {
    String quiz="";
    int num1=0;
    int num2=0;
    int num3=0;

    public int getNumInRange(int min,int max){
        int result=(int)(min+Math.random()*(max-min+1));
        return result;
    }

    public String GradeOnePlus0(){//一位数加法
        num1=getNumInRange(0,9);
        num2=getNumInRange(0,9);
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeOnePlus1(){//整十数加一位数
        num1=getNumInRange(1,9)*10;
        num2=getNumInRange(0,9);
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeOnePlus2(){//两位数加整十数
        num1=getNumInRange(1,9)*10;
        num2=getNumInRange(10,99);
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeOneMinus0(){//一位数减法
        num1=getNumInRange(0,9);
        num2=getNumInRange(0,9);
        if(num2>num1){
            num2=num2-num1;
            num1=num1+num2;
            num2=num1-num2;
        }
        quiz=num1+"-"+num2+"=";
        return quiz;
    }

    public String GradeOneMinus1(){//整十数减一位数
        num1=getNumInRange(0,9)*10;
        num2=getNumInRange(0,9);
        quiz=num1+"-"+num2+"=";
        return quiz;
    }

    public String GradeOneMinus2(){//两位数减整十数
        num1=getNumInRange(11,99);
        num2=getNumInRange(1,9)*10;
        while (num2>num1)
            num2=getNumInRange(1,9)*10;
        quiz=num1+"-"+num2+"=";
        return quiz;
    }


}
