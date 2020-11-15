package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {


    int scoreTeamA=0;
    int scoreTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamA(scoreTeamB);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamA(View view){
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View view){
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamA(View view){
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }


    ///team b

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamB(View view){
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View view){
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }

    public void addOneForTeamB(View view){
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }

//reset
    public void resetScores(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }



}
