package com.example.playermusica

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var executarSom: ImageView
    private lateinit var pararMusica: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executarSom = findViewById(R.id.executarSom)
        pararMusica = findViewById(R.id.pararMusica)

        mediaPlayer = MediaPlayer.create(this, R.raw.musicaum)

        executarSom.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                executarSom.setImageResource(R.drawable.pause)
            } else {
                mediaPlayer.start()
                executarSom.setImageResource(R.drawable.start)
            }
        }

        pararMusica.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this, R.raw.musicaum)
            }
        }
    }
}