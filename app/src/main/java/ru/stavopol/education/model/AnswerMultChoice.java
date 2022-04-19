package ru.stavopol.education.model;

import java.io.Serializable;

public class AnswerMultChoice implements Serializable {

    private int id;

    private String name;

    private boolean right;

    private int question_id;

    public AnswerMultChoice(int id, String name, boolean right, int question_id) {
        this.id = id;
        this.name = name;
        this.right = right;
        this.question_id = question_id;
    }

    public AnswerMultChoice(String name, boolean right, int question_id) {
        this.name = name;
        this.right = right;
        this.question_id = question_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
}
