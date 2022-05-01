package ru.stavopol.education.dao.csv;

import java.util.List;

import ru.stavopol.education.model.PartOfChapter;

public interface PartOfChapterReader {

    List<PartOfChapter> findAll();

    List<PartOfChapter> findByChapterId(int id);
}
