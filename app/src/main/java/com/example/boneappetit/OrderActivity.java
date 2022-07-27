package com.example.boneappetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {


    CheckBox treat1Check;
    CheckBox treat2Check;
    CheckBox treat3Check;
    RadioGroup treat3RG;
    RadioButton largeRB;
    int prevRB = 0;
    RadioButton medRB;
    RadioButton smallRB;
    String user;
    Button calculate;
    TextView totalTV;
    double total = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent incomingIntent = getIntent();
        user = incomingIntent.getStringExtra("" + R.id.userName);
        treat1Check = (CheckBox) findViewById(R.id.treat1);
        treat2Check = (CheckBox) findViewById(R.id.treat2);
        treat3Check = (CheckBox) findViewById(R.id.treat3);
        largeRB = (RadioButton) findViewById(R.id.treat3Large);

        medRB = (RadioButton) findViewById(R.id.treat3Med);
        smallRB = (RadioButton) findViewById(R.id.treat3Small);
        treat3RG = (RadioGroup) findViewById(R.id.treat3Choices);
        calculate = (Button) findViewById(R.id.calc);

        totalTV = (TextView) findViewById(R.id.totalView);
        treat1Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (treat1Check.isChecked()) {
                    total = total + 4;

                } else {
                    total = total - 4;

                }
            }
        });

        treat2Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (treat2Check.isChecked()) {
                    total = total + 3;

                } else {
                    total = total - 3;

                }
            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            /*    treat3Check.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        treat3RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                //  Log.d("chk", "id" + checkedId); */
                                if (treat3Check.isChecked()) {
                                    if (largeRB.isChecked()) {
                                        if (prevRB == R.id.treat3Med) {
                                            total = total - 4;}
                                        else if (prevRB == R.id.treat3Small) {
                                            total = total - 3;}

                                        total = total + 5;

                                        prevRB = R.id.treat3Large;
                                    } else if (medRB.isChecked()) {
                                        if (prevRB == R.id.treat3Large) {
                                            total = total - 5;}
                                        else if (prevRB == R.id.treat3Small) {
                                            total = total - 3;}
                                        total = total + 4;

                                        prevRB = R.id.treat3Med;
                                    } else if (smallRB.isChecked()) {
                                        if (prevRB == R.id.treat3Med) {
                                            total = total - 4;}
                                        else if (prevRB == R.id.treat3Large) {
                                            total = total - 5;}
                                        total = total + 3;

                                        prevRB = R.id.treat3Small;
                                    }


                                }
                                else if (!treat3Check.isChecked()){
                                    if (prevRB == R.id.treat3Med) {
                                        total = total - 4;}
                                    else if (prevRB == R.id.treat3Large) {
                                        total = total - 5;}
                                    else if (prevRB == R.id.treat3Small) {
                                        total = total - 3;}
                                }
                                totalTV.setText("" + total);
            }


        });
    }
}


