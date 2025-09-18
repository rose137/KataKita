package com.example.katakita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.katakita.R;
//import com.example.katakita.model.StatusItemModel;
import com.example.katakita.model.StatusContentModel;
import com.example.katakita.model.UserStatusModel;
import com.example.katakita.utils.Utils;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {

    private List<UserStatusModel> statusList;
    private OnStatusClickListener listener;

    public interface OnStatusClickListener {
        void onStatusClick(int position);
    }

    public StatusAdapter(List<UserStatusModel> statusList, OnStatusClickListener listener) {
        this.statusList = statusList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_status, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusAdapter.ViewHolder holder, int position) {
        UserStatusModel item = statusList.get(position);
        holder.name.setText(item.getUserName());
        List<StatusContentModel> statusList = item.getStatusList();

        if (!statusList.isEmpty()) {
            // Ambil status terakhir untuk preview
            StatusContentModel lastStatus = statusList.get(statusList.size() - 1);

            // Tampilkan waktu
            holder.time.setText(Utils.formatTime(lastStatus.getTimestamp()));

            // Load image dari URL status terakhir
            Glide.with(holder.itemView.getContext())
                    .load(lastStatus.getImageUrl())
                    .into(holder.image);
        }

        // Jika image dari URL (gunakan salah satu)
        /*
        Glide.with(holder.itemView.getContext())
                .load(item.getImageUrl()) // jika ada getImageUrl()
                .into(holder.image);
        */

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onStatusClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, time;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.status_name);
            time = itemView.findViewById(R.id.status_time);
            image = itemView.findViewById(R.id.status_image);
        }
    }
}
