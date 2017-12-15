package com.example.bendenisshaffer.ourapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ReportChores extends Activity implements View.OnClickListener  {

    private Button buttonchoresubmit, buttonchorepageback;
    private CheckBox checkBoxtakeouttrash, checkBoxcleanthebathroom, checkBoxvacuum, checkBoxwashdishes,checkBoxshopsupply;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_chores);


        buttonchoresubmit = (Button) findViewById(R.id.buttonchoresubmit);
        buttonchorepageback = (Button) findViewById(R.id.buttonchorepageback);

        checkBoxtakeouttrash = (CheckBox) findViewById(R.id.checkBoxtakeouttrash);
        checkBoxcleanthebathroom = (CheckBox) findViewById(R.id.checkBoxcleanthebathroom);
        checkBoxvacuum = (CheckBox) findViewById(R.id.checkBoxvacuum);
        checkBoxwashdishes = (CheckBox) findViewById(R.id.checkBoxwashdishes);
        checkBoxshopsupply = (CheckBox) findViewById(R.id.checkBoxshopsupply);

        buttonchoresubmit.setOnClickListener(this);
        buttonchorepageback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == buttonchoresubmit){
           /* an overlay saying: Congrats! You've earned xx points! then homepage


            */
        }else if(view == buttonchorepageback){
            /* Authenticate and go to the homepage */
        }

    }
}
