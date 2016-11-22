package com.pallefire.cyy_b34;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class SecondActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    YouTubePlayerView youTubePlayerView;
//    String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubeview);
        youTubePlayerView.initialize("AIzaSyAZ46IMIrKsCqMYvtZybVG5rRZ47GkL_L8", this);
//        Intent i = getIntent();
//        Bundle bundle = i.getExtras();
//        videoUrl = bundle.getString("Movie");
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

       // youTubePlayer.loadVideo("F0n3kfPG06s");
        WebView webView=new WebView(this);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading (WebView view, String url){
                Intent in = getIntent();
                Bundle b =in.getExtras();
                String url1 = b.getString("url");
                return true;
            }
        });
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Connection Failed", Toast.LENGTH_SHORT).show();
    }
}
