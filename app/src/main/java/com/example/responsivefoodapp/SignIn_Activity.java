package com.example.responsivefoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn_Activity extends AppCompatActivity {
    TextView tvsignup;
    Button btnsignin2;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);

        getSupportActionBar().setTitle("SIGN IN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvsignup = findViewById(R.id.tvsignup);
        btnsignin2 = findViewById(R.id.btnsignin2);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignIn_Activity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        btnsignin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateEmail() | !validatePassword()){
                    return;
                }
//                if(TextUtils.isEmpty(et1.getText()) ){
//                    et1.setError("Enter Value");
//                    et1.requestFocus();
//                }else{
//                    String s1 = et1.getText().toString();
//                    et1.setText(s1);
//                }

                Intent intent = new Intent(SignIn_Activity.this, MainInfoScreen.class);
                startActivity(intent);
            }
        });

    }
    private boolean validateEmail() {
        String val = et1.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
        if(val.isEmpty()){
            et1.setError("Field cannot be empty");
            return false;

        }else if(!val.matches(checkEmail)){
            et1.setError("Invalid Email");
            return false;
        }
        else{
            et1.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String val = et2.getText().toString().trim();
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
            et2.setError("Field cannot be empty");
            return false;

        }
//        else if(!val.matches(checkPassword)){
//            et2.setError("Password should contain 4 characters");
//            return false;
//        }
        else{
            et2.setError(null);
            return true;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}