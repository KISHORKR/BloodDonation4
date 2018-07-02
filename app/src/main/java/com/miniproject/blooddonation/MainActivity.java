package com.miniproject.blooddonation;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final EditText username = (EditText) findViewById(R.id.editText);
        final EditText password = (EditText) findViewById(R.id.editText2);
        Button login = (Button) findViewById(R.id.button);
        Button guest = (Button) findViewById(R.id.button2);
        Button about = (Button) findViewById(R.id.button11);
        setSupportActionBar(toolbar);
        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buidmessage();
            }
        });
        guest.setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),guest.class);
                startActivity(intent);
            }
         }
        );
                login.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if(username.getText().toString().equals("kishor"))
                        {
                            if (password.getText().toString().equals("klnce"))
                            {
                                Intent i2 = new Intent(getApplicationContext(), admin.class);
                                username.getText().clear();
                                password.getText().clear();
                                startActivity(i2);
                            }
                            else
                            {
                            password.setError("Invalid Password");
                            }
                        }
                        else
                        {
                            username.setError("Invalid Username");
                            password.setError("Invalid Password");
                        }
                    }

                });

    }
    public void buidmessage()
    {
        AlertDialog.Builder bu = new  AlertDialog.Builder(this);
        bu.setCancelable(true);
        bu.setTitle("About");
        bu.setMessage("Developed by :\n\n\t\t\t\t\tKISHOR K R\n\t\t\t\t\tASHOK KUMAR T S\n\nBuilt for Rotaract club\nK.L.N.College of Engineering\n\nversion : 1");
        bu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
