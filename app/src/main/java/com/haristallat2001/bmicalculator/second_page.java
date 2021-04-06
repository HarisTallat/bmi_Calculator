package com.haristallat2001.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class second_page extends AppCompatActivity {
    TextView tvResult,tv_YourResult,tv_State,tv_information;
Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
tvResult=findViewById(R.id.tvResult);
        tv_State=findViewById(R.id.tv_State);
        tv_YourResult=findViewById(R.id.tv_YourResult);
        tv_information=findViewById(R.id.tv_information);
        btnBack=findViewById(R.id.btnBack);


String show= getIntent().getStringExtra("key_Height");
String show2= getIntent().getStringExtra("key_Weight ");
String name1= getIntent().getStringExtra("key_name ");
String age1= getIntent().getStringExtra("key_age ");
String gender1 = getIntent().getStringExtra("key_gender");


        double height= Double.parseDouble(show );
        double weight = Double.parseDouble(show2 );
        double height_meters= (height)* 0.304;

        DecimalFormat round_off= new DecimalFormat(".00");

        double final_result1= weight / (height_meters*height_meters);
        double final_result2= Double.parseDouble(round_off.format(final_result1));


        if(final_result2<18.5)
        {
            tv_State.setText("Body mass deficit ");
            tv_information.setText("* Low risk of other illness.\n Normal BMI range 18.5 kg/m^2 - 25kg/m^2");
        }
        else if(final_result2 >=18.5&&final_result2 <=24.9)
        {
            tv_State.setText("Normal  Body mass ");
            tv_information.setText("* Average risk of other illness.\n* Normal BMI range 18.5 kg/m^2 - 25kg/m^2");
        }
      else   if(final_result2 >=25.0&&final_result2 <=29.9)
        {
            tv_State.setText("Excessive Body mass ");
            tv_information.setText("* Heightened  risk of other illness.\n* Normal BMI range 18.5 kg/m^2 - 25kg/m^2");
        }
        else   if(final_result2 >=30.0&&final_result2 <=34.9)
        {
            tv_State.setText("Obesity 1st Degree  ");
            tv_information.setText("* High  risk of other illness.\n* Normal BMI range 18.5 kg/m^2 - 25kg/m^2");
        }
        else   if(final_result2 >=35.0&&final_result2 <=39.9)
        {
            tv_State.setText("Obesity 2nd Degree  ");
            tv_information.setText("* Very High  risk of other illness.\n* Normal BMI range 18.5 kg/m^2 - 25kg/m^2");
        }
        else   if(final_result2 >=40.0)
        {
            tv_State.setText("Obesity 3rd Degree  ");
            tv_information.setText("* Extremely High risk of other illness.\n* Normal BMI range 18.5 kg/m^2 - 25kg/m^2");
        }


        String result_show=  Double.toString(final_result2);
        tv_YourResult.setText(" Your BMI Result ");
        tvResult.setText(result_show);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(second_page.this, MainActivity.class);
                 saveDataIntoFile();

                startActivity(intent);
                finish();

            }
            private void saveDataIntoFile()
            {
                String file="Haris_Tallat.txt";

                FileOutputStream f = null;
                String data = "\n" + name1 + "\n" + age1 + "\n" + gender1 + "\n" + weight + "\n" + height + "\n" +result_show  + "\n";
                try {
                    f= openFileOutput(file, Context.MODE_APPEND);
                    try {
                        f.write(data.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });









    }


}