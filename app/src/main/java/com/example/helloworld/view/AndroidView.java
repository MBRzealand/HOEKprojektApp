package com.example.helloworld.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

                }

                if(!hasFocus) {
                    if ( omsaetning.getText().toString().equals("")) {
                        omsaetning.setText(Integer.toString(0));
                        model.setOmsaetning(0);
                    } else {
                        model.setOmsaetning(Integer.parseInt(omsaetning.getText().toString()));
                    }



                }



            }
        });

        vareforbrug.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( vareforbrug.getText().toString().equals("")) {
                        vareforbrug.setText(Integer.toString(0));
                        model.setVareforbrug(0);

                    } else {
                        model.setVareforbrug(Integer.parseInt(vareforbrug.getText().toString()));
                    }



                }

            }
        });



        markedsfoeringsomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( markedsfoeringsomkostninger.getText().toString().equals("")) {
                        markedsfoeringsomkostninger.setText(Integer.toString(0));
                        model.setMarkedsfoeringsomkostninger(0);
                    } else {
                        model.setMarkedsfoeringsomkostninger(Integer.parseInt(markedsfoeringsomkostninger.getText().toString()));
                    }



                }


            }
        });



        oevrigeKapacitetsomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( oevrigeKapacitetsomkostninger.getText().toString().equals("")) {
                        oevrigeKapacitetsomkostninger.setText(Integer.toString(0));
                        model.setOevrigeKapacitetsomkostninger(0);
                    } else {
                        model.setOevrigeKapacitetsomkostninger(Integer.parseInt(oevrigeKapacitetsomkostninger.getText().toString()));
                    }


                }


            }
        });



        afskrivninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( afskrivninger.getText().toString().equals("")) {
                        afskrivninger.setText(Integer.toString(0));
                        model.setAfskrivninger(0);
                    } else {
                        model.setAfskrivninger(Integer.parseInt(afskrivninger.getText().toString()));
                    }

                }

            }
        });



        renteomkostninger.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( renteomkostninger.getText().toString().equals("")) {
                        renteomkostninger.setText(Integer.toString(0));
                        model.setRenteomkostninger(0);


                    } else {
                        model.setRenteomkostninger(Integer.parseInt(renteomkostninger.getText().toString()));
                    }



                }


                renteomkostninger.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            opdaterTal();
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
            bruttofortjeneste.setText(Integer.toString( (Integer.parseInt(omsaetning.getText().toString())) - (Integer.parseInt(vareforbrug.getText().toString())) ) );
            model.setBruttofortjeneste(Integer.parseInt(bruttofortjeneste.getText().toString()));
        }

        if( !(bruttofortjeneste.getText().toString().equals("tomt")) && !(markedsfoeringsomkostninger.getText().toString().equals("")) ){
            markedsfoeringsbidrag.setText( Integer.toString( ( Integer.parseInt(bruttofortjeneste.getText().toString()) ) - ( Integer.parseInt(markedsfoeringsomkostninger.getText().toString() )) ) );
        }

        if( !(markedsfoeringsbidrag.getText().toString().equals("tomt")) && !(oevrigeKapacitetsomkostninger.getText().toString().equals("")) ){
            indtjeningsbidrag.setText( Integer.toString( ( Integer.parseInt(markedsfoeringsbidrag.getText().toString()) ) - ( Integer.parseInt(oevrigeKapacitetsomkostninger.getText().toString() )) ) );
        }

        if( !(indtjeningsbidrag.getText().toString().equals("tomt")) && !(afskrivninger.getText().toString().equals("")) ){
            resultatFoerRenter.setText( Integer.toString( ( Integer.parseInt(indtjeningsbidrag.getText().toString()) ) - ( Integer.parseInt(afskrivninger.getText().toString() )) ) );
        }

        if( !(resultatFoerRenter.getText().toString().equals("tomt")) && !(renteomkostninger.getText().toString().equals("")) ){
            resultat.setText( Integer.toString( ( Integer.parseInt(resultatFoerRenter.getText().toString()) ) - ( Integer.parseInt(renteomkostninger.getText().toString() )) ) );
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 666:
                if (resultCode == Activity.RESULT_OK){

                    Model returnmodel = (Model) data.getSerializableExtra("modelObject");

                    model = returnmodel;

                    omsaetning.setText(Integer.toString(returnmodel.getOmsaetning()));

                        opdaterTal();

                }
                break;

            case 420:
                if (resultCode == Activity.RESULT_OK){

                    Model returnmodel = (Model) data.getSerializableExtra("modelObject");

                    model = returnmodel;

                    vareforbrug.setText(Integer.toString(returnmodel.getVareforbrug()));

                        opdaterTal();

                }
                break;

            case 69:
                if (resultCode == Activity.RESULT_OK){

                    Model returnmodel = (Model) data.getSerializableExtra("modelObject");

                    model = returnmodel;

                    oevrigeKapacitetsomkostninger.setText(Integer.toString(returnmodel.getOevrigeKapacitetsomkostninger()));

                        opdaterTal();

                }
                break;
        }
    }




}