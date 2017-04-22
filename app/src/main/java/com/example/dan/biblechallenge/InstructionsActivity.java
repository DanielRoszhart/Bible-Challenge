package com.example.dan.biblechallenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class InstructionsActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        final Context context = this;
        button = (Button) findViewById(R.id.btnStart);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Bundle b = getIntent().getExtras();
                String value = b.getString("category");
                if (value.equals("When")) {
                    Intent myIntent = new Intent(context, WhenQuestionActivity.class);
                    startActivity(myIntent);
                }
                if (value.equals("Where")) {
                    Intent myIntent = new Intent(context, WhereQuestionActivity.class);
                    startActivity(myIntent);
                }
                if (value.equals("Who")) {
                    Intent myIntent = new Intent(context, WhoQuestionActivity.class);
                    startActivity(myIntent);
                }
                if (value.equals("What")) {
                    Intent myIntent = new Intent(context, WhatQuestionActivity.class);
                    startActivity(myIntent);
                }
                if (value.equals("Why")) {
                    Intent myIntent = new Intent(context, WhyQuestionActivity.class);
                    startActivity(myIntent);
                }
            }
        });

    }
}