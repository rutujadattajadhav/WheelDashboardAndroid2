package com.railway.wheeldashboard;


import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
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
        setupTable();
    }


    private void getAllMachines() {
        MachineApiService machineApiService = RetrofitClientInstance.getRetrofitInstance().create(MachineApiService.class);
        machineApiService.getAllMachines().enqueue(new Callback<List<Machine>>() {
            @Override
            public void onResponse(Call<List<Machine>> call, Response<List<Machine>> response) {
                if (response.isSuccessful()) {
                    List<Machine> machines = response.body();
                    Log.d("Successfully fetched",machines.toString());
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

    private void setupTable() {
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Define table headers
        String[] headers = {
                "Plant No.", "Description of Machine", "Make",
                "Date of acquisition/installation", "Capacity"
        };

        // Define table data
        String[][] data = {
                {"73", "Axle box cleaning plant", "HYT", "25.02.2020", "AXLE BOXES- 60/ 8Hrs"},
                {"72", "Chip Compactor", "HYT", "12.02.2020", "Turning cuts of 14 wheel set/ 8Hrs"},
                {"71", "Heating Oven", "HYT", "29.01.2019", "40 Axle box/ 8Hrs"},
                {"59", "Spring testing machine, RM/STM/001", "Remmach", "04.07.2019", "25 no. coil spring/ 8Hrs"},
                {"54", "Bearing Cleaning Plant", "HYT", "13.11.2018", "BEARINGS- 60/ 8Hrs"},
                {"42", "Roller Bearing Extractor", "HYT", "03.11.2018", "10 roller bearings/ 8Hrs"},
                {"41", "Roller Bearing Extractor", "HYT", "02.11.2018", "10 roller bearings/ 8Hrs"},
                {"40", "CNC Axle Turning Lathe", "HYT", "31.10.2018", "TURN NEW AXLE-01 EMU OR TURN WHEEL SET-02/ EMU/ 8Hrs"},
                {"39", "Wheel press 500T Wheel press 500 St:No. BBM 608", "HYT", "27.09.2018", "PRESS ON-08 WHEELS EMU WHEEL PRESS OFF-12 WHEEL/ 8Hrs"},
                {"38", "Wheel press 500T Wheel press 500 St:No. BBM 605", "HYT", "15.09.2018", "PRESS ON-08 WHEELS EMU WHEEL PRESS OFF-12 WHEEL/ 8Hrs"},
                {"36", "Horizontal Drilling Tapping Machine", "GEETA TOOL", "21.04.2018", "DRILL AND TAP NEW AXLE-02/ 8Hrs"},
                {"26", "CNC Surface Wheel Lathe Machine Including Provisions", "HYT", "28.03.2018", "14 EMU WHEEL SET/ 8Hrs"},
                {"25", "Axle Journal Turning & Burnishing Machine", "HYT", "28.03.2018", "EMU AXLE JR/08/ 8Hrs"},
                {"14", "Axle box Extractor", "HYT", "24.02.2018", "20 Axle box/ 8Hrs"},
                {"13", "Bearing Induction Heater", "HYT", "22.02.2018", "36 bearings/ 8Hrs"},
                {"18", "Vertical Turning Lathe", "HYT", "25.10.2017", "EMU-06 DISC/ 8Hrs"},
                {"18", "Vertical Turning Lathe", "HYT", "25.10.2017", "EMU-06 DISC/ 8Hrs"},
                {"19", "Hydraulically operated Bearing Extractor", "Liba engineering", "21.06.2016", "10 roller bearings/ 8Hrs"},
                {"19", "L-45 LATHE", "HMT", "null", "null"}
        };

        // Add headers
        TableRow headerRow = new TableRow(this);
        for (String header : headers) {
            TextView textView = new TextView(this);
            textView.setText(header);
            textView.setPadding(8, 8, 8, 8);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            headerRow.addView(textView);
        }
        tableLayout.addView(headerRow);

        // Add rows
        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setPadding(8, 8, 8, 8);
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }
    }
}
