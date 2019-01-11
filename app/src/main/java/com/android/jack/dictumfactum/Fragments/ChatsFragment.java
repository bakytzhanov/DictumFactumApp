package com.android.jack.dictumfactum.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.jack.dictumfactum.Adapter.UserAdapter;
import com.android.jack.dictumfactum.MainActivity;
import com.android.jack.dictumfactum.Model.Chat;
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
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChatsFragment extends Fragment {
  //  List<String> temp = new ArrayList<String>();
    private RecyclerView recyclerView;

    private UserAdapter userAdapter;
    private List<User> mUsers;

    FirebaseUser fuser;
    DatabaseReference reference;

    private List<String> usersList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fuser = FirebaseAuth.getInstance().getCurrentUser();

        usersList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Chat chat = snapshot.getValue(Chat.class);

                    if(chat.getSender().equals(fuser.getUid())){
                        usersList.add(chat.getReceiver());
                    }

                    if(chat.getReceiver().equals(fuser.getUid())){
                        usersList.add(chat.getSender());
                    }

                }


                readChats();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }



    private void readChats(){
        mUsers = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              //  Object[] arr = mUsers.toArray();
              //  Integer arr[] = new Integer[mUsers.size()];
                mUsers.clear();
               // mUsers.clear();
                //Object[] arr = mUsers.toArray();
              // Integer arr[] = new Integer[mUsers.size()];
              //  String [] arr = mUsers.toArray(new String[mUsers.size()]);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);

                    for (String id : usersList){
                        if(user.getId().equals(id)) {



                            mUsers.add(user);
                            Toast.makeText(getActivity(), "clean", Toast.LENGTH_SHORT).show();
                            List<String> strings = new ArrayList<>(mUsers.size());
                            for (Object object : mUsers) {
                                strings.add(object != null ? object.toString() : null);
                            }
                            Set<String> listWithoutDuplicates = new LinkedHashSet<String>(strings);

                            strings.clear();
                            strings.addAll(listWithoutDuplicates)
                     /*      if(mUsers.size() != 0) {

                                if(mUsers.size() == 1) {

                                    for (User user1 : mUsers) {
                                        if (!user.getId().equals(user1.getId())) {
                                            mUsers.add(user);

                                        }
                                    }





                                }else{
                                    mUsers.add(user);
                                    Toast.makeText(getActivity(), "else", Toast.LENGTH_SHORT).show();

                                }

*/



                               /* Toast.makeText(getActivity(), "getid" + user.getId() + "id" + id, Toast.LENGTH_SHORT).show();

                                for (int i = 0; i < temp.size(); i++) {
                                    if (!temp.contains(user.getId())) {

                                        mUsers.add(user);

                                        Toast.makeText(getActivity(), "Getid" + user.getId() + "id" + id, Toast.LENGTH_SHORT).show();

                                    }
                                }
                                Toast.makeText(getActivity(), "size" + mUsers.size(), Toast.LENGTH_SHORT).show();
                                temp.add(user.getId());*/
                          /*  if (mUsers.size() != 0) {

                                // if (arr.length == 1) {
                             //   for (User user1: mUsers) {
                                    if (!user.getId().equals(mUsers.get(mUsers.size()-1))) {
                                        mUsers.add(user);

                                    }

                                //}

                            }*/


                                //    if(arr.length != 0){

                                //  for(int i = 0; i <arr.length; i++) {

                                // if (!mUsers.contains(user.getId().equals(id))) {
                                //   mUsers.add(user);

                                // }
                                // }

                                // }else{

                                //    if (!mUsers.contains(user.getId())) {
                                //mUsers.add(user);

                                //}

     /*                       if(mUsers.size() != 0){
                                if(mUsers.size()==1) {
                                    for (User user1 : mUsers) {
                                        if (!user.getId().equals(user1.getId())) {
                                            mUsers.add(user);
                                            Toast.makeText(getActivity(), "size" + mUsers.size() + "user.getId" + user.getId(), Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                }else {
                                  //  for(int i = 0; i<mUsers.size(); i++) {
                                     //   if (!mUsers.get(i).equals(user.getId())) {
                                            mUsers.add(user);
                                            Toast.makeText(getActivity(), "7size" + mUsers.size() + "user.getId" + user.getId(), Toast.LENGTH_SHORT).show();
                                    //    }
                                  //  }
                                }
                            }else {
                                mUsers.add(user);
                            }

*/
                       /*     }else {
                                mUsers.add(user);
                          //      temp.add(user.getId());
                            }*/

                        }
                    }

                    }

                userAdapter = new UserAdapter(getContext(), mUsers, true);
                recyclerView.setAdapter(userAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
