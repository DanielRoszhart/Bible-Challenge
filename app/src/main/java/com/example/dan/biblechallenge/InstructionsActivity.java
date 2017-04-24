package com.example.dan.biblechallenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class InstructionsActivity extends AppCompatActivity {
    private Button button;
    private String myvalue;
    private Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);
        Bundle b = getIntent().getExtras();
        myvalue= b.getString("category");
        addListenerOnButton();
    }
    //Whatever category is chosen compare with the if statement and go to that class.
    public void addListenerOnButton() {
        final Context context = this;
        button = (Button) findViewById(R.id.btnStart);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (myvalue.equals("When")) {
                    myIntent = new Intent(context, WhenQuestionActivity.class);
                    startActivity(myIntent);
                }
                if (myvalue.equals("Where")) {
                    myIntent = new Intent(context, WhereQuestionActivity.class);
                    startActivity(myIntent);
                }
                if (myvalue.equals("Who")) {
                    myIntent = new Intent(context, WhoQuestionActivity.class);
                    startActivity(myIntent);
                }
                if (myvalue.equals("What")) {
                    myIntent = new Intent(context, WhatQuestionActivity.class);
                    startActivity(myIntent);
                }
                if (myvalue.equals("Why")) {
                    myIntent = new Intent(context, WhyQuestionActivity.class);
                    startActivity(myIntent);
                }
            }
        });
    }
}