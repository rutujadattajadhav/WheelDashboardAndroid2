package com.railway.wheeldashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.railway.wheeldashboard.breakdownhistory.BreakdownHistory;

public class BreakdownHistoryPagedAdapter extends PagingDataAdapter<BreakdownHistory, BreakdownHistoryPagedAdapter.ViewHolder> {
    public BreakdownHistoryPagedAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<BreakdownHistory> DIFF_CALLBACK = new DiffUtil.ItemCallback<BreakdownHistory>() {
        @Override
        public boolean areItemsTheSame(@NonNull BreakdownHistory oldItem, @NonNull BreakdownHistory newItem) {
            return oldItem.getId()==(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull BreakdownHistory oldItem, @NonNull BreakdownHistory newItem) {
            return false;
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_breakdown_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BreakdownHistory item = getItem(position);
        if (item != null) {
            holder.txtId.setText(String.valueOf(item.getId()));
            holder.txtVehicleNumber.setText(item.getPlantName());
            holder.txtBreakdownDate.setText(item.getToDate());
            holder.txtStatus.setText(item.getIssue()
            );
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtVehicleNumber, txtBreakdownDate, txtStatus;

        ViewHolder(View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtId);
            txtVehicleNumber = itemView.findViewById(R.id.txtVehicleNumber);
            txtBreakdownDate = itemView.findViewById(R.id.txtBreakdownDate);
            txtStatus = itemView.findViewById(R.id.txtStatus);
        }
    }
}
