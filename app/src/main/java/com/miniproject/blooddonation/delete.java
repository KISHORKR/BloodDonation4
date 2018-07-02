package com.miniproject.blooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity{
    DatabaseHelper h3;
    EditText rno;
    EditText year;
    Button delete;
    Button delete1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        rno= (EditText) findViewById(R.id.editText67);
        delete= (Button)  findViewById(R.id.button60);
        year = (EditText) findViewById(R.id.editText3);
        delete1 = (Button) findViewById(R.id.button9);
        h3= new DatabaseHelper(this);
        deleterno();
    }
    public void deleterno()
    {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             Integer dr = h3.deletedata(rno.getText().toString(),"k1");
                if (dr ==0)
                {
                    Toast.makeText(delete.this,"No Record deleted", Toast.LENGTH_LONG).show();
                    rno.getText().clear();
                }else
                {
                    Toast.makeText(delete.this, dr + " Record deleted", Toast.LENGTH_LONG).show();
                    rno.getText().clear();
                }
            }
        });
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Integer dr = h3.deletedata(year.getText().toString(),"k2");
                if (dr ==0)
                {
                    Toast.makeText(delete.this,"No Record deleted", Toast.LENGTH_LONG).show();
                    year.getText().clear();
                }else
                {
                    Toast.makeText(delete.this, dr + " Record's deleted", Toast.LENGTH_LONG).show();
                    year.getText().clear();
                }
            }
        });

    }
}
