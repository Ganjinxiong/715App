package com.example.mrgan.design;

public class Quizs {
    String quiz="";
    int num1=0;
    int num2=0;
    int num3=0;
    int ran;

    //加法随机交换数字位置
    public void swap(){
        ran =(int)(Math.random()*2);
        if (ran == 1){
           num1 = num1 +num2;
           num2 = num1 -num2;
           num1 = num1 -num2;
        }
    }

    public int getNumInRange(int min,int max){
        int result=(int)(min+Math.random()*(max-min+1));
        return result;
    }

    public String GradeOnePlus0(){//一位数加法
        num1=getNumInRange(0,9);
        num2=getNumInRange(0,9);
        swap();
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeOnePlus1(){//十加几
        num1=10;
        num2=getNumInRange(0,9);
        swap();
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeOnePlus2(){//十几加几
        num1=getNumInRange(11,20);
        num2=getNumInRange(1,9);
        swap();
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeOnePlus3(){//整十加法
        num1=getNumInRange(1,9)*10;
        num2=getNumInRange(1,9)*10;
        swap();
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeOnePlus4(){//两位数加整十
        num1=getNumInRange(11,99);
        num2=getNumInRange(1,9)*10;
        swap();
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

    public String GradeOneMinus1(){//十减一位数
        num1=10;
        num2=getNumInRange(0,9);
        quiz=num1+"-"+num2+"=";
        return quiz;
    }

    public String GradeOneMinus2(){//十几减几
        num1=getNumInRange(11,19);
        num2=getNumInRange(1,9);
        quiz=num1+"-"+num2+"=";
        return quiz;
    }

    public String GradeOneMinus3(){//整十数减一位数
        num1=getNumInRange(2,9)*10;
        num2=getNumInRange(1,9);
        quiz=num1+"-"+num2+"=";
        return quiz;
    }

    public String GradeOneMinus4(){//两位数减整十数
        num1=getNumInRange(11,99);
        num2=getNumInRange(1,9)*10;
        while (num2>num1)
            num2=getNumInRange(1,9)*10;
        quiz=num1+"-"+num2+"=";
        return quiz;
    }

}
