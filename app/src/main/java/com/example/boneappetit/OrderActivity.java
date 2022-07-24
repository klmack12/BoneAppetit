package com.example.boneappetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    RadioButton medRB;
    RadioButton smallRB;
    String user;
    Button calculate;
    TextView totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent incomingIntent = getIntent();
        user = incomingIntent.getStringExtra("" + R.id.userName);

        treat1Check = (CheckBox) findViewById(R.id.treat1);
        treat2Check = (CheckBox) findViewById(R.id.treat2);
        totalTV = (TextView) findViewById(R.id.totalView);
        treat1Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(treat1Check.isChecked()) {
                    totalTV.setText("4");

                }
            }
        });

    }
    public void checkbox_clicked(View v)
    {

        if(treat1Check.isChecked())
        {
            // true,do the task

        }
        else
        {

        }

    }
}