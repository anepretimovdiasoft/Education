package ru.stavopol.education.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class QuestionMultChoice implements Serializable {

    private int id;

    private final String name;

    private List<AnswerMultChoice> answerMultChoiceList;

    private final int test_id;


    public QuestionMultChoice(int id, String name, List<AnswerMultChoice> answerMultChoiceList, int test_id) {
        this.id = id;
        this.name = name;
        this.answerMultChoiceList = answerMultChoiceList;
        this.test_id = test_id;
    }

    public QuestionMultChoice(String name, List<AnswerMultChoice> answerMultChoiceList, int test_id) {
        this.name = name;
        this.answerMultChoiceList = answerMultChoiceList;
        this.test_id = test_id;
    }

    public int getTest_id() {
        return test_id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AnswerMultChoice> getAnswerMultChoiceList() {
        return answerMultChoiceList;
    }
}
