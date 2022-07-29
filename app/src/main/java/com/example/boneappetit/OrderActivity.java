package com.example.boneappetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

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
    Button calculate, submitBTN;
    TextView totalTV;
    TextView hi;
    String order ="";
    double total = 0.0;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent incomingIntent = getIntent();

        user = incomingIntent.getStringExtra("userName");
        treat1Check = (CheckBox) findViewById(R.id.treat1);
        treat2Check = (CheckBox) findViewById(R.id.treat2);
        treat3Check = (CheckBox) findViewById(R.id.treat3);
        largeRB = (RadioButton) findViewById(R.id.treat3Large);
        hi = (TextView) findViewById(R.id.hello);
        medRB = (RadioButton) findViewById(R.id.treat3Med);
        smallRB = (RadioButton) findViewById(R.id.treat3Small);
        treat3RG = (RadioGroup) findViewById(R.id.treat3Choices);
        calculate = (Button) findViewById(R.id.calc);
        submitBTN = (Button) findViewById(R.id.submitOrder);
        totalTV = (TextView) findViewById(R.id.totalView);
        hi.setText("Hello " + user);
        treat1Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (treat1Check.isChecked()) {
                    total = total + 4;
                    order = order + "Dipped Bones \n";
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
                    order = order + "Peanut Butter Bacon Bones \n";
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
                                        order = order + "Large Bully Sticks \n";
                                        prevRB = R.id.treat3Large;
                                    } else if (medRB.isChecked()) {
                                        if (prevRB == R.id.treat3Large) {
                                            total = total - 5;}
                                        else if (prevRB == R.id.treat3Small) {
                                            total = total - 3;}
                                        total = total + 4;
                                        order = order + "Medium Bully Sticks \n";
                                        prevRB = R.id.treat3Med;
                                    } else if (smallRB.isChecked()) {
                                        if (prevRB == R.id.treat3Med) {
                                            total = total - 4;}
                                        else if (prevRB == R.id.treat3Large) {
                                            total = total - 5;}
                                        total = total + 3;
                                        order = order + "Small Bully Sticks \n ";
                                        prevRB = R.id.treat3Small;
                                    }


                                }
                                else if (!treat3Check.isChecked()){
                                    if (prevRB == R.id.treat3Med) {
                                        total = total - 4;
                                        prevRB = 0;}
                                    else if (prevRB == R.id.treat3Large) {
                                        total = total - 5;
                                        prevRB = 0;}
                                    else if (prevRB == R.id.treat3Small) {
                                        total = total - 3;
                                        prevRB = 0;}
                                    smallRB.setChecked(false);
                                    medRB.setChecked(false);
                                    largeRB.setChecked(false);
                                }



                totalTV.setText("Subtotal $" + total + "\n Total with taxes $" + (df.format(total * 1.06)));
                order = order+ " " + totalTV.getText();
            }


        });
        submitBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String subj = user + "'s BoneAppetit Order";
                String bod = order;
                composeEmail(subj, bod);

            }
        });
    }
    public void composeEmail(String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        String owner = "katherine.mack@gbcseagles.org";
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, owner);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Define what your app should do if no activity can handle the intent.
        }

    }
}


