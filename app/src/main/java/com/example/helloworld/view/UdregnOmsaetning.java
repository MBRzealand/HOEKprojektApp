package com.example.helloworld.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

    EditText afsaetningInput;
    EditText salgsprisInput;
    TextView udregnOmsaetningResultat;
    TextView omsaetningText;
    TextView omsaetningResultatText;

    ImageView omsaetningImage;

    Button tilfoejTilOmsaetningKnap;




    List<String[]> listeAfOmsaetning;
    List<String[]> listeAfOmsaetningMedEnheder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udregn_omsaetning);

        model = (Model) getIntent().getSerializableExtra("modelObject");

        table = findViewById(R.id.tableView);
        table.setHeaderAdapter(new SimpleTableHeaderAdapter(this,"Afsætning", "Salgspris", "Omsætning"));


        afsaetningInput = findViewById(R.id.afsaetningInput);
        salgsprisInput = findViewById(R.id.salgsprisInput);
        udregnOmsaetningResultat = findViewById(R.id.udregnOmsaetningResultat);

        tilfoejTilOmsaetningKnap = findViewById(R.id.tilfoejTilOmsaetningKnap);
        omsaetningText = findViewById(R.id.omsaetningText);
        omsaetningResultatText = findViewById(R.id.omsaetningResultatText);
        omsaetningImage = findViewById(R.id.omsaetningImage);


        afsaetningInput.setVisibility(View.GONE);
        salgsprisInput.setVisibility(View.GONE);
        tilfoejTilOmsaetningKnap.setVisibility(View.GONE);
        afsaetningInput.setEnabled(false);
        salgsprisInput.setEnabled(false);
        tilfoejTilOmsaetningKnap.setEnabled(false);

        omsaetningResultatText.setVisibility(View.GONE);
        udregnOmsaetningResultat.setVisibility(View.GONE);


        listeAfOmsaetning = new ArrayList<String[]>();
        listeAfOmsaetningMedEnheder = new ArrayList<String[]>();



        afsaetningInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( afsaetningInput.getText().toString().equals("")) {
                        afsaetningInput.setText(Integer.toString(0));
                        omsaetningElement.setAfsaetning(Integer.toString(0));
                    } else {
                        omsaetningElement.setAfsaetning(afsaetningInput.getText().toString());
                    }
                }

                if( !(afsaetningInput.getText().toString().equals("")) && !(salgsprisInput.getText().toString().equals("")) ){
                    omsaetningElement.setOmsaetning( Integer.toString( ( Integer.parseInt(afsaetningInput.getText().toString()) * ( Integer.parseInt(salgsprisInput.getText().toString() )) )) );
                }

            }
        });

        salgsprisInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( salgsprisInput.getText().toString().equals("")) {
                        salgsprisInput.setText(Integer.toString(0));
                        omsaetningElement.setSalgspris(Integer.toString(0));
                    } else {
                        omsaetningElement.setSalgspris(Integer.toString(Integer.parseInt(salgsprisInput.getText().toString())));
                    }
                }

                if( !(afsaetningInput.getText().toString().equals("")) && !(salgsprisInput.getText().toString().equals("")) ){
                    omsaetningElement.setOmsaetning( Integer.toString (( Integer.parseInt(afsaetningInput.getText().toString())  * ( Integer.parseInt(salgsprisInput.getText().toString() )) ) ));

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

        String [] stringOmsaetningsElement = new String[]{
                omsaetningElement.getAfsaetning(),
                omsaetningElement.getSalgspris(),
                omsaetningElement.getOmsaetning()
        };

        listeAfOmsaetning.add(stringOmsaetningsElement);



        String [] stringOmsaetningsElementMedEnheder = new String[]{
                omsaetningElement.getAfsaetning() + " stk",
                omsaetningElement.getSalgspris() + " kr",
                omsaetningElement.getOmsaetning() + " kr"
        };

        listeAfOmsaetningMedEnheder.add(stringOmsaetningsElementMedEnheder);


        int totalOmsaetning = 0;

        for (int i = 0; i < listeAfOmsaetning.size(); i++) {
            totalOmsaetning += Integer.parseInt(listeAfOmsaetning.get(i)[2]);

        }

        if(listeAfOmsaetning.size() > 0){
            udregnOmsaetningResultat.setVisibility(View.VISIBLE);
            omsaetningResultatText.setVisibility(View.VISIBLE);
        }

        table.setDataAdapter(new SimpleTableDataAdapter(this,  listeAfOmsaetningMedEnheder));
        udregnOmsaetningResultat.setText(Integer.toString(totalOmsaetning) + " kr");

        salgsprisInput.setText("");
        afsaetningInput.setText("");

        afsaetningInput.setVisibility(View.GONE);
        salgsprisInput.setVisibility(View.GONE);
        tilfoejTilOmsaetningKnap.setVisibility(View.GONE);
        afsaetningInput.setEnabled(false);
        salgsprisInput.setEnabled(false);
        tilfoejTilOmsaetningKnap.setEnabled(false);

        omsaetningImage.setVisibility(View.VISIBLE);
        omsaetningText.setVisibility(View.VISIBLE);
        omsaetningImage.setEnabled(true);
        omsaetningText.setEnabled(true);


    }


    public void tilfoejVareTilOmsaetning(View view) {

        afsaetningInput.setVisibility(View.VISIBLE);
        salgsprisInput.setVisibility(View.VISIBLE);
        tilfoejTilOmsaetningKnap.setVisibility(View.VISIBLE);
        afsaetningInput.setEnabled(true);
        salgsprisInput.setEnabled(true);
        tilfoejTilOmsaetningKnap.setEnabled(true);

        omsaetningImage.setVisibility(View.GONE);
        omsaetningText.setVisibility(View.GONE);
        omsaetningImage.setEnabled(false);
        omsaetningText.setEnabled(false);

    }
}