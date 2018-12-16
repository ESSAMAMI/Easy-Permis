package fr.easypermis.vue;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import fr.easypermis.Player.YoutubePlayer;
import fr.easypermis.R;

public class TestVideoActivity extends YouTubeBaseActivity {

    private YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_video);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayer);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("ITZEjDKILN0");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize(YoutubePlayer.getApiKey(), onInitializedListener);

    }

}
