package com.example.cascadeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            Intent intent = new Intent(this, GameActivity.class);
            System.out.println("score" + getIntent().getStringExtra("bestScore"));
            if (getIntent().getStringExtra("bestScore") != null) {
                int bestScore = Integer.parseInt(getIntent().getStringExtra("bestScore"));
                intent.putExtra("bestScore", "" + bestScore);
            }
            intent.putExtra("difficulty", "" + difficulty);
            this.startActivity(intent);
        }
    }

    public void onClickScores(View view) {
        int bestScore = 0;
        if (getIntent().getStringExtra("bestScore") != null) {
            bestScore = Integer.parseInt(getIntent().getStringExtra("bestScore"));
        }
        Intent intent = new Intent(this, ScoresActivity.class);
        intent.putExtra("bestScore", "" + bestScore);
        startActivity(new Intent(this, ScoresActivity.class));
    }
}