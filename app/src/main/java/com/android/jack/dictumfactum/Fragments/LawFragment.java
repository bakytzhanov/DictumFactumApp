package com.android.jack.dictumfactum.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.jack.dictumfactum.AdminActivity;
import com.android.jack.dictumfactum.BorderActivity;
import com.android.jack.dictumfactum.FamilyActivity;
import com.android.jack.dictumfactum.FeeActivity;
import com.android.jack.dictumfactum.LandActivity;
import com.android.jack.dictumfactum.PoliceActivity;
import com.android.jack.dictumfactum.R;
import com.android.jack.dictumfactum.RawActivity;
import com.android.jack.dictumfactum.WorkActivity;


public class LawFragment extends Fragment {

    Button fee;
    Button raw;
    Button family;
    Button work;
    Button police;
    Button border;
    Button land;
    Button admin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_law, container, false);


        fee = view.findViewById(R.id.button1);
        raw = view.findViewById(R.id.button2);
        family = view.findViewById(R.id.button3);
        work = view.findViewById(R.id.button4);
        police = view.findViewById(R.id.button5);
        border = view.findViewById(R.id.button6);
        land = view.findViewById(R.id.button7);
        admin = view.findViewById(R.id.button8);


        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FeeActivity.class);
                startActivity(intent);
            }
        });



        raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RawActivity.class);
                startActivity(intent);
            }
        });


        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FamilyActivity.class);
                startActivity(intent);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WorkActivity.class);
                startActivity(intent);
            }
        });

        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PoliceActivity.class);
                startActivity(intent);
            }
        });

        border.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BorderActivity.class);
                startActivity(intent);
            }
        });

        land.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LandActivity.class);
                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AdminActivity.class);
                startActivity(intent);
            }
        });




        return view;
    }


}
