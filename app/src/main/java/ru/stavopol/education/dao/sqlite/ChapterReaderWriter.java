package ru.stavopol.education.dao.sqlite;

import ru.stavopol.education.dao.csv.ChapterReader;
import ru.stavopol.education.model.Chapter;

public interface ChapterReaderWriter extends ChapterReader {

    void insert(Chapter chapter);

    void update(int id, boolean checked, boolean accept);

}
