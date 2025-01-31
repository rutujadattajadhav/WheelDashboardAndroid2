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

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setupYearBarChart();
        setupRepairPieChart();
        setupTypeOfWheelChart();
        setupWheelAssemblyChart();
    }

    private void setupYearBarChart() {
        BarChart barChart = findViewById(R.id.year_bar_chart);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(2019, 474));
        entries.add(new BarEntry(2020, 1005));
        entries.add(new BarEntry(2021, 1726));
        entries.add(new BarEntry(2022, 2082));
        entries.add(new BarEntry(2023, 1760));

        BarDataSet barDataSet = new BarDataSet(entries, "Year-wise Performance");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.invalidate();
    }

    private void setupRepairPieChart() {
        PieChart pieChart = findViewById(R.id.repair_pie_chart);

        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(37.7f, "Normal (T)"));
        pieEntries.add(new PieEntry(61f, "RD"));
        pieEntries.add(new PieEntry(1.3f, "RA"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Type of Repair");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    private void setupTypeOfWheelChart() {
        BarChart barChart = findViewById(R.id.type_of_wheel_chart);

        List<BarEntry> entries1 = new ArrayList<>();
        entries1.add(new BarEntry(2019, 50));
        entries1.add(new BarEntry(2020, 75));
        entries1.add(new BarEntry(2021, 150));
        entries1.add(new BarEntry(2022, 200));
        entries1.add(new BarEntry(2023, 250));

        BarDataSet dataSet1 = new BarDataSet(entries1, "AC/DC BMW");

        BarData barData = new BarData(dataSet1);
        barChart.setData(barData);
        barChart.invalidate();
    }

    private void setupWheelAssemblyChart() {
        BarChart barChart = findViewById(R.id.wheel_assembly_chart);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(2019, 89));
        entries.add(new BarEntry(2020, 98));
        entries.add(new BarEntry(2021, 57));
        entries.add(new BarEntry(2022, 103));
        entries.add(new BarEntry(2023, 702));

        BarDataSet barDataSet = new BarDataSet(entries, "Wheel Assembly");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.invalidate();
    }
}
