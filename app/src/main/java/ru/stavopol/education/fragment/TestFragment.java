package ru.stavopol.education.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.stavopol.education.R;
import ru.stavopol.education.adapter.AdapterTest;
import ru.stavopol.education.dao.sqlite.TestReaderWriterSqlite;
import ru.stavopol.education.db.EducationDbOpenHelper;
import ru.stavopol.education.model.Test;
import ru.stavopol.education.dao.csv.TestReaderCsv;

public class TestFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        List<Test> allTest = new TestReaderWriterSqlite(new EducationDbOpenHelper(getContext())).findAll();

        RecyclerView rvTest = view.findViewById(R.id.rv_test);
        AdapterTest adapterTest = new AdapterTest(getContext(), allTest);
        rvTest.setAdapter(adapterTest);

        return view;
    }
}