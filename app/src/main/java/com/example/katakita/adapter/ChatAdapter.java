package com.example.katakita.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.katakita.R;
import com.example.katakita.model.ChatItemModel;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private Context context;
    private List<ChatItemModel> chatList;

    public ChatAdapter(Context context, List<ChatItemModel> chatList) {
        this.context = context;
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatItemModel chat = chatList.get(position);
        holder.textName.setText(chat.getName());
        holder.textLastMessage.setText(chat.getLastMessage());
        holder.tvTime.setText(chat.getTime());
        // Load gambar dari URL
        // Gunakan Glide untuk load dari URL
        Glide.with(context)
                .load(chat.getProfileImageResId())
                .placeholder(R.drawable.ic_person) // placeholder jika loading
                .error(R.drawable.ic_error) // jika error
                .circleCrop()
                .into(holder.imageProfile);

        // Online status visibility and color
        if (chat.isOnline()) {
            holder.onlineStatus.setVisibility(View.VISIBLE);
        } else {
            holder.onlineStatus.setVisibility(View.GONE);
        }


        // Unread count visibility and text
        if (chat.getUnreadCount() > 0) {
            holder.unreadCount.setVisibility(View.VISIBLE);
            holder.unreadCount.setText(String.valueOf(chat.getUnreadCount()));
        } else {
            holder.unreadCount.setVisibility(View.GONE);
        }

    }


    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {

        ImageView imageProfile;
        TextView textName, textLastMessage, tvTime, unreadCount;
        View onlineStatus;


        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProfile = itemView.findViewById(R.id.imageProfile);
            textName = itemView.findViewById(R.id.textName);
            textLastMessage = itemView.findViewById(R.id.textLastMessage);
            tvTime = itemView.findViewById(R.id.tvTime);
            unreadCount = itemView.findViewById(R.id.unreadCount);
            onlineStatus = itemView.findViewById(R.id.onlineStatus);
        }
    }
}

