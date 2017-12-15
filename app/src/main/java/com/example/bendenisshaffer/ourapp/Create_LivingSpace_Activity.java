package com.example.bendenisshaffer.ourapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Create_LivingSpace_Activity extends Activity implements View.OnClickListener {

    private Button back_button, next_button;
    private EditText shared_space_name;
    private ListView shared_spaces_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__living_space_);

        back_button = (Button) findViewById(R.id.create_living_space_back_button);
        next_button = (Button) findViewById(R.id.create_living_space_next_button);

        shared_space_name = (EditText) findViewById(R.id.create_living_space_name_field);

        back_button.setOnClickListener(this);
        next_button.setOnClickListener(this);

        shared_spaces_list = (ListView) findViewById(R.id.shared_spaces_list);


    }

    @Override
    public void onClick(View view) {

        if(view == back_button){
            Intent goBack = new Intent(this,Create_Profile_Activity.class);
            this.startActivity(goBack);
        }else if(view == next_button){
            /* Go to the add chores activity  */
        }

    }
}
