package com.example.truyencuoi2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        TextView tvTenTruyen = findViewById(R.id.tvTenTruyen);
        TextView tvNoiDung = findViewById(R.id.tvNoiDung);
        ImageView btnBack = findViewById(R.id.btnBack);

        String ten = getIntent().getStringExtra("tenTruyen");
        String nd = getIntent().getStringExtra("noiDung");

        tvTenTruyen.setText(ten);
        tvNoiDung.setText(nd);

        btnBack.setOnClickListener(v -> finish());
    }
}
