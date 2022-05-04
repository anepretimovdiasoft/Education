package ru.stavopol.education.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ru.stavopol.education.MainActivity;
import ru.stavopol.education.R;
import ru.stavopol.education.activity.ChapterActivity;
import ru.stavopol.education.activity.TestActivity;
import ru.stavopol.education.dao.sqlite.TestReaderWriterSqlite;
import ru.stavopol.education.db.EducationDbOpenHelper;
import ru.stavopol.education.fragment.TestFragment;
import ru.stavopol.education.model.Chapter;
import ru.stavopol.education.model.QuestionMultChoice;
import ru.stavopol.education.model.Test;

public class AdapterQuestionPager extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private final List<QuestionMultChoice> questionMultChoiceList;
    private Context context;
    private final Test test;
    private int size;


    private int countEnter = 0;
    private int countRightQuestion = 0;

    public AdapterQuestionPager(
            Context context,
            List<QuestionMultChoice> questionMultChoiceList,
            Test test
    ) {

        this.inflater = LayoutInflater.from(context);
        this.questionMultChoiceList = questionMultChoiceList;
        this.context = context;
        this.test = test;
        size = questionMultChoiceList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvQuestionName;
        private final RecyclerView rvAnswer;
        private final AppCompatButton btnEnter;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            btnEnter = itemView.findViewById(R.id.btn_enter);
            rvAnswer = itemView.findViewById(R.id.rv_answer);
            tvQuestionName = itemView.findViewById(R.id.tv_question_name);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_pager_item_test, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder,
            @SuppressLint("RecyclerView") int position
    ) {

        QuestionMultChoice questionMultChoice = questionMultChoiceList.get(position);

        ((MyViewHolder) holder).tvQuestionName.setText(questionMultChoiceList.get(position).getName());

        AdapterAnswer adapterAnswer = new AdapterAnswer(context, questionMultChoice.getAnswerMultChoiceList());
        ((MyViewHolder) holder).rvAnswer.setAdapter(adapterAnswer);

        ((MyViewHolder) holder).btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (adapterAnswer.getResult()) {

                    Snackbar.make(view, "Верно", Snackbar.LENGTH_LONG).show();
                    countRightQuestion++;
                } else
                    Snackbar.make(view, "Не верно", Snackbar.LENGTH_LONG).show();

                countEnter++;
                view.setClickable(false);

                if (countEnter == size) {
                    if (countEnter == countRightQuestion) {
                        Toast.makeText(context, "Тест пройден", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Тест не пройден", Toast.LENGTH_LONG).show();
                    }
                    ((TestActivity) context).finish();
                }
                questionMultChoiceList.remove(position);
                AdapterQuestionPager.this.notifyDataSetChanged();
            }

        });

    }

    @Override
    public int getItemCount() {

        return questionMultChoiceList.size();
    }


}