package ru.stavopol.education.db;

public class EducationReaderContract {

    private EducationReaderContract(){}

    public static class AnswerMultChoiceEntry{
        public static final String TABLE_NAME = "AnswerMultChoice";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_RIGHT = "rightAnsw";
        public static final String COLUMN_QUESTION_ID = "question_id";
    }

    public static class ChapterEntry{
        public static final String TABLE_NAME = "Chapter";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CHECKED = "checked";
        public static final String COLUMN_ACCEPTED = "accepted";
    }

    public static class PartOfChapterEntry{
        public static final String TABLE_NAME = "PartOfChapter";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TOP_IMAGE = "topImage";
        public static final String COLUMN_BOTTOM_IMAGE = "bottomImage";
        public static final String COLUMN_CHAPTER_TEXT = "chapterText";
        public static final String COLUMN_PART_NUMBER = "part_number";
        public static final String COLUMN_CHAPTER_ID = "chapter_id";
        public static final String COLUMN_PART_LINK = "part_link";
    }

    public static class QuestionMultChoiceEntry{
        public static final String TABLE_NAME = "QuestionMultChoice";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TEST_ID = "test_id";
    }

    public static class TestEntry{
        public static final String TABLE_NAME = "Test";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ACCEPT = "accept";
        public static final String COLUMN_CHAPTER_ID = "chapter_id";
    }

}
