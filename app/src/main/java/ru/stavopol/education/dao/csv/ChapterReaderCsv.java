package ru.stavopol.education.dao.csv;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import ru.stavopol.education.R;
import ru.stavopol.education.model.Chapter;

public class ChapterReaderCsv implements ChapterReader {

    private final int rawResId;
    private final Context context;
    private List<Chapter> chapterList = null;

    public ChapterReaderCsv(Context context, int rawResId) {

        this.rawResId = rawResId;
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Chapter> findAll() {

        if (chapterList != null)
            return chapterList;

        List<Chapter> chapterList = new LinkedList<>();

        InputStream inputStream = context.getResources().openRawResource(rawResId);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        );

        String line = "";
        Chapter chapter;
        try {
            while ((line = bufferedReader.readLine()) != null) {

                String[] splitArray = line.split(";");

                chapter = new Chapter(
                        Integer.parseInt(splitArray[0]),
                        splitArray[1],
                        splitArray[2],
                        new PartOfChapterReaderCsv(context, R.raw.part_of_chapter_data)
                                .findByChapterId(Integer.parseInt(splitArray[0])),
                        false,
                        false,
                        null
                );

                chapterList.add(chapter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.chapterList = chapterList;
        return chapterList;
    }
}
