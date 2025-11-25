package com.example.truyencuoi2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

public class ChuDeAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> listChuDe;

    public ChuDeAdapter(Context context, ArrayList<String> listChuDe) {
        this.context = context;
        this.listChuDe = listChuDe;
    }

    @Override
    public int getCount() {
        return listChuDe.size();
    }

    @Override
    public Object getItem(int position) {
        return listChuDe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_chude, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.imgIcon);
        TextView tv = convertView.findViewById(R.id.tvTenChuDe);

        String tenFile = listChuDe.get(position);   // ban_be
        String fileName = tenFile + ".png";         // ban_be.png

        // Load ảnh từ assets/photo
        try {
            InputStream is = context.getAssets().open("photo/" + fileName);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            img.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Hiển thị tên đẹp: ban_be → Ban be → Ban be
        String tenHienThi = tenFile.replace("_", " ");
        tenHienThi = Character.toUpperCase(tenHienThi.charAt(0)) + tenHienThi.substring(1);

        tv.setText(tenHienThi);

        return convertView;
    }
}
