package com.example.helloworld.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;
import com.example.helloworld.model.Model;
import com.example.helloworld.model.OmsaetningElement;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

import java.util.ArrayList;
import java.util.List;

public class UdregnOmsaetning extends AppCompatActivity {

    Model model;
    OmsaetningElement omsaetningElement = new OmsaetningElement();

    TableView<String[]> table;

    EditText omsaetningNavnInput;
    EditText afsaetningInput;
    EditText salgsprisInput;
    TextView udregnOmsaetningResultat;
    TextView omsaetningText;
    TextView omsaetningResultatText;

    ImageButton omsaetningImage;
    ImageButton tilfoejTilOmsaetningKnap;

    Button godkendOmsaetningKnap;


    List<String[]> listeAfOmsaetning;
    List<String[]> listeAfOmsaetningMedEnheder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udregn_omsaetning);

        model = (Model) getIntent().getSerializableExtra("modelObject");

        table = findViewById(R.id.tableView);
        table.setHeaderAdapter(new SimpleTableHeaderAdapter(this,"Varenavn","Afsætning", "Salgspris", "Total"));


        omsaetningNavnInput = findViewById(R.id.omsaetningNavnInput);
        afsaetningInput = findViewById(R.id.afsaetningInput);
        salgsprisInput = findViewById(R.id.salgsprisInput);
        udregnOmsaetningResultat = findViewById(R.id.udregnOmsaetningResultat);

        tilfoejTilOmsaetningKnap = findViewById(R.id.tilfoejTilOmsaetningKnap);
        omsaetningText = findViewById(R.id.omsaetningText);
        omsaetningResultatText = findViewById(R.id.omsaetningResultatText);
        omsaetningImage = findViewById(R.id.omsaetningImage);

        godkendOmsaetningKnap = findViewById(R.id.godkendOmsaetningKnap);


        godkendOmsaetningKnap.setVisibility(View.GONE);
        godkendOmsaetningKnap.setEnabled(false);

        omsaetningNavnInput.setVisibility(View.GONE);
        afsaetningInput.setVisibility(View.GONE);
        salgsprisInput.setVisibility(View.GONE);
        tilfoejTilOmsaetningKnap.setVisibility(View.GONE);
        omsaetningNavnInput.setEnabled(false);
        afsaetningInput.setEnabled(false);
        salgsprisInput.setEnabled(false);
        tilfoejTilOmsaetningKnap.setEnabled(false);

        omsaetningResultatText.setVisibility(View.GONE);
        udregnOmsaetningResultat.setVisibility(View.GONE);


        listeAfOmsaetning = new ArrayList<String[]>();
        listeAfOmsaetningMedEnheder = new ArrayList<String[]>();


        omsaetningNavnInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( omsaetningNavnInput.getText().toString().equals("")) {
                        omsaetningNavnInput.setText("Intet Navn");
                        omsaetningElement.setVarenavn("Intet Navn");
                    } else {
                        omsaetningElement.setVarenavn(omsaetningNavnInput.getText().toString());
                    }

                    opdaterTal();

                }



            }
        });


        afsaetningInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( afsaetningInput.getText().toString().equals("")) {
                        afsaetningInput.setText(Long.toString(0));
                        omsaetningElement.setAfsaetning(Long.toString(0));
                    } else {
                        omsaetningElement.setAfsaetning(Long.toString(Long.parseLong(afsaetningInput.getText().toString())));
                    }

                    opdaterTal();

                }


            }
        });

        salgsprisInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( salgsprisInput.getText().toString().equals("")) {
                        salgsprisInput.setText(Long.toString(0));
                        omsaetningElement.setSalgspris(Long.toString(0));
                    } else {
                        omsaetningElement.setSalgspris(Long.toString(Long.parseLong(salgsprisInput.getText().toString())));
                    }

                    if( (!(afsaetningInput.getText().toString().equals("")) && !(salgsprisInput.getText().toString().equals(""))) && !(omsaetningNavnInput.getText().toString().equals("")) ){
                        omsaetningElement.setOmsaetning( Long.toString (( Long.parseLong(afsaetningInput.getText().toString())  * ( Long.parseLong(salgsprisInput.getText().toString() )) ) ));

                    }

                    opdaterTal();

                }



                salgsprisInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            salgsprisInput.clearFocus();
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





    public void tilbageFraUdregnOmsaetning(View view) {

        finish();

    }

    public void addElementToTable(View view) {

        salgsprisInput.clearFocus();

        if( (!omsaetningNavnInput.getText().toString().equals("") && !salgsprisInput.getText().toString().equals("")) && !afsaetningInput.getText().toString().equals("") ) {

            String[] stringOmsaetningsElement = new String[]{
                    omsaetningElement.getVarenavn(),
                    omsaetningElement.getAfsaetning(),
                    omsaetningElement.getSalgspris(),
                    omsaetningElement.getOmsaetning()
            };

            listeAfOmsaetning.add(stringOmsaetningsElement);


            String[] stringOmsaetningsElementMedEnheder = new String[]{
                    omsaetningElement.getVarenavn(),
                    omsaetningElement.getAfsaetning() + " stk",
                    omsaetningElement.getSalgspris() + " kr",
                    omsaetningElement.getOmsaetning() + " kr"
            };

            listeAfOmsaetningMedEnheder.add(stringOmsaetningsElementMedEnheder);


            int totalOmsaetning = 0;

            for (int i = 0; i < listeAfOmsaetning.size(); i++) {
                totalOmsaetning += Long.parseLong(listeAfOmsaetning.get(i)[3]);

            }

            if (listeAfOmsaetning.size() > 0) {
                udregnOmsaetningResultat.setVisibility(View.VISIBLE);
                omsaetningResultatText.setVisibility(View.VISIBLE);
            }

            table.setDataAdapter(new SimpleTableDataAdapter(this, listeAfOmsaetningMedEnheder));
            udregnOmsaetningResultat.setText(Long.toString(totalOmsaetning) + " kr");
            model.setOmsaetning(totalOmsaetning);

            omsaetningNavnInput.setText("");
            salgsprisInput.setText("");
            afsaetningInput.setText("");

            omsaetningNavnInput.setVisibility(View.GONE);
            afsaetningInput.setVisibility(View.GONE);
            salgsprisInput.setVisibility(View.GONE);
            tilfoejTilOmsaetningKnap.setVisibility(View.GONE);
            omsaetningNavnInput.setEnabled(false);
            afsaetningInput.setEnabled(false);
            salgsprisInput.setEnabled(false);
            tilfoejTilOmsaetningKnap.setEnabled(false);

            omsaetningImage.setVisibility(View.VISIBLE);
            omsaetningText.setVisibility(View.VISIBLE);
            omsaetningImage.setEnabled(true);
            omsaetningText.setEnabled(true);

            godkendOmsaetningKnap.setVisibility(View.VISIBLE);
            godkendOmsaetningKnap.setEnabled(true);

        } else {

            Toast.makeText(getApplicationContext(), "Udfyld venligst alle felter", Toast.LENGTH_SHORT).show();

        }


    }


    public void tilfoejVareTilOmsaetning(View view) {

        omsaetningNavnInput.setVisibility(View.VISIBLE);
        afsaetningInput.setVisibility(View.VISIBLE);
        salgsprisInput.setVisibility(View.VISIBLE);
        tilfoejTilOmsaetningKnap.setVisibility(View.VISIBLE);
        omsaetningNavnInput.setEnabled(true);
        afsaetningInput.setEnabled(true);
        salgsprisInput.setEnabled(true);
        tilfoejTilOmsaetningKnap.setEnabled(true);

        omsaetningImage.setVisibility(View.GONE);
        omsaetningText.setVisibility(View.GONE);
        omsaetningImage.setEnabled(false);
        omsaetningText.setEnabled(false);

    }

    public void godkendOmsaetning(View view) {

        if(listeAfOmsaetning.size() >0 ){

            Intent intent = new Intent(this, AndroidView.class);

            intent.putExtra("modelObject", model);

            setResult(Activity.RESULT_OK,intent);

        }

        finish();

    }

    public void opdaterTal(){

        if( (!(afsaetningInput.getText().toString().equals("")) && !(salgsprisInput.getText().toString().equals(""))) && !(omsaetningNavnInput.getText().toString().equals("")) ){
            omsaetningElement.setOmsaetning( Long.toString( ( Long.parseLong(afsaetningInput.getText().toString()) * ( Long.parseLong(salgsprisInput.getText().toString() )) )) );
        }

    }


}