package com.example.myapplication.adduser;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.Database.Task;
import com.example.myapplication.Database.TaskDatabse;
import com.example.myapplication.R;
import com.example.myapplication.show_Task.showTaskFragment;

import java.util.Calendar;


public class addUserFragment extends Fragment  {

private EditText e1,e2;
private Button b1,b2;
private TextView t1;
private int hour=0,min=0;
private TaskDatabse mydatabase;
private Task task = new Task();




    public addUserFragment() {

    }


    public static addUserFragment newInstance(String param1, String param2) {
        addUserFragment fragment = new addUserFragment();
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

        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        setUpUI(view);

        mydatabase = Room.databaseBuilder(getActivity(),TaskDatabse.class,"task.db").allowMainThreadQueries().build();


        final Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                final Calendar c = Calendar.getInstance();
                final int mHour = c.get(Calendar.HOUR_OF_DAY);
                final int mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        hour = i;
                        min=i1;
                        t1.setText("Alarm At " + i + " : " + i1);
                    }
                },Calendar.HOUR_OF_DAY,Calendar.MINUTE,true);
                timePickerDialog.show();
            }
        },5000);





    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty())
            {
                task.setTask_name(e1.getText().toString());
                task.setTask_desc(e2.getText().toString());
                task.setHour(hour);
                task.setMin(min);
                mydatabase.myDao().addTask(task);
                Toast.makeText(getActivity(), "Task Added", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().remove(addUserFragment.this).commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new showTaskFragment(),null).commit();
            }

        }
    });


        return view;

    }

    private void setUpUI(View view)
    {
        e1 = view.findViewById(R.id.taskNameView);
        e2 = view.findViewById(R.id.taskDescriptionView);
        b1 = view.findViewById(R.id.Add);
        b2 = view.findViewById(R.id.Cancel);
        t1 = view.findViewById(R.id.dateTimeView);
    }



}
