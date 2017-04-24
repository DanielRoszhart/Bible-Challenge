package com.example.dan.biblechallenge;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
public class WhatQuestionActivity extends AppCompatActivity implements View.OnClickListener{
    private int score = 0;
    private int qid = 0;
    private Button btnA, btnB, btnC, btnD;
    private TextView txtQuestion;
    private List<QuestionsTable> whatQuesList;
    private  QuestionsTable currentWhatQ;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        //access the database and get all what questions
        MySQLiteHelper db = new MySQLiteHelper(this);
        whatQuesList = db.getAllWhats();
        currentWhatQ = whatQuesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.txtViewQuestion);
        final TextView myTimer = (TextView) findViewById(R.id.txtViewTimer);
        btnA = (Button) findViewById(R.id.btnOptionA);
        btnB = (Button) findViewById(R.id.btnOptionB);
        btnC = (Button) findViewById(R.id.btnOptionC);
        btnD = (Button) findViewById(R.id.btnOptionD);
        setWhatQuestionView();
        countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                myTimer.setText(millisUntilFinished / 1000 + " seconds remaining");
            }
            public void onFinish()
            {
                myTimer.setText("Done!");
                Intent intent = new Intent(WhatQuestionActivity.this, ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
            }
        }.start();
    }
    //Run through the questions and display the question in a textview and possible answers
    //on the buttons
    public void onClick(View v) {
        if (v.getId() == R.id.btnOptionA || v.getId() == R.id.btnOptionB
                || v.getId()==R.id.btnOptionC || v.getId() == R.id.btnOptionD) {

            if (currentWhatQ.getAnswer().equals(((TextView) v).getText())) {
                score++;
            } else {
                Log.e("Yolo", "Right Answer " + currentWhatQ.getAnswer());
            }
            if (qid < 10) {
                currentWhatQ = whatQuesList.get(qid);
                setWhatQuestionView();
            } else {
                countDownTimer.cancel();
                Intent intent = new Intent(WhatQuestionActivity.this, ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
            }
        }
    }
    //Method to set the textview and buttons with the why question and possible answers
    public void setWhatQuestionView() {
        txtQuestion.setText(currentWhatQ.getQuestion());
        btnA.setText(currentWhatQ.getMultipleChoiceA());
        btnB.setText(currentWhatQ.getMultipleChoiceB());
        btnC.setText(currentWhatQ.getMultipleChoiceC());
        btnD.setText(currentWhatQ.getMultipleChoiceD());
        qid++;
    }
}