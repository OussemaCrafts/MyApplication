package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class ThirdActivity extends Activity {

    TextView txtResult;
    Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txtResult = findViewById(R.id.txtResult);
        btnRetour = findViewById(R.id.btnRetour);

        Bundle bundle = getIntent().getExtras();
        String user = bundle.getString("user_name");
        double d1 = bundle.getDouble("dep1");
        double d2 = bundle.getDouble("dep2");
        double total = d1 + d2;

        txtResult.setText("Voila " + user + " !\n\n"
                + "Dépense 1 : " + d1 + " DT\n"
                + "Dépense 2 : " + d2 + " DT\n\n"
                + "💰 Total : " + total + " DT");

        // Ajouter le total au bundle pour le renvoyer
        bundle.putDouble("total", total);
        Intent resultIntent = new Intent();
        resultIntent.putExtras(bundle);
        setResult(Activity.RESULT_OK, resultIntent);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // retourne à SecondActivity
            }
        });
    }
}
