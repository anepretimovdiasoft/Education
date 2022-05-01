package ru.stavopol.education.dao.sqlite;

import ru.stavopol.education.dao.csv.TestReader;
import ru.stavopol.education.model.Test;

public interface TestReaderWriter extends TestReader {

    void insert(Test test);

    void update(int id, boolean accept);

}
