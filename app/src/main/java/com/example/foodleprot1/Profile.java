package com.example.foodleprot1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView Pname, PstudentNo, Pcontact, Pbranch, Pmail, Pyear;
    Button btnUpdateProfile, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Pname = findViewById(R.id.Pname);
        PstudentNo = findViewById(R.id.PstudentNo);
        Pcontact = findViewById(R.id.Pcontact);
        Pbranch = findViewById(R.id.Pbranch);
        Pmail= findViewById(R.id.Pmail);
        Pyear = findViewById(R.id.Pyear);
        btnUpdateProfile = findViewById(R.id.btnUpdateProfile);
        btnHome = findViewById(R.id.btnHome);



        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Profile.this, com.example.foodleprot1.HomePageNew.class);
                startActivity(home);
            }
        });
    }
}
