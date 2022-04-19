package ru.stavopol.education.model;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {

    private Integer id;

    private final String name;

    private final List<QuestionMultChoice> questionMultChoiceList;

    private boolean accept = false;

    private final int chapter_id;

    public Test(Integer id, String name, List<QuestionMultChoice> questionMultChoiceList, int chapter_id) {
        this.id = id;
        this.name = name;
        this.questionMultChoiceList = questionMultChoiceList;
        this.chapter_id = chapter_id;
    }

    public Test(String name, List<QuestionMultChoice> questionMultChoiceList, int chapter_id) {
        this.name = name;
        this.questionMultChoiceList = questionMultChoiceList;
        this.chapter_id = chapter_id;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public Integer getId() {
        return id;
    }

    public int getChapter_id() {
        return chapter_id;
    }

    public String getName() {
        return name;
    }

    public List<QuestionMultChoice> getQuestionMultChoiceList() {
        return questionMultChoiceList;
    }
}
