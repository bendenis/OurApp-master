package com.example.bendenisshaffer.ourapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button login_button, signup_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_button = (Button) findViewById(R.id.main_login_button);
        signup_button = (Button) findViewById(R.id.main_signup_button);

        login_button.setOnClickListener(this);
        signup_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == signup_button){
            Intent goToCreateProfile = new Intent(this, Create_Profile_Activity.class);
            this.startActivity(goToCreateProfile);
        }else if(view == login_button){
            /* Authenticate and go to the dashboard */
        }

    }
}
