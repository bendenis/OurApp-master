package com.example.bendenisshaffer.ourapp;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.bendenisshaffer.ourapp.datamodel.ChoresAdapter;

import java.util.ArrayList;

public class ChoresActivity extends AppCompatActivity {


    //final String[] values = new String[] { "Clean Kitchen", "Take out Trash" ,"Clean Bathroom"};
    private ArrayList<String> chores = new ArrayList<String>();


    ListView choresList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chores);
        chores.add("Clean Bathroom");
        chores.add("Take out Trash");
        chores.add("Buy Groceries");
        chores.add("Clean common areas");

        choresList = (ListView) findViewById(R.id.chores_list);
        ChoresAdapter adapter = new ChoresAdapter(this, chores);
        choresList.setAdapter(adapter);

    }

}
