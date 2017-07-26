package com.example.user.echogreen.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.app.Dialog;
import android.widget.ListView;

import com.example.user.echogreen.Adapter.ListViewAdapter;
import com.example.user.echogreen.R;
import com.example.user.echogreen.Adapter.ScheduleAdapter;

import java.util.List;

/**
 * Created by user on 2017-07-26.
 */

public class ScheduleEditActivity extends AppCompatActivity {
    GridView gridView;
    ScheduleAdapter scheduleAdapter;
    String subject;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_time_table);

        ImageButton backwardButton = (ImageButton) findViewById(R.id.backwardButtonTimeTable2);
        Button confirmButton = (Button) findViewById(R.id.confirm);

        scheduleAdapter = new ScheduleAdapter(this);

        gridView=(GridView)findViewById(R.id.edit_gridView);
        scheduleAdapter = new ScheduleAdapter(this);
        gridView.setAdapter(scheduleAdapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                scheduleAdapter.notifyDataSetChanged();
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
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                final ListViewAdapter adapter = new ListViewAdapter();
                final Dialog dialog = new Dialog(ScheduleEditActivity.this);
                dialog.setContentView(R.layout.modal);

                ListView listView = dialog.findViewById(R.id.listview);
                listView.setAdapter(adapter);

                dialog.findViewById(R.id.exitButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        ListViewAdapter listViewAdapter = new ListViewAdapter();

                        subject = (String) listViewAdapter.getItem(position);

                        scheduleAdapter.editItem(subject, i);
                        scheduleAdapter.notifyDataSetChanged();

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}
