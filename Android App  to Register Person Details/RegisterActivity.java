package com.example.registerpersonapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class RegisterActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    AppCompatButton b1,b2;
    String getName,getEmail,getMobile,getUsername,getPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1=(EditText)findViewById(R.id.name);

        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.mobile);
        e4=(EditText)findViewById(R.id.username);
        e5=(EditText)findViewById(R.id.password);
        b1=(AppCompatButton)findViewById(R.id.register);
        b2=(AppCompatButton)findViewById(R.id.backtologin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=e1.getText().toString();
                getEmail=e2.getText().toString();
                getMobile=e3.getText().toString();
                getUsername=e4.getText().toString();
                getPassword=e5.getText().toString();
                Toast.makeText(getApplicationContext(),getName,Toast.LENGTH_LONG).show();
               Toast.makeText(getApplicationContext(),getEmail,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getMobile,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getUsername,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getPassword,Toast.LENGTH_LONG).show();
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

