package com.example.mahan.tcandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerActivity extends AppCompatActivity {

    private TextView mAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Integer ans = (Integer)getIntent().getSerializableExtra("num_answer");
        Integer size = (Integer)getIntent().getSerializableExtra("size");

        if (ans == null) {
            Toast.makeText(this, "answer is null", Toast.LENGTH_SHORT).show();
        }
        if (size == null) {
            Toast.makeText(this, "size list is null", Toast.LENGTH_SHORT).show();
        }

        double num = (double)ans/size;

        mAns = (TextView) findViewById(R.id.show_ans);
        mAns.setText("%" + num * 100);
    }
}
