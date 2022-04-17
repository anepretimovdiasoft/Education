package ru.stavopol.education.model;

import java.util.List;

public class Chapter {

    private Integer id;

    private final String name;

    private final String description;

    private final List<PartOfChapter> partOfChapterList;

    private boolean checked;

    private boolean accepted;

    private final Test test;


    public Chapter(Integer id, String name, String description, List<PartOfChapter> partOfChapterList, boolean checked, boolean accepted, Test test) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.partOfChapterList = partOfChapterList;
        this.checked = checked;
        this.accepted = accepted;
        this.test = test;
    }

    public Chapter(String name, String description, List<PartOfChapter> partOfChapterList, boolean checked, boolean accepted, Test test) {
        this.name = name;
        this.description = description;
        this.partOfChapterList = partOfChapterList;
        this.checked = checked;
        this.accepted = accepted;
        this.test = test;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PartOfChapter> getPartOfChapterList() {
        return partOfChapterList;
    }

    public boolean isChecked() {
        return checked;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Test getTest() {
        return test;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getDescription() {
        return description;
    }
}
