package ru.stavopol.education.dao;

import android.content.Context;

import ru.stavopol.education.R;
import ru.stavopol.education.dao.csv.ChapterReader;
import ru.stavopol.education.dao.csv.ChapterReaderCsv;
import ru.stavopol.education.dao.csv.PartOfChapterReader;
import ru.stavopol.education.dao.csv.PartOfChapterReaderCsv;
import ru.stavopol.education.dao.csv.QuestionMultChoiceReader;
import ru.stavopol.education.dao.csv.QuestionMultChoiceReaderCsv;
import ru.stavopol.education.dao.csv.TestReader;
import ru.stavopol.education.dao.csv.TestReaderCsv;
import ru.stavopol.education.dao.sqlite.AnswerMultChoiceReaderWriter;
import ru.stavopol.education.dao.sqlite.AnswerMultChoiceReaderWriterSqlite;
import ru.stavopol.education.dao.sqlite.ChapterReaderWriter;
import ru.stavopol.education.dao.sqlite.ChapterReaderWriterSqlite;
import ru.stavopol.education.dao.sqlite.PartOfChapterReaderWriter;
import ru.stavopol.education.dao.sqlite.PartOfChapterReaderWriterSqlite;
import ru.stavopol.education.dao.sqlite.QuestionMultChoiceReaderWriter;
import ru.stavopol.education.dao.sqlite.QuestionMultChoiceReaderWriterSqlite;
import ru.stavopol.education.dao.sqlite.TestReaderWriter;
import ru.stavopol.education.dao.sqlite.TestReaderWriterSqlite;
import ru.stavopol.education.db.EducationDbOpenHelper;

public class TransferCsvSqlite {

    private final ChapterReader chapterReader;
    private final PartOfChapterReader partOfChapterReader;
    private final QuestionMultChoiceReader questionMultChoiceReader;
    private final TestReader testReader;

    private final ChapterReaderWriter chapterReaderWriter;
    private final PartOfChapterReaderWriter partOfChapterReaderWriter;
    private final QuestionMultChoiceReaderWriter questionMultChoiceReaderWriter;
    private final AnswerMultChoiceReaderWriter answerMultChoiceReaderWriter;
    private final TestReaderWriter testReaderWriter;

    public TransferCsvSqlite(Context context, EducationDbOpenHelper openHelper){

        this.chapterReader = new ChapterReaderCsv(context, R.raw.chapter_data);
        this.partOfChapterReader = new PartOfChapterReaderCsv(context, R.raw.part_of_chapter_data);
        this.questionMultChoiceReader = new QuestionMultChoiceReaderCsv(context, R.raw.question_mult_choice_data);
        this.testReader = new TestReaderCsv(context, R.raw.test_data);

        this.chapterReaderWriter = new ChapterReaderWriterSqlite(openHelper);
        this.partOfChapterReaderWriter = new PartOfChapterReaderWriterSqlite(openHelper);
        this.questionMultChoiceReaderWriter = new QuestionMultChoiceReaderWriterSqlite(openHelper);
        this.answerMultChoiceReaderWriter = new AnswerMultChoiceReaderWriterSqlite(openHelper);
        this.testReaderWriter = new TestReaderWriterSqlite(openHelper);
    }



}
