package com.example.helloworld.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;

public class UdregnAfskrivninger extends AppCompatActivity {

    RadioButton lineaerAfskrivning;
    RadioButton saldometoden;

    TextView p1;
    TextView p2;
    TextView p3;
    TextView p4;
    TextView m1;
    TextView d1;

    EditText kostprisInput;
    EditText scrapvaerdiInput;
    EditText brugstidInput;

    TextView p5;
    TextView p6;
    TextView p7;
    TextView p8;
    TextView g1;

    EditText afskrivningsprocentInput;
    EditText bogfoertPrimovaerdiInput;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udregn_afskrivninger);

        lineaerAfskrivning = findViewById(R.id.lineaerAfskrivningKnap);
        saldometoden = findViewById(R.id.saldometodeKnap);

        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        m1 = findViewById(R.id.m1);
        d1 = findViewById(R.id.d1);

        kostprisInput = findViewById(R.id.kostprisInput);
        scrapvaerdiInput = findViewById(R.id.scrapvaerdiInput);
        brugstidInput = findViewById(R.id.brugstidInput);

        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        g1 = findViewById(R.id.g1);

        afskrivningsprocentInput = findViewById(R.id.afskrivningsprocentInput);
        bogfoertPrimovaerdiInput = findViewById(R.id.bogfoertPrimovaerdiInput);

        lineaerAfskrivning.setChecked(true);
        turnOffVisibilityEquation2();


    }

    public void tilbageFraUdregnAfskrivninger(View view) {

        finish();

    }

    public void godkendAfskrivninger(View view) {
    }

    public void linearKnapKlik(View view) {

        turnOnVisibilityEquation1();
        turnOffVisibilityEquation2();
        saldometoden.setChecked(false);

    }

    public void saldoKnapKlik(View view) {

        turnOnVisibilityEquation2();
        turnOffVisibilityEquation1();
        lineaerAfskrivning.setChecked(false);

    }


    public void turnOffVisibilityEquation1(){

        lineaerAfskrivning.setTextColor(Color.parseColor("#C6C6C6"));

        kostprisInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C6C6C6")));
        scrapvaerdiInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C6C6C6")));
        brugstidInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C6C6C6")));

        kostprisInput.setEnabled(false);
        scrapvaerdiInput.setEnabled(false);
        brugstidInput.setEnabled(false);

        kostprisInput.setText("");
        scrapvaerdiInput.setText("");
        brugstidInput.setText("");

        p1.setTextColor(Color.parseColor("#C6C6C6"));
        p2.setTextColor(Color.parseColor("#C6C6C6"));
        p3.setTextColor(Color.parseColor("#C6C6C6"));
        p4.setTextColor(Color.parseColor("#C6C6C6"));
        m1.setTextColor(Color.parseColor("#C6C6C6"));
        d1.setTextColor(Color.parseColor("#C6C6C6"));

    }

    public void turnOnVisibilityEquation1(){

        lineaerAfskrivning.setTextColor(Color.parseColor("#000000"));

        kostprisInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
        scrapvaerdiInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
        brugstidInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

        kostprisInput.setEnabled(true);
        scrapvaerdiInput.setEnabled(true);
        brugstidInput.setEnabled(true);

        p1.setTextColor(Color.parseColor("#000000"));
        p2.setTextColor(Color.parseColor("#000000"));
        p3.setTextColor(Color.parseColor("#000000"));
        p4.setTextColor(Color.parseColor("#000000"));
        m1.setTextColor(Color.parseColor("#000000"));
        d1.setTextColor(Color.parseColor("#000000"));

    }

    public void turnOffVisibilityEquation2(){

        saldometoden.setTextColor(Color.parseColor("#C6C6C6"));

        afskrivningsprocentInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C6C6C6")));
        bogfoertPrimovaerdiInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C6C6C6")));

        afskrivningsprocentInput.setEnabled(false);
        bogfoertPrimovaerdiInput.setEnabled(false);

        afskrivningsprocentInput.setText("");
        bogfoertPrimovaerdiInput.setText("");

        p5.setTextColor(Color.parseColor("#C6C6C6"));
        p6.setTextColor(Color.parseColor("#C6C6C6"));
        p7.setTextColor(Color.parseColor("#C6C6C6"));
        p8.setTextColor(Color.parseColor("#C6C6C6"));
        g1.setTextColor(Color.parseColor("#C6C6C6"));

    }

    public void turnOnVisibilityEquation2(){

        saldometoden.setTextColor(Color.parseColor("#000000"));

        afskrivningsprocentInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
        bogfoertPrimovaerdiInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

        afskrivningsprocentInput.setEnabled(true);
        bogfoertPrimovaerdiInput.setEnabled(true);


        p5.setTextColor(Color.parseColor("#000000"));
        p6.setTextColor(Color.parseColor("#000000"));
        p7.setTextColor(Color.parseColor("#000000"));
        p8.setTextColor(Color.parseColor("#000000"));
        g1.setTextColor(Color.parseColor("#000000"));

    }



}