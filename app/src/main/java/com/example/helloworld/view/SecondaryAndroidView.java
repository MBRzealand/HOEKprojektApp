package com.example.helloworld.view;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;
import com.example.helloworld.model.Model;

public class SecondaryAndroidView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Model model = (Model) getIntent().getSerializableExtra("modelObject");

        setContentView(R.layout.activity_secondary);

        TextView outputView = findViewById(R.id.outputView);

        outputView.setText(model.getData());

    }

}