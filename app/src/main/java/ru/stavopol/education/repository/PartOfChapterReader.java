package ru.stavopol.education.repository;

import java.util.List;

import ru.stavopol.education.model.PartOfChapter;

public interface PartOfChapterReader {

    List<PartOfChapter> findAllPartOfChapter();

    List<PartOfChapter> findPartOfChapterByChapterId(int id);
}
