package com.example.katakita.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.katakita.R;
import com.example.katakita.Repository.CallRepository;
import com.example.katakita.adapter.CallsAdapter;
import com.example.katakita.model.CallModel;

import java.util.ArrayList;
import java.util.List;

public class CallsFragment extends Fragment {

    private RecyclerView recyclerView;
    private CallsAdapter adapter;


    public CallsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calls, container, false);

        recyclerView = view.findViewById(R.id.callsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<CallModel> dummyCalls = CallRepository.getDummyCalls();
        adapter = new CallsAdapter(dummyCalls);
        recyclerView.setAdapter(adapter);

        return view;
    }
}

