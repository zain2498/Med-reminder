package com.example.handlerclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MakeSelection extends AppCompatActivity {

    private Button email, sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);

        email = (Button) findViewById(R.id.btn_email);
        sms = (Button) findViewById(R.id.btn_sms);


        //sms button move to verification screen
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MakeSelection.this,Verification.class);
                startActivity(i);
                finish();
            }
        });

        //email button move to verification screen
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MakeSelection.this,Verification.class);
                startActivity(i);
                finish();
            }
        });


    }


}
