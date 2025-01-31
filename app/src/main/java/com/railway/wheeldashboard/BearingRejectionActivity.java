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

public class BearingRejectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bearing_rejection);

        setupMakeWiseChart();
        setupAgeWiseChart();
        setupCauseWiseChart();
    }

    private void setupMakeWiseChart() {
        PieChart pieChart = findViewById(R.id.make_wise_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(52.3f, "FAG"));
        entries.add(new PieEntry(48.7f, "NBC"));

        PieDataSet dataSet = new PieDataSet(entries, "Make Wise");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    private void setupAgeWiseChart() {
        PieChart pieChart = findViewById(R.id.age_wise_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(12.1f, "21"));
        entries.add(new PieEntry(13.2f, "20"));
        entries.add(new PieEntry(11.9f, "19"));
        entries.add(new PieEntry(10.6f, "18"));
        entries.add(new PieEntry(8.7f, "17"));
        entries.add(new PieEntry(9.4f, "16"));
        entries.add(new PieEntry(8.1f, "Others"));

        PieDataSet dataSet = new PieDataSet(entries, "Age Wise");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    private void setupCauseWiseChart() {
        BarChart barChart = findViewById(R.id.cause_wise_chart);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 79, "Roller Indentations"));
        entries.add(new BarEntry(1, 39, "Excess Bore"));
        entries.add(new BarEntry(2, 36, "Flaking"));
        entries.add(new BarEntry(3, 24, "Inner Race Crack"));
        entries.add(new BarEntry(4, 21, "Overage"));
        entries.add(new BarEntry(5, 21, "Peeling"));
        entries.add(new BarEntry(6, 18, "Outer Race Fretting"));
        entries.add(new BarEntry(7, 10, "Roller Path Skewing"));
        entries.add(new BarEntry(8, 6, "Cage Damage"));

        BarDataSet barDataSet = new BarDataSet(entries, "Causes");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();
    }
}
