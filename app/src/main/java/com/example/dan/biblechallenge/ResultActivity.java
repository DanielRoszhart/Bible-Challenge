package com.example.dan.biblechallenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class ResultActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        addListenerOnButton();
    }

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
