package com.example.handlerclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class newAct extends AppCompatActivity {
    private Button login, cancel;
    private EditText number ;
    private TextInputEditText pass;
    private TextView register, forgetPass;
    //delay variable variable
    private static int DELAY_TIME = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        //Initialization
        login = (Button) findViewById(R.id.Btn_login);
        cancel = (Button) findViewById(R.id.Btn_Cancel);
        number = (EditText) findViewById(R.id.Edt_username);
        pass = (TextInputEditText) findViewById(R.id.Edt_pass);

        register = (TextView) findViewById(R.id.tv_register);
        forgetPass = (TextView) findViewById(R.id.tv_forgetpass);

        //Reg_BTN move to signUp
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(newAct.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        //move to forget Password screen
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(newAct.this, ForgetPass.class);
                startActivity(intent);
            }
        });


        //Cancel_BTN for the closing of an app
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

        //move to Dashboard
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //method call
                checkDataEntered();
            }
        });


    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {

        if (isEmpty(number)) {
            number.setError("Enter number");
        } else if (isEmpty(pass)) {
            pass.setError("Enter password");
        } else {
            Toast.makeText(getApplicationContext(), " Login processing ", Toast.LENGTH_SHORT).show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //moving towards dashboard screen
                    Intent intent = new Intent(newAct.this, DashBoard.class);
                    startActivity(intent);
                    finish();
                } //Delay for 1.5sec after clicking on SignUp Button
            }, DELAY_TIME);

        }
    }

    //pressing back button for generating the dialog box for closing an app
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder build = new AlertDialog.Builder(newAct.this);
        build.setTitle("Exit");
        build.setMessage("Are You sure you wants to exit? ");
        build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newAct.super.onBackPressed();
            }
        }).setNegativeButton("No", null).setCancelable(false);
        AlertDialog alert = build.create();
        alert.show();
    }
}
