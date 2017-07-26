package com.example.user.echogreen.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.example.user.echogreen.Activity.SubjectManageActivity;
import com.example.user.echogreen.Data.Subject_item;
import com.example.user.echogreen.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.security.auth.Subject;

/**
 * Created by user on 2017-07-27.
 */

public class SubjectManageAdapter extends  BaseAdapter{

    ArrayList<Subject_item> subject_items = new ArrayList<>();
    private ArrayList<String> subjects = new ArrayList<>();

    public SubjectManageAdapter() {
        setArray();
    }

    public void setArray() {
        subjects.add("체육");
        subjects.add("문학");
        subjects.add("DB");
        subjects.add("NT");
        subjects.add("한국사");
        subjects.add("미술");
        subjects.add("JAVA");
        subjects.add("미적");
    }

    @Override
    public int getCount() {
        return subject_items.size();
    }

    @Override
    public Object getItem(int position) {
        return subject_items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parents) {
        Context context = parents.getContext();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.manage_subject_item, parents, false);

            TextView subject = (TextView) view.findViewById(R.id.subject);
            Switch sw=(Switch) view.findViewById(R.id.subject_switch);

            new Subject_item(sw, subjects.get(position));
        }

        return null;
    }
}
