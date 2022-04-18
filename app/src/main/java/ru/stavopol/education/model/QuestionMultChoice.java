package ru.stavopol.education.model;

import java.io.Serializable;
import java.util.Map;

public class QuestionMultChoice implements Serializable {

    private int id;

    private final String name;

    private Map<String, Boolean> answerMap;

    private final int test_id;


    public QuestionMultChoice(int id, String name, Map<String, Boolean> answerMap, int test_id) {
        this.id = id;
        this.name = name;
        this.answerMap = answerMap;
        this.test_id = test_id;
    }

    public QuestionMultChoice(String name, Map<String, Boolean> answerMap, int test_id) {
        this.name = name;
        this.answerMap = answerMap;
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

    public Map<String, Boolean> getAnswerMap() {
        return answerMap;
    }
}
