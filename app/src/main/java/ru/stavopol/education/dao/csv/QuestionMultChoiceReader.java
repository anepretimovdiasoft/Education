package ru.stavopol.education.dao.csv;

import java.util.List;

import ru.stavopol.education.model.QuestionMultChoice;

public interface QuestionMultChoiceReader {

    List<QuestionMultChoice> findAll();

    List<QuestionMultChoice> findByTestId(int id);
}
