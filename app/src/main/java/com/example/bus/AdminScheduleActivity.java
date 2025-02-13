package com.example.bus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdminScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSchedule;
    private ScheduleAdapter scheduleAdapter;
    private List<ScheduleItem> scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_schedule);

        // Initialize views
        TextView btnAdd = findViewById(R.id.addButton);
        TextView btnMarkCompleted = findViewById(R.id.markCompletedButton);
        findViewById(R.id.btnBack).setOnClickListener(v -> navigateToMainActivity());

        recyclerViewSchedule = findViewById(R.id.recyclerView);
        recyclerViewSchedule.setLayoutManager(new LinearLayoutManager(this));

        // Initialize list and adapter
        scheduleList = new ArrayList<>();
        scheduleAdapter = new ScheduleAdapter(scheduleList);
        recyclerViewSchedule.setAdapter(scheduleAdapter);

        // Add new schedule item
        btnAdd.setOnClickListener(v -> {
            scheduleList.add(new ScheduleItem("Route A", "10:00 AM", "Bus 1"));
            scheduleAdapter.notifyDataSetChanged();
        });

        // Mark completed and navigate to main
        btnMarkCompleted.setOnClickListener(v -> navigateToMainActivity());
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
