package com.android.jack.dictumfactum.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.jack.dictumfactum.Adapter.UserAdapter;
import com.android.jack.dictumfactum.MainActivity;
import com.android.jack.dictumfactum.Model.User;
import com.android.jack.dictumfactum.R;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class UsersFragment extends Fragment {


    private RecyclerView recyclerView;

    private UserAdapter userAdapter;
    private List<User> mUsers;

    TextView txt_title;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_users, container, false);


        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        txt_title = view.findViewById(R.id.txt_title);

        mUsers = new ArrayList<>();

        readUsers();




        return view;
    }



    private void readUsers() {

        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user1 = dataSnapshot.getValue(User.class);

                if (user1.getLawyer_status().equals("lawyer")) {
                    txt_title.setText("Список пользователей");
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            mUsers.clear();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                User user = snapshot.getValue(User.class);


                                assert user != null;
                                if (!user.getId().equals(firebaseUser.getUid())) {

                                    if (user.getLawyer_status().equals("notlawyer"))
                                        mUsers.add(user);


                                }
                            }


                            userAdapter = new UserAdapter(getContext(), mUsers, false);
                            recyclerView.setAdapter(userAdapter);


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                } else {
                    txt_title.setText("Список юристов");
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            mUsers.clear();
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                User user = snapshot.getValue(User.class);


                                assert user != null;
                                if (!user.getId().equals(firebaseUser.getUid())) {

                                    if (user.getLawyer_status().equals("lawyer"))
                                        mUsers.add(user);


                                }
                            }


                            userAdapter = new UserAdapter(getContext(), mUsers, false);
                            recyclerView.setAdapter(userAdapter);


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }



        }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
