package com.example.truyencuoi2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryAdapter extends BaseAdapter {

    Context context;
    String[] tenTruyen;
    int[] iconTruyen;

    public StoryAdapter(Context context, String[] tenTruyen, int[] iconTruyen) {
        this.context = context;
        this.tenTruyen = tenTruyen;
        this.iconTruyen = iconTruyen;
    }

    @Override
    public int getCount() {
        return tenTruyen.length;
    }

    @Override
    public Object getItem(int i) {
        return tenTruyen[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_truyen, parent, false);
        }

        ImageView img = view.findViewById(R.id.imgTruyen);
        TextView tv = view.findViewById(R.id.tvTenTruyen);

        img.setImageResource(iconTruyen[i]);
        tv.setText(tenTruyen[i]);

        return view;
    }
}
