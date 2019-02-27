package com.example.my_ac_lifecycle;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String STATE_SCORE = "playScore";
    public static final String STATE_LEVEL = "playLevel";
    private TextView mLevelText;
    private TextView mScoreText;

    private int mLevel =0;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLevelText= findViewById(R.id.level_text);
        mScoreText=findViewById(R.id.score_text);
        //상태가 null이면 상태가 저장됨/ 아님 저장안됨
        if(savedInstanceState == null){

        }else{
            //상태가 복원된다 화면 돌리때
            mScore= savedInstanceState.getInt(STATE_SCORE);
            mLevel =savedInstanceState.getInt(STATE_LEVEL);
            mLevelText.setText("Level:" + mLevel);
            mScoreText.setText("Score:"+ mScore);

        }
    }

    public void onLevleUp(View view) {
        mLevel ++;
        mLevelText.setText("Level:" + mLevel);
    }


    public void onScoreUp(View view) {
        mScore++;
        mScoreText.setText("Score:"+ mScore);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE,mScore);
        outState.putInt(STATE_LEVEL,mLevel);
        super.onSaveInstanceState(outState);
    }
}
