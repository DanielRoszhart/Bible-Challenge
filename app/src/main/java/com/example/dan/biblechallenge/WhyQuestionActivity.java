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
public class WhyQuestionActivity extends AppCompatActivity implements View.OnClickListener{
    int score = 0;
    Button button;
    int qid = 0;
    Button btnA, btnB, btnC, btnD;
    TextView txtQuestion;
    List<QuestionsTable> whyQuesList;
    QuestionsTable currentWhyQ;
    CountDownTimer countDownTimer;
    TextView textV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        MySQLiteHelper db = new MySQLiteHelper(this);
        whyQuesList = db.getAllWhys();
        currentWhyQ = whyQuesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.txtViewQuestion);
        final TextView myTimer = (TextView) findViewById(R.id.txtViewTimer);

        btnA = (Button) findViewById(R.id.btnOptionA);
        btnB = (Button) findViewById(R.id.btnOptionB);
        btnC = (Button) findViewById(R.id.btnOptionC);
        btnD = (Button) findViewById(R.id.btnOptionD);
        setWhyQuestionView();

        countDownTimer = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                myTimer.setText(millisUntilFinished / 1000 + " seconds remaining");
            }

            public void onFinish()
            {
                myTimer.setText("Done!");
                Intent intent = new Intent(WhyQuestionActivity.this, ResultActivity.class);
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

                if (currentWhyQ.getAnswer().equals(((TextView) v).getText())) {
                    score++;
                } else {
                    Log.e("Yolo", "Right Answer " + currentWhyQ.getAnswer());
                }
                if (qid < 10) {
                    currentWhyQ = whyQuesList.get(qid);
                    setWhyQuestionView();
                } else {
                    countDownTimer.cancel();
                    Intent intent = new Intent(WhyQuestionActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                }

        }
    }
    public void setWhyQuestionView() {
        txtQuestion.setText(currentWhyQ.getQuestion());
        btnA.setText(currentWhyQ.getMultipleChoiceA());
        btnB.setText(currentWhyQ.getMultipleChoiceB());
        btnC.setText(currentWhyQ.getMultipleChoiceC());
        btnD.setText(currentWhyQ.getMultipleChoiceD());
        qid++;
    }


}