package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button kmtomiles,milestokm;
    DecimalFormat format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        kmtomiles=findViewById(R.id.kmtomiles);
        milestokm=findViewById(R.id.milestokm);
        format=new DecimalFormat("##.##");

        milestokm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter miles.", Toast.LENGTH_SHORT).show();
                } else {
                    Double miles = Double.valueOf(et1.getText().toString());
                    double km = miles / 0.62137;
                    et2.setText(format.format(km));
                }
            }
        });

        kmtomiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter Kms.", Toast.LENGTH_SHORT).show();
                } else {
                    Double km = Double.valueOf(et2.getText().toString());
                    double miles = km * 0.62137;
                    et1.setText(format.format(miles));
                }
            }
        });
    }


}
