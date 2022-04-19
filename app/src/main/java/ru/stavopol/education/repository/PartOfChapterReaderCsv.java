package ru.stavopol.education.repository;

import android.content.Context;
import android.net.LinkAddress;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import ru.stavopol.education.model.PartOfChapter;

public class PartOfChapterReaderCsv implements PartOfChapterReader{

    private final int rawResId;
    private final Context context;
    private List<PartOfChapter> partOfChapterList = null;

    public PartOfChapterReaderCsv(Context context, int rawResId) {

        this.rawResId = rawResId;
        this.context = context;
    }

    @Override
    public List<PartOfChapter> findAllPartOfChapter() {

        if (partOfChapterList != null)
            return partOfChapterList;

        List<PartOfChapter> partOfChapterList = new LinkedList<>();

        InputStream inputStream = context.getResources().openRawResource(rawResId);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        );

        String line = "";
        PartOfChapter partOfChapter;
        try{
            while ( (line = bufferedReader.readLine()) != null) {

                String[] splitArray = line.split(";");

                partOfChapter = new PartOfChapter(
                        Integer.parseInt(splitArray[0]),
                        splitArray[1],
                        splitArray[2],
                        splitArray[3],
                        Integer.parseInt(splitArray[5])
                );

                partOfChapterList.add(partOfChapter);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        this.partOfChapterList = partOfChapterList;
        return partOfChapterList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<PartOfChapter> findPartOfChapterByChapterId(int id) {

        if (partOfChapterList == null)
            partOfChapterList = findAllPartOfChapter();

        return partOfChapterList.stream()
                .filter(partOfChapter -> partOfChapter.getChapter_id() == id)
                .collect(Collectors.toList());
    }
}
