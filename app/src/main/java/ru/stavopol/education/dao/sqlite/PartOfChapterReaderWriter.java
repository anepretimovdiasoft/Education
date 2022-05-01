package ru.stavopol.education.dao.sqlite;

import ru.stavopol.education.dao.csv.PartOfChapterReader;
import ru.stavopol.education.model.PartOfChapter;

public interface PartOfChapterReaderWriter extends PartOfChapterReader {

    void insert(PartOfChapter partOfChapter);

}
