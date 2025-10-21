package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    TextView lblHeader;
    EditText dep1, dep2;
    Button btnEnvoyer;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        lblHeader = findViewById(R.id.lblHeader);
        dep1 = findViewById(R.id.dep1);
        dep2 = findViewById(R.id.dep2);
        btnEnvoyer = findViewById(R.id.btnEnvoyer);

        userName = getIntent().getStringExtra("user_name");
        lblHeader.setText("Salut " + userName + " 👋");

        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d1 = Double.parseDouble(dep1.getText().toString());
                double d2 = Double.parseDouble(dep2.getText().toString());

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("user_name", userName);
                bundle.putDouble("dep1", d1);
                bundle.putDouble("dep2", d2);
                intent.putExtras(bundle);

                // On attend un résultat (total calculé) de ThirdActivity
                startActivityForResult(intent, 101);
            }
        });
    }

    // Récupérer le résultat de ThirdActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            double total = bundle.getDouble("total");
            lblHeader.setText("Salut " + userName + " 👋\nTotal des dépenses : " + total + " DT");
        }
    }
}
