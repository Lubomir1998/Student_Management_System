package com.example.studentmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    Context context;
    ArrayList<Student> students_list;


    public MyAdapter(Context context, ArrayList<Student> students_list) {
        this.context = context;
        this.students_list = students_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.stu_facNum.setText(students_list.get(position).getFac_num());
        holder.stu_name.setText(students_list.get(position).getName());
        holder.stu_course.setText(students_list.get(position).getCourse());

    }

    @Override
    public int getItemCount() {
        return students_list.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{
        TextView stu_facNum, stu_name, stu_course;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stu_facNum = itemView.findViewById(R.id.facnumTextView);
            stu_name = itemView.findViewById(R.id.nameTextView);
            stu_course = itemView.findViewById(R.id.courseTextView);
        }
    }

}
