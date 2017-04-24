package com.example.dan.biblechallenge;
//Program Name: Bible Challenge
//Date:         April 24, 2017
//Programmer:   Daniel Roszhart
//Description:  This is a game application about the Bible. The user can randomly pick a category
//              and then answer as many questions as possible within 60 seconds. When the user
//              finishes the score is displayed on another layout.
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton () {
    final Context context = this;
    button = (Button) findViewById(R.id.btnIntroNext);
    button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
    Intent intent = new Intent(context, CategoryActivity.class);
    startActivity(intent);
    }
    });
    }
}
