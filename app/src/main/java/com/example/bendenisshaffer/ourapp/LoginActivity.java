package com.example.bendenisshaffer.ourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by aksha on 12/14/2017.
 */

public class LoginActivity  extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogin, buttonRegister;
    private FirebaseAuth mAuth;
    private EditText editTextEMail, editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editTextEMail = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        buttonRegister = findViewById(R.id.register_button);
        buttonLogin = findViewById(R.id.login_button);

        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();



    }

    @Override
    public void onClick(View view) {

        if (view == buttonLogin) {
            signIn(editTextEMail.getText().toString(), editTextPassword.getText().toString());
        } else if (view == buttonRegister) {
            registerAccount(editTextEMail.getText().toString(), editTextPassword.getText().toString());
        }

    }

    public void registerAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Register Denied", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            gotoHome();
                        } else {
                            Toast.makeText(LoginActivity.this, "Login Denied", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void gotoHome() {
        Intent intenHome = new Intent(this, SpaceDefinitionActivity.class);
        this.startActivity(intenHome);
    }

}
