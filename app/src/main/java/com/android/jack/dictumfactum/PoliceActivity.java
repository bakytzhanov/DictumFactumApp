package com.android.jack.dictumfactum;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.jack.dictumfactum.Adapter.UserAdapter;
import com.android.jack.dictumfactum.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PoliceActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private UserAdapter userAdapter;
    private List<User> mUsers;

    TextView txt_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Уголовные правоотношения");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(PoliceActivity.this));

        txt_title = findViewById(R.id.txt_title);

        mUsers = new ArrayList<>();

        readUsers();
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

                                    if (user.getLawyer_status().equals("notlawyer")) {

                                        if (user.getCch5().equals(true)) {
                                            mUsers.add(user);
                                        }
                                    }
                                }
                            }


                            userAdapter = new UserAdapter(PoliceActivity.this, mUsers, false);
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

                                    if (user.getLawyer_status().equals("lawyer")) {
                                        if (user.getCch5().equals(true)) {
                                            mUsers.add(user);
                                        }

                                    }
                                }
                            }


                            userAdapter = new UserAdapter(PoliceActivity.this, mUsers, false);
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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
