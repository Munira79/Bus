package com.example.bus;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;

public class BusRq extends AppCompatActivity {

    private RadioGroup rgTime;
    private RadioButton selectedTime;
    private Spinner spinnerRoutes;
    private Button btnVote;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_rq);

        // Initialize Views
        rgTime = findViewById(R.id.rgTime);
        spinnerRoutes = findViewById(R.id.spinnerRoutes);
        btnVote = findViewById(R.id.btnVote);
        btnBack = findViewById(R.id.btnBack);

        // Setup Spinner
        String[] routes = {"Route 1", "Route 2", "Route 3", "Route 4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, routes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoutes.setAdapter(adapter);

        // Back Button Functionality
        btnBack.setOnClickListener(v -> finish());

        // Vote Button Click
        btnVote.setOnClickListener(v -> {
            // Get Selected Time
            int selectedTimeId = rgTime.getCheckedRadioButtonId();
            if (selectedTimeId == -1) {
                Toast.makeText(BusRq.this, "Please select a time", Toast.LENGTH_SHORT).show();
                return;
            }
            selectedTime = findViewById(selectedTimeId);

            // Get Selected Route
            String selectedRoute = spinnerRoutes.getSelectedItem().toString();

            // Show Result
            Toast.makeText(BusRq.this, "You voted for " + selectedRoute + " at " + selectedTime.getText(), Toast.LENGTH_SHORT).show();
        });
    }
}
