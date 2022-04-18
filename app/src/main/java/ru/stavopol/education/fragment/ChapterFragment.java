package ru.stavopol.education.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.stavopol.education.R;
import ru.stavopol.education.adapter.AdapterChapter;
import ru.stavopol.education.model.Chapter;
import ru.stavopol.education.repository.ChapterReaderCsv;


public class ChapterFragment extends Fragment {

    private List<Chapter> chapterList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);

        chapterList = new ChapterReaderCsv(getContext(), R.raw.chapter_data).findAllChapter();
        RecyclerView rvChapter = view.findViewById(R.id.rv_course);
        AdapterChapter adapterChapter = new AdapterChapter(getContext(), chapterList);
        rvChapter.setAdapter(adapterChapter);

        return view;
    }
}