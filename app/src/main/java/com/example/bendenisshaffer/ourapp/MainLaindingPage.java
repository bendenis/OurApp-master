package com.example.bendenisshaffer.ourapp;

import android.app.Activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bendenisshaffer.ourapp.datamodel.Space;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainLaindingPage extends AppCompatActivity implements View.OnClickListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */




    private ListView friendList;
    private FirebaseAuth mAuth;
    private TextView spaceName;

    private Button reportChore, claimSpace;

    private ArrayList<String> friends = new ArrayList<String>();
    LandingPageAdapter adapter;
    MainLaindingPage context;

             @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lainding_page);
        spaceName = findViewById(R.id.space_title);
        reportChore = findViewById(R.id.report_button);
        claimSpace = findViewById(R.id.claim_space);
        reportChore.setOnClickListener(this);
        claimSpace.setOnClickListener(this);
        /*mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);*/

        // Set up the drawer.
        /*mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));*/

        context = this;
        friendList = (ListView) findViewById(R.id.test);
        loadfriendList();






    }
    private void loadfriendList(){
        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference searchRef = db.getReference("Space");

        searchRef.child(mAuth.getCurrentUser().getUid().toString()).limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null) {
                    Toast.makeText(MainLaindingPage.this, "No Roommates", Toast.LENGTH_SHORT).show();
                } else {
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                        Toast.makeText(MainLaindingPage.this, "Roomates found Found. Card Name: " + snapshot.getValue(Space.class).name, Toast.LENGTH_SHORT).show();
                        Space space = snapshot.getValue(Space.class);
                        friends = space.roommateList;
                        adapter = new LandingPageAdapter(context, friends);
                        friendList.setAdapter(adapter);
                        spaceName.setText(space.name);


                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        if(view == reportChore) {

            Intent i = new Intent(context, ChoresActivity.class);
            context.startActivity(i);



        } else if (view == claimSpace) {

            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("title", "Claiming Space");
            intent.putExtra("description", "Claiming space because of points acquired");

            startActivity(intent);


        }
    }
}
