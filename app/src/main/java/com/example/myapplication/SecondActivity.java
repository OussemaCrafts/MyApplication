package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView textGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textGreeting = findViewById(R.id.textGreeting);

        String name = getIntent().getStringExtra("user_name"); // récupérer la donnée
        textGreeting.setText("Salut " + name + " !");
    }
}
