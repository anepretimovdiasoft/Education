package ru.stavopol.education.dao.csv;

import java.util.List;

import ru.stavopol.education.model.Test;

public interface TestReader {

    List<Test> findAll();

}
