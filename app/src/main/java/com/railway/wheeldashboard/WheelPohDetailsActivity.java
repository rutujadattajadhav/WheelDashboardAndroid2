package com.railway.wheeldashboard;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.railway.wheeldashboard.client.RetrofitClientInstance;
import com.railway.wheeldashboard.login.LoginService;
import com.railway.wheeldashboard.wheelPohDetail.WheelPoh;
import com.railway.wheeldashboard.wheelPohDetail.WheelPohApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WheelPohDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_poh);
        getAllWheelPohDetails();

        setupTypeOfWheelChart();
        setupTypeOfBearingChart();
    }


    private void getAllWheelPohDetails() {
        WheelPohApiService wheelPohService = RetrofitClientInstance.getRetrofitInstance().create(WheelPohApiService.class);
        wheelPohService.getAllWheelPohDetails().enqueue(new Callback<List<WheelPoh>>() {
            @Override
            public void onResponse(Call<List<WheelPoh>> call, Response<List<WheelPoh>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<WheelPoh> wheelPohList = response.body();
                    Log.d("successfully fetched","Successfully fetched");
                    setupTable(wheelPohList);
                } else {
                    Log.e("API_ERROR", "Error Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<WheelPoh>> call, Throwable t) {
                Log.e("API_FAILURE", "Error: " + t.getMessage());
            }
        });
    }



    private void setupTable(List<WheelPoh> wheelPohList) {
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Clear any existing rows to avoid duplication
        tableLayout.removeAllViews();

        // Define all table headers
        String[] headers = {
                "Id", "DATE", "WHEEL NO", "WHEEL TYPE", "TREAD DIA", "FLANGE", "JOURNAL DIA A",
                "SNPD BEARING A", "BEARING MAKE", "SHRINKING A", "SNPD BEARING B",
                "SHRINKING B", "BEARING", "JOURNAL DIA B", "UST"
        };

        // Add headers to the table
        TableRow headerRow = new TableRow(this);
        for (String header : headers) {
            TextView textView = new TextView(this);
            textView.setText(header);
            textView.setPadding(8, 8, 8, 8);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setGravity(Gravity.CENTER);
            headerRow.addView(textView);
        }
        tableLayout.addView(headerRow);

        // Add rows to the table
        for (WheelPoh row : wheelPohList) {
            TableRow tableRow = new TableRow(this);

            // Add each column data to the row
            addTextViewToRow(tableRow, row.getId() != null ? row.getId().toString() : "N/A");
            addTextViewToRow(tableRow, row.getDate());
            addTextViewToRow(tableRow, row.getWheelNo());
            addTextViewToRow(tableRow, row.getWheelType());
            addTextViewToRow(tableRow, row.getTreadDia() != null ? row.getTreadDia().toString() : "N/A");
            addTextViewToRow(tableRow, row.getFlange() != null ? row.getFlange().toString() : "N/A");
            addTextViewToRow(tableRow, row.getJournalDiaA() != null ? row.getJournalDiaA().toString() : "N/A");
            addTextViewToRow(tableRow, row.getSnpdBearingA());
            addTextViewToRow(tableRow, row.getBearingMake());
            addTextViewToRow(tableRow, row.getShrinkingA() != null ? row.getShrinkingA().toString() : "N/A");
            addTextViewToRow(tableRow, row.getSnpdBearingB());
            addTextViewToRow(tableRow, row.getShrinkingB() != null ? row.getShrinkingB().toString() : "N/A");
            addTextViewToRow(tableRow, row.getBearing());
            addTextViewToRow(tableRow, row.getJournalDiaB() != null ? row.getJournalDiaB().toString() : "N/A");
            addTextViewToRow(tableRow, row.getUst());

            // Add the row to the table
            tableLayout.addView(tableRow);
        }
    }

    // Helper method to add TextView to a TableRow
    private void addTextViewToRow(TableRow tableRow, String text) {
        TextView textView = new TextView(this);
        textView.setText(text != null ? text : "N/A");
        textView.setPadding(8, 8, 8, 8);
        textView.setGravity(Gravity.CENTER);
        tableRow.addView(textView);
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
