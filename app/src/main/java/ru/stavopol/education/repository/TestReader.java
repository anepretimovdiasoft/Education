package ru.stavopol.education.repository;

import java.util.List;

import ru.stavopol.education.model.Test;

public interface TestReader {

    List<Test> findAllTest();

}
