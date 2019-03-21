package com.example.mrgan.design;

import org.litepal.crud.LitePalSupport;

public class Question extends LitePalSupport {

    private int id;//id
    private String grade;//年级
    private String qString;//题目1+1=
    private String result;//对的
    private String answer;//错的

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getqString() {
        return qString;
    }

    public void setqString(String qString) {
        this.qString = qString;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
