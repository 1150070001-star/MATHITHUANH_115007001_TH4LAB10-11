package com.example.truyencuoi2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvChuDe;
    ArrayList<String> dsChuDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvChuDe = findViewById(R.id.lvChuDe);
        dsChuDe = new ArrayList<>();

        // ⭐ Load danh sách chủ đề từ assets/photo
        loadTopicFromAssets();

        // ⭐ Gán vào Adapter
        ChuDeAdapter adapter = new ChuDeAdapter(this, dsChuDe);
        lvChuDe.setAdapter(adapter);

        // ⭐ Khi bấm vào 1 chủ đề
        lvChuDe.setOnItemClickListener((parent, view, pos, id) -> {
            Intent i = new Intent(this, StoryListActivity.class);
            i.putExtra("chude", dsChuDe.get(pos));   // VD: ban_be
            startActivity(i);
        });
    }

    private void loadTopicFromAssets() {
        try {
            String[] files = getAssets().list("photo");
            if (files == null) return;

            for (String f : files) {
                if (f.endsWith(".png") || f.endsWith(".jpg")) {

                    // bỏ .png hoặc .jpg
                    String name = f.replace(".png", "").replace(".jpg", "");

                    dsChuDe.add(name);   // VD: ban_be → sẽ hiện trong list
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
