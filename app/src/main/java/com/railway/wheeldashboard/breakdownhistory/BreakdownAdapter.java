package com.railway.wheeldashboard.breakdownhistory;


import com.railway.wheeldashboard.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BreakdownAdapter extends RecyclerView.Adapter<BreakdownAdapter.ViewHolder> {
    private List<BreakdownHistory> tableData;

    public BreakdownAdapter(List<BreakdownHistory> tableData) {
        this.tableData = tableData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breakdown_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BreakdownHistory item = tableData.get(position);

        holder.id.setText(item.getId() != null ? String.valueOf(item.getId()) : "N/A");
        holder.serialNumber.setText(item.getSerialNumber() != null ? String.valueOf(item.getSerialNumber()) : "N/A");
        holder.plantName.setText(item.getPlantName() != null ? item.getPlantName() : "N/A");
        holder.issue.setText(item.getIssue() != null ? item.getIssue() : "N/A");
        holder.noOfDays.setText(item.getNoOfDays() != null ? String.valueOf(item.getNoOfDays()) : "N/A");
        holder.fromDate.setText(item.getFromDate() != null ? item.getFromDate() : "N/A");
        holder.toDate.setText(item.getToDate() != null ? item.getToDate() : "N/A");
    }

    @Override
    public int getItemCount() {
        return this.tableData.size();
    }

    public void updateData(List<BreakdownHistory> newData) {
        tableData.clear();
        tableData.addAll(newData);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, serialNumber, plantName, issue, noOfDays, fromDate, toDate;

        ViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.column11);
            serialNumber = itemView.findViewById(R.id.column13);
            plantName = itemView.findViewById(R.id.column12);
            issue = itemView.findViewById(R.id.column14);
            noOfDays = itemView.findViewById(R.id.column15);
            fromDate = itemView.findViewById(R.id.column16);
            toDate = itemView.findViewById(R.id.column17);
        }
    }
}
