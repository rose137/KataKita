package com.example.katakita.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.katakita.R;
import com.example.katakita.Repository.StatusRepository;
import com.example.katakita.adapter.StatusAdapter;
import com.example.katakita.model.UserStatusModel;

import java.util.List;

public class StatusFragment extends Fragment implements StatusAdapter.OnStatusClickListener {

    private RecyclerView recyclerView;
    private StatusAdapter statusAdapter;
    private List<UserStatusModel> statusList;

    public StatusFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        recyclerView = view.findViewById(R.id.statusRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Ambil data status dari repository
        statusList = StatusRepository.getAllStatuses();

        // Setup adapter dengan listener (this)
        statusAdapter = new StatusAdapter(statusList, this);

        recyclerView.setAdapter(statusAdapter);

        return view;
    }

    // ✅ Method dari interface StatusAdapter.OnStatusClickListener
    @Override
    public void onStatusClick(int position) {
        Intent intent = new Intent(getContext(), StatusViewerActivity.class);
        intent.putExtra("userIndex", position);
        startActivity(intent);
    }
}
