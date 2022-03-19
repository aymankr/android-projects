package com.example.cascadeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private Integer[][] board;
    private ImageAdapter imageAdapter;
    private List<Integer> imagesList;
    private int size, score = 0, bestScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView txtBestScore = findViewById(R.id.bestScore);
        txtBestScore.setText("0");
        TextView txtScore = findViewById(R.id.scoreId);
        txtScore.setText("0");

        initBoard();
        initGridView();
    }

    public void onClickReturn(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("bestScore", "" + bestScore);
        this.startActivity(intent);
    }

    public void onClickTryAgain(View view) {
        score = 0;
        TextView txtScore = findViewById(R.id.scoreId);
        txtScore.setText("0");
        initBoard();
        initGridView();
    }

    private void initBoard() {
        switch (getIntent().getStringExtra("difficulty")) {
            case "0":
                size = 4;
                break;
            case "1":
                size = 5;
                break;
            case "2":
                size = 6;
                break;
        }
        board = new Integer[size][size];
        imagesList = new ArrayList<>();
        imagesList.add(R.drawable.baseball);
        imagesList.add(R.drawable.dbz);
        imagesList.add(R.drawable.football);
        imagesList.add(R.drawable.basket);
        for (int i = 0; i < size;i++) {
            for (int j = 0; j<size;j++) {
                board[i][j] = imagesList.get((int)(4.0*Math.random()));
            }
        }
    }

    private void initGridView() {
        imageAdapter = new ImageAdapter(this, boardToList());
        GridView gridView = findViewById(R.id.gridViewId);
        gridView.setNumColumns(size);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener((parent, view, pos, id) -> {
            Context activity = getApplicationContext();
            int row = pos / size;
            int col = pos % size;
            removeNeighbours(row,col, board[row][col]);

            TextView txtBestScore = findViewById(R.id.bestScore);
            txtBestScore.setText(String.valueOf(bestScore));
            TextView txtScore = findViewById(R.id.scoreId);
            txtScore.setText(String.valueOf(score));

            imageAdapter = new ImageAdapter(activity, boardToList());
            gridView.setAdapter(imageAdapter);
        });
    }

    private List<Integer> boardToList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer[] row : board) {
            list.addAll((Arrays.asList(row)));
        }
        return list;
    }

    private void removeNeighbours(int row, int col, int removedNeighbour) {
        int i = 1;
        while (row + i < size && removedNeighbour == board[row+i][col]) {
            score++;
            int removed = board[row+i][col];
            board[row+i][col] = 0;
            applyGravity(row+i,col);
            removeNeighbours(row+i, col,removed);
        }
        i=1;
        while (row - i >= 0 && board[row - i][col] == removedNeighbour){
            score++;
            int removed = board[row-i][col];
            board[row-i][col] = 0;
            applyGravity(row-i,col);
            removeNeighbours(row-i, col,removed);
        }
        i=1;
        while (col + i < size && board[row][col + i] == removedNeighbour) {
            score++;
            int removed = board[row][col+i];
            board[row][col+i] = 0;
            applyGravity(row,col+i);
            removeNeighbours(row, col+i,removed);
        }
        i=1;
        while (col - i >= 0 && board[row][col - i] == removedNeighbour) {
            score++;
            int removed = board[row][col-i];
            board[row][col-i] = 0;
            applyGravity(row,col-i);
            removeNeighbours(row, col-i,removed);
        }

        if (score > bestScore) {
            bestScore = score;
        }
    }

    private void applyGravity(int i, int j) {
        if (board[i][j] == 0) {
            for (int a = i; a > 0; a--) {
                int tmp = board[a][j];
                board[a][j] = board[a - 1][j];
                board[a - 1][j] = tmp;
            }
        }
    }
}