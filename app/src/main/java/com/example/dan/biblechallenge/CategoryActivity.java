package com.example.dan.biblechallenge;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

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
        button = (Button) findViewById(R.id.btnCategoryNext);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, InstructionsActivity.class);
                startActivity(intent);
            }
        });

    }
}
