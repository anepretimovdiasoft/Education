package ru.stavopol.education.dao.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import ru.stavopol.education.db.EducationDbOpenHelper;
import ru.stavopol.education.db.EducationReaderContract;
import ru.stavopol.education.model.AnswerMultChoice;

public class AnswerMultChoiceReaderWriterSqlite implements AnswerMultChoiceReaderWriter{

    private final EducationDbOpenHelper openHelper;

    public AnswerMultChoiceReaderWriterSqlite(EducationDbOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    @Override
    public void insert(AnswerMultChoice answerMultChoice) {

        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(
                EducationReaderContract.AnswerMultChoiceEntry.COLUMN_ID, answerMultChoice.getId()
        );
        contentValues.put(
                EducationReaderContract.AnswerMultChoiceEntry.COLUMN_NAME, answerMultChoice.getName()
        );
        contentValues.put(
                EducationReaderContract.AnswerMultChoiceEntry.COLUMN_RIGHT, answerMultChoice.isRight()
        );
        contentValues.put(
                EducationReaderContract.AnswerMultChoiceEntry.COLUMN_QUESTION_ID, answerMultChoice.getQuestion_id()
        );


        writableDatabase.insert(
                EducationReaderContract.AnswerMultChoiceEntry.TABLE_NAME,
                null,
                contentValues
        );
    }

    @Override
    public List<AnswerMultChoice> findAll() {

        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                EducationReaderContract.AnswerMultChoiceEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<AnswerMultChoice> answerMultChoiceList = new LinkedList<>();

        if (cursor.moveToFirst()) {

            int columnIndexId = cursor
                    .getColumnIndex(EducationReaderContract.AnswerMultChoiceEntry.COLUMN_ID);
            int columnIndexName = cursor
                    .getColumnIndex(EducationReaderContract.AnswerMultChoiceEntry.COLUMN_NAME);
            int columnIndexRight = cursor
                    .getColumnIndex(EducationReaderContract.AnswerMultChoiceEntry.COLUMN_RIGHT);
            int columnIndexQuestionId = cursor
                    .getColumnIndex(EducationReaderContract.AnswerMultChoiceEntry.COLUMN_QUESTION_ID);

            do {

                AnswerMultChoice answerMultChoice = new AnswerMultChoice(
                        cursor.getInt(columnIndexId),
                        cursor.getString(columnIndexName),
                        Boolean.parseBoolean(cursor.getString(columnIndexRight)),
                        cursor.getInt(columnIndexQuestionId)
                );

                answerMultChoiceList.add(answerMultChoice);
            } while (cursor.moveToNext());

        }

        return answerMultChoiceList;
    }

    @Override
    public List<AnswerMultChoice> findByTestId(int id) {

        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                EducationReaderContract.AnswerMultChoiceEntry.TABLE_NAME,
                null,
                EducationReaderContract.AnswerMultChoiceEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );

        List<AnswerMultChoice> answerMultChoiceList = new LinkedList<>();

        if (cursor.moveToFirst()) {

            int columnIndexId = cursor
                    .getColumnIndex(EducationReaderContract.AnswerMultChoiceEntry.COLUMN_ID);
            int columnIndexName = cursor
                    .getColumnIndex(EducationReaderContract.AnswerMultChoiceEntry.COLUMN_NAME);
            int columnIndexRight = cursor
                    .getColumnIndex(EducationReaderContract.AnswerMultChoiceEntry.COLUMN_RIGHT);
            int columnIndexQuestionId = cursor
                    .getColumnIndex(EducationReaderContract.AnswerMultChoiceEntry.COLUMN_QUESTION_ID);

            do {

                AnswerMultChoice answerMultChoice = new AnswerMultChoice(
                        cursor.getInt(columnIndexId),
                        cursor.getString(columnIndexName),
                        Boolean.parseBoolean(cursor.getString(columnIndexRight)),
                        cursor.getInt(columnIndexQuestionId)
                );

                answerMultChoiceList.add(answerMultChoice);
            } while (cursor.moveToNext());

        }

        return answerMultChoiceList;
    }
}
