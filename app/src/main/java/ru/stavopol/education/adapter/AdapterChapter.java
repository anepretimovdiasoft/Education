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

import ru.stavopol.education.R;
import ru.stavopol.education.activity.ChapterActivity;
import ru.stavopol.education.model.Chapter;

public class AdapterChapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String CHAPTER_NUMBER = "Chapter number";
    private LayoutInflater inflater;
    private List<Chapter> chapterList;
    private Context context;

    public AdapterChapter(Context context, List<Chapter> chapterList) {

        this.inflater = LayoutInflater.from(context);
        this.chapterList = chapterList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvChapterName;
        private final TextView tvChapterDiscription;
        private final CheckBox cbChapter;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            tvChapterName = itemView.findViewById(R.id.tv_chapter_name);
            cbChapter = itemView.findViewById(R.id.cb_chapter);
            tvChapterDiscription = itemView.findViewById(R.id.tv_chapter_description);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_chapter, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder,
            @SuppressLint("RecyclerView") int position
    ) {

        Chapter chapter = chapterList.get(position);

        ((MyViewHolder) holder).tvChapterName.setText(chapter.getName());
        ((MyViewHolder) holder).cbChapter.setChecked(chapter.isChecked());
        ((MyViewHolder) holder).tvChapterDiscription.setText(chapter.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ChapterActivity.class);

                intent.putExtra(CHAPTER_NUMBER, chapterList.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return chapterList.size();
    }
}