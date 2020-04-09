package com.example.studentmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InformaticsAdd extends AppCompatActivity {

    EditText facNum, name, course;
    Button add;
    ImageButton backToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatics_add);

        facNum = findViewById(R.id.facNum_edit);
        name = findViewById(R.id.name_edit);
        course = findViewById(R.id.course_edit);
        add = findViewById(R.id.add_btn);
        backToList = findViewById(R.id.back_to_list);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_student = database.getReference("Informatics");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_student.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(facNum.getText().toString().isEmpty() || name.getText().toString().isEmpty() ||
                                course.getText().toString().isEmpty()){
                            Toast.makeText(getApplicationContext(), "All fields must be filled!", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.child(facNum.getText().toString()).exists()) {
                            Toast.makeText(getApplicationContext(), "Student already exists!", Toast.LENGTH_SHORT).show();
                        }
                        else if(facNum.getText().toString().length() != 10){
                            Toast.makeText(getApplicationContext(), "Fac. number length is incorrect!", Toast.LENGTH_SHORT).show();
                        }
                        else if(!facNum.getText().toString().substring(0, 6).equals("170126")){
                            Toast.makeText(getApplicationContext(), "Fac. number is wrong!", Toast.LENGTH_SHORT).show();
                        }
                        else if(Integer.parseInt(course.getText().toString()) < 1 || Integer.parseInt(course.getText().toString()) > 4){
                            Toast.makeText(getApplicationContext(), "Enter a valid course!", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            Student stu = new Student(facNum.getText().toString(),
                                                      name.getText().toString(),
                                                      course.getText().toString()
                            );
                            table_student.child(facNum.getText().toString()).setValue(stu);
                            Toast.makeText(InformaticsAdd.this, "Student added", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent intent = new Intent(getApplicationContext(), InformaticsAdd.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        backToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Informatics.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });



    }


}
