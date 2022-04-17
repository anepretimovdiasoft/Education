package ru.stavopol.education.testdata;

import java.util.ArrayList;
import java.util.List;

import ru.stavopol.education.model.Chapter;
import ru.stavopol.education.model.PartOfChapter;

public class TestData {

    public static final List<Chapter> CHAPTER_LIST = new ArrayList<>();

    public static final List<PartOfChapter> PART_OF_CHAPTER_LIST = new ArrayList<>();

    static {

        PART_OF_CHAPTER_LIST.add(new PartOfChapter(null, null,
                "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка "));

        PART_OF_CHAPTER_LIST.add(new PartOfChapter(null, null,
                "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка "));

        PART_OF_CHAPTER_LIST.add(new PartOfChapter(null, null,
                "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка "));

        PART_OF_CHAPTER_LIST.add(new PartOfChapter(null, null,
                "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка "));

        PART_OF_CHAPTER_LIST.add(new PartOfChapter(null, null,
                "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка "));

        PART_OF_CHAPTER_LIST.add(new PartOfChapter(null, null,
                "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка " +
                        "Текст раздела заглушка "));


        CHAPTER_LIST.add(new Chapter("Глава 1. \"Название главы\"", "Краткое описание 1 главы", PART_OF_CHAPTER_LIST, false, false, null));
        CHAPTER_LIST.add(new Chapter("Глава 2. \"Название главы\"", "Краткое описание 2 главы", PART_OF_CHAPTER_LIST, false, false, null));
        CHAPTER_LIST.add(new Chapter("Глава 3. \"Название главы\"", "Краткое описание 3 главы", PART_OF_CHAPTER_LIST, false, false, null));
        CHAPTER_LIST.add(new Chapter("Глава 4. \"Название главы\"", "Краткое описание 4 главы", PART_OF_CHAPTER_LIST, false, false, null));
        CHAPTER_LIST.add(new Chapter("Глава 5. \"Название главы\"", "Краткое описание 5 главы", PART_OF_CHAPTER_LIST, false, false, null));
        CHAPTER_LIST.add(new Chapter("Глава 6. \"Название главы\"", "Краткое описание 6 главы", PART_OF_CHAPTER_LIST, false, false, null));
        CHAPTER_LIST.add(new Chapter("Глава 7. \"Название главы\"", "Краткое описание 7 главы", PART_OF_CHAPTER_LIST, false, false, null));
        CHAPTER_LIST.add(new Chapter("Глава 8. \"Название главы\"", "Краткое описание 8 главы", PART_OF_CHAPTER_LIST, false, false, null));
        CHAPTER_LIST.add(new Chapter("Глава 9. \"Название главы\"", "Краткое описание 9 главы", PART_OF_CHAPTER_LIST, false, false, null));

    }


}
