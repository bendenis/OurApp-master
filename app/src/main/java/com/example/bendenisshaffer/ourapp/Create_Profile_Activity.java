package com.example.bendenisshaffer.ourapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Create_Profile_Activity extends Activity implements View.OnClickListener {

    private Button back_button, next_button, facebook_button, google_button, linkedin_button;
    private EditText firtsname_input, lastname_input, email_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__profile_);

        back_button = (Button) findViewById(R.id.create_profile_back_button);
        next_button = (Button) findViewById(R.id.create_profile_next_button);

        firtsname_input = (EditText) findViewById(R.id.create_profile_firstname_field);
        lastname_input = (EditText) findViewById(R.id.create_profile_lastname_field);
        email_input = (EditText) findViewById(R.id.create_profile_email_field);

        back_button.setOnClickListener(this);
        next_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == back_button){
            Intent goBack = new Intent(this, MainActivity.class);
            this.startActivity(goBack);
        }else if(view == next_button){
            Intent goNext = new Intent(this, Create_LivingSpace_Activity.class);
            this.startActivity(goNext);
        }

    }
}
