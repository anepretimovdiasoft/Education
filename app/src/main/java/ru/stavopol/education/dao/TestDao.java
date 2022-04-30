package ru.stavopol.education.dao;

import java.util.List;

import ru.stavopol.education.model.Test;

public interface TestDao {

    void insert(Test test);

    void update(int id, boolean accept);

    List<Test> findAll();

}
