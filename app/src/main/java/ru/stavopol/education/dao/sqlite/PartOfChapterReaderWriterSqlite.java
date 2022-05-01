package ru.stavopol.education.dao.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import ru.stavopol.education.db.EducationDbOpenHelper;
import ru.stavopol.education.db.EducationReaderContract;
import ru.stavopol.education.model.PartOfChapter;

public class PartOfChapterReaderWriterSqlite implements PartOfChapterReaderWriter {

    private final EducationDbOpenHelper openHelper;

    public PartOfChapterReaderWriterSqlite(EducationDbOpenHelper openHelper) {

        this.openHelper = openHelper;
    }

    @Override
    public void insert(PartOfChapter partOfChapter) {

        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(
                EducationReaderContract.PartOfChapterEntry.COLUMN_ID, partOfChapter.getId()
        );
        contentValues.put(
                EducationReaderContract.PartOfChapterEntry.COLUMN_TITLE, partOfChapter.getTitle()
        );
        contentValues.put(
                EducationReaderContract.PartOfChapterEntry.COLUMN_TOP_IMAGE, partOfChapter.getTopImage()
        );
        contentValues.put(
                EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_TEXT, partOfChapter.getChapterText()
        );
        contentValues.put(
                EducationReaderContract.PartOfChapterEntry.COLUMN_BOTTOM_IMAGE, partOfChapter.getBottomImage()
        );
        contentValues.put(
                EducationReaderContract.PartOfChapterEntry.COLUMN_PART_LINK, partOfChapter.getPart_link()
        );
        contentValues.put(
                EducationReaderContract.PartOfChapterEntry.COLUMN_PART_NUMBER, partOfChapter.getPart_number()
        );
        contentValues.put(
                EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_ID, partOfChapter.getChapter_id()
        );

        writableDatabase.insert(
                EducationReaderContract.PartOfChapterEntry.TABLE_NAME,
                null,
                contentValues
        );
    }

    @Override
    public List<PartOfChapter> findAll() {

        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                EducationReaderContract.PartOfChapterEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<PartOfChapter> partOfChapterList = new LinkedList<>();

        if (cursor.moveToFirst()) {

            int columnIndexId = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_ID);
            int columnIndexTitle = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_TITLE);
            int columnIndexTopImage = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_TOP_IMAGE);
            int columnIndexChapterText = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_TEXT);
            int columnIndexBottomIndex = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_BOTTOM_IMAGE);
            int columnIndexPartLink = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_PART_LINK);
            int columnIndexPartNumber = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_PART_NUMBER);
            int columnIndexChapterId = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_ID);

            do {

                PartOfChapter partOfChapter = new PartOfChapter(
                        cursor.getInt(columnIndexId),
                        cursor.getString(columnIndexTitle),
                        cursor.getString(columnIndexTopImage),
                        cursor.getString(columnIndexBottomIndex),
                        cursor.getString(columnIndexChapterText),
                        cursor.getInt(columnIndexPartNumber),
                        cursor.getInt(columnIndexChapterId),
                        cursor.getString(columnIndexPartLink)
                );

                partOfChapterList.add(partOfChapter);
            } while (cursor.moveToNext());

        }

        return partOfChapterList;
    }

    @Override
    public List<PartOfChapter> findByChapterId(int id) {

        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                EducationReaderContract.PartOfChapterEntry.TABLE_NAME,
                null,
                EducationReaderContract.PartOfChapterEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );

        List<PartOfChapter> partOfChapterList = new LinkedList<>();

        if (cursor.moveToFirst()) {

            int columnIndexId = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_ID);
            int columnIndexTitle = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_TITLE);
            int columnIndexTopImage = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_TOP_IMAGE);
            int columnIndexChapterText = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_TEXT);
            int columnIndexBottomIndex = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_BOTTOM_IMAGE);
            int columnIndexPartLink = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_PART_LINK);
            int columnIndexPartNumber = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_PART_NUMBER);
            int columnIndexChapterId = cursor
                    .getColumnIndex(EducationReaderContract.PartOfChapterEntry.COLUMN_CHAPTER_ID);

            do {

                PartOfChapter partOfChapter = new PartOfChapter(
                        cursor.getInt(columnIndexId),
                        cursor.getString(columnIndexTitle),
                        cursor.getString(columnIndexTopImage),
                        cursor.getString(columnIndexBottomIndex),
                        cursor.getString(columnIndexChapterText),
                        cursor.getInt(columnIndexPartNumber),
                        cursor.getInt(columnIndexChapterId),
                        cursor.getString(columnIndexPartLink)
                );

                partOfChapterList.add(partOfChapter);
            } while (cursor.moveToNext());

        }

        return partOfChapterList;
    }
}
