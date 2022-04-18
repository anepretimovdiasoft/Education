package ru.stavopol.education.repository;

import java.util.List;

import ru.stavopol.education.model.QuestionMultChoice;

public interface QuestionMultChoiceReader {

    List<QuestionMultChoice> findAllQuestionMultChoice();

    List<QuestionMultChoice> findQuestionMultChoiceTestId(int id);
}
