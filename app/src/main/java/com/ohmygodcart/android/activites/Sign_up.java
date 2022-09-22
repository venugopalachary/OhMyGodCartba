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

public class Sign_up extends AppCompatActivity {

    EditText fullname,phonenumber,EmailAddress,Password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // hide the title bar name
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

       if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(Sign_up.this,MainActivity.class));
            finish();
        }

        fullname=findViewById(R.id.fullname);
        phonenumber=findViewById(R.id.phonenumber);
        EmailAddress=findViewById(R.id.EmailAddress);
        Password=findViewById(R.id.Password);


    }


    public void signup (View view)
    {
        String userName=fullname.getText().toString();
        String userPhoneNumber=phonenumber.getText().toString();
        String userEmail=EmailAddress.getText().toString();
        String userPassword=Password.getText().toString();

        if(TextUtils.isEmpty(userName)){
            Toast.makeText(this,"Enter Name !",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userPhoneNumber)){
            Toast.makeText(this,"Enter Phonenumber !",Toast.LENGTH_SHORT).show();
            return;
        }

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
    mAuth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(Sign_up.this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){
                Toast.makeText(Sign_up.this,"Successfully Register",Toast.LENGTH_SHORT);
                startActivity(new Intent(Sign_up.this,MainActivity.class));
            }
            else{
                Toast.makeText(Sign_up.this,"Registration Failed"+task.getException(),Toast.LENGTH_SHORT);
            }
        }
    });

        startActivity(new Intent(Sign_up.this,MainActivity.class));
    }

    public void signin (View view)
    {
        startActivity(new Intent(Sign_up.this,Sign_in.class));
    }
}