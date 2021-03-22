package com.example.helloworld.view;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;

import com.example.helloworld.model.Model;

public class AndroidView extends AppCompatActivity {

    Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendMessage(View view) {

        Intent intent = new Intent(this, SecondaryAndroidView.class);

        EditText inputText = findViewById(R.id.inputText);

        String textInput = inputText.getText().toString();

        model.setData(textInput);

        intent.putExtra("modelObject", model);

        startActivity(intent);

    }

}