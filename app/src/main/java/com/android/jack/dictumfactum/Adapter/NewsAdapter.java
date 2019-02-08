package com.android.jack.dictumfactum.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.jack.dictumfactum.MessageActivity;
import com.android.jack.dictumfactum.Model.Chat;
import com.android.jack.dictumfactum.Model.News;
import com.android.jack.dictumfactum.Model.User;
import com.android.jack.dictumfactum.PostActivity;
import com.android.jack.dictumfactum.R;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


    private Context mContext;
    private List<News> mNews;




    public NewsAdapter(Context mContext, List<News> mNews){
        this.mNews = mNews;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final News news = mNews.get(position);
        holder.header_post.setText(news.getHeader());
        holder.def.setText(news.getField());


        holder.learn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PostActivity.class);
                intent.putExtra("newsid", news.getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView header_post;
        public TextView def;
        public TextView learn_more;


        public ViewHolder(View itemView){
            super(itemView);

            header_post = itemView.findViewById(R.id.header_post);
            def = itemView.findViewById(R.id.def);
            learn_more = itemView.findViewById(R.id.learn_more);

        }


    }


}
