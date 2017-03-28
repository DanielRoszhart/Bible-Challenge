package com.example.dan.biblechallenge;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

import org.w3c.dom.Text;


public class QuestionActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);


        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                TextView textView = (TextView) findViewById(R.id.txtViewTimer);
                textView.setText( millisUntilFinished / 1000 + " seconds remaining");
            }

            public void onFinish() {
                TextView textView = (TextView) findViewById(R.id.txtViewTimer);
                textView.setText("Done!");
                nextScreen();
            }

            public void nextScreen() {
                Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                startActivity(intent);
            }


        }.start();


    }
}
