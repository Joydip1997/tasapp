package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.myapplication.adduser.addUserFragment;
import com.example.myapplication.show_Task.showTaskFragment;

public class MainActivity extends AppCompatActivity  {
    private FrameLayout frameLayout;
    private Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frameLayout = findViewById(R.id.frameLayout);
        button = findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new addUserFragment(),null).commit();
            }
        });
    }


}
