package com.railway.wheeldashboard;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.railway.wheeldashboard.client.RetrofitClientInstance;
import com.railway.wheeldashboard.login.LoginService;
import com.railway.wheeldashboard.machine.Machine;
import com.railway.wheeldashboard.machine.MachineApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MachinePlantActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_plant);
        getAllMachines();

    }


    private void getAllMachines() {
        MachineApiService machineApiService = RetrofitClientInstance.getRetrofitInstance().create(MachineApiService.class);
        machineApiService.getAllMachines().enqueue(new Callback<List<Machine>>() {
            @Override
            public void onResponse(Call<List<Machine>> call, Response<List<Machine>> response) {
                if (response.isSuccessful()) {
                    List<Machine> machines = response.body();
                    Log.d("Successfully fetched",machines.toString());
                    setupTable(machines);
                } else {
                    Log.d("Not get successfully","not get successfully");
                }
            }

            @Override
            public void onFailure(Call<List<Machine>> call, Throwable t) {
                Log.d("Failure occour at the time get all machine",t.getMessage());
            }
        });
    }

    private void setupTable(List<Machine> machines) {
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Clear previous rows if any
        tableLayout.removeAllViews();

        // Define table headers
        String[] headers = {
                "Plant No.", "Description of Machine", "Make",
                "Date of acquisition/installation", "Capacity"
        };

        // Add headers
        TableRow headerRow = new TableRow(this);
        for (String header : headers) {
            TextView textView = new TextView(this);
            textView.setText(header);
            textView.setPadding(16, 16, 16, 16);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setBackgroundResource(android.R.color.darker_gray);
            textView.setTextColor(Color.WHITE);
            textView.setGravity(Gravity.CENTER);
            headerRow.addView(textView);
        }
        tableLayout.addView(headerRow);

        // Add rows with data
        for (Machine machine : machines) {
            TableRow tableRow = new TableRow(this);

            // Plant No.
            TextView plantNoTextView = new TextView(this);
            plantNoTextView.setText(machine.getPlantNo() != null ? machine.getPlantNo().toString() : "N/A");
            plantNoTextView.setPadding(16, 16, 16, 16);
            tableRow.addView(plantNoTextView);

            // Description of Machine
            TextView descriptionTextView = new TextView(this);
            descriptionTextView.setText(machine.getDescription() != null ? machine.getDescription() : "N/A");
            descriptionTextView.setPadding(16, 16, 16, 16);
            tableRow.addView(descriptionTextView);

            // Make
            TextView makeTextView = new TextView(this);
            makeTextView.setText(machine.getMake() != null ? machine.getMake() : "N/A");
            makeTextView.setPadding(16, 16, 16, 16);
            tableRow.addView(makeTextView);

            // Date of Acquisition/Installation
            TextView acquisitionDateTextView = new TextView(this);
            acquisitionDateTextView.setText(machine.getAcquisitionDate() != null ? machine.getAcquisitionDate() : "N/A");
            acquisitionDateTextView.setPadding(16, 16, 16, 16);
            tableRow.addView(acquisitionDateTextView);

            // Capacity
            TextView capacityTextView = new TextView(this);
            capacityTextView.setText(machine.getCapacity() != null ? machine.getCapacity() : "N/A");
            capacityTextView.setPadding(16, 16, 16, 16);
            tableRow.addView(capacityTextView);

            // Add the row to the table layout
            tableRow.setBackgroundResource(android.R.color.white);
            tableLayout.addView(tableRow);
        }
    }

}
