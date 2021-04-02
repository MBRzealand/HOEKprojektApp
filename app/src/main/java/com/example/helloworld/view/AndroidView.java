package com.example.helloworld.view;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;

import com.example.helloworld.model.Model;

public class AndroidView extends AppCompatActivity {

    Model model;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new Model();

        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        final EditText omsaetning = findViewById(R.id.omsaetning);
        final EditText vareforbrug = findViewById(R.id.vareforbrug);
        final TextView bruttofortjeneste = findViewById(R.id.bruttofortjeneste);
        final EditText markedsfoeringsomkostninger = findViewById(R.id.markedsfoeringsomkostninger);
        final TextView markedsfoeringsbidrag = findViewById(R.id.markedsfoeringsbidrag);
        final EditText oevrigeKapacitetsomkostninger = findViewById(R.id.oevrigeKapacitetsomkostninger);
        final TextView indtjeningsbidrag = findViewById(R.id.indtjeningsbidrag);
        final EditText afskrivninger = findViewById(R.id.afskrivninger);
        final TextView resultatFoerRenter = findViewById(R.id.resultatFoerRenter);
        final EditText renteomkostninger = findViewById(R.id.renteomkostninger);
        final TextView resultat = findViewById(R.id.resultat);



        omsaetning.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( omsaetning.getText().toString().equals("")) {
                        omsaetning.setText(Integer.toString(0));
                        model.setOmsaetning(0);
                    } else {
                        model.setOmsaetning(Integer.parseInt(omsaetning.getText().toString()));
                    }
                }

                if( !(omsaetning.getText().toString().equals("")) && !(vareforbrug.getText().toString().equals(""))){
                    bruttofortjeneste.setText(Integer.toString( (Integer.parseInt(omsaetning.getText().toString())) - (Integer.parseInt(vareforbrug.getText().toString())) ) );
                    model.setBruttofortjeneste(Integer.parseInt(bruttofortjeneste.getText().toString()));
                }

            }
        });

        vareforbrug.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( vareforbrug.getText().toString().equals("")) {
                        vareforbrug.setText(Integer.toString(0));
                        model.setVareforbrug(0);

                    } else {
                        model.setVareforbrug(Integer.parseInt(vareforbrug.getText().toString()));
                    }
                }

                if( !(omsaetning.getText().toString().equals("")) && !(vareforbrug.getText().toString().equals(""))){
                    bruttofortjeneste.setText(Integer.toString((Integer.parseInt(omsaetning.getText().toString())) - (Integer.parseInt(vareforbrug.getText().toString())) ) );
                    model.setBruttofortjeneste(Integer.parseInt(bruttofortjeneste.getText().toString()));
                }
            }
        });


        markedsfoeringsomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( markedsfoeringsomkostninger.getText().toString().equals("")) {
                        markedsfoeringsomkostninger.setText(Integer.toString(0));
                        model.setMarkedsfoeringsomkostninger(0);
                    } else {
                        model.setMarkedsfoeringsomkostninger(Integer.parseInt(markedsfoeringsomkostninger.getText().toString()));
                    }
                }

                if( !(bruttofortjeneste.getText().toString().equals("tomt")) && !(markedsfoeringsomkostninger.getText().toString().equals("")) ){
                    markedsfoeringsbidrag.setText( Integer.toString( ( Integer.parseInt(bruttofortjeneste.getText().toString()) ) - ( Integer.parseInt(markedsfoeringsomkostninger.getText().toString() )) ) );
                }
            }
        });



        oevrigeKapacitetsomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( oevrigeKapacitetsomkostninger.getText().toString().equals("")) {
                        oevrigeKapacitetsomkostninger.setText(Integer.toString(0));
                        model.setOevrigeKapacitetsomkostninger(0);
                    } else {
                        model.setOevrigeKapacitetsomkostninger(Integer.parseInt(oevrigeKapacitetsomkostninger.getText().toString()));
                    }
                }

                if( !(markedsfoeringsbidrag.getText().toString().equals("tomt")) && !(oevrigeKapacitetsomkostninger.getText().toString().equals("")) ){
                    indtjeningsbidrag.setText( Integer.toString( ( Integer.parseInt(markedsfoeringsbidrag.getText().toString()) ) - ( Integer.parseInt(oevrigeKapacitetsomkostninger.getText().toString() )) ) );
                }
            }
        });



        afskrivninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( afskrivninger.getText().toString().equals("")) {
                        afskrivninger.setText(Integer.toString(0));
                        model.setAfskrivninger(0);
                    } else {
                        model.setAfskrivninger(Integer.parseInt(afskrivninger.getText().toString()));
                    }
                }

                if( !(indtjeningsbidrag.getText().toString().equals("tomt")) && !(afskrivninger.getText().toString().equals("")) ){
                    resultatFoerRenter.setText( Integer.toString( ( Integer.parseInt(indtjeningsbidrag.getText().toString()) ) - ( Integer.parseInt(afskrivninger.getText().toString() )) ) );
                }

            }
        });



        renteomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( renteomkostninger.getText().toString().equals("")) {
                        renteomkostninger.setText(Integer.toString(0));
                        model.setRenteomkostninger(0);


                    } else {
                        model.setRenteomkostninger(Integer.parseInt(renteomkostninger.getText().toString()));
                    }

                }

                if( !(resultatFoerRenter.getText().toString().equals("tomt")) && !(renteomkostninger.getText().toString().equals("")) ){
                    resultat.setText( Integer.toString( ( Integer.parseInt(resultatFoerRenter.getText().toString()) ) - ( Integer.parseInt(renteomkostninger.getText().toString() )) ) );
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

    public void goToUdregnOmsaetning(View view) {

        Intent intent = new Intent(this, UdregnOmsaetning.class);

        intent.putExtra("modelObject", model);

        startActivity(intent);
    }

//    public void sendMessage(View view) {
//
//        Intent intent = new Intent(this, SecondaryAndroidView.class);
//
//         EditText inputText = findViewById(R.id.inputText);
//
//         String textInput = inputText.getText().toString();
//
//         model.setData(textInput);
//
//        intent.putExtra("modelObject", model);
//
//        startActivity(intent);
//
//    }





}