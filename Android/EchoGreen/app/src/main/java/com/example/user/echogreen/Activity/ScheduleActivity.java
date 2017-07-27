package com.example.user.echogreen.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.user.echogreen.R;
import com.example.user.echogreen.Adapter.ScheduleAdapter;

/**
 * Created by user on 2017-07-26.
 */

public class ScheduleActivity extends AppCompatActivity {
    GridView gridView;
    ScheduleAdapter scheduleAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table);

        ImageButton backwardButton = (ImageButton) findViewById(R.id.backwardButtonMain);
        Button editButton = (Button) findViewById(R.id.editSubjectButton);
//        Button manageButton = (Button) findViewById(R.id.manageSubjectButton);

        gridView=(GridView)findViewById(R.id.gridView);
        scheduleAdapter = new ScheduleAdapter(this);
        gridView.setAdapter(scheduleAdapter);

//        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
//        layoutParams.height = 50;
//        gridView.setLayoutParams(layoutParams);

//        manageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), SubjectManageActivity.class));
//            }
//        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScheduleEditActivity.class));
            }
        });

        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Dialog dialog = new Dialog(ScheduleActivity.this);
                dialog.setContentView(R.layout.modal);
            }
        });
    }
}
