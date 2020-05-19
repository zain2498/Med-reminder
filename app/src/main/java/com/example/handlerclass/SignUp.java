package com.example.handlerclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.handlerclass.R;

import org.w3c.dom.Text;


public class SignUp extends AppCompatActivity {

    private EditText firstName, lastName, pass, email, repass, number;
    private Button signUp, ext;

    //variable
    private static int DELAY_TIME = 1500;

    //Database Variable
    //DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //db Hook
        // db = new DatabaseHelper(this);
        //thats it

        firstName = (EditText) findViewById(R.id.Edt_frstName);
        lastName = (EditText) findViewById(R.id.Edt_lstName);
        pass = (EditText) findViewById(R.id.Edt_pass);
        repass = (EditText) findViewById(R.id.Edt_Repass);
        email = (EditText) findViewById(R.id.Edt_email);
        number = (EditText) findViewById(R.id.Edt_phoneNo);


        signUp = findViewById(R.id.Btn_SignUp);
        ext = findViewById(R.id.Btn_Exit);

        //exit OnclickListener
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, newAct.class);
                startActivity(intent);
                finish();
            }
        });

        //SignUp OnclickListener
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //method calling
                checkDataEntered();

            }
        });
    }


    //validate Entries

    //Email
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(firstName)) {
            firstName.setError("Enter valid name");
        } else if (isEmpty(lastName)) {
            lastName.setError("Last name is required!");
        } else if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        } else if (isEmpty(number)) {
            number.setError("number is required");
            //Toast.makeText(this, "You must enter password to register!", Toast.LENGTH_SHORT).show();
        } else if (isEmpty(pass)) {
            pass.setError("password is required ");
        } else if (isEmpty(repass)) {
            repass.setError("Re enter the password");
        } //When pass != repass then shw error !!!
        else {
            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Set Intent
                    Intent intent = new Intent(SignUp.this, newAct.class);
                    startActivity(intent);
                    finish();
                } //Delay for 1.5sec after clicking on SignUp Button
            }, DELAY_TIME);
        }

    }


    //on backpressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUp.this, newAct.class);
        startActivity(intent);
        finish();
    }
}


