package ru.stavopol.education.dao.sqlite;

import java.util.List;

import ru.stavopol.education.model.AnswerMultChoice;

public interface AnswerMultChoiceReaderWriter {

    void insert(AnswerMultChoice answerMultChoice);

    List<AnswerMultChoice> findAll();

    List<AnswerMultChoice> findByTestId(int id);

}
