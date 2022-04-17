package ru.stavopol.education.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.stavopol.education.R;
import ru.stavopol.education.adapter.AdapterChapter;
import ru.stavopol.education.adapter.AdapterPartOfChapter;
import ru.stavopol.education.testdata.TestData;


public class ChapterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);

        RecyclerView rvChapter = view.findViewById(R.id.rv_course);
        AdapterChapter adapterChapter = new AdapterChapter(getContext(), TestData.CHAPTER_LIST);
        rvChapter.setAdapter(adapterChapter);

        return view;
    }
}