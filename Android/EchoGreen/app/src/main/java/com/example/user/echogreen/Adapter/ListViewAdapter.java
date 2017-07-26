package com.example.user.echogreen.Adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.echogreen.R;

import java.util.ArrayList;

/**
 * Created by user on 2017-07-26.
 */

public class ListViewAdapter extends BaseAdapter{
    private ArrayList arrayList = new ArrayList();
    private String[] subject = {"체육", "문학", "DB", "NT", "한국사", "미술", "미적", "java"};

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parents) {
        final Context context = parents.getContext();

        View v = null;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item, parents, false);

            v = new TextView(context);
            ((TextView)v).setGravity(Gravity.CENTER);
            ((TextView)v).setText(subject[position]);
        }

        return view;
    }
}
