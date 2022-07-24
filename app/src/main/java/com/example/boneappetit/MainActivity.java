package com.example.boneappetit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    ImageView icon;
    Button startOrder;
    EditText userText;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userText = (EditText) findViewById(R.id.userName);
        startOrder = (Button) findViewById(R.id.order);

        startOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = userText.getText().toString();  //pull the name from the textbox
                Intent startOrder = new Intent(MainActivity.this, OrderActivity.class);
                startOrder.putExtra("userName", user);
                startActivity(startOrder);
            }
        });


        }
    }
