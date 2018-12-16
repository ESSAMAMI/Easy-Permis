package fr.easypermis;

import android.content.Intent;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;

import fr.easypermis.vue.ConnexionActivity;

public class MainActivity extends AppCompatActivity {


    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, ConnexionActivity.class);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(intent);
            }
        }, 4000);
    }


}
