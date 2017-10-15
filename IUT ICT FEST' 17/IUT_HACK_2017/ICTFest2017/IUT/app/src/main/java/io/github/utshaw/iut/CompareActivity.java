package io.github.utshaw.iut;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by Utshaw on 10/14/2017.
 */

public class CompareActivity extends FragmentActivity {

    private TextView txtOutput;
    private double mileAge = 12.5;
    private double mileAgeBus = 2.00;
    private Button okButton;
    private Button cancelButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);



        txtOutput = (TextView) findViewById(R.id.textView1);

        double dist = getIntent().getDoubleExtra("dist",0.0);
        double carCost = dist * mileAge;
        double busCost = dist * mileAgeBus;

        txtOutput.setText("Private Transport:  " + formatMagnitude(carCost) + "Tk.");
        txtOutput.append("\nPublic Transport: " + formatMagnitude(busCost) + "Tk.");
        txtOutput.append("\nSave: " + formatMagnitude((carCost - busCost)) + "Tk.");

        okButton = (Button) findViewById(R.id.ok_btn_id);
        cancelButton = (Button) findViewById(R.id.cancel_btn_id);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompareActivity.this, "Your code has been verified.\nHave a safe trip", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private String formatMagnitude(double magnitude)
    {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.00");
        return magnitudeFormat.format(magnitude);
    }


}
