package ru.stavopol.education.dao.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import ru.stavopol.education.db.EducationDbOpenHelper;
import ru.stavopol.education.db.EducationReaderContract;
import ru.stavopol.education.model.QuestionMultChoice;

public class QuestionMultChoiceReaderWriterSqlite implements QuestionMultChoiceReaderWriter {

    private final EducationDbOpenHelper openHelper;

    public QuestionMultChoiceReaderWriterSqlite(EducationDbOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    @Override
    public List<QuestionMultChoice> findAll() {

        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                EducationReaderContract.QuestionMultChoiceEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<QuestionMultChoice> questionMultChoiceList = new LinkedList<>();

        if (cursor.moveToFirst()) {

            int columnIndexId = cursor
                    .getColumnIndex(EducationReaderContract.QuestionMultChoiceEntry.COLUMN_ID);
            int columnIndexName = cursor
                    .getColumnIndex(EducationReaderContract.QuestionMultChoiceEntry.COLUMN_NAME);
            int columnIndexTestId = cursor
                    .getColumnIndex(EducationReaderContract.QuestionMultChoiceEntry.COLUMN_TEST_ID);

            do {

                QuestionMultChoice questionMultChoice = new QuestionMultChoice(
                        cursor.getInt(columnIndexId),
                        cursor.getString(columnIndexName),
                        new AnswerMultChoiceReaderWriterSqlite(openHelper).findByQuestionId(
                                cursor.getInt(columnIndexId)
                        ),
                        cursor.getInt(columnIndexTestId)
                );

                questionMultChoiceList.add(questionMultChoice);
            } while (cursor.moveToNext());

        }

        return questionMultChoiceList;
    }

    @Override
    public List<QuestionMultChoice> findByTestId(int id) {

        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                EducationReaderContract.QuestionMultChoiceEntry.TABLE_NAME,
                null,
                EducationReaderContract.QuestionMultChoiceEntry.COLUMN_TEST_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );

        List<QuestionMultChoice> questionMultChoiceList = new LinkedList<>();

        if (cursor.moveToFirst()) {

            int columnIndexId = cursor
                    .getColumnIndex(EducationReaderContract.QuestionMultChoiceEntry.COLUMN_ID);
            int columnIndexName = cursor
                    .getColumnIndex(EducationReaderContract.QuestionMultChoiceEntry.COLUMN_NAME);
            int columnIndexTestId = cursor
                    .getColumnIndex(EducationReaderContract.QuestionMultChoiceEntry.COLUMN_TEST_ID);

            do {

                QuestionMultChoice questionMultChoice = new QuestionMultChoice(
                        cursor.getInt(columnIndexId),
                        cursor.getString(columnIndexName),
                        new AnswerMultChoiceReaderWriterSqlite(openHelper).findByQuestionId(
                                cursor.getInt(columnIndexId)
                        ),
                        cursor.getInt(columnIndexTestId)
                );

                questionMultChoiceList.add(questionMultChoice);
            } while (cursor.moveToNext());

        }

        return questionMultChoiceList;
    }

    @Override
    public void insert(QuestionMultChoice questionMultChoice) {

        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(
                EducationReaderContract.QuestionMultChoiceEntry.COLUMN_ID, questionMultChoice.getId()
        );
        contentValues.put(
                EducationReaderContract.QuestionMultChoiceEntry.COLUMN_NAME, questionMultChoice.getName()
        );
        contentValues.put(
                EducationReaderContract.QuestionMultChoiceEntry.COLUMN_TEST_ID, questionMultChoice.getTest_id()
        );


        writableDatabase.insert(
                EducationReaderContract.QuestionMultChoiceEntry.TABLE_NAME,
                null,
                contentValues
        );
    }
}
