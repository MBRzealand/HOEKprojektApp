package com.example.helloworld.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

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

    Button godkendAfskrivningerKnap;
    TextView AfskrivningResultatText;

    ImageButton plusKnap;
    TextView plusTekst;

    TableView<String[]> table4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udregn_afskrivninger);

        lineaerAfskrivning = findViewById(R.id.lineaerAfskrivningKnap);
        saldometoden = findViewById(R.id.saldometodeKnap);

        p1 = findViewById(R.id.p1);  // "p" for parentes
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        m1 = findViewById(R.id.m1);  // "m" for minus
        d1 = findViewById(R.id.d1);  // "d" for division

        kostprisInput = findViewById(R.id.kostprisInput);
        scrapvaerdiInput = findViewById(R.id.scrapvaerdiInput);
        brugstidInput = findViewById(R.id.brugstidInput);

        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);
        p7 = findViewById(R.id.p7);
        p8 = findViewById(R.id.p8);
        g1 = findViewById(R.id.g1);  // "g" for gange

        afskrivningsprocentInput = findViewById(R.id.afskrivningsprocentInput);
        bogfoertPrimovaerdiInput = findViewById(R.id.bogfoertPrimovaerdiInput);

        godkendAfskrivningerKnap = findViewById(R.id.godkendAfskrivningerKnap);
        AfskrivningResultatText = findViewById(R.id.AfskrivningResultatText);

        plusKnap = findViewById(R.id.plusKnap);
        plusTekst = findViewById(R.id.plusTekst);

        table4 = findViewById(R.id.tableView4);
        table4.setHeaderAdapter(new SimpleTableHeaderAdapter(this,"Afskrivningsnavn","Afskrivning"));

        hideEquations();


    }

    public void tilbageFraUdregnAfskrivninger(View view) {

        finish();

    }

    public void godkendAfskrivninger(View view) {

        hideEquations();
        plusKnap.setEnabled(true);
        plusKnap.setVisibility(View.VISIBLE);
        plusTekst.setVisibility(View.VISIBLE);

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


    public void plusButtonPressed(View view) {

        plusKnap.setEnabled(false);
        plusKnap.setVisibility(View.GONE);
        plusTekst.setVisibility(View.GONE);

        lineaerAfskrivning.setChecked(true);
        saldometoden.setChecked(false);
        turnOnVisibilityEquation1();
        turnOffVisibilityEquation2();

        showEquations();



    }

    public void showEquations(){

        lineaerAfskrivning.setEnabled(true);
        lineaerAfskrivning.setVisibility(View.VISIBLE);

        saldometoden.setEnabled(true);
        saldometoden.setVisibility(View.VISIBLE);

        kostprisInput.setEnabled(true);
        scrapvaerdiInput.setEnabled(true);
        brugstidInput.setEnabled(true);
        kostprisInput.setVisibility(View.VISIBLE);
        scrapvaerdiInput.setVisibility(View.VISIBLE);
        brugstidInput.setVisibility(View.VISIBLE);

        afskrivningsprocentInput.setEnabled(true);
        bogfoertPrimovaerdiInput.setEnabled(true);
        afskrivningsprocentInput.setVisibility(View.VISIBLE);
        bogfoertPrimovaerdiInput.setVisibility(View.VISIBLE);

        p1.setVisibility(View.VISIBLE);
        p2.setVisibility(View.VISIBLE);
        p3.setVisibility(View.VISIBLE);
        p4.setVisibility(View.VISIBLE);
        p5.setVisibility(View.VISIBLE);
        p6.setVisibility(View.VISIBLE);
        p7.setVisibility(View.VISIBLE);
        p8.setVisibility(View.VISIBLE);
        m1.setVisibility(View.VISIBLE);
        d1.setVisibility(View.VISIBLE);
        g1.setVisibility(View.VISIBLE);

    }

    public void hideEquations(){

        lineaerAfskrivning.setEnabled(false);
        lineaerAfskrivning.setVisibility(View.GONE);

        saldometoden.setEnabled(false);
        saldometoden.setVisibility(View.GONE);

        kostprisInput.setEnabled(false);
        scrapvaerdiInput.setEnabled(false);
        brugstidInput.setEnabled(false);
        kostprisInput.setVisibility(View.GONE);
        scrapvaerdiInput.setVisibility(View.GONE);
        brugstidInput.setVisibility(View.GONE);

        afskrivningsprocentInput.setEnabled(false);
        bogfoertPrimovaerdiInput.setEnabled(false);
        afskrivningsprocentInput.setVisibility(View.GONE);
        bogfoertPrimovaerdiInput.setVisibility(View.GONE);

        p1.setVisibility(View.GONE);
        p2.setVisibility(View.GONE);
        p3.setVisibility(View.GONE);
        p4.setVisibility(View.GONE);
        p5.setVisibility(View.GONE);
        p6.setVisibility(View.GONE);
        p7.setVisibility(View.GONE);
        p8.setVisibility(View.GONE);
        m1.setVisibility(View.GONE);
        d1.setVisibility(View.GONE);
        g1.setVisibility(View.GONE);

    }

}