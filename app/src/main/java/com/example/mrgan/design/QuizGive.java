package com.example.mrgan.design;

public class QuizGive {
    private String gradeLabel, typeLabel;
    private int Level=0;
    String quiz="";
    String equation ="";

    public QuizGive(String label1, String label2,int level) {
        gradeLabel = label1;
        typeLabel = label2;
        Level=level;
    }

    public String Give() {
        switch (gradeLabel) {
            case "一年级":
                quiz = GradeOne();
            break;
            case "二年级":
                quiz = GradeTwo();
            break;
            case "三年级":
                quiz = GradeThree();
            break;
            case "四年级":
                quiz = GradeFour();
            break;
            case "五年级":
                quiz = GradeFive();
            break;
            case "六年级":
                quiz = GradeSix();
            break;
        }
        return quiz;
    }

    public String GradeOne() {
        switch (typeLabel) {
            case "加法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeOnePlus0();
                        break;
                    case 1:
                        equation=new Quizs().GradeOnePlus1();
                        break;
                    case 2:
                        equation=new Quizs().GradeOnePlus2();
                        break;
                }
                break;
            case "减法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeOneMinus0();
                        break;
                    case 1:
                        equation=new Quizs().GradeOneMinus1();
                        break;
                    case 2:
                        equation=new Quizs().GradeOneMinus2();
                        break;
                }
                break;
        }
        return equation;
    }

    public String GradeTwo(){
        switch (typeLabel) {
            case "加法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeTwoPlus0();
                        break;
                    case 1:
                        equation=new Quizs().GradeTwoPlus1();
                        break;
                    case 2:
                        equation=new Quizs().GradeTwoPlus2();
                        break;
                }
                break;
            case "减法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeTwoMinus0();
                        break;
                    case 1:
                        equation=new Quizs().GradeTwoMinus1();
                        break;
                    case 2:
                        equation=new Quizs().GradeTwoMinus2();
                        break;
                }
                break;
            case "乘法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeTwoMul0();
                        break;
                    case 1:
                        equation=new Quizs().GradeTwoMul1();
                        break;
                    case 2:
                        equation=new Quizs().GradeTwoMul2();
                        break;
                }
                break;
            case "除法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeTwoDiv0();
                        break;
                    case 1:
                        equation=new Quizs().GradeTwoDiv0();
                        break;
                    case 2:
                        equation=new Quizs().GradeTwoDiv0();
                        break;
                }
                break;
        }
        return equation;
    }
    public String GradeThree(){
        switch (typeLabel) {
            case "加法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeThreePlus0();
                        break;
                    case 1:
                        equation=new Quizs().GradeThreePlus1();
                        break;
                    case 2:
                        equation=new Quizs().GradeThreePlus2();
                        break;
                }
                break;
            case "减法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeThreeMinus0();
                        break;
                    case 1:
                        equation=new Quizs().GradeThreeMinus1();
                        break;
                    case 2:
                        equation=new Quizs().GradeThreeMinus2();
                        break;
                }
                break;
            case "乘法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeThreeMul0();
                        break;
                    case 1:
                        equation=new Quizs().GradeThreeMul1();
                        break;
                    case 2:
                        equation=new Quizs().GradeThreeMul2();
                        break;
                }
                break;
            case "除法":
                switch(Level){
                    case 0:
                        equation=new Quizs().GradeThreeDiv0();
                        break;
                    case 1:
                        equation=new Quizs().GradeThreeDiv1();
                        break;
                    case 2:
                        equation=new Quizs().GradeThreeDiv2();
                        break;
                }
                break;
        }
        return equation;
    }
    public String GradeFour(){
        switch (typeLabel) {
            case "加法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "减法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "乘法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "除法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
        }
        return equation;
    }
    public String GradeFive(){
        switch (typeLabel) {
            case "加法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "减法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "乘法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "除法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
        }
        return equation;
    }
    public String GradeSix(){
        switch (typeLabel) {
            case "加法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "减法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "乘法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "除法":
                switch(Level){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
        }
        return equation;
    }
}

