package com.example.helloworld.view;

import android.content.Context;
import android.util.Log;
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

        table.setDataAdapter(new SimpleTableDataAdapter(this,  listeAfOmsaetningMedEnheder));
        udregnOmsaetningResultat.setText(Integer.toString(totalOmsaetning) + " kr");

        salgsprisInput.setText("");
        afsaetningInput.setText("");

    }


}