package com.example.bendenisshaffer.ourapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ClaimSpace extends Activity implements Button.OnClickListener {

    private Button buttonCS1;
    private Button buttonCS2;
    private TextView textViewCS1;
    private TextView textViewCS2;
    private TextView textViewCS3;
    private TextView textViewCS4;
    private TextView textViewCS5;
    private TextView textViewCS6;
    private TextView textViewCS7;
    private RadioButton radioButtonCS1;
    private RadioButton radioButtonCS2;
    private RadioButton radioButtonCS3;
    private EditText editTextCS1;
    private EditText editTextCS2;
    private EditText editTextCS3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_space);

        buttonCS1 = (Button) findViewById(R.id.buttonCS1);
        buttonCS2 = (Button) findViewById(R.id.buttonCS2);

        textViewCS1 = (TextView) findViewById(R.id.textViewCS1);
        textViewCS2 = (TextView) findViewById(R.id.textViewCS2);
        textViewCS3 = (TextView) findViewById(R.id.textViewCS3);
        textViewCS4 = (TextView) findViewById(R.id.textViewCS4);
        textViewCS6 = (TextView) findViewById(R.id.textViewCS6);

        radioButtonCS1 = (RadioButton) findViewById(R.id.radioButtonCS1);
        radioButtonCS2 = (RadioButton) findViewById(R.id.radioButtonCS2);
        radioButtonCS3 = (RadioButton) findViewById(R.id.radioButtonCS3);

        editTextCS1 = (EditText) findViewById(R.id.editTextCS1);
        editTextCS2 = (EditText) findViewById(R.id.editTextCS2);
        editTextCS3 = (EditText) findViewById(R.id.editTextCS3);

        buttonCS1.setOnClickListener(this);
        buttonCS2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
