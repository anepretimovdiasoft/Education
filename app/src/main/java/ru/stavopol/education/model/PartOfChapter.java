package ru.stavopol.education.model;

public class PartOfChapter {

    private Integer id;

    private final String topImage;

    private final String bottomImage;

    private final String chapterText;

    public PartOfChapter(Integer id, String topImage, String bottomImage, String chapterText) {
        this.id = id;
        this.topImage = topImage;
        this.bottomImage = bottomImage;
        this.chapterText = chapterText;
    }

    public PartOfChapter(String topImage, String bottomImage, String chapterText) {
        this.topImage = topImage;
        this.bottomImage = bottomImage;
        this.chapterText = chapterText;
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
