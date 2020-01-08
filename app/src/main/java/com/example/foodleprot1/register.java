package com.example.foodleprot1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText etName, etStudentNo, etContactNo, etBranch, etYear;
    Button btnSbmit;
    Students student;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etStudentNo = findViewById(R.id.etStudentNo);
        etContactNo = findViewById(R.id.etContactNo);
        etBranch = findViewById(R.id.etBranch);
        etYear = findViewById(R.id.etYear);
        btnSbmit = findViewById(R.id.btnSbmit);
        student = new Students();
        reff = FirebaseDatabase.getInstance().getReference().child("Students");

        btnSbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etName.getText().toString().isEmpty() || etStudentNo.getText().toString().isEmpty() || etContactNo.getText().toString().isEmpty()
                || etBranch.getText().toString().isEmpty() || etYear.getText().toString().isEmpty())
                {
                    Toast.makeText(register.this, "Please fill all the details!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    student.setName(etName.getText().toString().trim());
                    student.setStudent_number(etStudentNo.getText().toString().trim());
                    student.setContact_number(etContactNo.getText().toString().trim());
                    student.setBranch(etBranch.getText().toString().trim());
                    student.setYear(etYear.getText().toString().trim());
                    reff.child(etStudentNo.getText().toString().trim()).setValue(student);
                    Toast.makeText(register.this, "Congratulations, You have registered successfully", Toast.LENGTH_SHORT).show();

                    //save detail in profile


                    setResult(RESULT_OK, intent);
                    register.this.finish();

                }
            }
        });
    }
}
