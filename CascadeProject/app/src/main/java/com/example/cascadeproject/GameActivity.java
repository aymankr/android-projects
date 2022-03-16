package com.example.cascadeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void onClickReturn(View view) {
        startActivity(new Intent(GameActivity.this, HomeActivity.class));
    }

    public void onClickTryAgain(View view) {
        //startActivity(new Intent(GameActivity.this, HomeActivity.class));
        // fc restart
    }
}