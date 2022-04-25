package ru.stavopol.education.model;

import java.io.Serializable;

public class PartOfChapter implements Serializable {

    private int id;

    private final String title;

    private final String topImage;

    private final String bottomImage;

    private final String chapterText;

    private final int part_number;

    private final int chapter_id;

    private final String part_link;

    public PartOfChapter(
            int id,
            String title,
            String topImage,
            String bottomImage,
            String chapterText,
            int part_number,
            int chapter_id,
            String part_link
    ) {

        this.id = id;
        this.title = title;
        this.topImage = topImage;
        this.bottomImage = bottomImage;
        this.chapterText = chapterText;
        this.part_number = part_number;
        this.chapter_id = chapter_id;
        this.part_link = part_link;
    }

    public PartOfChapter(
            String title,
            String topImage,
            String bottomImage,
            String chapterText,
            int part_number,
            int chapter_id,
            String part_link
    ) {

        this.title = title;
        this.topImage = topImage;
        this.bottomImage = bottomImage;
        this.chapterText = chapterText;
        this.part_number = part_number;
        this.chapter_id = chapter_id;
        this.part_link = part_link;
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

    public String getTitle() {
        return title;
    }

    public int getPart_number() {
        return part_number;
    }

    public String getPart_link() {
        return part_link;
    }
}
