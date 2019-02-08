package com.android.jack.dictumfactum.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.jack.dictumfactum.Adapter.NewsAdapter;
import com.android.jack.dictumfactum.Adapter.UserAdapter;
import com.android.jack.dictumfactum.AddPostActivity;
import com.android.jack.dictumfactum.Model.News;
import com.android.jack.dictumfactum.Model.User;
import com.android.jack.dictumfactum.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {


    private RecyclerView recyclerView;

    private NewsAdapter newsAdapter;
    private List<News> mNews;

    TextView txt_title;





    FloatingActionButton add_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_news, container, false);


        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        txt_title = view.findViewById(R.id.txt_title);

        mNews = new ArrayList<>();










        add_button = view.findViewById(R.id.add_post);












        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user1 = dataSnapshot.getValue(User.class);

                if (user1.getLawyer_status().equals("lawyer")) {

                    add_button.setVisibility(View.VISIBLE);


                }else {
                    add_button.setVisibility(View.GONE);

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });














        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddPostActivity.class));

            }
        });

        readNews();

        return view;
    }



    private void readNews() {

        //final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();



        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("News");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                mNews.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    News news = snapshot.getValue(News.class);


                    mNews.add(news);

                }










                newsAdapter = new NewsAdapter(getContext(), mNews);
                recyclerView.setAdapter(newsAdapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
