package ru.stavopol.education.dao;

import java.util.List;

import ru.stavopol.education.model.AnswerMultChoice;

public interface AnswerMultChoiceDao {

    void insert(AnswerMultChoice answerMultChoice);

    List<AnswerMultChoice> findAll();

}
