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

        import com.example.user.echogreen.R;

        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.Arrays;

/**
 * Created by user on 2017-07-26.
 */

public class ListViewAdapter extends BaseAdapter{
//    private String[] subjects = {"체육", "문학", "DB", "NT", "한국사", "미술", "미적", "java"};
    private ArrayList<String> subjects = new ArrayList<>();

    public void setSubjects() {
        subjects.add("체육");
        subjects.add("문학");
        subjects.add("DB");
        subjects.add("NT");
        subjects.add("한국사");
        subjects.add("미술");
        subjects.add("JAVA");
        subjects.add("미적");
    }

    public ListViewAdapter() {
        setSubjects();
    }

    @Override
    public int getCount() {
        return subjects.size();
    }

    @Override
    public Object getItem(int position) {
        return subjects.get(position);
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

            TextView textView=view.findViewById(R.id.list_item);

            Switch switch_1=view.findViewById(R.id.subject_switch);

            textView.setGravity(Gravity.CENTER);
            switch_1.setGravity(Gravity.CENTER);
            switch_1.setChecked(true);
            textView.setText(subjects.get(position));
        }

        return view;
    }
}
