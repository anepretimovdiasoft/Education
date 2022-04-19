package ru.stavopol.education.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

import ru.stavopol.education.R;
import ru.stavopol.education.activity.TestActivity;
import ru.stavopol.education.model.AnswerMultChoice;
import ru.stavopol.education.model.Test;

public class AdapterAnswer extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private LayoutInflater inflater;
    private List<AnswerMultChoice> answerMultChoiceList;
    private Context context;
    private int countRight = 0;
    private int needRight;

    public AdapterAnswer(Context context, List<AnswerMultChoice> answerMultChoiceList) {

        this.inflater = LayoutInflater.from(context);
        this.answerMultChoiceList = answerMultChoiceList;
        this.context = context;
        for (int i = 0; i < answerMultChoiceList.size(); i++) {
            if (answerMultChoiceList.get(i).isRight()) needRight++;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvAnswerName;
        private final CheckBox cbAnswer;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            tvAnswerName = itemView.findViewById(R.id.tv_answer_name);
            cbAnswer = itemView.findViewById(R.id.cb_answer);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_answer, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder,
            @SuppressLint("RecyclerView") int position
    ) {

        AnswerMultChoice answerMultChoice = answerMultChoiceList.get(position);

        ((MyViewHolder) holder).tvAnswerName.setText(answerMultChoice.getName());
        //((MyViewHolder) holder).cbAnswer.setChecked(answerMultChoice.isRight());
        ((MyViewHolder) holder).cbAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (answerMultChoice.isRight() == ((CheckBox)view).isChecked())
                    countRight++;
                else
                    countRight--;

            }
        });



    }

    @Override
    public int getItemCount() {

        return answerMultChoiceList.size();
    }

    public int getCountRight() {
        return countRight;
    }

    public boolean getResult(){

        return countRight == needRight;
    }
}
