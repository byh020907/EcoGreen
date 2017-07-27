package com.example.user.echogreen.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.user.echogreen.Adapter.ScheduleAdapter;
import com.example.user.echogreen.R;
import com.example.user.echogreen.Splash;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Map<String, Boolean> params = new HashMap<String, Boolean>();
    static int cnt = 0;
    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aq = new AQuery(this);

        final ImageButton stateButton = (ImageButton) findViewById(R.id.button);
        Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        stateButton.setImageResource(R.drawable.on_button);

        startActivity(new Intent(this, Splash.class));

        stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt++;
                if(cnt% 2 == 0) {
                    stateButton.setImageResource(R.drawable.on_button);
                    String url = "";

                    setParams();

                    aq.ajax(url, params, JSONObject.class, new AjaxCallback<JSONObject>() {
                        @Override
                        public void callback(String url, JSONObject json, AjaxStatus status) {
                            if(json != null) {

                                Toast.makeText(aq.getContext(), status.getCode() + ":" + json.toString(), Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(aq.getContext(), "Error:" + status.getCode(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
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

    public void setParams() {
        ScheduleAdapter adapter = new ScheduleAdapter(this);
        String[] subjects = adapter.getSubjects();
        boolean result;

        for(int i = 0; i < subjects.length; i++) {
            result = false;
            if (subjects[i] == "체육" || subjects[i] == "미술") {
                result = true;
            }
            params.put(String.valueOf(i), result);
        }
    }
}
