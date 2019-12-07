package com.example.myapplication.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Database.Task;
import com.example.myapplication.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.TaskViewHolder> {

    private List<Task> mList;
    private Context context;

    public void setList(List<Task> list)
    {
        mList = list;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder
    {
        private TextView t1,t2,t3;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.taskName);
            t2=itemView.findViewById(R.id.taskDesc);
            t3=itemView.findViewById(R.id.taskTime);
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,null,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task current = mList.get(position);
        holder.t1.setText(current.getTask_name());
        holder.t2.setText(current.getTask_desc());
        holder.t3.setText(current.getHour() + " : " + current.getMin());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
