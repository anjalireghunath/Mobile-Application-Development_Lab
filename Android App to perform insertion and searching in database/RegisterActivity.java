package com.example.enquiryperson;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5;
AppCompatButton b1,b2;
String getName,getPerson,getEmail,getMobile,getPlace;
DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.person);
        ed3=(EditText) findViewById(R.id.Email);

        ed4=(EditText) findViewById(R.id.mobno);
        ed5=(EditText) findViewById(R.id.Place);
        b1=(AppCompatButton)findViewById(R.id.submit);
        b2=(AppCompatButton)findViewById(R.id.board);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=ed1.getText().toString();
                getPerson=ed2.getText().toString();
                getEmail=ed3.getText().toString();
                getMobile=ed4.getText().toString();
                getPlace=ed5.getText().toString();
boolean result=dbhelper.InsertData(getName,getPerson,getEmail,getMobile,getPlace);
if(result==true)
{
    ed1.setText("");
    ed2.setText("");
    ed3.setText("");
    ed4.setText("");
    ed5.setText("");
    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
}
else
{
          Toast.makeText(getApplicationContext(), "Insertion Failed!!",                Toast.LENGTH_SHORT).show();
}
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
