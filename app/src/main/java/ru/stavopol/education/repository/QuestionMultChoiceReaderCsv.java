package ru.stavopol.education.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ru.stavopol.education.model.QuestionMultChoice;

public class QuestionMultChoiceReaderCsv implements QuestionMultChoiceReader {

    private final int rawResId;
    private final Context context;
    private List<QuestionMultChoice> questionMultChoiceList = null;

    public QuestionMultChoiceReaderCsv(Context context, int rawResId) {

        this.rawResId = rawResId;
        this.context = context;
    }


    @Override
    public List<QuestionMultChoice> findAllQuestionMultChoice() {

        List<QuestionMultChoice> questionMultChoiceList = new LinkedList<>();

        InputStream inputStream = context.getResources().openRawResource(rawResId);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        );

        String line = "";
        QuestionMultChoice questionMultChoice;
        Map<String, Boolean> answerList = new HashMap<>();
        try {
            while ((line = bufferedReader.readLine()) != null) {

                String[] splitArray = line.split(";");

                for (int i = 2; i < splitArray.length; i++) {
                    if (splitArray[i].charAt(splitArray[i].length() - 1) == 't')
                        answerList.put(splitArray[i].substring(0, splitArray[i].length() - 2), true);
                    else
                        answerList.put(splitArray[i].substring(0, splitArray[i].length() - 2), false);
                }

                questionMultChoice = new QuestionMultChoice(
                        splitArray[2],
                        answerList,
                        Integer.parseInt(splitArray[1])
                );

                answerList.clear();
                questionMultChoiceList.add(questionMultChoice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.questionMultChoiceList = questionMultChoiceList;
        return questionMultChoiceList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<QuestionMultChoice> findQuestionMultChoiceTestId(int id) {

        if (questionMultChoiceList == null)
            questionMultChoiceList = findAllQuestionMultChoice();

        return questionMultChoiceList.stream()
                .filter(questionMultChoice -> questionMultChoice.getTest_id() == id)
                .collect(Collectors.toList());
    }
}
