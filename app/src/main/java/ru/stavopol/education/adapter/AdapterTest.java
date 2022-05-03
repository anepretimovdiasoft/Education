package ru.stavopol.education.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

import ru.stavopol.education.R;
import ru.stavopol.education.activity.TestActivity;
import ru.stavopol.education.dao.sqlite.TestReaderWriterSqlite;
import ru.stavopol.education.db.EducationDbOpenHelper;
import ru.stavopol.education.model.Test;

public class AdapterTest extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String CHAPTER_NUMBER = "Chapter number";
    private LayoutInflater inflater;
    private List<Test> testList;
    private Context context;

    public AdapterTest(Context context, List<Test> testList) {

        this.inflater = LayoutInflater.from(context);
        this.testList = testList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTestName;
        private final CheckBox cbTest;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            tvTestName = itemView.findViewById(R.id.tv_test_name);
            cbTest = itemView.findViewById(R.id.cb_test);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_test, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder,
            @SuppressLint("RecyclerView") int position
    ) {

        Test test = testList.get(position);

        ((MyViewHolder) holder).tvTestName.setText(test.getName());
        ((MyViewHolder) holder).cbTest.setChecked(test.isAccept());

        /*if (test.isAccept()){
            holder.itemView.setBackgroundColor(Color.GREEN);
        }*/

        ((MyViewHolder) holder).cbTest.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        test.setAccept(((CheckBox)view).isChecked());
                        new TestReaderWriterSqlite(
                                new EducationDbOpenHelper(context))
                                .update(test.getId(), test.isAccept()
                                );
                        AdapterTest.this.notifyDataSetChanged();
                    }
                }
        );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, TestActivity.class);

                intent.putExtra(CHAPTER_NUMBER, testList.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return testList.size();
    }
}
