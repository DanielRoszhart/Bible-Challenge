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
public class WhenQuestionActivity extends AppCompatActivity implements View.OnClickListener{
    private int score = 0;
    private int qid = 0;
    private Button btnA, btnB, btnC, btnD;
    private TextView txtQuestion;
    private List<QuestionsTable> whenQuesList;
    private QuestionsTable currentWhenQ;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        MySQLiteHelper db = new MySQLiteHelper(this);
        whenQuesList = db.getAllWhens();
        currentWhenQ = whenQuesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.txtViewQuestion);
        final TextView myTimer = (TextView) findViewById(R.id.txtViewTimer);
        btnA = (Button) findViewById(R.id.btnOptionA);
        btnB = (Button) findViewById(R.id.btnOptionB);
        btnC = (Button) findViewById(R.id.btnOptionC);
        btnD = (Button) findViewById(R.id.btnOptionD);
        setWhenQuestionView();
        countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                myTimer.setText(millisUntilFinished / 1000 + " seconds remaining");
            }
            public void onFinish()
            {
                myTimer.setText("Done!");
                Intent intent = new Intent(WhenQuestionActivity.this, ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
            }
        }.start();
    }
    public void onClick(View v) {
        if (v.getId() == R.id.btnOptionA || v.getId() == R.id.btnOptionB
                || v.getId()==R.id.btnOptionC || v.getId() == R.id.btnOptionD) {

            if (currentWhenQ.getAnswer().equals(((TextView) v).getText())) {
                score++;
            } else {
                Log.e("Yolo", "Right Answer " + currentWhenQ.getAnswer());
            }
            if (qid < 10) {
                currentWhenQ = whenQuesList.get(qid);
                setWhenQuestionView();
            } else {
                countDownTimer.cancel();
                Intent intent = new Intent(WhenQuestionActivity.this, ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
            }
        }
    }
    public void setWhenQuestionView() {
        txtQuestion.setText(currentWhenQ.getQuestion());
        btnA.setText(currentWhenQ.getMultipleChoiceA());
        btnB.setText(currentWhenQ.getMultipleChoiceB());
        btnC.setText(currentWhenQ.getMultipleChoiceC());
        btnD.setText(currentWhenQ.getMultipleChoiceD());
        qid++;
    }
}