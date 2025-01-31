package com.railway.wheeldashboard;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class WheelPohDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_poh);

        setupTable();
        setupTypeOfWheelChart();
        setupTypeOfBearingChart();
    }

    private void setupTable() {
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Define all table headers
        String[] headers = {
                "DATE", "WHEEL NO", "WHEEL TYPE", "TREAD DIA", "FLANGE", "JOURNAL DIA A",
                "SNPD BEARING", "BEARING MAKE", "SHRINKING", "JOURNAL DIA B", "UST"
        };

        // Define table data
        String[][] data = {
                {"Jan 22, 2025", "SU0562", "AC/DC (SIEMENS FORGE)", "953", "29.4", "140.85", "SNA-13710", "FAG", "0.055", "140.05", "PVF"},
                {"Jan 22, 2025", "SU0566", "HCC/TLR (FORGE)", "954", "26.0", "140.55", "SNA-813", "FAG", "0.065", "140.45", "CIS"},
                {"Jan 22, 2025", "SU0462", "HCC/TLR (CAST)", "926", "27.0", "140.45", "SNA-4070", "NBC", "0.055", "140.55", "CIS"},
                {"Jan 22, 2025", "SU0015", "AC/DC (BMW CAST)", "912", "26.0", "140.35", "SNA-1405", "NBC", "0.065", "140.25", "GMM"},
                {"Jan 21, 2025", "SU0048", "HCC/TLR (FORGE)", "954", "26.0", "140.55", "SNA-170", "FAG", "0.065", "140.45", "CIS"},
                {"Jan 21, 2025", "SU0048", "HCC/TLR (CAST)", "926", "27.0", "140.45", "SNA-813", "FAG", "0.055", "140.55", "CIS"},
                {"Jan 21, 2025", "SU0567", "AC/DC (BMW CAST)", "912", "26.0", "140.35", "SNA-1405", "NBC", "0.065", "140.25", "GMM"},
                {"Jan 21, 2025", "SU0014", "AC/DC (SIEMENS FORGE)", "953", "29.4", "140.85", "SNA-13710", "FAG", "0.055", "140.05", "PVF"},
                {"Jan 21, 2025", "SU0045", "AC/DC (SIEMENS FORGE)", "920", "28.5", "140.90", "SNA-1221", "NBC", "0.055", "140.15", "CIS"},
                {"Jan 21, 2025", "SU0021", "HCC/TLR (FORGE)", "940", "27.5", "140.50", "SNA-1175", "FAG", "0.065", "140.55", "PVF"},
                {"Jan 20, 2025", "SU0089", "HCC/TLR (CAST)", "930", "25.0", "140.60", "SNA-4113", "NBC", "0.055", "140.35", "GMM"},
                {"Jan 20, 2025", "SU0154", "AC/DC (BMW CAST)", "945", "26.5", "140.75", "SNA-3112", "FAG", "0.065", "140.65", "CIS"}
        };

        // Add headers to the table
        TableRow headerRow = new TableRow(this);
        for (String header : headers) {
            TextView textView = new TextView(this);
            textView.setText(header);
            textView.setPadding(8, 8, 8, 8);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            headerRow.addView(textView);
        }
        tableLayout.addView(headerRow);

        // Add rows to the table
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

    private void setupTypeOfWheelChart() {
        PieChart pieChart = findViewById(R.id.type_of_wheel_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40, "AC/DC BMW FORGE"));
        entries.add(new PieEntry(30, "HCC/TLR CAST"));
        entries.add(new PieEntry(30, "Others"));

        PieDataSet dataSet = new PieDataSet(entries, "Type of Wheel POH");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    private void setupTypeOfBearingChart() {
        PieChart pieChart = findViewById(R.id.type_of_bearing_chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(62.6f, "FAG"));
        entries.add(new PieEntry(37.4f, "NBC"));

        PieDataSet dataSet = new PieDataSet(entries, "Type of Bearing");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }
}
