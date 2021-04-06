 package com.haristallat2001.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    Button btnCalculator;
EditText etName,etAge,etGender,etHeight,etWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       data_Initialization();

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(check_for_error()==1)
                {
                    Toast errorToast = Toast.makeText(MainActivity.this, " You did not entered any value, Please enter the Value ",Toast.LENGTH_SHORT);
                    errorToast.show();
                }
                else if(etName.getText().toString().isEmpty())
                {
                    etName.setError(" You did not entered any name");
                }
                else  if(etGender.getText().toString().isEmpty())
                {
                    etGender.setError(" You did not entered any Gender ");
                }
                else  if(etAge.getText().toString().isEmpty())
                {
                    etAge.setError(" You did not entered any age");
                }

                else  if(etHeight.getText().toString().isEmpty())
                {
                    etHeight.setError(" You did not entered any Height");
                }
                else  if(etWeight.getText().toString().isEmpty())
                {
                    etWeight.setError(" You did not entered any Weight");
                }
                else
              {

                  String  height,weight, name,age,gender;
                  height = etHeight.getText().toString();
                  weight= etWeight.getText().toString();
                  name= etName.getText().toString();
                  age=etAge.getText().toString();
                  gender=etGender.getText().toString();

                  Intent intent= new Intent( MainActivity.this  ,com.haristallat2001.bmicalculator. second_page.class);
intent.putExtra("key_Height", height );
intent.putExtra("key_Weight ", weight );
intent.putExtra("Key_name",name);
intent.putExtra("Key_age",age);
intent.putExtra("Key_gender",gender);
startActivity(intent);
finish();

              }

            }
        });
    }



    private int check_for_error() {

        if(etName.getText().toString().isEmpty()&&etAge.getText().toString().isEmpty()&&etGender.getText().toString().isEmpty()&&etHeight.getText().toString().isEmpty()&&etWeight.getText().toString().isEmpty())
        {

            return 1;

}
        return 0;
    }


    private void data_Initialization() {

        btnCalculator=findViewById(R.id.btnBack);
        etName=findViewById(R.id.etName);
        etGender=findViewById(R.id.etGender);
        etAge=findViewById(R.id.etAge);
        etHeight=findViewById(R.id.etHeight);
        etWeight=findViewById(R.id.etWeight);




    }

}