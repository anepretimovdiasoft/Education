package ru.stavopol.education.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EducationDbOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Edu.db";
    public static final int DATABASE_VERSION = 1;

    public EducationDbOpenHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + EducationReaderContract.PartOfChapterEntry.TABLE_NAME + " (" +
                        EducationReaderContract.PartOfChapterEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        EducationReaderContract.PartOfChapterEntry.COLUMN_TITLE + " TEXT, " +
                        EducationReaderContract.PartOfChapterEntry.COLUMN_TOP_IMAGE + " TEXT, " +
                        EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_TEXT + " TEXT, " +
                        EducationReaderContract.PartOfChapterEntry.COLUMN_BOTTOM_IMAGE + " TEXT, " +
                        EducationReaderContract.PartOfChapterEntry.COLUMN_PART_NUMBER + " INTEGER, " +
                        EducationReaderContract.PartOfChapterEntry.COLUMN_PART_LINK + " TEXT, " +
                        EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_ID + " INTEGER, " +
                        "FOREIGN KEY(" + EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_ID + ") " +
                        "REFERENCES " + EducationReaderContract.ChapterEntry.TABLE_NAME +
                        "(" + EducationReaderContract.ChapterEntry.COLUMN_ID + ")" + ");"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + EducationReaderContract.ChapterEntry.TABLE_NAME + " (" +
                        EducationReaderContract.ChapterEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        EducationReaderContract.ChapterEntry.COLUMN_NAME + " TEXT, " +
                        EducationReaderContract.ChapterEntry.COLUMN_DESCRIPTION + " TEXT, " +
                        EducationReaderContract.ChapterEntry.COLUMN_CHECKED + " BOOLEAN, " +
                        EducationReaderContract.ChapterEntry.COLUMN_ACCEPTED + " BOOLEAN);"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + EducationReaderContract.TestEntry.TABLE_NAME + " (" +
                        EducationReaderContract.TestEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        EducationReaderContract.TestEntry.COLUMN_NAME + " TEXT, " +
                        EducationReaderContract.TestEntry.COLUMN_ACCEPT + " BOOLEAN, " +
                        EducationReaderContract.TestEntry.COLUMN_CHAPTER_ID + " INTEGER, " +
                        "FOREIGN KEY(" + EducationReaderContract.TestEntry.COLUMN_CHAPTER_ID + ") " +
                        "REFERENCES " + EducationReaderContract.ChapterEntry.TABLE_NAME +
                        "(" + EducationReaderContract.ChapterEntry.COLUMN_ID + ")" + ");"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + EducationReaderContract.QuestionMultChoiceEntry.TABLE_NAME + " (" +
                        EducationReaderContract.QuestionMultChoiceEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        EducationReaderContract.QuestionMultChoiceEntry.COLUMN_NAME + " TEXT, " +
                        EducationReaderContract.QuestionMultChoiceEntry.COLUMN_TEST_ID + " INTEGER, " +
                        "FOREIGN KEY(" + EducationReaderContract.QuestionMultChoiceEntry.COLUMN_TEST_ID + ") " +
                        "REFERENCES " + EducationReaderContract.TestEntry.TABLE_NAME +
                        "(" + EducationReaderContract.TestEntry.COLUMN_ID + ")" + ");"
        );

        sqLiteDatabase.execSQL(
                "CREATE TABLE " + EducationReaderContract.AnswerMultChoiceEntry.TABLE_NAME + " (" +
                        EducationReaderContract.AnswerMultChoiceEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        EducationReaderContract.AnswerMultChoiceEntry.COLUMN_NAME + " TEXT, " +
                        EducationReaderContract.AnswerMultChoiceEntry.COLUMN_RIGHT + " BOOLEAN, " +
                        EducationReaderContract.AnswerMultChoiceEntry.COLUMN_QUESTION_ID + " INTEGER, " +
                        "FOREIGN KEY(" + EducationReaderContract.AnswerMultChoiceEntry.COLUMN_QUESTION_ID + ") " +
                        "REFERENCES " + EducationReaderContract.QuestionMultChoiceEntry.TABLE_NAME +
                        "(" + EducationReaderContract.QuestionMultChoiceEntry.COLUMN_ID + ")" + ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(
                "DROP TABLE IF EXISTS " + EducationReaderContract.PartOfChapterEntry.TABLE_NAME
        );

        sqLiteDatabase.execSQL(
                "DROP TABLE IF EXISTS " + EducationReaderContract.ChapterEntry.TABLE_NAME
        );

        sqLiteDatabase.execSQL(
                "DROP TABLE IF EXISTS " + EducationReaderContract.TestEntry.TABLE_NAME
        );

        sqLiteDatabase.execSQL(
                "DROP TABLE IF EXISTS " + EducationReaderContract.QuestionMultChoiceEntry.TABLE_NAME
        );

        sqLiteDatabase.execSQL(
                "DROP TABLE IF EXISTS " + EducationReaderContract.AnswerMultChoiceEntry.TABLE_NAME
        );

        onCreate(sqLiteDatabase);

    }
}
