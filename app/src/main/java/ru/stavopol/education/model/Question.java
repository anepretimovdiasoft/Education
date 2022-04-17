package ru.stavopol.education.model;

import java.util.Map;

public class Question {

    private Integer id;

    private final String name;

    private Map<String, Boolean> answerMap;


    public Question(Integer id, String name, Map<String, Boolean> answerMap) {
        this.id = id;
        this.name = name;
        this.answerMap = answerMap;
    }

    public Question(String name, Map<String, Boolean> answerMap) {
        this.name = name;
        this.answerMap = answerMap;
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
