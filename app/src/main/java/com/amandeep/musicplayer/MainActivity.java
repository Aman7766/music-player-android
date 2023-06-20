package com.amandeep.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button forward,rewind,play,pause;
    TextView start,end;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    int current_time;
    int final_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        end=findViewById(R.id.endtime);
        forward=findViewById(R.id.forward);
        rewind=findViewById(R.id.rewind);
        play=findViewById(R.id.play);
        mediaPlayer=MediaPlayer.create(this,R.raw.ob);
        forward.setOnClickListener(this);
        rewind.setOnClickListener(this);
        play.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v==forward)
        {
            Log.d("forwad","forward clikced");
        }
        else if(v==rewind)
        {
            Log.d("rewind","rewind clikced");
        }
        else  if(v==play)
        {
            Log.d("play","play clikced");
        PlayMusic();
        }

    }
   public void PlayMusic()
    {
        current_time=mediaPlayer.getCurrentPosition();
        final_time=mediaPlayer.getDuration();
        int minutes=(final_time/1000)/60;
        int second=(final_time/1000)%60;
        String time=minutes+":"+second;
        end.setText(time);
        mediaPlayer.start();
    }
}