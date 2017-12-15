package com.example.bendenisshaffer.ourapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bendenisshaffer.ourapp.datamodel.Space;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SpaceDefinitionActivity extends AppCompatActivity implements View.OnClickListener {

    ListView spaceList;
    //final String[] values = new String[] { "Kitchen", "Living Room" ,"Bathroom"};
    private ArrayList<String> friends = new ArrayList<String>();
    private final static int CONTACT_PICKER = 1;
    private EditText spaceName;
    private EditText txtNombreContacto;
    private EditText txtTelefono;
    private Button button, nextButton;
    //private TextView selectedContacts;
    private SpaceAdapter adapter;
    FirebaseDatabase db;
    DatabaseReference createRef;

    SpaceDefinitionActivity context;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_definition);

        context = this;

        spaceList = (ListView) findViewById(R.id.inventory_list);

        //friends.add("Sumanth");
        //friends.add("Rahul");

        adapter = new SpaceAdapter(this, friends);
        spaceList.setAdapter(adapter);

        spaceList.setOnItemClickListener(adapter);
        button = findViewById(R.id.roommate_add);
        nextButton = findViewById(R.id.next_button);
        spaceName = findViewById(R.id.space_name);
        //selectedContacts = findViewById(R.id.selected_contacts);
        button.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        //pickContact();
        db = FirebaseDatabase.getInstance();
        createRef = db.getReference("Space");
        mAuth = FirebaseAuth.getInstance();


    }

    public void pickContact()
    {
        Intent contactPickerIntent =
                new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(contactPickerIntent, CONTACT_PICKER);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // check whether the result is ok
        if (resultCode == RESULT_OK) {
            // Check for the request code, we might be using multiple startActivityForReslut
            switch (requestCode) {
                case CONTACT_PICKER:
                    contactPicked(data);
                    break;
            }
        } else {
            Log.e("MainActivity", "Failed to pick contact");
        }
    }
    private void contactPicked(Intent data) {
        ContentResolver cr = getContentResolver();
        Cursor cur;
        try {
            // getData() method will have the Content Uri of the selected contact
            Uri uri = data.getData();
            //Query the content uri
            cur = cr.query(uri, null, null, null, null);
            cur.moveToFirst();
            // column index of the contact ID
            String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
            // column index of the contact name
            String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            //selectedContacts.append(name + " \n");
            friends.add(name);

            adapter.notifyDataSetChanged();

            Log.v("akshay" ,"Contact selcted : " + name);
            //txtNombreContacto.setText(name);        //print data
            // column index of the phone number
            Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                    new String[]{id}, null);
            while (pCur.moveToNext()) {
                String phone = pCur.getString(
                        pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                //txtTelefono.setText(phone);         //print data
            }
            pCur.close();
            // column index of the email
            Cursor emailCur = cr.query(
                    ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                    new String[]{id}, null);
            while (emailCur.moveToNext()) {
                // This would allow you get several email addresses
                // if the email addresses were stored in an array
                String email = emailCur.getString(
                        emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS));
                //txtMailContacto.setText(email);         //print data
            }
            emailCur.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        if(view == button) {
            pickContact();
        }else if(view == nextButton) {

            Space space = new Space(spaceName.getText().toString(), friends);
            createRef.child(mAuth.getCurrentUser().getUid()).push().setValue(space);

            Intent i = new Intent(context, MainLaindingPage.class);
            context.startActivity(i);


        }
    }
}


