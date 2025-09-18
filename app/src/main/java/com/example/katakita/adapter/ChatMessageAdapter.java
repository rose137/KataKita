package com.example.katakita.adapter;

import static com.example.katakita.model.MessageStatus.DELIVERED;
import static com.example.katakita.model.MessageStatus.SENT;
import static com.example.katakita.model.MessageStatus.READ;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.katakita.R;
import com.example.katakita.model.ChatMessageModel;

import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.MessageViewHolder> {

    private Context context;
    private List<ChatMessageModel> messageList;

    public ChatMessageAdapter(Context context, List<ChatMessageModel> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chat_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        ChatMessageModel message = messageList.get(position);
        holder.textMessage.setText(message.getMessage());
        holder.textTime.setText(message.getTime());

        // Set max width 70% dari layar
        int maxWidth = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.7);
        holder.textMessage.setMaxWidth(maxWidth);

        if (message.isSentByUser()) {
            holder.container.setGravity(Gravity.END);
            holder.textMessage.setBackgroundResource(R.drawable.bg_message_sent);
            holder.textMessage.setTextColor(0xFFFFFFFF);
        } else {
            holder.container.setGravity(Gravity.START);
            holder.textMessage.setBackgroundResource(R.drawable.bg_message_received);
            holder.textMessage.setTextColor(0xFF000000);
        }

        holder.textTime.setText(message.getTime());

        switch(message.getStatus()) {
            case SENT:
                holder.imgStatus.setImageResource(R.drawable.ic_single_check_gray);
                break;
            case DELIVERED:
                holder.imgStatus.setImageResource(R.drawable.ic_double_check_gray);
                break;
            case READ:
                holder.imgStatus.setImageResource(R.drawable.ic_double_check_blue);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView textMessage,textTime;
        LinearLayout container;
        ImageView imgStatus;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            container = (LinearLayout) itemView;
            textMessage = itemView.findViewById(R.id.textMessage);
            textTime = itemView.findViewById(R.id.textTime);
            imgStatus = itemView.findViewById(R.id.imageStatus);
        }
    }
}
