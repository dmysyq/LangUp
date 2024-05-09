package com.example.langup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SeriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);

        // json из Intent
        String jsonFileName = getIntent().getStringExtra("jsonFileName");

        // загрузка json в кнопки
        loadJsonAndCreateButtons(jsonFileName);
    }

    private void loadJsonAndCreateButtons(String jsonFileName) {
        String jsonString = loadJsonFromAsset(jsonFileName);
        Gson gson = new Gson();
        Type seriesType = new TypeToken<Series>(){}.getType();
        Series series = gson.fromJson(jsonString, seriesType);

        LinearLayout episodesContainer = findViewById(R.id.episodesContainer);
        episodesContainer.removeAllViews(); // Очистка контейнера

        for (Episode episode : series.getEpisodes()) {
            Button button = new Button(this, null, 0, R.style.SeriesButtonStyle);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(24, 0, 24, 24);
            button.setLayoutParams(layoutParams);
            button.setText(episode.getEpisodeTitle());
            button.setOnClickListener(view -> {
                // TODO: Реализуйте логику перехода к активности с карточками для перевода
            });
            episodesContainer.addView(button);
        }
    }

    private String loadJsonFromAsset(String jsonFileName) {
        String json = null;
        try {
            InputStream is = getAssets().open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void onBackPressed(View view) {
        super.onBackPressed();
    }

    class Series {
        private String seriesName;
        private ArrayList<Episode> episodes;

        // Конструктор(на будущее)
        public Series() {

        }

        // Геттер списка эпизодов
        public ArrayList<Episode> getEpisodes() {
            return episodes;
        }

        // Сеттер списка эпидозов
        public void setEpisodes(ArrayList<Episode> episodes) {
            this.episodes = episodes;
        }
    }

    class Episode {
        private int episodeNumber;
        private String episodeTitle;
        private String content;

        public Episode() {

        }

        // Геттер для эпизода
        public String getEpisodeTitle() {
            return episodeTitle;
        }

        // Сеттер для названия эпизода
        public void setEpisodeTitle(String episodeTitle) {
            this.episodeTitle = episodeTitle;
        }
    }

}