package ru.stavopol.education.repository;

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
import ru.stavopol.education.model.Test;

public class TestReaderCsv implements TestReader {

    private final int rawResId;
    private final Context context;

    public TestReaderCsv(Context context, int rawResId) {

        this.rawResId = rawResId;
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Test> findAllTest() {

        List<Test> testList = new LinkedList<>();

        InputStream inputStream = context.getResources().openRawResource(rawResId);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        );

        String line = "";
        Test test;
        try {
            while ((line = bufferedReader.readLine()) != null) {

                String[] splitArray = line.split(";");

                test = new Test(
                        Integer.parseInt(splitArray[0]),
                        splitArray[1],
                        new QuestionMultChoiceReaderCsv(context, R.raw.question_mult_choice_data)
                                .findQuestionMultChoiceTestId(Integer.parseInt(splitArray[0])),
                        Integer.parseInt(splitArray[2])
                );

                testList.add(test);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testList;
    }
}
