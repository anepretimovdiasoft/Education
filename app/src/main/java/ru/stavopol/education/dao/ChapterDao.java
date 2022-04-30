package ru.stavopol.education.dao;

import java.util.List;

import ru.stavopol.education.model.Chapter;

public interface ChapterDao {

    void insert(Chapter chapter);
    
    void update(int id, boolean checked, boolean accept);

    List<Chapter> findAll();

}
