package com.example.handlerclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newAct extends AppCompatActivity {
    Button login,cancel;
    EditText usrname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        cancel = (Button) findViewById(R.id.Btn_Cancel);
        login = (Button) findViewById(R.id.Btn_login);
        usrname = (EditText) findViewById(R.id.Edt_username);
        pass = (EditText) findViewById(R.id.Edt_pass);
        
        
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(newAct.this);
                builder.setMessage("Are you sure you wants to exit ");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        newAct.this.finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                    AlertDialog alert = builder.create();
                    alert.show();

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Login Processing", Toast.LENGTH_SHORT).show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"Successfully Login", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(newAct.this, loginImplementation.class);
                       startActivity(intent);
                    }
                },3000);
            }
        });

    }
}
