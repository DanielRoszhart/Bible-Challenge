package com.example.dan.biblechallenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
public class ResultActivity extends AppCompatActivity {
    private Button button;
    @Override
    //Grab the score from the last layout and display in a textview
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        TextView t=(TextView)findViewById(R.id.txtViewResult);
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        t.setText("You answered: " + Integer.toString(score) + " out of 10! ");
        addListenerOnButton();
    }
    //Go to category activity if the user taps the button
    public void addListenerOnButton () {
        final Context context = this;
        button = (Button) findViewById(R.id.btnGo);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
