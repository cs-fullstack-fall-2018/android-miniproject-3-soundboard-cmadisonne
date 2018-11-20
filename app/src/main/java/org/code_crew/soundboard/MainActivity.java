package org.code_crew.soundboard;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SoundPool poolSound;
    private int sound1 , sound2 , sound3 , sound4;
    private int soundId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();

        poolSound = new SoundPool.Builder().setMaxStreams(6).build();

        sound1 = poolSound.load(this, R.raw.sound1, 1);
        sound2 = poolSound.load(this, R.raw.sound2, 1);
        sound3 = poolSound.load(this, R.raw.sound3, 1);
        sound4 = poolSound.load(this, R.raw.sound4, 1);

    }

    public void playSound(View view) {
        switch (view.getId()) {
            case R.id.button:
                poolSound.play(sound1, 1, 1,0,0,1 );
                break;
            case R.id.button2:
                poolSound.play(sound2, 1, 1,0,0,1 );
                break;
            case R.id.button3:
                poolSound.play(sound3, 1, 1,0,0,1 );
                break;
            case R.id.button4:
                poolSound.play(sound4, 1, 1,0,0,1 );
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        poolSound.release();
        poolSound = null;
    }
}
