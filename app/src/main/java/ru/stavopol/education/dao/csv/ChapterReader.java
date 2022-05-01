package ru.stavopol.education.dao.csv;

import java.util.List;

import ru.stavopol.education.model.Chapter;

public interface ChapterReader {

    List<Chapter> findAll();
}
