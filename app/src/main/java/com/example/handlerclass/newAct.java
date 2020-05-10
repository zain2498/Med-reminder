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
    Button login;
    EditText usrname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        login = (Button) findViewById(R.id.Btn_login);
        usrname = (EditText) findViewById(R.id.Edt_username);
        pass = (EditText) findViewById(R.id.Edt_pass);

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
