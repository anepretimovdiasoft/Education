package ru.stavopol.education.model;

import java.util.List;

public class Test {

    private Integer id;

    private final List<Question> questionList;

    public Test(Integer id, List<Question> questionList) {
        this.id = id;
        this.questionList = questionList;
    }

    public Test(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Integer getId() {
        return id;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
