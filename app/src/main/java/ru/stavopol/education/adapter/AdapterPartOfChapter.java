package ru.stavopol.education.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.stavopol.education.R;
import ru.stavopol.education.activity.WebViewActivity;
import ru.stavopol.education.model.PartOfChapter;

public class AdapterPartOfChapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<PartOfChapter> partOfChapterList;
    private Context context;
    public static final String PART_LINK = "link";

    public AdapterPartOfChapter(Context context, List<PartOfChapter> partOfChapterList) {

        this.inflater = LayoutInflater.from(context);
        this.partOfChapterList = partOfChapterList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivChapterImageTop;
        private final ImageView ivChapterImageBottom;
        private final TextView tvChapterText;
        private final TextView tvChapterTitle;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            ivChapterImageTop = itemView.findViewById(R.id.iv_chapter_image_top);
            ivChapterImageBottom = itemView.findViewById(R.id.iv_chapter_image_bottom);
            tvChapterText = itemView.findViewById(R.id.tv_chapter_text);
            tvChapterTitle = itemView.findViewById(R.id.tv_chapter_title);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_part_of_chapter, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RecyclerView.ViewHolder holder,
            @SuppressLint("RecyclerView") int position
    ) {

        PartOfChapter partOfChapter = partOfChapterList.get(position);

        if (!partOfChapter.getTopImage().equals("-1")) {
            int drawableTopResourceId = context
                    .getResources()
                    .getIdentifier(
                            partOfChapter.getTopImage(),
                            "drawable",
                            context.getPackageName()
                    );

            ((MyViewHolder) holder).ivChapterImageTop.setImageDrawable(context.getDrawable(drawableTopResourceId));
        }else {

            ((MyViewHolder) holder).ivChapterImageTop.setVisibility(View.GONE);
        }

        if (!partOfChapter.getBottomImage().equals("-1")) {
            int drawableBotResourceId = context
                    .getResources()
                    .getIdentifier(
                            partOfChapter.getBottomImage(),
                            "drawable",
                            context.getPackageName()
                    );
            ((MyViewHolder) holder).ivChapterImageBottom.setImageDrawable(context.getDrawable(drawableBotResourceId));
        }else {

            ((MyViewHolder) holder).ivChapterImageBottom.setVisibility(View.GONE);
        }

        if (!partOfChapter.getChapterText().equals("-1")) {

            ((MyViewHolder) holder).tvChapterText.setText(partOfChapter.getChapterText());
        }else {

            ((MyViewHolder) holder).tvChapterText.setVisibility(View.GONE);
        }

        if (!partOfChapter.getTitle().equals("-1")) {

            ((MyViewHolder) holder).tvChapterTitle.setText(partOfChapter.getTitle());
        }else{

            ((MyViewHolder) holder).tvChapterTitle.setVisibility(View.GONE);
        }

        if (!partOfChapter.getPart_link().equals("-1")) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, WebViewActivity.class);

                    intent.putExtra(PART_LINK, partOfChapter.getPart_link());

                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {

        return partOfChapterList.size();
    }
}