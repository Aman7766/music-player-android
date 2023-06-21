package com.amandeep.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
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
    TextView start,end,songname;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    int current_time;
    int final_time;
    boolean isPlaying=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        end=findViewById(R.id.endtime);
        forward=findViewById(R.id.forward);
        rewind=findViewById(R.id.rewind);
        play=findViewById(R.id.play);
        seekBar=findViewById(R.id.seekbar);
        songname=findViewById(R.id.song);
        mediaPlayer=MediaPlayer.create(this,R.raw.ob);
        forward.setOnClickListener(this);
        rewind.setOnClickListener(this);
        play.setOnClickListener(this);
        seekBar.setClickable(false);



    }

    @Override
    public void onClick(View v) {
        if(v==forward)
        {
           Forward();
        }
        else if(v==rewind)
        {
           Rewind();
        }
        else  if(v==play)
        {
        PlayMusic();
        }

    }
    public void Rewind()
    {
        if(mediaPlayer.getCurrentPosition()>10)
        {
         mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-10000);
        }
    }

    public void Forward()
    {
        if(mediaPlayer.getCurrentPosition()<mediaPlayer.getDuration())
        {
            mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+10000);
        }
    }
   public void PlayMusic()
    {
        if (isPlaying)
        {
            Drawable playdrawable= ResourcesCompat.getDrawable(getResources(),R.drawable.baseline_play_circle_filled_24,null);
            play.setBackground(playdrawable);
            mediaPlayer.pause();
        }
        else
        {
            current_time=mediaPlayer.getCurrentPosition();
            final_time=mediaPlayer.getDuration();
            seekBar.setMax(final_time);
            int minutes=(final_time/1000)/60;
            int second=(final_time/1000)%60;
            String time=minutes+":"+second;
            end.setText(time);
            mediaPlayer.start();
            seekBar.setProgress((int)current_time);
            songname.setText(getResources().getResourceEntryName(R.raw.ob));
            Drawable pausedrawable= ResourcesCompat.getDrawable(getResources(),R.drawable.baseline_pause_circle_filled_24,null);
            play.setBackground(pausedrawable);
        }
        isPlaying=!isPlaying;

    }
}