package com.example.bendenisshaffer.ourapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailedView extends Activity implements OnClickListener {

    private Button activity_detailed_view_back;
    private TextView indvActivity, totalPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        activity_detailed_view_back = (Button) findViewById(R.id.activity_detailed_view_back);

        indvActivity = (TextView) findViewById(R.id.indvActivity);
        totalPoints = (TextView) findViewById(R.id.totalPoints);

        activity_detailed_view_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        /* Add Intent for Back Button */
    }
}
