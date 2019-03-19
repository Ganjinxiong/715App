package com.example.mrgan.design;

public class Quizs {
    String quiz="";
    int num1=0;
    int num2=0;
    int num3=0;
    int tmp=0;
    int answer=0;

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
        quiz=num1+"*"+num2+"-"+num3+"=";
        return quiz;
    }

    public String GradeTwoDiv0(){//乘法口诀范围内的除法
        num1=getNumInRange(1,9);//除数
        num2=getNumInRange(1,9);//商
        tmp=num1*num2;//被除数
        quiz=tmp+"/"+num1+"=";
        return quiz;
    }

    public String GradeTwoDiv1(){//除完后加一个数
        num1=getNumInRange(1,9);//除数
        num2=getNumInRange(1,9);//商
        tmp=num1*num2;//被除数
        num3=getNumInRange(1,99);//加数
        quiz=tmp+"/"+num1+"+"+num3+"=";
        return quiz;
    }

    public String GradeTwoDiv2(){//除完后减一位数
        num1=getNumInRange(1,9);//除数
        num2=getNumInRange(1,9);//商
        tmp=num1*num2;//被除数
        num3=getNumInRange(1,9);//减数
        while(num3>num2){
            num3=getNumInRange(1,9);
        }
        quiz=tmp+"/"+num1+"-"+num3+"=";
        return quiz;
    }

    public String GradeThreePlus0(){//几百几十加几百几十
        num1=getNumInRange(11,99)*10;
        num2=getNumInRange(11,99)*10;
        answer=num1+num2;
        quiz=num1+"+"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreePlus1(){//任意三位数加几百几十
        num1=getNumInRange(100,999);
        num2=getNumInRange(11,99)*10;
        answer=num1+num2;
        quiz=num1+"+"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreePlus2(){//任意三位数加任意三位数
        num1=getNumInRange(100,999);
        num2=getNumInRange(100,999);
        answer=num1+num2;
        quiz=num1+"+"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeMinus0(){//几百几十减几百几十
        num1=getNumInRange(11,99)*10;
        num2=getNumInRange(11,99)*10;
        if(num2>num1){
            tmp=num2;
            num2=num1;
            num1=tmp;
        }
        answer=num1-num2;
        quiz=num1+"-"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeMinus1(){//三位数减几百几十
        num1=getNumInRange(101,999);
        num2=getNumInRange(10,99)*10;
        while(num2>num1){
            num2=getNumInRange(10,99)*10;
        }
        answer=num1-num2;
        quiz=num1+"-"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeMinus2(){//任意三位数减任意三位数
        num1=getNumInRange(100,999);
        num2=getNumInRange(100,999);
        if(num2>num1){
            tmp=num2;
            num2=num1;
            num1=tmp;
        }
        answer=num1-num2;
        quiz=num1+"-"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeMul0(){//整十数乘一位数
        num1=getNumInRange(1,9)*10;
        num2=getNumInRange(2,9);
        answer=num1*num2;
        quiz=num1+"*"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeMul1(){//两位数乘一位数
        num1=getNumInRange(11,99);
        num2=getNumInRange(2,9);
        answer=num1*num2;
        quiz=num1+"*"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeMul2(){//两位数乘整十数
        num1=getNumInRange(11,99);
        num2=getNumInRange(1,9)*10;
        answer=num1*num2;
        quiz=num1+"*"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeDiv0(){//整十数除以一位数
        num1=getNumInRange(1,9)*10;
        num2=getNumInRange(1,9);
        while(num1%num2!=0){
            num2=getNumInRange(1,9);
        }
        answer=num1/num2;
        quiz=num1+"/"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeDiv1(){//两位数除以一位数
        num1=getNumInRange(10,99);
        num2=getNumInRange(1,9);
        while(num1%num2!=0){
            num2=getNumInRange(1,9);
        }
        answer=num1/num2;
        quiz=num1+"/"+num2+"="+answer;
        return quiz;
    }

    public String GradeThreeDiv2(){//几百几十除以一位数
        num1=getNumInRange(10,99)*10;
        num2=getNumInRange(1,9);
        while(num1%num2!=0){
            num2=getNumInRange(1,9);
        }
        answer=num1/num2;
        quiz=num1+"/"+num2+"="+answer;
        return quiz;
    }


}
