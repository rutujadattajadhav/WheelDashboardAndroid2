package com.railway.wheeldashboard.machine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.railway.wheeldashboard.R;

public class MachineTableAdapter extends RecyclerView.Adapter<MachineTableAdapter.ViewHolder> {
    private List<Machine> machineList;

    public MachineTableAdapter(List<Machine> machineList) {
        this.machineList = machineList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.machine_table, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Machine item = machineList.get(position);
        holder.tv_id.setText(item.getId() != null ? String.valueOf(item.getId()) : "N/A");
        holder.tv_plantNo.setText(item.getPlantNo() != null ? String.valueOf(item.getPlantNo()) : "N/A");
        holder.tv_description.setText(item.getDescription() != null ? item.getDescription() : "N/A");
        holder.tv_make.setText(item.getMake() != null ? item.getMake() : "N/A");
        holder.tv_acquisitionDate.setText(item.getAcquisitionDate() != null ? item.getAcquisitionDate() : "N/A");
        holder.tv_capacity.setText(item.getCapacity() != null ? item.getCapacity() : "N/A");
    }

    @Override
    public int getItemCount() {
        return machineList.size();
    }

    public void updateData(List<Machine> newData) {
        machineList.clear();
        machineList.addAll(newData);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_plantNo, tv_description, tv_make, tv_acquisitionDate, tv_capacity;

        ViewHolder(View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.machineid);
            tv_plantNo = itemView.findViewById(R.id.tv_plantNo);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_make = itemView.findViewById(R.id.tv_make);
            tv_acquisitionDate = itemView.findViewById(R.id.tv_acquisitionDate);
            tv_capacity = itemView.findViewById(R.id.tv_capacity);
        }
    }
}
