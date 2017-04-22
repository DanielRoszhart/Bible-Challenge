package com.example.dan.biblechallenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.Random;

public class CategoryActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        addListenerOnButton();
    }

    public void addListenerOnButton () {
        final Context context = this;
        button = (Button) findViewById(R.id.btnPush);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String[] mycategory = {"Who", "What", "When", "Where", "Why"};
                int i = new Random().nextInt(mycategory.length);
                TextView textView = (TextView) findViewById(R.id.Category_Result);
                textView.setText(mycategory[i]);

                if (mycategory[i].equals("Where")) {
                    Intent myIntent = new Intent(CategoryActivity.this, InstructionsActivity.class);
                    Bundle b = new Bundle();
                    b.putString("category", "Where"); //Your score
                    myIntent.putExtras(b); //Put your score to your next Intent
                    startActivity(myIntent);
                }
                if (mycategory[i].equals("Who")) {
                    Intent myIntent = new Intent(CategoryActivity.this, InstructionsActivity.class);
                    Bundle b = new Bundle();
                    b.putString("category", "Who"); //Your score
                    myIntent.putExtras(b); //Put your score to your next Intent
                    startActivity(myIntent);
                }
                if (mycategory[i].equals("Why")) {
                    Intent myIntent = new Intent(CategoryActivity.this, InstructionsActivity.class);
                    Bundle b = new Bundle();
                    b.putString("category", "Why"); //Your score
                    myIntent.putExtras(b); //Put your score to your next Intent
                    startActivity(myIntent);
                }
                if (mycategory[i].equals("What")) {
                    Intent myIntent = new Intent(CategoryActivity.this, InstructionsActivity.class);
                    Bundle b = new Bundle();
                    b.putString("category", "What"); //Your score
                    myIntent.putExtras(b); //Put your score to your next Intent
                    startActivity(myIntent);
                    startActivity(myIntent);
                }
                if (mycategory[i].equals("When")) {
                    Intent myIntent = new Intent(CategoryActivity.this, InstructionsActivity.class);
                    Bundle b = new Bundle();
                    b.putString("category", "When"); //Your score
                    myIntent.putExtras(b); //Put your score to your next Intent
                    startActivity(myIntent);
                }
            }
        });

    }
}
