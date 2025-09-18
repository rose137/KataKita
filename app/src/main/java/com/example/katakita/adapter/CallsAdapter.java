package com.example.katakita.adapter;


import static java.security.AccessController.getContext;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.katakita.R;
import com.example.katakita.model.CallModel;

import java.util.ArrayList;
import java.util.List;

public class CallsAdapter extends RecyclerView.Adapter<CallsAdapter.CallViewHolder> {

    private List<CallModel> callList;



    public CallsAdapter(List<CallModel> callList) {
        this.callList = callList;
    }

    @NonNull
    @Override
    public CallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_call, parent, false);
        return new CallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallViewHolder holder, int position) {
        CallModel model = callList.get(position);
        holder.tvName.setText(model.getName());
        holder.tvTime.setText(model.getTime());
//        holder.imageCallType.setImageResource(model.isVideo() ? R.drawable.ic_video_call : R.drawable.ic_call);

        // Load gambar profil dari URL
        Glide.with(holder.itemView.getContext())
                .load(model.getImageUrl())
                .placeholder(R.drawable.ic_person) // fallback sementara loading
                .circleCrop()
                .into(holder.imageProfile);


        // Set ikon video / audio
        int iconRes = model.isVideo() ? R.drawable.ic_video_call : R.drawable.ic_call;
        holder.imageCallType.setImageResource(iconRes);

        // Ganti warna jika missed
        int tintColor = model.isMissed()
                ? Color.RED        // ❌ Missed Call → Merah
                : Color.parseColor("#2196F3"); // ✅ Terjawab → Biru
        holder.imageCallType.setColorFilter(tintColor);
    }

    @Override
    public int getItemCount() {
        return callList.size();
    }

    public static class CallViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTime;
        ImageView imageCallType;
        ImageView imageProfile;


        public CallViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTime = itemView.findViewById(R.id.tvTime);
            imageCallType = itemView.findViewById(R.id.imageCallType);
            imageProfile = itemView.findViewById(R.id.imageProfile);
        }
    }
}
