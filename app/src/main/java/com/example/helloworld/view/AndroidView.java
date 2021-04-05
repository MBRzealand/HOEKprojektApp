package com.example.helloworld.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;

import com.example.helloworld.model.Model;

public class AndroidView extends AppCompatActivity {


    Model model;
    InputMethodManager imm;

    EditText omsaetning;
    EditText vareforbrug;
    EditText oevrigeKapacitetsomkostninger;
    TextView bruttofortjeneste;
    EditText markedsfoeringsomkostninger;
    TextView markedsfoeringsbidrag;
    TextView indtjeningsbidrag;
    EditText afskrivninger;
    TextView resultatFoerRenter;
    EditText renteomkostninger;
    TextView resultat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new Model();

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        omsaetning = findViewById(R.id.omsaetning);
        vareforbrug = findViewById(R.id.vareforbrug);
        bruttofortjeneste = findViewById(R.id.bruttofortjeneste);
        markedsfoeringsomkostninger = findViewById(R.id.markedsfoeringsomkostninger);
        markedsfoeringsbidrag = findViewById(R.id.markedsfoeringsbidrag);
        oevrigeKapacitetsomkostninger = findViewById(R.id.oevrigeKapacitetsomkostninger);
        indtjeningsbidrag = findViewById(R.id.indtjeningsbidrag);
        afskrivninger = findViewById(R.id.afskrivninger);
        resultatFoerRenter = findViewById(R.id.resultatFoerRenter);
        renteomkostninger = findViewById(R.id.renteomkostninger);
        resultat = findViewById(R.id.resultat);



