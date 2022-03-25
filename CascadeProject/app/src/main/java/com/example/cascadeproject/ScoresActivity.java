package com.example.cascadeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    private ArrayList<String> scoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Button returnBtn =findViewById(R.id.returnScoreId);
        returnBtn.setBackgroundColor(Color.RED);
        returnBtn.setTextColor(Color.WHITE);

        Button reinitBtn =findViewById(R.id.reinitScoreId);
        reinitBtn.setBackgroundColor(Color.RED);
        reinitBtn.setTextColor(Color.WHITE);

        if (getIntent().getStringArrayListExtra("scoresList")!=null) {
            scoresList = getIntent().getStringArrayListExtra("scoresList");
        }
        else {
            scoresList = new ArrayList<>();
            Snackbar.make(findViewById(R.id.myCoordinatorLayout), "No one played",
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
        displayScores();
    }

    public void onClickReturn(View view) {
        scoresList = getIntent().getStringArrayListExtra("scoresList");
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putStringArrayListExtra("scoresList", scoresList);
        startActivity(intent);
    }

    public void onClickReinit(View view) {
        scoresList = new ArrayList<>();
        displayScores();
    }

    private void displayScores() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, threeBestScoresList());
        ListView listView = findViewById(R.id.listViewId);
        listView.setAdapter(arrayAdapter);
    }

    private ArrayList<Integer> threeBestScoresList() {
        ArrayList<Integer> scoresIntegerList = new ArrayList<>(), bestScoresList = new ArrayList<>();
        for (int i = 0; i<scoresList.size();i++) {
            scoresIntegerList.add(Integer.parseInt(scoresList.get(i)));
        }

        for (int i = 0; i < 3;i++) {
            if (!scoresIntegerList.isEmpty()) {
                bestScoresList.add(Collections.max(scoresIntegerList));
                scoresIntegerList.remove(Collections.max(scoresIntegerList));
            }
        }
        return bestScoresList;
    }
}