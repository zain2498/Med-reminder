package com.example.handlerclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPass extends AppCompatActivity {

    private EditText email;
    private Button cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        email = (EditText) findViewById(R.id.Edt_input);
        cont = (Button) findViewById(R.id.Btn_Continue);


        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(ForgetPass.this, Verification.class);
                //startActivity(intent);
                //finish();

            }
        });
    }
}
