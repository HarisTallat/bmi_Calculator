package com.haristallat2001.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen_BMI extends AppCompatActivity {
    private final int SPLASH_TIME = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen__b_m_i);
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent= new Intent(splash_screen_BMI.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}, SPLASH_TIME);

    }
}