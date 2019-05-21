package com.example.mahan.tcandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Question mQuestion1;
    private Question[] mQuestions;
    private int[] questions = {R.string.question_1, R.string.question_2, R.string.question_3
            , R.string.question_4, R.string.question_5};
    private boolean[] mAnswers = {false, true, false, false, true};
    private boolean[] mUserAnswer;
    private int mNumber = -1;

    private TextView mTv;
    private TextView mAns;

    private Button mTrueBtn;
    private Button mFalseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserAnswer = new boolean[5];

        mQuestion1 = new Question();
        mQuestion1.setQuestion(R.string.question_1);
        mQuestion1.setAnswer(false);

        mQuestions = new Question[5];

        for (int i = 0; i < mQuestions.length; i++) {
            Log.i("TAG", "onCreate: ErrorLength: " + questions[i]);
            Question q = new Question();
            q.setQuestion(questions[i]);
            q.setAnswer(mAnswers[i]);
            mQuestions[i] = q ;
        }

        mTv = (TextView) findViewById(R.id.text_android);
        mAns = (TextView) findViewById(R.id.answer);
        mTrueBtn = (Button) findViewById(R.id.btn_true);
//        mTrueBtn
        mTrueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseBtn = (Button) findViewById(R.id.btn_false);
        mFalseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        updateQuestion();
    }

    private void updateQuestion() {
        mNumber = (mNumber + 1) % 5;
        mTv.setText(getString(mQuestions[mNumber].getQuestion()));
    }


    private void checkAnswer(boolean ans) {
        mUserAnswer[mNumber] = ans;

        if (mNumber == 4) {
            int j = 0;

            for (int i = 0; i < mUserAnswer.length; i++) {
                if (mUserAnswer[i] == mAnswers[i]) {
                    j++;
                }
            }
//            mAns.setText(j + "");
//            Toast.makeText(this, "Answer is: " + (double)j/mUserAnswer.length, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, AnswerActivity.class);
            i.putExtra("num_answer", j);
            i.putExtra("size", mAnswers.length);
            startActivity(i);
            finish();
        }

        if (mQuestions[mNumber].isAnswer() == ans) {
            Toast.makeText(this, "Answer is correct :)", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Answer is incorrect :(", Toast.LENGTH_SHORT).show();
        }
        updateQuestion();
    }
}
