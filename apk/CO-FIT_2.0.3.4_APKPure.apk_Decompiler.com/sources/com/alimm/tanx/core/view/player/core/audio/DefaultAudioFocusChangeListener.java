package com.alimm.tanx.core.view.player.core.audio;

import android.content.Context;
import android.media.AudioManager;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

public class DefaultAudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
    private final WeakReference<Context> contextReference;
    private final IAudioManager iAudioManager;
    private final ITanxPlayer iTanxPlayer;
    private boolean playOnAudioFocus = true;

    public DefaultAudioFocusChangeListener(WeakReference<Context> weakReference, IAudioManager iAudioManager2, ITanxPlayer iTanxPlayer2) {
        this.contextReference = weakReference;
        this.iAudioManager = iAudioManager2;
        this.iTanxPlayer = iTanxPlayer2;
    }

    public int getCurrentVolume(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        return (int) ((((float) audioManager.getStreamVolume(3)) * 1.0f) / ((float) audioManager.getStreamMaxVolume(3)));
    }

    public void onAudioFocusChange(int i) {
        Context context;
        if (this.iTanxPlayer != null && (context = this.contextReference.get()) != null) {
            if (1 == i) {
                if (this.playOnAudioFocus && !this.iTanxPlayer.isPlaying()) {
                    this.iTanxPlayer.start();
                } else if (this.iTanxPlayer.isPlaying()) {
                    this.iTanxPlayer.setVolume((float) getCurrentVolume(context));
                }
                this.playOnAudioFocus = false;
            } else if (-3 == i) {
                this.iTanxPlayer.setVolume(((float) getCurrentVolume(context)) * 0.8f);
            } else if (-2 == i) {
                if (this.iTanxPlayer.isPlaying()) {
                    this.playOnAudioFocus = true;
                    this.iTanxPlayer.pause();
                }
            } else if (-1 == i) {
                this.iAudioManager.abandonAudioFocus();
                this.playOnAudioFocus = false;
                this.iTanxPlayer.stop();
            }
        }
    }
}
