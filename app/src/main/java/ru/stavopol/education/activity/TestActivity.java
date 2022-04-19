package ru.stavopol.education.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import ru.stavopol.education.R;
import ru.stavopol.education.adapter.AdapterQuestionPager;
import ru.stavopol.education.adapter.AdapterTest;
import ru.stavopol.education.model.Test;

public class TestActivity extends AppCompatActivity {

    private ViewPager2 vpQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Test test = (Test) getIntent().getSerializableExtra(AdapterTest.CHAPTER_NUMBER);

        vpQuestion = findViewById(R.id.vp_question);
        vpQuestion.setAdapter(new AdapterQuestionPager(this, test.getQuestionMultChoiceList()));

    }
}