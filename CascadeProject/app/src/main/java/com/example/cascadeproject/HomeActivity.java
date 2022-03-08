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
        RadioButton easyButton = (RadioButton) findViewById(R.id.easyId);
        RadioButton mediumButton = (RadioButton) findViewById(R.id.mediumId);
        RadioButton hardButton = (RadioButton) findViewById(R.id.hardId);
        if (easyButton.isChecked() || mediumButton.isChecked() || hardButton.isChecked()) {
            startActivity(new Intent(HomeActivity.this, GameActivity.class));
        }
    }

    public void onClickScores(View view) {
        startActivity(new Intent(HomeActivity.this, ScoresActivity.class));
    }
}