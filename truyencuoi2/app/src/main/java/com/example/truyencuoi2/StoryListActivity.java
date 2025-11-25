package com.example.truyencuoi2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class StoryListActivity extends AppCompatActivity {

    String[] tenTruyen = {
            "Tình bạn sâu sắc",
            "Nói nhỏ thôi",
            "Quà sinh nhật",
            "Tình bạn chân thành",
            "Bạn đàng hoàng",
            "Đi học trễ",
            "Bạn tốt",
            "Học nhóm",
            "Hỏi bài",
            "Chơi game"
    };

    int[] iconTruyen = {
            R.drawable.ic_tinh_ban_sau_sac,
            R.drawable.ic_noi_nho_thoi,
            R.drawable.ic_qua_sinh_nhat,
            R.drawable.ic_tinh_ban_chan_thanh,
            R.drawable.ic_ban_dang_hoang,
            R.drawable.ic_di_hoc_tre,
            R.drawable.ic_ban_tot,
            R.drawable.ic_hoc_nhom,
            R.drawable.ic_hoi_bai,
            R.drawable.ic_choi_game
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);

        // Chủ đề gửi từ MainActivity
        String chude = getIntent().getStringExtra("chude");
        TextView tvChuDe = findViewById(R.id.tvChuDe);
        tvChuDe.setText(chude.replace("_", " "));

        // Tạo adapter custom để hiện icon + tên truyện
        StoryAdapter adapter = new StoryAdapter(
                this,
                tenTruyen,
                iconTruyen
        );

        ListView lv = findViewById(R.id.lvTruyen);
        lv.setAdapter(adapter);

        // Click mở chi tiết truyện
        lv.setOnItemClickListener((parent, view, pos, id) -> {
            Intent i = new Intent(this, StoryDetailActivity.class);
            i.putExtra("tenTruyen", tenTruyen[pos]);
            i.putExtra("noiDung", getStoryContent(pos)); // Đọc nội dung từ TXT
            startActivity(i);
        });
    }

    // Hàm đọc nội dung từ file TXT dựa theo index truyện
    private String getStoryContent(int index) {
        try {
            InputStream is = getAssets().open("story/ban_be.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            String title = "";
            StringBuilder content = new StringBuilder();
            int currentIndex = -1;

            while ((line = reader.readLine()) != null) {

                if (line.contains("','0')")) {
                    currentIndex++;

                    if (currentIndex == index) {
                        return content.toString();
                    }

                    title = "";
                    content.setLength(0);
                }
                else if (title.isEmpty()) {
                    title = line;
                }
                else {
                    content.append(line).append("\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
