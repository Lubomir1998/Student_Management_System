package com.example.studentmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Std extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<Student> stu_list4;
    MyAdapter adapter4;
    ImageButton btn, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std);

        btn = findViewById(R.id.img_btn3);
        back = findViewById(R.id.back4);

        recyclerView = findViewById(R.id.recyclerView4);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reference = FirebaseDatabase.getInstance().getReference("STD");

        stu_list4 = new ArrayList<>();

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    Student value = ds.getValue(Student.class);
                    stu_list4.add(value);
                }
                adapter4 = new MyAdapter(Std.this, stu_list4);
                recyclerView.setAdapter(adapter4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), StdAdd.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }
}
