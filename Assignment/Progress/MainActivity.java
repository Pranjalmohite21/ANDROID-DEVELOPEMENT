package com.example.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView txtProgress;
    Button btnStart;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        txtProgress = findViewById(R.id.txtProgress);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> {
            progress = 0;

            new Thread(() -> {
                while (progress <= 100) {
                    progress += 5;

                    handler.post(() -> {
                        progressBar.setProgress(progress);
                        txtProgress.setText("Progress: " + progress + "%");
                    });

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}