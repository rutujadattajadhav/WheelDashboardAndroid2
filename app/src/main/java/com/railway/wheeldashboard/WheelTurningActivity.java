package com.railway.wheeldashboard;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class WheelTurningActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_turning);

        setupWheelTurningCutChart();
        setupWornWheelProfileChart();
        setupDropdown();
    }

    private void setupWheelTurningCutChart() {
        PieChart pieChart = findViewById(R.id.wheel_turning_cut_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(12.8f, "1"));
        entries.add(new PieEntry(15.3f, "2"));
        entries.add(new PieEntry(18.5f, "3"));
        entries.add(new PieEntry(16.2f, "4"));
        entries.add(new PieEntry(11.9f, "5"));
        entries.add(new PieEntry(8.1f, "Others"));

        PieDataSet dataSet = new PieDataSet(entries, "Wheel Turning Cut");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    private void setupWornWheelProfileChart() {
        PieChart pieChart = findViewById(R.id.worn_wheel_profile_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(32.6f, "29.4"));
        entries.add(new PieEntry(21.7f, "28"));
        entries.add(new PieEntry(20.5f, "27"));
        entries.add(new PieEntry(16.4f, "26"));
        entries.add(new PieEntry(8.8f, "Others"));

        PieDataSet dataSet = new PieDataSet(entries, "Worn Wheel Profile");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    private void setupDropdown() {
        Spinner dropdown = findViewById(R.id.received_from_dropdown);
        String[] options = {"Option 1", "Option 2", "Option 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        dropdown.setAdapter(adapter);
    }
}
