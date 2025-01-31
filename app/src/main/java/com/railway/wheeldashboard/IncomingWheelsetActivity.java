package com.railway.wheeldashboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class IncomingWheelsetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_wheelset);

        setupAxleRejectionChart();
        setupWheelDefectsChart();
        setupAxleBoxRejectionChart();
        setupTypesOfRepairsChart();
    }

    private void setupAxleRejectionChart() {
        PieChart pieChart = findViewById(R.id.axle_rejection_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(46, "Journal Under Size"));
        entries.add(new PieEntry(35, "Wheel Seat Under Size"));
        entries.add(new PieEntry(15, "UST Fail"));
        entries.add(new PieEntry(5, "Wheel Seat Scorched"));

        PieDataSet dataSet = new PieDataSet(entries, "Axle Rejection Defects");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    private void setupWheelDefectsChart() {
        BarChart barChart = findViewById(R.id.wheel_defects_chart);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, new float[]{80, 60}, "2024-25"));
        entries.add(new BarEntry(1, new float[]{75, 55}, "2023-24"));
        entries.add(new BarEntry(2, new float[]{70, 50}, "2022-23"));
        entries.add(new BarEntry(3, new float[]{65, 45}, "2021-22"));

        BarDataSet dataSet = new BarDataSet(entries, "Wheel Defects (CMI K003)");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        BarData data = new BarData(dataSet);
        barChart.setData(data);
        barChart.invalidate();
    }

    private void setupAxleBoxRejectionChart() {
        BarChart barChart = findViewById(R.id.axle_box_rejection_chart);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, new float[]{200, 50, 20}, "164"));
        entries.add(new BarEntry(1, new float[]{180, 40, 15}, "98"));

        BarDataSet dataSet = new BarDataSet(entries, "Axle Box Rejection");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(dataSet);
        barChart.setData(data);
        barChart.invalidate();
    }

    private void setupTypesOfRepairsChart() {
        PieChart pieChart = findViewById(R.id.types_of_repairs_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(61, "Normal (T)"));
        entries.add(new PieEntry(37.7f, "IR"));
        entries.add(new PieEntry(1.3f, "RA"));

        PieDataSet dataSet = new PieDataSet(entries, "Types of Repairs");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }
}
