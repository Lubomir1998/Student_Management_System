package com.example.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Subjects extends Fragment {

    Button inf, maths, bit, std;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_subjects, container, false);

        inf = v.findViewById(R.id.informatics);
        maths = v.findViewById(R.id.maths);
        bit = v.findViewById(R.id.bit);
        std = v.findViewById(R.id.std);

        inf.setOnClickListener(buttonClicked);
        std.setOnClickListener(buttonClicked);
        bit.setOnClickListener(buttonClicked);
        maths.setOnClickListener(buttonClicked);

        return v;
    }

    View.OnClickListener buttonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.informatics:
                    Intent intent = new Intent(getActivity(), Informatics.class);
                    startActivity(intent);
                    break;
                case R.id.std:
                    Intent intent2 = new Intent(getActivity(), Std.class);
                    startActivity(intent2);
                    break;
                case R.id.bit:
                    Intent intent3 = new Intent(getActivity(), Bit.class);
                    startActivity(intent3);
                    break;
                case R.id.maths:
                    Intent intent4 = new Intent(getActivity(), Maths.class);
                    startActivity(intent4);
                    break;
            }
        }
    };
}
