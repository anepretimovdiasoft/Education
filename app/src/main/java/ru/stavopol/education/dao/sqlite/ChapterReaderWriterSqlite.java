package ru.stavopol.education.dao.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.LinkedList;
import java.util.List;

import ru.stavopol.education.db.EducationDbOpenHelper;
import ru.stavopol.education.db.EducationReaderContract;
import ru.stavopol.education.model.Chapter;

public class ChapterReaderWriterSqlite implements ChapterReaderWriter {

    private final EducationDbOpenHelper openHelper;

    public ChapterReaderWriterSqlite(EducationDbOpenHelper openHelper) {
        this.openHelper = openHelper;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Chapter> findAll() {

        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                EducationReaderContract.ChapterEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<Chapter> chapterList = new LinkedList<>();

        if (cursor.moveToFirst()) {

            int columnIndexId = cursor
                    .getColumnIndex(EducationReaderContract.ChapterEntry.COLUMN_ID);
            int columnIndexName = cursor
                    .getColumnIndex(EducationReaderContract.ChapterEntry.COLUMN_NAME);
            int columnIndexDescription = cursor
                    .getColumnIndex(EducationReaderContract.ChapterEntry.COLUMN_DESCRIPTION);
            int columnIndexChecked = cursor
                    .getColumnIndex(EducationReaderContract.ChapterEntry.COLUMN_CHECKED);
            int columnIndexAccepted = cursor
                    .getColumnIndex(EducationReaderContract.ChapterEntry.COLUMN_ACCEPTED);

            do {

                Chapter chapter = new Chapter(
                        cursor.getInt(columnIndexId),
                        cursor.getString(columnIndexName),
                        cursor.getString(columnIndexDescription),
                        new PartOfChapterReaderWriterSqlite(openHelper)
                                .findByChapterId(cursor.getInt(columnIndexId)),
                        cursor.getInt(columnIndexChecked) == 1,
                        cursor.getInt(columnIndexAccepted) == 1,
                        new TestReaderWriterSqlite(openHelper)
                                .findAll()
                        .stream()
                        .filter(test -> test.getChapter_id() == cursor.getInt(columnIndexId))
                        .findFirst()
                        .orElse(null)
                );

                chapterList.add(chapter);
            } while (cursor.moveToNext());

        }

        cursor.close();
        return chapterList;
    }

    @Override
    public void insert(Chapter chapter) {

        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(
                EducationReaderContract.ChapterEntry.COLUMN_ID, chapter.getId()
        );
        contentValues.put(
                EducationReaderContract.ChapterEntry.COLUMN_NAME, chapter.getName()
        );
        contentValues.put(
                EducationReaderContract.ChapterEntry.COLUMN_DESCRIPTION, chapter.getDescription()
        );
        contentValues.put(
                EducationReaderContract.ChapterEntry.COLUMN_CHECKED, chapter.isChecked()
        );
        contentValues.put(
                EducationReaderContract.ChapterEntry.COLUMN_ACCEPTED, chapter.isAccepted()
        );


        writableDatabase.insert(
                EducationReaderContract.ChapterEntry.TABLE_NAME,
                null,
                contentValues
        );
    }

    @Override
    public void update(int id, boolean checked, boolean accept) {

        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(
                EducationReaderContract.ChapterEntry.COLUMN_ACCEPTED, accept
        );
        contentValues.put(
                EducationReaderContract.ChapterEntry.COLUMN_CHECKED, checked
        );

        writableDatabase.update(
                EducationReaderContract.ChapterEntry.TABLE_NAME,
                contentValues,
                EducationReaderContract.TestEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
    }
}
