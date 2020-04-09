package com.example.studentmanagementsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fragment_DeleteStudent extends Fragment {

    EditText facDeleteText;
    Button deleteStudentButton;
    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_delete, container, false);

        facDeleteText = v.findViewById(R.id.facnDelete);
        deleteStudentButton = v.findViewById(R.id.deleteStudent);

        deleteStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(facDeleteText.getText().toString().length() < 6){
                            Toast.makeText(getActivity(), "Not existing fac. number", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.child("Informatics").child(facDeleteText.getText().toString()).exists() && facDeleteText.getText().toString().substring(0, 6).equals("170126")) {
                            mRef.child("Informatics").child(facDeleteText.getText().toString()).removeValue();
                            Toast.makeText(getActivity(), "Student deleted", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.child("Maths").child(facDeleteText.getText().toString()).exists() && facDeleteText.getText().toString().substring(0, 6).equals("170138")) {
                            mRef.child("Maths").child(facDeleteText.getText().toString()).removeValue();
                            Toast.makeText(getActivity(), "Student deleted", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.child("BIT").child(facDeleteText.getText().toString()).exists() && facDeleteText.getText().toString().substring(0, 6).equals("170152")) {
                            mRef.child("BIT").child(facDeleteText.getText().toString()).removeValue();
                            Toast.makeText(getActivity(), "Student deleted", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.child("STD").child(facDeleteText.getText().toString()).exists() && facDeleteText.getText().toString().substring(0, 6).equals("170134")) {
                            mRef.child("STD").child(facDeleteText.getText().toString()).removeValue();
                            Toast.makeText(getActivity(), "Student deleted", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), "Not existing fac. number", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });




        return v;
    }

}
