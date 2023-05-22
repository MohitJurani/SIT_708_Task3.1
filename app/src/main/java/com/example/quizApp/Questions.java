package com.example.quizApp;

import java.util.List;

public class Questions {
    private String question;
    private List<String> options;
    private int correctAns;

    public Questions(String question, List<String> options, int correctAns) {
        this.question = question;
        this.options = options;
        this.correctAns = correctAns;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }
}
