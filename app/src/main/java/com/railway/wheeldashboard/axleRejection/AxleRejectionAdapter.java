package com.railway.wheeldashboard.axleRejection;
import com.railway.wheeldashboard.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AxleRejectionAdapter extends RecyclerView.Adapter<AxleRejectionAdapter.ViewHolder> {
    private List<AxleRejectionModel> tableData;
    private int totalPages;

    public AxleRejectionAdapter(List<AxleRejectionModel> tableData) {
        this.tableData = tableData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AxleRejectionModel item = tableData.get(position);
        holder.id.setText(item.getId() !=null ? String.valueOf(item.getId()):"N/A");
        holder.axleNo.setText(item.getAxleNo() != null ? String.valueOf(item.getAxleNo()): "N/A");
        holder.yearOfMfg.setText(item.getYearOfMfg() != null ? String.valueOf(item.getYearOfMfg()) : "N/A");
        holder.reasonOfRejectionAxle.setText(item.getReasonOfRejectionAxle() !=null ? String.valueOf(item.getReasonOfRejectionAxle()):"N/A1");
    }

    @Override
    public int getItemCount() {
        return this.tableData.size();
    }

    public void updateData(List<AxleRejectionModel> newData) {
        tableData.clear();
        tableData.addAll(newData);
        notifyDataSetChanged();

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, axleNo, yearOfMfg,reasonOfRejectionAxle;
        SearchView searchView ;

        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.column11);
            axleNo = itemView.findViewById(R.id.column12);
            yearOfMfg = itemView.findViewById(R.id.column13);
            reasonOfRejectionAxle=itemView.findViewById(R.id.column14);

        }
    }
}
