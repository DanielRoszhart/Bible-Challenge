package com.example.dan.biblechallenge;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import static android.R.attr.value;

public class CategoryActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        pickCategoryOnButton();


    }
    public void pickCategoryOnButton() {

        button = (Button) findViewById(R.id.btnPush);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String[] category = {"Who", "What", "When", "Where", "Why"};
                int i = new Random().nextInt(category.length);
                TextView textView = (TextView) findViewById(R.id.Category_Result);
                textView.setText(category[i]);
                if ("Who".equals(category[i]) ) {

                    Intent myIntent= new Intent(CategoryActivity.this, QuestionActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("category", i); //Your score
                    myIntent.putExtras(b); //Put your score to your next Intent
                    startActivity(myIntent);
                }
                if ("What".equals(category[i]) ) {

                }

            }
        });
    }



}
