package com.example.handlerclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPass extends AppCompatActivity {

    private EditText email;
    private Button cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        email = (EditText) findViewById(R.id.Edt_input);
        cont = (Button) findViewById(R.id.Btn_Continue);

        //move to selection screen
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling the method
                checkDataEntered();
            }
        });
    }
    //Email
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }


    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered(){
        if (isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Email is Required", Toast.LENGTH_SHORT).show();
        }else if (isEmail(email) == false)
        {
            email.setError("Enter Valid Email");
        }else {
            Intent intent = new Intent(ForgetPass.this, MakeSelection.class);
            startActivity(intent);
            finish();

        }

    }

}


