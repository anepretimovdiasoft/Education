package ru.stavopol.education.csv;

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
import java.util.stream.Collectors;

import ru.stavopol.education.model.AnswerMultChoice;
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

        if (questionMultChoiceList != null)
            return  questionMultChoiceList;

        List<QuestionMultChoice> questionMultChoiceList = new LinkedList<>();

        InputStream inputStream = context.getResources().openRawResource(rawResId);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        );

        String line = "";
        QuestionMultChoice questionMultChoice;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                List<AnswerMultChoice> answerMultChoiceList = new LinkedList<>();
                String[] splitArray = line.split(";");

                for (int i = 3; i < splitArray.length; i++) {
                    if (splitArray[i].charAt(splitArray[i].length() - 1) == 't')
                        answerMultChoiceList.add(new AnswerMultChoice(
                                splitArray[i].substring(0, splitArray[i].length() - 1),
                                true,
                                Integer.parseInt(splitArray[0])
                        ));
                    else
                        answerMultChoiceList.add(new AnswerMultChoice(
                                splitArray[i].substring(0, splitArray[i].length() - 1),
                                false,
                                Integer.parseInt(splitArray[0])
                        ));
                }

                questionMultChoice = new QuestionMultChoice(
                        splitArray[2],
                        answerMultChoiceList,
                        Integer.parseInt(splitArray[1])
                );

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
