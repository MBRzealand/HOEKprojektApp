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
import com.example.helloworld.model.VareforbrugElement;
import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

import java.util.ArrayList;
import java.util.List;

public class UdregnVareforbrug extends AppCompatActivity {

    Model model;
    VareforbrugElement vareforbrugElement = new VareforbrugElement();

    TableView<String[]> table2;

    EditText vareforbrugNavnInput;
    EditText opkoebInput;
    EditText koebsprisInput;

    TextView udregnVareforbrugResultat;
    TextView vareforbrugText;
    TextView vareforbrugResultatText;

    ImageButton vareforbrugImage;
    ImageButton tilfoejTilVareforbrugKnap;

    Button godkendVareforbrugKnap;




    List<String[]> listeAfVareforbrug;
    List<String[]> listeAfVareforbrugMedEnheder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udregn_vareforbrug);


        model = (Model) getIntent().getSerializableExtra("modelObject");

        table2 = findViewById(R.id.tableView2);
        table2.setHeaderAdapter(new SimpleTableHeaderAdapter(this,"Varenavn","Opkøb", "Købspris", "Total"));


        vareforbrugNavnInput = findViewById(R.id.vareforbrugNavnInput);
        opkoebInput = findViewById(R.id.opkoebInput);
        koebsprisInput = findViewById(R.id.koebsprisInput);
        udregnVareforbrugResultat = findViewById(R.id.udregnVareforbrugResultat);

        tilfoejTilVareforbrugKnap = findViewById(R.id.tilfoejTilVareforbrugKnap);
        vareforbrugText = findViewById(R.id.vareforbrugText);
        vareforbrugResultatText = findViewById(R.id.vareforbrugResultatText);
        vareforbrugImage = findViewById(R.id.vareforbrugImage);

        godkendVareforbrugKnap = findViewById(R.id.godkendVareforbrugKnap);

        godkendVareforbrugKnap.setVisibility(View.GONE);
        godkendVareforbrugKnap.setEnabled(false);

        vareforbrugNavnInput.setVisibility(View.GONE);
        opkoebInput.setVisibility(View.GONE);
        koebsprisInput.setVisibility(View.GONE);
        tilfoejTilVareforbrugKnap.setVisibility(View.GONE);
        vareforbrugNavnInput.setEnabled(false);
        opkoebInput.setEnabled(false);
        koebsprisInput.setEnabled(false);
        tilfoejTilVareforbrugKnap.setEnabled(false);

        vareforbrugResultatText.setVisibility(View.GONE);
        udregnVareforbrugResultat.setVisibility(View.GONE);


        listeAfVareforbrug = new ArrayList<String[]>();
        listeAfVareforbrugMedEnheder = new ArrayList<String[]>();


        vareforbrugNavnInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( vareforbrugNavnInput.getText().toString().equals("")) {
                        vareforbrugNavnInput.setText("Intet Navn");
                        vareforbrugElement.setVarenavn("Intet Navn");
                    } else {
                        vareforbrugElement.setVarenavn(vareforbrugNavnInput.getText().toString());
                    }
                }

                if( (!(opkoebInput.getText().toString().equals("")) && !(koebsprisInput.getText().toString().equals(""))) && !(vareforbrugNavnInput.getText().toString().equals("")) ){
                    vareforbrugElement.setVareforbrug( Integer.toString( ( Integer.parseInt(opkoebInput.getText().toString()) * ( Integer.parseInt(koebsprisInput.getText().toString() )) )) );
                }

            }
        });


        opkoebInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( opkoebInput.getText().toString().equals("")) {
                        opkoebInput.setText(Integer.toString(0));
                        vareforbrugElement.setOpkoeb(Integer.toString(0));
                    } else {
                        vareforbrugElement.setOpkoeb(opkoebInput.getText().toString());
                    }
                }

                if( (!(opkoebInput.getText().toString().equals("")) && !(koebsprisInput.getText().toString().equals(""))) && !(vareforbrugNavnInput.getText().toString().equals("")) ){
                    vareforbrugElement.setVareforbrug( Integer.toString( ( Integer.parseInt(opkoebInput.getText().toString()) * ( Integer.parseInt(koebsprisInput.getText().toString() )) )) );
                }

            }
        });

        koebsprisInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus) {
                    if ( koebsprisInput.getText().toString().equals("")) {
                        koebsprisInput.setText(Integer.toString(0));
                        vareforbrugElement.setKoebsPris(Integer.toString(0));
                    } else {
                        vareforbrugElement.setKoebsPris(Integer.toString(Integer.parseInt(koebsprisInput.getText().toString())));
                    }
                }

                if( (!(opkoebInput.getText().toString().equals("")) && !(koebsprisInput.getText().toString().equals(""))) && !(vareforbrugNavnInput.getText().toString().equals("")) ){
                    vareforbrugElement.setVareforbrug( Integer.toString (( Integer.parseInt(opkoebInput.getText().toString())  * ( Integer.parseInt(koebsprisInput.getText().toString() )) ) ));

                }

                koebsprisInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            koebsprisInput.clearFocus();
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



    public void tilbageFraUdregnVareforbrug(View view) {

        finish();

    }

    public void addElementToTable(View view) {

        if( (!vareforbrugNavnInput.getText().toString().equals("") && !opkoebInput.getText().toString().equals("")) && !koebsprisInput.getText().toString().equals("") ) {

            String[] stringVareforbrugElement = new String[]{
                    vareforbrugElement.getVarenavn(),
                    vareforbrugElement.getOpkoeb(),
                    vareforbrugElement.getKoebsPris(),
                    vareforbrugElement.getVareforbrug()
            };

            listeAfVareforbrug.add(stringVareforbrugElement);


            String[] stringVareforbrugElementMedEnheder = new String[]{
                    vareforbrugElement.getVarenavn(),
                    vareforbrugElement.getOpkoeb() + " stk",
                    vareforbrugElement.getKoebsPris() + " kr",
                    vareforbrugElement.getVareforbrug() + " kr"
            };

            listeAfVareforbrugMedEnheder.add(stringVareforbrugElementMedEnheder);


            int totalVareforbrug = 0;

            for (int i = 0; i < listeAfVareforbrug.size(); i++) {
                totalVareforbrug += Integer.parseInt(listeAfVareforbrug.get(i)[3]);

            }

            if (listeAfVareforbrug.size() > 0) {
                udregnVareforbrugResultat.setVisibility(View.VISIBLE);
                vareforbrugResultatText.setVisibility(View.VISIBLE);
            }

            table2.setDataAdapter(new SimpleTableDataAdapter(this, listeAfVareforbrugMedEnheder));
            udregnVareforbrugResultat.setText(Integer.toString(totalVareforbrug) + " kr");
            model.setVareforbrug(totalVareforbrug);

            vareforbrugNavnInput.setText("");
            koebsprisInput.setText("");
            opkoebInput.setText("");

            vareforbrugNavnInput.setVisibility(View.GONE);
            opkoebInput.setVisibility(View.GONE);
            koebsprisInput.setVisibility(View.GONE);
            tilfoejTilVareforbrugKnap.setVisibility(View.GONE);
            vareforbrugNavnInput.setEnabled(false);
            opkoebInput.setEnabled(false);
            koebsprisInput.setEnabled(false);
            tilfoejTilVareforbrugKnap.setEnabled(false);

            vareforbrugImage.setVisibility(View.VISIBLE);
            vareforbrugText.setVisibility(View.VISIBLE);
            vareforbrugImage.setEnabled(true);
            vareforbrugText.setEnabled(true);

            godkendVareforbrugKnap.setVisibility(View.VISIBLE);
            godkendVareforbrugKnap.setEnabled(true);

        } else {

            Toast.makeText(getApplicationContext(), "Udfyld venligst alle felter", Toast.LENGTH_SHORT).show();

        }


    }

    public void tilfoejVareTilVareforbrug(View view) {

        vareforbrugNavnInput.setVisibility(View.VISIBLE);
        opkoebInput.setVisibility(View.VISIBLE);
        koebsprisInput.setVisibility(View.VISIBLE);
        tilfoejTilVareforbrugKnap.setVisibility(View.VISIBLE);
        vareforbrugNavnInput.setEnabled(true);
        opkoebInput.setEnabled(true);
        koebsprisInput.setEnabled(true);
        tilfoejTilVareforbrugKnap.setEnabled(true);

        vareforbrugImage.setVisibility(View.GONE);
        vareforbrugText.setVisibility(View.GONE);
        vareforbrugImage.setEnabled(false);
        vareforbrugText.setEnabled(false);
    }

    public void godkendVareforbrug(View view) {

        if(listeAfVareforbrug.size() >0 ){

            Intent intent = new Intent(this, AndroidView.class);

            intent.putExtra("modelObject", model);

            setResult(Activity.RESULT_OK,intent);

        }

        finish();

    }
}