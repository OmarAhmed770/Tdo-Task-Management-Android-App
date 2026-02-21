package com.example.tdo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements TaskAdapter.OnTaskClickListener {

    private EditText taskInput, timeInput;
    private Button saveTaskButton, btnStartPauseTimer, btnResetTimer;
    private RecyclerView taskRecyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    private TextView timerDisplay;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private boolean timerRunning = false;
    private boolean timerPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views
        taskInput = findViewById(R.id.task_input);
        timeInput = findViewById(R.id.time_input);
        saveTaskButton = findViewById(R.id.btn_save_task);
        btnStartPauseTimer = findViewById(R.id.btn_start_pause_timer);
        btnResetTimer = findViewById(R.id.btn_reset_timer);
        timerDisplay = findViewById(R.id.timer_display);
        taskRecyclerView = findViewById(R.id.task_recycler_view);

        // Initialize task list and adapter
        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(taskList, this); // Pass "this" as the click listener

        // Set up RecyclerView
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskRecyclerView.setAdapter(taskAdapter);

        // Save Task Button
        saveTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskDescription = taskInput.getText().toString().trim();
                if (!taskDescription.isEmpty()) {
                    taskList.add(new Task(taskDescription, false));
                    taskAdapter.notifyDataSetChanged();
                    taskInput.setText("");
                    Toast.makeText(HomeActivity.this, "Task Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(HomeActivity.this, "Please enter a task description", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Start or pause the timer
        btnStartPauseTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning) {
                    String timeString = timeInput.getText().toString().trim();
                    if (TextUtils.isEmpty(timeString)) {
                        timeInput.setError("Please enter time in minutes");
                        return;
                    }
                    long timeInMinutes = Long.parseLong(timeString);
                    timeLeftInMillis = timeInMinutes * 60000; // Convert minutes to milliseconds
                    startTimer();
                } else {
                    if (timerPaused) {
                        resumeTimer();
                    } else {
                        pauseTimer();
                    }
                }
            }
        });

        // Reset the timer
        btnResetTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    // Timer functionality
    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerDisplay();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                btnStartPauseTimer.setText("Start Timer");
                timerDisplay.setText("Time's up!");
            }
        }.start();

        timerRunning = true;
        btnStartPauseTimer.setText("Pause Timer");
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        timerPaused = true;
        btnStartPauseTimer.setText("Resume Timer");
    }

    private void resumeTimer() {
        startTimer();
        timerPaused = false;
    }

    private void resetTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        timerRunning = false;
        timerPaused = false;
        timeLeftInMillis = 0;
        updateTimerDisplay();
        btnStartPauseTimer.setText("Start Timer");
    }

    private void updateTimerDisplay() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format("%02d:%02d", minutes, seconds);
        timerDisplay.setText("Time Remaining: " + timeFormatted);
    }

    // Handle task deletion with confirmation
    @Override
    public void onTaskDeleteClick(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Task");
        builder.setMessage("Are you sure you want to delete this task?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            taskList.remove(position);
            taskAdapter.notifyItemRemoved(position);
            Toast.makeText(HomeActivity.this, "Task Deleted", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

    @Override
    public void onTaskCompleteClick(int position) {
        Task task = taskList.get(position);
        task.setCompleted(!task.isCompleted());
        taskAdapter.notifyItemChanged(position);
    }
}
