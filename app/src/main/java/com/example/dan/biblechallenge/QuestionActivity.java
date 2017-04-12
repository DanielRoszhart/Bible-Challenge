package com.example.dan.biblechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;




public class QuestionActivity extends AppCompatActivity {
    List<QuestionsTable> whoQuesList;
    int score = 0;
    int qid = 0;
    QuestionsTable currentWhoQ;
    Button btnA, btnB, btnC, btnD;
    Button butSkip;
    TextView txtQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        butSkip = (Button) findViewById(R.id.btnSkip);
        MySQLiteHelper db = new MySQLiteHelper(this);
        whoQuesList = db.getAllWhos();
        currentWhoQ = whoQuesList.get(qid);
        txtQuestion = (TextView)findViewById(R.id.txtViewQuestion);
        btnA = (Button) findViewById(R.id.btnOptionA);
        btnB = (Button) findViewById(R.id.btnOptionB);
        btnC = (Button) findViewById(R.id.btnOptionC);
        btnD = (Button) findViewById(R.id.btnOptionD);
        setQuestionView();
    }
    public void onClickQuestion(View v) {

       switch (v.getId()) {
                case R.id.btnOptionA:
                if (currentWhoQ.getAnswer().equals(btnA.getText())) {
                    score++;
                }
                if (qid < 10) {
                    currentWhoQ = whoQuesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);

                }
                break;

                case R.id.btnOptionB:
                if (currentWhoQ.getAnswer().equals(btnB.getText())) {
                    score++;
                }
                if (qid < 10) {
                    currentWhoQ = whoQuesList.get(qid);
                    setQuestionView();

                } else {
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);

                }

                break;

                case R.id.btnOptionC:
                if (currentWhoQ.getAnswer().equals(btnC.getText())) {
                    score++;
                }

                if (qid < 10) {
                    currentWhoQ = whoQuesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);

                }

                break;

                case R.id.btnOptionD:
                if (currentWhoQ.getAnswer().equals(btnD.getText())) {
                    score++;
                }
                if (qid < 10) {
                    currentWhoQ = whoQuesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);

                }
                break;

        }
    }



    public void setQuestionView() {
        txtQuestion.setText(currentWhoQ.getQuestion());
        btnA.setText(currentWhoQ.getMultipleChoiceA());
        btnB.setText(currentWhoQ.getMultipleChoiceB());
        btnC.setText(currentWhoQ.getMultipleChoiceC());
        btnD.setText(currentWhoQ.getMultipleChoiceD());
        qid++;
    }


}

