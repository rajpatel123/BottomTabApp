package com.jpr.bottomtabapp.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.jpr.bottomtabapp.R;
import com.jpr.bottomtabapp.ui.dashboard.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    List<Student> studentList;
    Context context;
   // UserListButtonsClickListener userListButtonsClickListener;

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.userId.setText(String.valueOf(student.getId()));
        holder.nameTv.setText(student.getName());
        holder.emailTv.setText(student.getEmail());
        holder.phoneTv.setText(student.getPhone());
        holder.addressTv.setText(student.getAddress());

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  userListButtonsClickListener.onDeleteButtonClicked(student);
            }
        });

        holder.detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // userListButtonsClickListener.onDetailButtonClicked(student);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (studentList==null) {
            return 0;
        } else {
            return studentList.size();

        }
    }


//    public void setOnButtonClickListener(UserListButtonsClickListener userListButtonsClickListener) {
//        this.userListButtonsClickListener = userListButtonsClickListener;
//    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        notifyDataSetChanged();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView userId;
        TextView nameTv, emailTv, phoneTv, addressTv;
        Button deleteBtn, detailBtn;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            emailTv = itemView.findViewById(R.id.emailTv);
            nameTv = itemView.findViewById(R.id.nameTv);
            phoneTv = itemView.findViewById(R.id.phoneTv);
            addressTv = itemView.findViewById(R.id.addressTv);
            userId = itemView.findViewById(R.id.idTv);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            detailBtn = itemView.findViewById(R.id.detailBtn);
        }
    }
}
