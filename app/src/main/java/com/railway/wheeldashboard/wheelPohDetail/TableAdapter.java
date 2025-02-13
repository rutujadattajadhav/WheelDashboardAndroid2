package com.railway.wheeldashboard.wheelPohDetail;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.railway.wheeldashboard.R;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {
    private List<WheelPoh> tableData;

    public TableAdapter(List<WheelPoh> tableData) {
        this.tableData = tableData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wheel_poh_table, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WheelPoh item = tableData.get(position);

        holder.id.setText(item.getId() != null ? String.valueOf(item.getId()) : "N/A");
        holder.date.setText(item.getDate() != null ? item.getDate() : "N/A");
        holder.wheelNo.setText(item.getWheelNo() != null ? item.getWheelNo() : "N/A");
        holder.wheelType.setText(item.getWheelType() != null ? item.getWheelType() : "N/A");
        holder.treadDia.setText(item.getTreadDia() != null ? String.valueOf(item.getTreadDia()) : "N/A");
        holder.flange.setText(item.getFlange() != null ? String.valueOf(item.getFlange()) : "N/A");
        holder.journalDiaA.setText(item.getJournalDiaA() != null ? String.valueOf(item.getJournalDiaA()) : "N/A");
        holder.snpdBearingA.setText(item.getSnpdBearingA() != null ? item.getSnpdBearingA() : "N/A");
        holder.bearingMake.setText(item.getBearingMake() != null ? item.getBearingMake() : "N/A");
        holder.shrinkingA.setText(item.getShrinkingA() != null ? String.valueOf(item.getShrinkingA()) : "N/A");
        holder.journalDiaB.setText(item.getJournalDiaB() != null ? String.valueOf(item.getJournalDiaB()) : "N/A");
        holder.snpdBearingB.setText(item.getSnpdBearingB() != null ? item.getSnpdBearingB() : "N/A");
        holder.shrinkingB.setText(item.getShrinkingB() != null ? String.valueOf(item.getShrinkingB()) : "N/A");
        holder.ust.setText(item.getUst() != null ? item.getUst() : "N/A");
        holder.bearing.setText(item.getBearing() != null ? item.getBearing() : "N/A");
    }

    @Override
    public int getItemCount() {
        return tableData.size();
    }

    public void updateData(List<WheelPoh> newData) {
        tableData.clear();
        tableData.addAll(newData);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, date, wheelNo, wheelType, treadDia, flange, journalDiaA, snpdBearingA,
                bearingMake, shrinkingA, journalDiaB, snpdBearingB, shrinkingB, ust, bearing;

        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            date = itemView.findViewById(R.id.tv_date);
            wheelNo = itemView.findViewById(R.id.tv_wheelNo);
            wheelType = itemView.findViewById(R.id.tv_wheelType);
            treadDia = itemView.findViewById(R.id.tv_treadDia);
            flange = itemView.findViewById(R.id.tv_flange);
            journalDiaA = itemView.findViewById(R.id.tv_journalDiaA);
            snpdBearingA = itemView.findViewById(R.id.tv_snpdBearingA);
            bearingMake = itemView.findViewById(R.id.tv_bearingMake);
            shrinkingA = itemView.findViewById(R.id.tv_shrinkingA);
            journalDiaB = itemView.findViewById(R.id.tv_journalDiaB);
            snpdBearingB = itemView.findViewById(R.id.tv_snpdBearingB);
            shrinkingB = itemView.findViewById(R.id.tv_shrinkingB);
            ust = itemView.findViewById(R.id.tv_ust);
            bearing = itemView.findViewById(R.id.tv_bearing);
        }
    }
}
