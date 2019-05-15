package com.example.a13703.happy_newyear;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    TypeTextView mTypeTextView;
    ImageView image;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.start();
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) actionBar.hide();
        if(Build.VERSION.SDK_INT>=21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        mTypeTextView = ( TypeTextView )findViewById(R.id.typeTxtId);
        image = (ImageView)findViewById(R.id.pic);
        mTypeTextView.setOnTypeViewListener( new TypeTextView.OnTypeViewListener( ) {
            @Override
            public void onTypeStart() {
                Log.e("MainActivity", "onTypeStart" );
            }

            @Override

            public void onTypeOver() {
                Log.e("MainActivity", "onTypeOver" );
            }

        });
        loadPic();
       mTypeTextView.start("  Dear My friends: \n" +
                            "         Hello!\n" +"\n"+"\n"+
                            "         我有些话想跟你说\n"+
                            "         许久没见，祝你在新的一年里：事业正当午，身体壮如虎，金钱不胜数，干活不辛苦，悠闲像老鼠，浪漫似乐谱，快乐非你莫属!\n" +
                            "\n" +
                            "\n" +
                            "                                                                          Yours Sincerely\n"+
                            "                                                                                      苏勇");
    }
    public void loadPic(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
               Glide.with(MainActivity.this).load(R.raw.background).into(image);
            }
        });
    }
    public void initMediaPlayer(){
       mediaPlayer = MediaPlayer.create(this, R.raw.music);
    }
}
