package com.wadaran.android;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new splashHandler(), 8000);
    }

    class splashHandler implements Runnable {
        public void run() {
            Intent inte = new Intent(getApplication(), MainActivity.class);
            startActivity(inte);
            MainActivity.this.finish();
        }
    }

}
