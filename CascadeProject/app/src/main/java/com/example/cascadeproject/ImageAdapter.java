package com.example.cascadeproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context activity;
    private List<Integer> board;

    public ImageAdapter(Context activity, List<Integer> board) {
        this.activity = activity;
        this.board = board;
    }

    @Override
    public int getCount() {
        return board.size();
    }

    @Override
    public Object getItem(int i) {
        return board.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView image = new ImageView(activity);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setPadding(0,0,0,0);
        image.setLayoutParams(new GridView.LayoutParams(150, 150));
        image.setImageResource(board.get(i));
        return image;
    }
}
