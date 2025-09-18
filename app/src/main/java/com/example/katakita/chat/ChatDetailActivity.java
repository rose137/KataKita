package com.example.katakita.chat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.katakita.R;
import com.example.katakita.Repository.ChatRepository;
import com.example.katakita.adapter.ChatMessageAdapter;
import com.example.katakita.model.ChatMessageModel;

import java.util.ArrayList;
import java.util.List;

public class ChatDetailActivity extends AppCompatActivity {
    private TextView textTitle;
    private ImageView imageProfile;
    private RecyclerView recyclerView;
    private ChatMessageAdapter adapter;
    private List<ChatMessageModel> messageList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        recyclerView = findViewById(R.id.recyclerViewMessages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        textTitle = findViewById(R.id.chatDetailName);
        imageProfile = findViewById(R.id.chatDetailImage);


        // Ambil data dari Intent
        String name = getIntent().getStringExtra("name");
        String profileImage = getIntent().getStringExtra("profileImage");
        textTitle.setText(name);
        Glide.with(this)
                .load(profileImage)
                .placeholder(R.drawable.ic_person)
                .error(R.drawable.ic_error)
                .circleCrop()
                .into(imageProfile);


        // Data dummy chat messages
        messageList = ChatRepository.getMessagesByUserName(name);

        adapter = new ChatMessageAdapter(this, messageList);
        recyclerView.setAdapter(adapter);
    }

}