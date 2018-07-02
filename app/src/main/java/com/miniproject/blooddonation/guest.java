package com.miniproject.blooddonation;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app. AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class guest extends AppCompatActivity {

    Button search;
    DatabaseHelper h1;
    AutoCompleteTextView bloodgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        h1 = new DatabaseHelper(this);
        bloodgroup = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        search = (Button) findViewById(R.id.button3);
        gsearch();
    }
    public void gsearch(){
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Cursor r = h1.search(bloodgroup.getText().toString().trim());
                if (r.getCount() == 0)
                {
                    print("Data not found","No records are found for this Blood Group");
                    return;
                }
                StringBuffer b = new StringBuffer();
                while (r.moveToNext())
                {
                    b.append("Rno: "+ r.getString(0)+"\n");
                    b.append("Name: "+ r.getString(1)+"\n");
                    b.append("Dept: "+ r.getString(2)+"\n");
                    b.append("Year: "+ r.getString(3)+"\n");
                    b.append("Ph.no: "+ r.getString(4)+"\n");
                    b.append("Blood Group: "+ r.getString(5)+"\n\n");

                }

                print(r.getCount()+" Data's found",b.toString());
                bloodgroup.getText().clear();
            }
        });
    }
    public void print(String t,String m)
    {
        AlertDialog.Builder bu = new  AlertDialog.Builder(this);
        bu.setCancelable(true);
        bu.setTitle(t);
        bu.setMessage(m);
        bu.show();;
    }
}
