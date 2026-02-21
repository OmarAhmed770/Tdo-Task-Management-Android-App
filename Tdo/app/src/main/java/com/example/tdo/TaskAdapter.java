package com.example.tdo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList;
    private final OnTaskClickListener listener;

    public TaskAdapter(List<Task> taskList, OnTaskClickListener listener) {
        this.taskList = taskList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskDescription.setText(task.getDescription());
        holder.taskCompleted.setChecked(task.isCompleted());

        holder.taskCompleted.setOnClickListener(v -> listener.onTaskCompleteClick(position));
        holder.deleteButton.setOnClickListener(v -> listener.onTaskDeleteClick(position));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public interface OnTaskClickListener {
        void onTaskDeleteClick(int position);
        void onTaskCompleteClick(int position);
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskDescription;
        CheckBox taskCompleted;
        ImageButton deleteButton;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskDescription = itemView.findViewById(R.id.task_description);
            taskCompleted = itemView.findViewById(R.id.task_completed);
            deleteButton = itemView.findViewById(R.id.btn_delete_task);
        }
    }
}
