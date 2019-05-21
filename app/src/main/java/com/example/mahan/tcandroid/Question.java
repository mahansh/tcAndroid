package com.example.mahan.tcandroid;

import android.widget.TextView;

public class Question {
    private int mQuestion;
    private boolean mAnswer;

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
