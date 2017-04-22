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
public class WhereQuestionActivity extends AppCompatActivity implements View.OnClickListener{
    private int score = 0;
    private int qid = 0;
    private Button btnA, btnB, btnC, btnD;
    private TextView txtQuestion;
    private List<QuestionsTable> whereQuesList;
    private QuestionsTable currentWhereQ;
    private  CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        MySQLiteHelper db = new MySQLiteHelper(this);
        whereQuesList = db.getAllWheres();
        currentWhereQ = whereQuesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.txtViewQuestion);
        final TextView myTimer = (TextView) findViewById(R.id.txtViewTimer);
        btnA = (Button) findViewById(R.id.btnOptionA);
        btnB = (Button) findViewById(R.id.btnOptionB);
        btnC = (Button) findViewById(R.id.btnOptionC);
        btnD = (Button) findViewById(R.id.btnOptionD);
        setWhereQuestionView();
        countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                myTimer.setText(millisUntilFinished / 1000 + " seconds remaining");
            }
            public void onFinish()
            {
                myTimer.setText("Done!");
                Intent intent = new Intent(WhereQuestionActivity.this, ResultActivity.class);
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

            if (currentWhereQ.getAnswer().equals(((TextView) v).getText())) {
                score++;
            } else {
                Log.e("Yolo", "Right Answer " + currentWhereQ.getAnswer());
            }
            if (qid < 10) {
                currentWhereQ = whereQuesList.get(qid);
                setWhereQuestionView();
            } else {
                countDownTimer.cancel();
                Intent intent = new Intent(WhereQuestionActivity.this, ResultActivity.class);
                Bundle b = new Bundle();
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
            }
        }
    }
    public void setWhereQuestionView() {
        txtQuestion.setText(currentWhereQ.getQuestion());
        btnA.setText(currentWhereQ.getMultipleChoiceA());
        btnB.setText(currentWhereQ.getMultipleChoiceB());
        btnC.setText(currentWhereQ.getMultipleChoiceC());
        btnD.setText(currentWhereQ.getMultipleChoiceD());
        qid++;
    }
}