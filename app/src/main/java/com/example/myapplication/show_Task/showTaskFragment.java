package com.example.myapplication.show_Task;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Database.Task;
import com.example.myapplication.Database.TaskDatabse;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;


public class showTaskFragment extends Fragment {


 private RecyclerView recyclerView;
 private List<Task> mList = new ArrayList<>();
 private Adapter mAdapter = new Adapter();
 private TaskDatabse myDatabase;

    public showTaskFragment() {
        // Required empty public constructor
    }


    public static showTaskFragment newInstance(String param1, String param2) {
        showTaskFragment fragment = new showTaskFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_task, container, false);

        if(getActivity() != null)
        myDatabase = Room.databaseBuilder(getActivity(),TaskDatabse.class,"task.db").allowMainThreadQueries().build();

        mList = myDatabase.myDao().getTask();

        mAdapter.setList(mList);

        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }


}
