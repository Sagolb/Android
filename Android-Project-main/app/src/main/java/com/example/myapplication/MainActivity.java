package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText Email_ET, Pass_ET;
    Button btn;
    Spinner spn_gen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        Email_ET = findViewById(R.id.emailEditText);
        Pass_ET = findViewById(R.id.passwordEditText);
        spn_gen = findViewById(R.id.genderSpinner);
        btn = findViewById(R.id.submitButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_gen.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = spn_gen.getSelectedItem().toString();
                String typedValue = String.valueOf(Email_ET.getText());
                Intent myintent = new Intent(MainActivity.this, WelcomeScreen.class);
                myintent.putExtra("bca",typedValue);
                myintent.putExtra("gender",gender);
                startActivity(myintent);
            }
        });
    }
}