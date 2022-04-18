package ru.stavopol.education.model;

import java.io.Serializable;

public class PartOfChapter implements Serializable {

    private int id;

    private final String topImage;

    private final String bottomImage;

    private final String chapterText;

    private final int chapter_id;

    public PartOfChapter(int id, String topImage, String bottomImage, String chapterText, int chapter_id) {
        this.id = id;
        this.topImage = topImage;
        this.bottomImage = bottomImage;
        this.chapterText = chapterText;
        this.chapter_id = chapter_id;
    }

    public PartOfChapter(String topImage, String bottomImage, String chapterText, int chapter_id) {
        this.topImage = topImage;
        this.bottomImage = bottomImage;
        this.chapterText = chapterText;
        this.chapter_id = chapter_id;
    }

    public int getId() {
        return id;
    }

    public int getChapter_id() {
        return chapter_id;
    }

    public String getTopImage() {
        return topImage;
    }

    public String getBottomImage() {
        return bottomImage;
    }

    public String getChapterText() {
        return chapterText;
    }
}
