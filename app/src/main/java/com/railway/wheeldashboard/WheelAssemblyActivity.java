package com.railway.wheeldashboard;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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

public class WheelAssemblyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_assembly);

        setupWheelAssemblyTypeChart();
        setupYearlyWheelAssemblyChart();
        setupTable();
        setupDropdowns();
    }

    private void setupWheelAssemblyTypeChart() {
        PieChart pieChart = findViewById(R.id.wheel_assembly_type_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(42.5f, "HCC/TLR FORGE"));
        entries.add(new PieEntry(31.1f, "HCC/TLR CAST"));
        entries.add(new PieEntry(13.7f, "Others"));

        PieDataSet dataSet = new PieDataSet(entries, "Assembly Type");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    private void setupYearlyWheelAssemblyChart() {
        BarChart barChart = findViewById(R.id.yearly_wheel_assembly_chart);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(2019, 89));
        entries.add(new BarEntry(2020, 98));
        entries.add(new BarEntry(2021, 57));
        entries.add(new BarEntry(2022, 103));
        entries.add(new BarEntry(2023, 362));
        entries.add(new BarEntry(2024, 702));

        BarDataSet barDataSet = new BarDataSet(entries, "Yearly Assembly");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();
    }

    private void setupTable() {
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Define headers
        String[] headers = {
                "WHEEL SET", "TYPE", "AXLE PARTICULAR", "DISC SERIAL NUMBER",
                "INTERFERENCE A", "WHEEL PRESSURE", "DISC SERIAL NO. B", "INTERFERENCE B", "WHEEL PRESSURE"
        };

        // Define data
        String[][] data = {
                {"SU0561", "AC/DC (Siemens - 1774C)", "DSP-1034-48165", "0.12", "17", "DSP-1034-48165", "0.12", "null"},
                {"SU0560", "AC/DC (Siemens - 1845C)", "DSP-1034-48167", "0.12", "106", "DSP-1034-48164", "0.12", "null"},
                {"SU0569", "HCC/TLR (CAST)", "DSP-1034-48178", "0.12", "18", "DSP-1034-48170", "0.12", "null"},
                {"SU0549", "HCC/TLR (FORGE)", "DSP-1034-48183", "0.12", "null", "DSP-1034-48175", "0.12", "null"},
                {"SU0589", "Others", "DSP-1034-48168", "0.12", "15", "DSP-1034-48179", "0.12", "null"}
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

        // Add data rows
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

    private void setupDropdowns() {
        Spinner wheelSetNoDropdown = findViewById(R.id.wheel_set_no_dropdown);
        Spinner dateRangeDropdown = findViewById(R.id.date_range_dropdown);

        String[] wheelSetNoOptions = {"Set 1", "Set 2", "Set 3"};
        String[] dateRangeOptions = {"Last Week", "Last Month", "Last Year"};

        ArrayAdapter<String> wheelSetNoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, wheelSetNoOptions);
        ArrayAdapter<String> dateRangeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dateRangeOptions);

        wheelSetNoDropdown.setAdapter(wheelSetNoAdapter);
        dateRangeDropdown.setAdapter(dateRangeAdapter);
    }
}
