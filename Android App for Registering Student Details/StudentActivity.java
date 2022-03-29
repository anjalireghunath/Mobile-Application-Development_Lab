package com.example.studlogactivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class StudActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    AppCompatButton b1,b2;
    String getAdd,getRoll,getDegree,getCollege,getId,getPass,getconform;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stud);
        ed1=(EditText) findViewById(R.id.adno);
        ed2=(EditText) findViewById(R.id.rono);
        ed3=(EditText) findViewById(R.id.deg);
        ed4=(EditText) findViewById(R.id.co);
        ed5=(EditText) findViewById(R.id.id);
        ed6=(EditText) findViewById(R.id.password);
        ed7=(EditText) findViewById(R.id.conpass);
        b1=(AppCompatButton) findViewById(R.id.reg);
        b2=(AppCompatButton) findViewById(R.id.blog);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAdd=ed1.getText().toString();
                getRoll=ed2.getText().toString();
                getDegree=ed3.getText().toString();
                getCollege=ed4.getText().toString();
                getId=ed5.getText().toString();
                getPass=ed6.getText().toString();
                getconform=ed7.getText().toString();

 Toast.makeText(getApplicationContext(),getAdd,Toast.LENGTH_SHORT).show();
Toast.makeText(getApplicationContext(),getRoll,Toast.LENGTH_SHORT).show();
Toast.makeText(getApplicationContext(),getDegree,Toast.LENGTH_SHORT).show();
Toast.makeText(getApplicationContext(),getCollege,Toast.LENGTH_SHORT).show();
Toast.makeText(getApplicationContext(),getId,Toast.LENGTH_SHORT).show();
      Toast.makeText(getApplicationContext(),getconform,Toast.LENGTH_SHORT).show();
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