        omsaetning.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if (hasFocus){

                    opdaterTal();
                    omsaetning.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( omsaetning.getText().toString().equals("")) {
                        omsaetning.setText(Long.toString(0));
                        model.setOmsaetning(0);
                    } else {
                        model.setOmsaetning(Long.parseLong(omsaetning.getText().toString()));
                    }

                    opdaterTal();
                    omsaetning.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }



            }
        });

        vareforbrug.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();
                    vareforbrug.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( vareforbrug.getText().toString().equals("")) {
                        vareforbrug.setText(Long.toString(0));
                        model.setVareforbrug(0);

                    } else {
                        model.setVareforbrug(Long.parseLong(vareforbrug.getText().toString()));
                    }

                    opdaterTal();
                    vareforbrug.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }

            }
        });



        markedsfoeringsomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();
                    markedsfoeringsomkostninger.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( markedsfoeringsomkostninger.getText().toString().equals("")) {
                        markedsfoeringsomkostninger.setText(Long.toString(0));
                        model.setMarkedsfoeringsomkostninger(0);
                    } else {
                        model.setMarkedsfoeringsomkostninger(Long.parseLong(markedsfoeringsomkostninger.getText().toString()));
                    }

                    opdaterTal();
                    markedsfoeringsomkostninger.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }


            }
        });



        oevrigeKapacitetsomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();
                    oevrigeKapacitetsomkostninger.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( oevrigeKapacitetsomkostninger.getText().toString().equals("")) {
                        oevrigeKapacitetsomkostninger.setText(Long.toString(0));
                        model.setOevrigeKapacitetsomkostninger(0);
                    } else {
                        model.setOevrigeKapacitetsomkostninger(Long.parseLong(oevrigeKapacitetsomkostninger.getText().toString()));
                    }

                    opdaterTal();
                    oevrigeKapacitetsomkostninger.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }


            }
        });



        afskrivninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();
                    afskrivninger.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( afskrivninger.getText().toString().equals("")) {
                        afskrivninger.setText(Long.toString(0));
                        model.setAfskrivninger(0);
                    } else {
                        model.setAfskrivninger(Long.parseLong(afskrivninger.getText().toString()));
                    }

                    opdaterTal();
                    afskrivninger.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }

            }
        });



        renteomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();
                    renteomkostninger.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00DAC5")));

                }

                if(!hasFocus) {
                    if ( renteomkostninger.getText().toString().equals("")) {
                        renteomkostninger.setText(Long.toString(0));
                        model.setRenteomkostninger(0);


                    } else {
                        model.setRenteomkostninger(Long.parseLong(renteomkostninger.getText().toString()));
                    }

                    opdaterTal();
                    renteomkostninger.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));

                }


                renteomkostninger.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            renteomkostninger.clearFocus();
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                            return true;
                        }
                        return false;
                    }
                });

            }
        });





    }

    public void opdaterTal(){

        if( !(omsaetning.getText().toString().equals("")) && !(vareforbrug.getText().toString().equals(""))){
            bruttofortjeneste.setText(Long.toString( (Long.parseLong(omsaetning.getText().toString())) - (Long.parseLong(vareforbrug.getText().toString())) ) );
            model.setBruttofortjeneste(Long.parseLong(bruttofortjeneste.getText().toString()));
        }

        if( !(bruttofortjeneste.getText().toString().equals("")) && !(markedsfoeringsomkostninger.getText().toString().equals("")) ){
            markedsfoeringsbidrag.setText( Long.toString( ( Long.parseLong(bruttofortjeneste.getText().toString()) ) - ( Long.parseLong(markedsfoeringsomkostninger.getText().toString() )) ) );
        }

        if( !(markedsfoeringsbidrag.getText().toString().equals("")) && !(oevrigeKapacitetsomkostninger.getText().toString().equals("")) ){
            indtjeningsbidrag.setText( Long.toString( ( Long.parseLong(markedsfoeringsbidrag.getText().toString()) ) - ( Long.parseLong(oevrigeKapacitetsomkostninger.getText().toString() )) ) );
        }

        if( !(indtjeningsbidrag.getText().toString().equals("")) && !(afskrivninger.getText().toString().equals("")) ){
            resultatFoerRenter.setText( Long.toString( ( Long.parseLong(indtjeningsbidrag.getText().toString()) ) - ( Long.parseLong(afskrivninger.getText().toString() )) ) );
        }

        if( !(resultatFoerRenter.getText().toString().equals("")) && !(renteomkostninger.getText().toString().equals("")) ){
            resultat.setText( Long.toString( ( Long.parseLong(resultatFoerRenter.getText().toString()) ) - ( Long.parseLong(renteomkostninger.getText().toString() )) ) );
        }


    }


    public void goToUdregnOmsaetning(View view) {

        Intent intent = new Intent(this, UdregnOmsaetning.class);

        intent.putExtra("modelObject", model);

        startActivityForResult(intent,666);

    }

    public void goToUdregnVareforbrug(View view) {

        Intent intent = new Intent(this, UdregnVareforbrug.class);

        intent.putExtra("modelObject", model);

        startActivityForResult(intent,420);

    }

    public void goToUdregnKapacitetsomkostninger(View view) {

        Intent intent = new Intent(this, UdregnKapacitetsomkostninger.class);

        intent.putExtra("modelObject", model);

        startActivityForResult(intent,69);

    }

    public void goToUdregnAfskrivninger(View view) {

        Intent intent = new Intent(this, UdregnAfskrivninger.class);

        intent.putExtra("modelObject", model);

        startActivityForResult(intent,911);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 666:
                if (resultCode == Activity.RESULT_OK){

                    Model returnmodel = (Model) data.getSerializableExtra("modelObject");

                    model = returnmodel;


                    omsaetning.setText(Long.toString(returnmodel.getOmsaetning()));

                        opdaterTal();

                }
                break;

            case 420:
                if (resultCode == Activity.RESULT_OK){

                    Model returnmodel = (Model) data.getSerializableExtra("modelObject");

                    model = returnmodel;

                    vareforbrug.setText(Long.toString(returnmodel.getVareforbrug()));

                        opdaterTal();

                }
                break;

            case 69:
                if (resultCode == Activity.RESULT_OK){

                    Model returnmodel = (Model) data.getSerializableExtra("modelObject");

                    model = returnmodel;

                    oevrigeKapacitetsomkostninger.setText(Long.toString(returnmodel.getOevrigeKapacitetsomkostninger()));

                        opdaterTal();

                }
                break;
        }
    }



}