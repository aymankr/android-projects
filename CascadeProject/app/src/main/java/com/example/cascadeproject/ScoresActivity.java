package com.example.cascadeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
    }

    public void onClickReturn(View view) {
        startActivity(new Intent(ScoresActivity.this, HomeActivity.class));
    }

    public void onClickReinit(View view) {

    }
}