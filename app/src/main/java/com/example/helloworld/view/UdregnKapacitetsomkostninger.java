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
import com.example.helloworld.model.KapacitetsomkostningElement;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

import java.util.ArrayList;
import java.util.List;

public class UdregnKapacitetsomkostninger extends AppCompatActivity {

    Model model;
    KapacitetsomkostningElement kapacitetsomkostningElement = new KapacitetsomkostningElement();

    TableView<String[]> table3;

    EditText kapacitetsomkostningNavnInput;
    EditText kapacitetsomkostningPrisInput;

    TextView udregnKapacitetsomkostningResultat;
    TextView kapacitetsomkostningText;
    TextView kapacitetsomkostningResultatText;

    ImageButton kapacitetsomkostningImage;
    ImageButton tilfoejTilKapacitetsomkostningKnap;

    Button godkendKapacitetsomkostningerKnap;


    List<String[]> listeAfKapacitetsomkostninger;
    List<String[]> listeAfKapacitetsomkostningerMedEnheder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udregn_kapacitetsomkostninger);

        model = (Model) getIntent().getSerializableExtra("modelObject");

        table3 = findViewById(R.id.tableView3);
        table3.setHeaderAdapter(new SimpleTableHeaderAdapter(this,"Kapacitetsomkostning","Omkostningspris"));


        kapacitetsomkostningNavnInput = findViewById(R.id.kapacitetsomkostningNavnInput);
        kapacitetsomkostningPrisInput = findViewById(R.id.kapacitetsomkostningPrisInput);
        udregnKapacitetsomkostningResultat = findViewById(R.id.udregnKapacitetsomkostningResultat);

        tilfoejTilKapacitetsomkostningKnap = findViewById(R.id.tilfoejTilKapacitetsomkostningKnap);
        kapacitetsomkostningText = findViewById(R.id.kapacitetsomkostningText);
        kapacitetsomkostningResultatText = findViewById(R.id.kapacitetsomkostningResultatText);
        kapacitetsomkostningImage = findViewById(R.id.kapacitetsomkostningImage);

        godkendKapacitetsomkostningerKnap = findViewById(R.id.godkendKapacitetsomkostningerKnap);


        godkendKapacitetsomkostningerKnap.setVisibility(View.GONE);
        godkendKapacitetsomkostningerKnap.setEnabled(false);

        kapacitetsomkostningNavnInput.setVisibility(View.GONE);
        kapacitetsomkostningPrisInput.setVisibility(View.GONE);
        tilfoejTilKapacitetsomkostningKnap.setVisibility(View.GONE);
        kapacitetsomkostningNavnInput.setEnabled(false);
        kapacitetsomkostningPrisInput.setEnabled(false);
        tilfoejTilKapacitetsomkostningKnap.setEnabled(false);

        kapacitetsomkostningResultatText.setVisibility(View.GONE);
        udregnKapacitetsomkostningResultat.setVisibility(View.GONE);


        listeAfKapacitetsomkostninger = new ArrayList<String[]>();
        listeAfKapacitetsomkostningerMedEnheder = new ArrayList<String[]>();


        kapacitetsomkostningNavnInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( kapacitetsomkostningNavnInput.getText().toString().equals("")) {
                        kapacitetsomkostningNavnInput.setText("Intet Navn");
                        kapacitetsomkostningElement.setKapacitetsomkostningNavn("Intet Navn");
                    } else {
                        kapacitetsomkostningElement.setKapacitetsomkostningNavn(kapacitetsomkostningNavnInput.getText().toString());
                    }

                    opdaterTal();

                }



            }
        });


        kapacitetsomkostningPrisInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {

                if(hasFocus) {

                    opdaterTal();

                }

                if(!hasFocus) {
                    if ( kapacitetsomkostningPrisInput.getText().toString().equals("")) {
                        kapacitetsomkostningPrisInput.setText(Integer.toString(0));
                        kapacitetsomkostningElement.setKapacitetsomkostningPris(Integer.toString(0));
                    } else {
                        kapacitetsomkostningElement.setKapacitetsomkostningPris(kapacitetsomkostningPrisInput.getText().toString());
                    }

                    opdaterTal();

                }


                kapacitetsomkostningPrisInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            kapacitetsomkostningPrisInput.clearFocus();
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

    public void tilbageFraUdregnKapacitetsomkostninger(View view) {

        finish();

    }

    public void addElementToTable(View view) {

        kapacitetsomkostningPrisInput.clearFocus();

        if( !kapacitetsomkostningNavnInput.getText().toString().equals("") && !kapacitetsomkostningPrisInput.getText().toString().equals("") ) {


            String[] stringKapacitetsomkostningElement = new String[]{
                    kapacitetsomkostningElement.getKapacitetsomkostningNavn(),
                    kapacitetsomkostningElement.getKapacitetsomkostningPris(),
            };

            listeAfKapacitetsomkostninger.add(stringKapacitetsomkostningElement);


            String[] stringKapacitetsomkostningElementMedEnheder = new String[]{
                    kapacitetsomkostningElement.getKapacitetsomkostningNavn(),
                    kapacitetsomkostningElement.getKapacitetsomkostningPris() + " kr"
            };

            listeAfKapacitetsomkostningerMedEnheder.add(stringKapacitetsomkostningElementMedEnheder);


            int totalKapacitetsomkostninger = 0;

            for (int i = 0; i < listeAfKapacitetsomkostninger.size(); i++) {
                totalKapacitetsomkostninger += Integer.parseInt(listeAfKapacitetsomkostninger.get(i)[1]);

            }

            if (listeAfKapacitetsomkostninger.size() > 0) {
                udregnKapacitetsomkostningResultat.setVisibility(View.VISIBLE);
                kapacitetsomkostningResultatText.setVisibility(View.VISIBLE);
            }

            table3.setDataAdapter(new SimpleTableDataAdapter(this, listeAfKapacitetsomkostningerMedEnheder));
            udregnKapacitetsomkostningResultat.setText(Integer.toString(totalKapacitetsomkostninger) + " kr");
            model.setOevrigeKapacitetsomkostninger(totalKapacitetsomkostninger);

            kapacitetsomkostningNavnInput.setText("");
            kapacitetsomkostningPrisInput.setText("");

            kapacitetsomkostningNavnInput.setVisibility(View.GONE);
            kapacitetsomkostningPrisInput.setVisibility(View.GONE);
            tilfoejTilKapacitetsomkostningKnap.setVisibility(View.GONE);
            kapacitetsomkostningNavnInput.setEnabled(false);
            kapacitetsomkostningPrisInput.setEnabled(false);
            tilfoejTilKapacitetsomkostningKnap.setEnabled(false);

            kapacitetsomkostningImage.setVisibility(View.VISIBLE);
            kapacitetsomkostningText.setVisibility(View.VISIBLE);
            kapacitetsomkostningImage.setEnabled(true);
            kapacitetsomkostningText.setEnabled(true);

            godkendKapacitetsomkostningerKnap.setVisibility(View.VISIBLE);
            godkendKapacitetsomkostningerKnap.setEnabled(true);

        } else {

            Toast.makeText(getApplicationContext(), "Udfyld venligst alle felter", Toast.LENGTH_SHORT).show();

        }

    }

    public void tilfoejTilKapacitetsomkostninger(View view) {

        kapacitetsomkostningNavnInput.setVisibility(View.VISIBLE);
        kapacitetsomkostningPrisInput.setVisibility(View.VISIBLE);
        tilfoejTilKapacitetsomkostningKnap.setVisibility(View.VISIBLE);
        kapacitetsomkostningNavnInput.setEnabled(true);
        kapacitetsomkostningPrisInput.setEnabled(true);
        tilfoejTilKapacitetsomkostningKnap.setEnabled(true);

        kapacitetsomkostningImage.setVisibility(View.GONE);
        kapacitetsomkostningText.setVisibility(View.GONE);
        kapacitetsomkostningImage.setEnabled(false);
        kapacitetsomkostningText.setEnabled(false);

    }

    public void godkendKapacitetsomkostninger(View view) {

        if(listeAfKapacitetsomkostninger.size() >0 ){

            Intent intent = new Intent(this, AndroidView.class);

            intent.putExtra("modelObject", model);

            setResult(Activity.RESULT_OK,intent);

        }

        finish();

    }

    public void opdaterTal(){

        if( (!(kapacitetsomkostningPrisInput.getText().toString().equals("")) ) && !(kapacitetsomkostningNavnInput.getText().toString().equals("")) ){
            kapacitetsomkostningElement.setKapacitetsomkostningPris( Integer.toString( ( Integer.parseInt(kapacitetsomkostningPrisInput.getText().toString()) )) );
        }

    }

}