package com.example.multimediaapp_letrongtanphat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnPlayAudio, btnStartRecord, btnStopRecord, btnCamera;
    ImageView imageView;
    MediaPlayer mediaPlayer;
    MediaRecorder mediaRecorder;
    String audioPath = "/sdcard/recording_letrongtanphat.3gp";
    final int REQUEST_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        btnPlayAudio = findViewById(R.id.btnPlayAudio_letrongtanphat);
        btnStartRecord = findViewById(R.id.btnStartRecord_letrongtanphat);
        btnStopRecord = findViewById(R.id.btnStopRecord_letrongtanphat);
        btnCamera = findViewById(R.id.btnCamera_letrongtanphat);
        imageView = findViewById(R.id.imageView_letrongtanphat);

        // Xin quyền
        requestPermissions();

        // Phát âm thanh
        mediaPlayer = MediaPlayer.create(this, R.raw.myaudio);
        btnPlayAudio.setOnClickListener(v -> mediaPlayer.start());

        // Ghi âm
        btnStartRecord.setOnClickListener(v -> {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(audioPath);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            try {
                mediaRecorder.prepare();
                mediaRecorder.start();
                Toast.makeText(this, "Đang ghi âm...", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Dừng ghi âm
        btnStopRecord.setOnClickListener(v -> {
            if (mediaRecorder != null) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
                Toast.makeText(this, "Ghi âm đã lưu", Toast.LENGTH_SHORT).show();
            }
        });

        // Chụp ảnh
        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_IMAGE);
        });
    }

    private void requestPermissions() {
        String[] permissions = {
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        ActivityCompat.requestPermissions(this, permissions, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}
