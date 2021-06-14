package com.example.responsivefoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    TextView tvlogin;
    Button btnsignin;
    EditText username, phone, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("SIGN UP");
        tvlogin = findViewById(R.id.tvlogin);
        btnsignin = findViewById(R.id.btnsignin);
        username = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignIn_Activity.class);
                startActivity(intent);
            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUser() | !validateEmail() | !validatePhoneNumber() | !validatePassword()){
                    return;
                }
                Toast.makeText(SignUpActivity.this, "Account has been created successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, SignIn_Activity.class);
                startActivity(intent);
            }
        });


    }
    private boolean validateUser(){
        String val  = username.getText().toString().trim();
        String checkspaces =  "Aw{1,20}z";
        if(val.isEmpty()){
            username.setError("Field can not be empty");
            return false;
        }else if(val.length()>20){
            username.setError("Username is too long");
            return false;
        }
//        else if(!val.matches(checkspaces)){
//            username.setError("No white spaces are allowed");
//            return false;
//        }
        else {
            username.setError(null);
            return true;

        }
    }
    private boolean validatePhoneNumber() {
        String val = phone.getText().toString().trim();
       // String checkspaces = "Aw{1,20}z";
        if (val.isEmpty()) {
            phone.setError("Enter valid phone number");
            return false;
        }
//        else if (!val.matches(checkspaces)) {
//            phone.setError("No White spaces are allowed!");
//            return false;
 //       }
        else {
            phone.setError(null);
            return true;
        }
    }
    private boolean validateEmail() {
        String val = email.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
        if(val.isEmpty()){
            email.setError("Field cannot be empty");
            return false;

        }else if(!val.matches(checkEmail)){
            email.setError("Invalid Email");
            return false;
        }
        else{
            email.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String val = password.getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if(val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;

        }
//        else if(!val.matches(checkPassword)){
//            et2.setError("Password should contain 4 characters");
//            return false;
//        }
        else{
            password.setError(null);
            return true;
        }
    }
}