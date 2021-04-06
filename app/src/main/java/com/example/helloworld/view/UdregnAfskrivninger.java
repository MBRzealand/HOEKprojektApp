package com.example.helloworld.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;
import com.example.helloworld.model.AfskrivningElement;
import com.example.helloworld.model.Model;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

import java.util.ArrayList;
import java.util.List;

public class UdregnAfskrivninger extends AppCompatActivity {

    AfskrivningElement afskrivningElement = new AfskrivningElement();

    Model model;

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
    TextView udregnAfskrivningerResultat;

    ImageButton plusKnap;
    TextView plusTekst;

    TableView<String[]> table4;

    ImageButton tilfoejTilAfskrivning1;
    ImageButton tilfoejTilAfskrivning2;


    List<String[]> listeAfAfskrivninger;
    List<String[]> listeAfAfskrivningerMedEnheder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udregn_afskrivninger);

        model = (Model) getIntent().getSerializableExtra("modelObject");

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


        listeAfAfskrivninger = new ArrayList<String[]>();
        listeAfAfskrivningerMedEnheder = new ArrayList<String[]>();


        afskrivningsprocentInput = findViewById(R.id.afskrivningsprocentInput);
        bogfoertPrimovaerdiInput = findViewById(R.id.bogfoertPrimovaerdiInput);

        godkendAfskrivningerKnap = findViewById(R.id.godkendAfskrivningerKnap);
        AfskrivningResultatText = findViewById(R.id.AfskrivningResultatText);
        udregnAfskrivningerResultat = findViewById(R.id.udregnAfskrivningerResultat);

        AfskrivningResultatText.setVisibility(View.GONE);
        udregnAfskrivningerResultat.setVisibility(View.GONE);

        plusKnap = findViewById(R.id.plusKnap);
        plusTekst = findViewById(R.id.plusTekst);

        table4 = findViewById(R.id.tableView4);
        table4.setHeaderAdapter(new SimpleTableHeaderAdapter(this,"Afskrivning"));

        tilfoejTilAfskrivning1 = findViewById(R.id.tilfoejTilAfskrivning1);
        tilfoejTilAfskrivning2 = findViewById(R.id.tilfoejTilAfskrivning2);

        tilfoejTilAfskrivning1.setVisibility(View.GONE);
        tilfoejTilAfskrivning1.setEnabled(false);

        tilfoejTilAfskrivning2.setVisibility(View.GONE);
        tilfoejTilAfskrivning2.setEnabled(false);


        hideEquations();

        kostprisInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal1();
                    kostprisInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( kostprisInput.getText().toString().equals("")) {
                        kostprisInput.setText(Long.toString(0));
                        afskrivningElement.setKostpris(Long.toString(0));
                    } else {
                        afskrivningElement.setKostpris(kostprisInput.getText().toString());
                    }

                    opdaterTal1();
                    kostprisInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }



            }
        });

        scrapvaerdiInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal1();
                    scrapvaerdiInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( scrapvaerdiInput.getText().toString().equals("")) {
                        scrapvaerdiInput.setText(Long.toString(0));
                        afskrivningElement.setScrapvaerdi(Long.toString(0));
                    } else {
                        afskrivningElement.setScrapvaerdi(Long.toString(Long.parseLong(scrapvaerdiInput.getText().toString())));
                    }

                    opdaterTal1();
                    scrapvaerdiInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }


            }
        });

        brugstidInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal1();
                    brugstidInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( brugstidInput.getText().toString().equals("")) {
                        brugstidInput.setText(Long.toString(0));
                        afskrivningElement.setBrugstid(Long.toString(0));
                    } else {
                        afskrivningElement.setBrugstid(Long.toString(Long.parseLong(brugstidInput.getText().toString())));
                    }

                    opdaterTal1();
                    brugstidInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }



                brugstidInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            brugstidInput.clearFocus();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                            return true;
                        }
                        return false;
                    }
                });

            }
        });


        afskrivningsprocentInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal2();
                    afskrivningsprocentInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( afskrivningsprocentInput.getText().toString().equals("")) {
                        afskrivningsprocentInput.setText(Long.toString(0));
                        afskrivningElement.setAfskrivningsprocent(Long.toString(0));
                    } else {
                        afskrivningElement.setAfskrivningsprocent(Long.toString(Long.parseLong(afskrivningsprocentInput.getText().toString())));
                    }

                    opdaterTal2();
                    afskrivningsprocentInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }


            }
        });



        bogfoertPrimovaerdiInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal2();
                    bogfoertPrimovaerdiInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( bogfoertPrimovaerdiInput.getText().toString().equals("")) {
                        bogfoertPrimovaerdiInput.setText(Long.toString(0));
                        afskrivningElement.setBogfoertPrimovaerdi(Long.toString(0));
                    } else {
                        afskrivningElement.setBogfoertPrimovaerdi(Long.toString(Long.parseLong(bogfoertPrimovaerdiInput.getText().toString())));
                    }


                    opdaterTal2();
                    bogfoertPrimovaerdiInput.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }



                bogfoertPrimovaerdiInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            bogfoertPrimovaerdiInput.clearFocus();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                            return true;
                        }
                        return false;
                    }
                });

            }
        });


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

        tilfoejTilAfskrivning1.setVisibility(View.GONE);
        tilfoejTilAfskrivning1.setEnabled(false);

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

        tilfoejTilAfskrivning1.setVisibility(View.VISIBLE);
        tilfoejTilAfskrivning1.setEnabled(true);

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

        tilfoejTilAfskrivning2.setVisibility(View.GONE);
        tilfoejTilAfskrivning2.setEnabled(false);

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

        tilfoejTilAfskrivning2.setVisibility(View.VISIBLE);
        tilfoejTilAfskrivning2.setEnabled(true);

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

        tilfoejTilAfskrivning1.setVisibility(View.GONE);
        tilfoejTilAfskrivning1.setEnabled(false);

        tilfoejTilAfskrivning2.setVisibility(View.GONE);
        tilfoejTilAfskrivning2.setEnabled(false);

    }

    public void opdaterTal1(){

        if( (!(kostprisInput.getText().toString().equals("")) && !(scrapvaerdiInput.getText().toString().equals(""))) && !(brugstidInput.getText().toString().equals("")) ){
            afskrivningElement.setAfskrivning( Long.toString( (( Long.parseLong(kostprisInput.getText().toString()) - ( Long.parseLong(scrapvaerdiInput.getText().toString() )) )) / ( Long.parseLong(brugstidInput.getText().toString() )) )  );
        }

    }

    public void opdaterTal2(){

        if( (!(afskrivningsprocentInput.getText().toString().equals("")) ) && !(bogfoertPrimovaerdiInput.getText().toString().equals("")) ){
            afskrivningElement.setAfskrivning( Long.toString( (  ( Long.parseLong(afskrivningsprocentInput.getText().toString())  ) * ( Long.parseLong(bogfoertPrimovaerdiInput.getText().toString()) ) ) ) );
        }


    }


    public void addElementToTable1(View view) {

        brugstidInput.clearFocus();

        if( (!kostprisInput.getText().toString().equals("") && !scrapvaerdiInput.getText().toString().equals("")) && !brugstidInput.getText().toString().equals("") ) {

            String[] stringOmsaetningsElement = new String[]{
//                    afskrivningElement.getKostpris(),
//                    afskrivningElement.getScrapvaerdi(),
//                    afskrivningElement.getBrugstid(),
                    afskrivningElement.getAfskrivning()
            };

            listeAfAfskrivninger.add(stringOmsaetningsElement);


            String[] stringAfskrivningsElementMedEnheder = new String[]{
//                    afskrivningElement.getKostpris(),
//                    afskrivningElement.getScrapvaerdi(),
//                    afskrivningElement.getBrugstid(),
                    afskrivningElement.getAfskrivning() + " kr"

            };

            listeAfAfskrivningerMedEnheder.add(stringAfskrivningsElementMedEnheder);


            int totaleAfskrivninger = 0;

            for (int i = 0; i < listeAfAfskrivninger.size(); i++) {
                totaleAfskrivninger += Long.parseLong(listeAfAfskrivninger.get(i)[0]);

            }

            if (listeAfAfskrivninger.size() > 0) {
                AfskrivningResultatText.setVisibility(View.VISIBLE);
                udregnAfskrivningerResultat.setVisibility(View.VISIBLE);
            }

            table4.setDataAdapter(new SimpleTableDataAdapter(this, listeAfAfskrivningerMedEnheder));
            udregnAfskrivningerResultat.setText(Long.toString(totaleAfskrivninger) + " kr");
            model.setOmsaetning(totaleAfskrivninger);

            kostprisInput.setText("");
            scrapvaerdiInput.setText("");
            brugstidInput.setText("");

            kostprisInput.setVisibility(View.GONE);
            scrapvaerdiInput.setVisibility(View.GONE);
            brugstidInput.setVisibility(View.GONE);
            godkendAfskrivningerKnap.setVisibility(View.GONE);
            kostprisInput.setEnabled(false);
            scrapvaerdiInput.setEnabled(false);
            brugstidInput.setEnabled(false);
            godkendAfskrivningerKnap.setEnabled(false);

            plusKnap.setVisibility(View.VISIBLE);
            plusTekst.setVisibility(View.VISIBLE);
            plusKnap.setEnabled(true);
            plusTekst.setEnabled(true);

            godkendAfskrivningerKnap.setVisibility(View.VISIBLE);
            godkendAfskrivningerKnap.setEnabled(true);

            hideEquations();

        } else {

            Toast.makeText(getApplicationContext(), "Udfyld venligst alle felter", Toast.LENGTH_SHORT).show();

        }


    }

    public void addElementToTable2(View view) {

        bogfoertPrimovaerdiInput.clearFocus();

    }
}