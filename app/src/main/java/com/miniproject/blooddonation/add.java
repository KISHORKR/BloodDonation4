package com.miniproject.blooddonation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class add extends AppCompatActivity
{
    DatabaseHelper h2;
    EditText rno;
    EditText name;
    EditText dept;
    EditText bloodgroup;
    EditText year;
    EditText pno;
    Button add;
    Button update;
   // MainActivity ob1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        h2 = new DatabaseHelper(this);
        rno = (EditText) findViewById(R.id.editText4);
        name = (EditText) findViewById(R.id.editText5);
        dept = (EditText) findViewById(R.id.editText6);
        year = (EditText) findViewById(R.id.editText7);
        add = (Button) findViewById(R.id.button8);
        pno = (EditText)findViewById(R.id.ed);
        bloodgroup = (EditText) findViewById(R.id.ed2);
        update =  (Button) findViewById(R.id.button10);
        adddata();

    }
    public void adddata()
        {
            add.setOnClickListener(new View.OnClickListener()
               {
               public void onClick(View v)
               {
               boolean check = h2.adddata(rno.getText().toString(),name.getText().toString(),
                       dept.getText().toString(),year.getText().toString(),pno.getText().toString(),
                       bloodgroup.getText().toString().trim());
                  if(check == true)
                  {
                      Toast.makeText(add.this,"Data Inserted",Toast.LENGTH_LONG).show();
                      rno.getText().clear();
                      name.getText().clear();
                      dept.getText().clear();
                      year.getText().clear();
                      pno.getText().clear();
                      bloodgroup.getText().clear();
                  }
                   if(check == false)
                  {
                      Toast.makeText(add.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                  }
               }
               }
        );
            update.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Integer c1 = h2.updatedata(rno.getText().toString(), name.getText().toString(),
                            dept.getText().toString(), year.getText().toString(), pno.getText().toString(),
                            bloodgroup.getText().toString());
                    if (c1>0) {
                        Toast.makeText(add.this, c1+" Data updated", Toast.LENGTH_LONG).show();
                        rno.getText().clear();
                        name.getText().clear();
                        dept.getText().clear();
                        year.getText().clear();
                        pno.getText().clear();
                        bloodgroup.getText().clear();
                    }
                    if (c1 == 0) {
                        Toast.makeText(add.this, "Data not updated", Toast.LENGTH_LONG).show();
                    }
                }

            });
        }
    }