package company.roc.tetris3d.View.Implementation;

import android.media.SoundPool;

import company.roc.tetris3d.View.Framework.Sound;

/**
 * Created by roc on 14/07/16.
 */
public class AndroidSound implements Sound {

    int soundId;
    SoundPool soundPool;

    public AndroidSound(SoundPool soundPool, int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }
}
