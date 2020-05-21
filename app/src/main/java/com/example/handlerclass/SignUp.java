package com.example.handlerclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.handlerclass.R;

import org.w3c.dom.Text;

import java.util.regex.Pattern;


public class SignUp extends AppCompatActivity {

    private EditText firstName, lastName, pass, email, repass, number;
    private Button signUp, ext;
    private TextView passStatus;

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

        passStatus = (TextView) findViewById(R.id.tv_passStatus);

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

        //move to Login page
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //method calling
                checkDataEntered();
            }
        });

        //validate password
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = pass.getText().toString().trim();
                validatePassword(password);
            }

            @Override
            public void afterTextChanged(Editable s) {

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

    //Validate Entries
    void checkDataEntered() {
        if (isEmpty(firstName)) {
            firstName.setError(" First Name is required");
        } else if (isEmpty(lastName)) {
            lastName.setError("Last name is required!");
        } else if (firstName.length() < 3 || lastName.length() < 3) {
            Toast.makeText(getApplicationContext(), "Enter a valid name", Toast.LENGTH_SHORT).show();
        } else if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        } else if (isEmpty(number)) {
            number.setError("number is required");
            //Toast.makeText(this, "You must enter password to register!", Toast.LENGTH_SHORT).show();
        } else if (number.length() < 12) {
            number.setError("Enter a valid number");
        } else if (isEmpty(pass)) {
            pass.setError("password is required ");
        } else if (isEmpty(repass)) {
            repass.setError("Re enter the password");
        } else {
            if (repass.equals(pass)) {
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
            } else {
                repass.setError("Passwords donot matched");
            }
        }
    }

    //on backpressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUp.this, newAct.class);
        startActivity(intent);
        finish();
    }


    // Validate password
    public void validatePassword(String pass) {
        Pattern CapsLetter = Pattern.compile("[A-Z]");
        Pattern SmallLetter = Pattern.compile("[a-z]");
        Pattern numCase = Pattern.compile("[0-9]");
        if (!CapsLetter.matcher(pass).find() || !SmallLetter.matcher(pass).find() || !numCase.matcher(pass).find()) {
            passStatus.setText("Password is weak");
            // passStatus.setTextColor(android.R.color.holo_red_dark);
        } else if (pass.length() < 7) {
            passStatus.setText("Length is short");
            //passStatus.setTextColor(android.R.color.holo_red_dark);
        }   //{
        //passStatus.setText("Password is Strong");
        //passStatus.setTextColor(android.R.color.holo_green_light);
        //}
        else {
            passStatus.setText("password is Strong");
            //passStatus.setTextColor(android.R.color.holo_green_light);
        }

    }
}