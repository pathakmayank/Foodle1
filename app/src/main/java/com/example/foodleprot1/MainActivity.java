package com.example.foodleprot1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnRegister;
    EditText etUsername, etPassword;
    final int code = 3;
    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference table_user = database.getReference("Students");


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.foodleprot1.register.class);
                startActivityForResult(intent, code);

            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage = new Intent(MainActivity.this, com.example.foodleprot1.HomePageNew.class);
                startActivity(homepage);
                /*final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
                mDialog.setMessage("Please waiting....");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //check whether user exists or not
                        if(dataSnapshot.child(etUsername.getText().toString()).exists()) {

                            //check password
                            mDialog.dismiss();
                            Students student = dataSnapshot.child(etUsername.getText().toString()).getValue(Students.class);
                            if (student.getContact_number().equals(etPassword.getText().toString())) {
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                //will redirect to home page
                                Intent homepage = new Intent(MainActivity.this, com.example.foodleprot1.HomePageNew.class);
                                startActivity(homepage);

                            }else {
                                Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "User does not exists", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            */}
        });

    }

}
