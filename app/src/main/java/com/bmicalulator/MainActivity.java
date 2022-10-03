package com.bmicalulator;

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

        // Declaring the variables
        EditText heightFT,heightInch,weightV;
        Button btnBMI;
        TextView Result;
        LinearLayout bMain;

        // Accessing data through ID's
        heightFT = findViewById(R.id.heightFT);
        heightInch = findViewById(R.id.heightInch);
        weightV = findViewById(R.id.weightV);
        btnBMI = findViewById(R.id.btnBMI);
        Result = findViewById(R.id.ResultV);
        bMain = findViewById(R.id.bMain);

        btnBMI.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int heightF = Integer.parseInt(heightFT.getText().toString());
             int heightI = Integer.parseInt(heightInch.getText().toString());
             int weight = Integer.parseInt(weightV.getText().toString());

             // Calculate the operation
             int heightTotal = heightI*12 + heightF;
             double heightCm = heightTotal*2.53;
             double heightM = heightCm/100;
             double total = (weight)/Math.pow(heightM,2);

             // check the condition
                if(total>25)
                {
                    Result.setText("overWeight");
                    bMain.setBackgroundColor(getResources().getColor(R.color.overWeight));
                }
                else if(total<18)
                {
                    Result.setText("underWeight");
                    bMain.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }
                else
                {
                    Result.setText("perfectWeight");
                    bMain.setBackgroundColor(getResources().getColor(R.color.perfectWeight));
                }

            }
        }));

    }
}