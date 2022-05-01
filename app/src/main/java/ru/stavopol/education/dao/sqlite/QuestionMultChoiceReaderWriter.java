package ru.stavopol.education.dao.sqlite;

import ru.stavopol.education.dao.csv.QuestionMultChoiceReader;
import ru.stavopol.education.model.QuestionMultChoice;

public interface QuestionMultChoiceReaderWriter extends QuestionMultChoiceReader {

    void insert(QuestionMultChoice questionMultChoice);
}
