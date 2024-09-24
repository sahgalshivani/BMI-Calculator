package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightF);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;
                double bmi = wt / (totalM * totalM);

                if (bmi > 25) {
                    txtResult.setText("OOpsie Baby!,You're Overweight.Work Hard!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.OW));
                } else if (bmi < 18) {
                    txtResult.setText("oh hh No! ,You're Underweight.Eat Healthy !");
                    llMain.setBackgroundColor(getResources().getColor(R.color.UW));
                } else {
                    txtResult.setText("yahoo!,You're Healthy. Maintain It!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.H));
                }
            }
        });}}