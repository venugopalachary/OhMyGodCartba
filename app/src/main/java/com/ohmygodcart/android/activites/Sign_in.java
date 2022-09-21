package com.ohmygodcart.android.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ohmygodcart.android.R;

public class Sign_in extends AppCompatActivity {

    EditText EmailAddress,Password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        // hide the title bar name
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        EmailAddress=findViewById(R.id.EmailAddress);
        Password=findViewById(R.id.Password);

    }

    public void signIn (View view)
    {

        String userEmail=EmailAddress.getText().toString();
        String userPassword=Password.getText().toString();



        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this,"Enter Email !",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this,"Enter Password !",Toast.LENGTH_SHORT).show();
            return;
        }

        if(userPassword.length()<6)
        {
            Toast.makeText(this,"Password too short ,enter minimum 6 characters! ",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                  //  Toast.makeText(Sign_in.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Sign_in.this,MainActivity.class));
                }else {
                    Toast.makeText(Sign_in.this, "Error" + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }



}