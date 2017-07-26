package com.example.user.echogreen.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by user on 2017-07-26.
 */

public class ScheduleAdapter extends BaseAdapter {
    Context context;
    int count = 40;
    String[] week = {"M", "T", "W", "T", "F"};
    String[] subjects = new String[35];

    public ScheduleAdapter(Context context) {
        this.context = context;
        setArray();
    }

    public void setArray() {
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = "hell";
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = null;

        if(position > count) {}

        if(view == null) {
            v = new TextView(context);
        }

        else if (position < 5) {
            v = new TextView(context);
            ((TextView)v).setGravity(Gravity.CENTER);
            ((TextView)v).setText(week[position]);
        }

        else if (position >= 5) {
            v = new TextView(context);

            ((TextView)v).setGravity(Gravity.CENTER);
            ((TextView)v).setText(subjects[position - 5]);
        }

        return v;
    }

    public void editItem(String item, int editPosition) {
        subjects[editPosition - 5] = item;
    }
}
