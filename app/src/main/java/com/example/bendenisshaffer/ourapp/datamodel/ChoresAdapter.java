package com.example.bendenisshaffer.ourapp.datamodel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bendenisshaffer.ourapp.R;

import java.util.ArrayList;

/**
 * Created by aksha on 12/14/2017.
 */

public class ChoresAdapter extends ArrayAdapter<String> implements AdapterView.OnItemClickListener {
    private final Context context;
    private final ArrayList<String> values;


    public ChoresAdapter(Context context, ArrayList<String> values) {

        super(context, -1, values);
        this.context = context;
        this.values = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout_chores, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values.get(position));


        return rowView;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        Log.v("akshay" , "click listener triggered");

    }
}
