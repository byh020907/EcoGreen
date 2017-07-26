package com.example.user.echogreen.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.user.echogreen.Adapter.ListViewAdapter;
import com.example.user.echogreen.Adapter.SubjectManageAdapter;
import com.example.user.echogreen.Data.Subject_item;
import com.example.user.echogreen.R;

import java.util.ArrayList;

/**
 * Created by user on 2017-07-27.
 */

public class SubjectManageActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_manage);

        ListView listView = (ListView) findViewById(R.id.listview);
        SubjectManageAdapter adapter = new SubjectManageAdapter();
        listView.setAdapter(adapter);

        ImageButton backwardButton = (ImageButton) findViewById (R.id.backwardButtonTimeTable);

        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScheduleActivity.class));
            }
        });
    }
}
