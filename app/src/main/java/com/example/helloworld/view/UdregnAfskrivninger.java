package com.example.helloworld.view;

import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;

public class UdregnAfskrivninger extends AppCompatActivity {

    RadioButton lineaerAfskrivning;
    RadioButton saldometoden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udregn_afskrivninger);

        lineaerAfskrivning = findViewById(R.id.lineaerAfskrivningKnap);
        saldometoden = findViewById(R.id.saldometodeKnap);

        lineaerAfskrivning.setChecked(true);


    }

    public void tilbageFraUdregnAfskrivninger(View view) {
    }

    public void godkendAfskrivninger(View view) {
    }

    public void linearKnapKlik(View view) {

        saldometoden.setChecked(false);

    }

    public void saldoKnapKlik(View view) {

        lineaerAfskrivning.setChecked(false);

    }
}