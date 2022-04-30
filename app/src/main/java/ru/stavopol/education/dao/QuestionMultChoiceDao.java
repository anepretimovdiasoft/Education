package ru.stavopol.education.dao;

import java.util.List;

import ru.stavopol.education.model.QuestionMultChoice;

public interface QuestionMultChoiceDao {

    void insert(QuestionMultChoice questionMultChoice);

    List<QuestionMultChoice> findAll();
}
