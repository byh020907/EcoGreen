package com.example.user.echogreen.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.user.echogreen.R;
import com.example.user.echogreen.Splash;

public class MainActivity extends AppCompatActivity {

    static int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton stateButton = (ImageButton) findViewById(R.id.button);
        Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        stateButton.setImageResource(R.drawable.on_button);

        startActivity(new Intent(this, SubjectManageActivity.class));
//        startActivity(new Intent(this, Splash.class));

        stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt++;
                if(cnt% 2 == 0) {
                    stateButton.setImageResource(R.drawable.on_button);
                }
                else {
                    stateButton.setImageResource(R.drawable.off_button);
                }
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScheduleActivity.class));
            }
        });
    }
}
