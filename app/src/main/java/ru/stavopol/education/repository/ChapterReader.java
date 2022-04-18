package ru.stavopol.education.repository;

import java.util.List;

import ru.stavopol.education.model.Chapter;

public interface ChapterReader {

    List<Chapter> findAllChapter();
}
