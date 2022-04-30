package ru.stavopol.education.dao;

import java.util.List;

import ru.stavopol.education.model.PartOfChapter;

public interface PartOfChapterDao {

    void insert(PartOfChapter partOfChapter);

    List<PartOfChapter> findAll();
}
