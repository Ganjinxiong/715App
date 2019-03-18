package com.example.mrgan.design;

public class Quizs {
    String quiz="";
    int num1=0;
    int num2=0;
    int num3=0;
    int tmp=0;

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
        while (num2>num1) {
            num2 = getNumInRange(1, 9) * 10;
        }
        quiz=num1+"-"+num2+"=";
        return quiz;
    }

    public String GradeTwoPlus0(){//一位数连加
        num1=getNumInRange(0,9);
        num2=getNumInRange(0,9);
        num3=getNumInRange(0,9);
        quiz=num1+"+"+num2+"+"+num3+"=";
        return quiz;
    }

    public String GradeTwoPlus1(){//两位数加两位数（不进位）
        num1=getNumInRange(11,99);
        num2=getNumInRange(11,99);
        while((num1%10)+(num2%10)>=10){
            num2=getNumInRange(11,99);
        }
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeTwoPlus2(){//两位数加两位数（进位）
        num1=getNumInRange(11,99);
        num2=getNumInRange(11,99);
        while((num1%10)+(num2%10)<10){
            num2=getNumInRange(11,99);
        }
        quiz=num1+"+"+num2+"=";
        return quiz;
    }

    public String GradeTwoMinus0(){//一位数连减
        num1=getNumInRange(0,9);
        num2=getNumInRange(0,9);
        num3=getNumInRange(0,9);
        tmp=num1+num2+num3;
        quiz=tmp+"-"+num1+"-"+num2+"=";
        return quiz;
    }

    public String GradeTwoMinus1(){//两位数减两位数（不退位）
        num1=getNumInRange(11,99);
        num2=getNumInRange(11,99);
        while((num1%10)+(num2%10)>=10){
            num2=getNumInRange(11,99);
        }
        tmp=num1+num2;
        quiz=tmp+"-"+num2+"=";
        return quiz;
    }

    public String GradeTwoMinus2(){//两位数减两位数（退位）
        num1=getNumInRange(11,99);
        num2=getNumInRange(11,99);
        while((num1%10)+(num2%10)<10){
            num2=getNumInRange(11,99);
        }
        tmp=num1+num2;
        quiz=tmp+"-"+num2+"=";
        return quiz;
    }

    public String GradeTwoMul0(){//一位数乘一位数
        num1=getNumInRange(0,9);
        num2=getNumInRange(0,9);
        quiz=num1+"*"+num2+"=";
        return quiz;
    }

    public String GradeTwoMul1(){//一位数乘一位数加一位数
        num1=getNumInRange(0,9);
        num2=getNumInRange(0,9);
        num3=getNumInRange(1,9);
        quiz=num1+"*"+num2+"+"+num3+"=";
        return quiz;
    }

    public String GradeTwoMul2(){//一位数乘一位数减一位数
        num1=getNumInRange(0,9);
        num2=getNumInRange(0,9);
        num3=getNumInRange(1,9);
        if((num1*num2)<num3){
            num3=getNumInRange(1,9);
        }
        quiz=num1+"*"+num2+"+"+num3+"=";
        return quiz;
    }


}
