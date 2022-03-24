package com.example.cascadeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<String> scoresList;
    private int bestScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getStringExtra("bestScore") != null) {
            bestScore = Integer.parseInt(getIntent().getStringExtra("bestScore"));
        }

        scoresList = new ArrayList<>();
        if (getIntent().getStringArrayListExtra("scoresList") != null) {
            scoresList = getIntent().getStringArrayListExtra("scoresList");
        }
    }

    public void onClickStart(View view) {
        RadioButton easyButton = findViewById(R.id.easyId);
        RadioButton mediumButton = findViewById(R.id.mediumId);
        RadioButton hardButton = findViewById(R.id.hardId);
        RadioButton selectedButton = null;
        int difficulty = 0;
        if (easyButton.isChecked()) {
            selectedButton = easyButton;
        }
        else if (mediumButton.isChecked()) {
            selectedButton = mediumButton;
            difficulty = 1;
        }
        else if(hardButton.isChecked()) {
            selectedButton = hardButton;
            difficulty = 2;
        }

        if (selectedButton != null) {
            if (bestScore!=0) {
                scoresList.add(String.valueOf(bestScore));
            }
            Intent intent = new Intent(this, GameActivity.class);
            System.out.println("score" + getIntent().getStringExtra("bestScore"));
            intent.putExtra("bestScore", "" + bestScore);
            intent.putStringArrayListExtra("scoresList", scoresList);
            intent.putExtra("difficulty", "" + difficulty);
            this.startActivity(intent);
        }
        else {
            Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Select a difficulty",
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

    public void onClickScores(View view) {
        if (bestScore!=0) {
            scoresList.add(String.valueOf(bestScore));
        }
        Intent intent = new Intent(this, ScoresActivity.class);
        intent.putStringArrayListExtra("scoresList", scoresList);
        startActivity(intent);
    }
}