package ru.stavopol.education.dao.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import ru.stavopol.education.db.EducationDbOpenHelper;
import ru.stavopol.education.db.EducationReaderContract;
import ru.stavopol.education.model.Test;

public class TestReaderWriterSqlite implements TestReaderWriter {

    private final EducationDbOpenHelper openHelper;

    public TestReaderWriterSqlite(EducationDbOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    @Override
    public List<Test> findAll() {

        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                EducationReaderContract.TestEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<Test> testList = new LinkedList<>();

        if (cursor.moveToFirst()) {

            int columnIndexId = cursor
                    .getColumnIndex(EducationReaderContract.TestEntry.COLUMN_ID);
            int columnIndexName = cursor
                    .getColumnIndex(EducationReaderContract.TestEntry.COLUMN_NAME);
            int columnIndexAccept = cursor
                    .getColumnIndex(EducationReaderContract.TestEntry.COLUMN_ACCEPT);
            int columnIndexChapterId = cursor
                    .getColumnIndex(EducationReaderContract.TestEntry.COLUMN_CHAPTER_ID);

            do {

                Test test = new Test(
                        cursor.getInt(columnIndexId),
                        cursor.getString(columnIndexName),
                        new QuestionMultChoiceReaderWriterSqlite(openHelper)
                                .findByTestId(cursor.getInt(columnIndexId)),
                        cursor.getInt(columnIndexChapterId)
                );

                test.setAccept(
                        cursor.getInt(columnIndexAccept) == 1
                );

                testList.add(test);
            } while (cursor.moveToNext());

        }

        cursor.close();
        return testList;
    }

    @Override
    public void insert(Test test) {

        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(
                EducationReaderContract.TestEntry.COLUMN_ID, test.getId()
        );
        contentValues.put(
                EducationReaderContract.TestEntry.COLUMN_NAME, test.getName()
        );
        contentValues.put(
                EducationReaderContract.TestEntry.COLUMN_ACCEPT, test.isAccept()
        );
        contentValues.put(
                EducationReaderContract.TestEntry.COLUMN_CHAPTER_ID, test.getChapter_id()
        );

        writableDatabase.insert(
                EducationReaderContract.TestEntry.TABLE_NAME,
                null,
                contentValues
        );
    }

    @Override
    public void update(int id, boolean accept) {

        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(
                EducationReaderContract.TestEntry.COLUMN_ACCEPT, accept
        );

        writableDatabase.update(
                EducationReaderContract.TestEntry.TABLE_NAME,
                contentValues,
                EducationReaderContract.TestEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
    }
}
