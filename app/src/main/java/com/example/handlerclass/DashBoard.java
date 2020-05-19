package com.example.handlerclass;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {
    Button btn_user, btn_Doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        btn_Doctor = (Button) findViewById(R.id.btn_doctor);
        btn_user = (Button) findViewById(R.id.btn_user);


        //show msg
        Toast.makeText(getApplicationContext(), " Successful ", Toast.LENGTH_SHORT).show();

      /*  Toolbar toolbar = findViewById(R.id.tb_header);
        setSupportActionBar(toolbar);
           //comes in layout file
            <include
        android:id="@+id/tb_header"
        layout="@layout/toolbar"
         />
        */
        //Doctor's Dashboard is Open
        btn_Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoard.this,doctorsDashboard.class);
                startActivity(i);

            }
        });

        //move to patients Dashboard
        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoard.this,patientDashboard.class);
                startActivity(i);

            }
        });

    }
    //on backpressed move to login screen
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DashBoard.this, newAct.class);
        startActivity(intent);
        finish();
    }
}
