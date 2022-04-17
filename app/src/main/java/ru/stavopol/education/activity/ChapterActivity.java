package ru.stavopol.education.activity;

import static ru.stavopol.education.adapter.AdapterChapter.CHAPTER_NUMBER;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import ru.stavopol.education.R;
import ru.stavopol.education.adapter.AdapterPartOfChapter;
import ru.stavopol.education.testdata.TestData;

public class ChapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        int chapterNumber = getIntent().getIntExtra(CHAPTER_NUMBER, -1);

        TextView tvChapterLabel = findViewById(R.id.tv_chapter_label);

        tvChapterLabel.setText(tvChapterLabel.getText().toString() + " " + (chapterNumber + 1));

        RecyclerView rvPartOfChapter = findViewById(R.id.rv_part_of_chapter);
        AdapterPartOfChapter adapterPartOfChapter = new AdapterPartOfChapter(this, TestData.PART_OF_CHAPTER_LIST);
        rvPartOfChapter.setAdapter(adapterPartOfChapter);
    }
}