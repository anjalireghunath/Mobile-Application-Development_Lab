package com.example.enquiryperson;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class SearchActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5;
    AppCompatButton b1,b2;
    String getPerson,getName,getEmail,getMobile,getPlace;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        helper=new DatabaseHelper(this);
        helper.getWritableDatabase();
        ed1=(EditText) findViewById(R.id.person);
        ed2=(EditText) findViewById(R.id.name);
        ed3=(EditText) findViewById(R.id.email);
        ed4=(EditText) findViewById(R.id.number);
        ed5=(EditText) findViewById(R.id.place);
        b1=(AppCompatButton) findViewById(R.id.search);
        b2=(AppCompatButton) findViewById(R.id.menu);
       b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPerson=ed1.getText().toString();
                getName=ed2.getText().toString();
                getEmail=ed3.getText().toString();
                getMobile=ed4.getText().toString();
                getPlace=ed5.getText().toString();
                Cursor cu=helper.searchData(getPerson);
                if (cu.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    ed5.setText("");
                    Toast.makeText(getApplicationContext(), "Invalid Person Id", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while(cu.moveToNext()) {
                        getName=cu.getString(1);
                        getEmail=cu.getString(3);
                        getMobile=cu.getString(4);
                        getPlace=cu.getString(5);
                    }
                        ed2.setText(getName);
                        ed3.setText(getEmail);
                        ed4.setText(getMobile);
                        ed5.setText(getPlace);

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
