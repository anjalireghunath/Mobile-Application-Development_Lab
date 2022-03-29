package com.example.registerpersonapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
    EditText e1,e2;
    AppCompatButton b1,b2;
    String getQualification,getInterest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.qualification);
        e2=(EditText)findViewById(R.id.interest);
        b1=(AppCompatButton)findViewById(R.id.submit);
        b2=(AppCompatButton)findViewById(R.id.logout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getQualification=e1.getText().toString();
                getInterest=e2.getText().toString();
         Toast.makeText(getApplicationContext(),getQualification,Toast.LENGTH_LONG).show();
             Toast.makeText(getApplicationContext(),getInterest,Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}

