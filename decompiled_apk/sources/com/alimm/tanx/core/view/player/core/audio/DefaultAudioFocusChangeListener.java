package com.alimm.tanx.core.view.player.core.audio;

import android.content.Context;
import android.media.AudioManager;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class DefaultAudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
    private final WeakReference<Context> contextReference;
    private final IAudioManager iAudioManager;
    private final ITanxPlayer iTanxPlayer;
    private boolean playOnAudioFocus = true;

    public DefaultAudioFocusChangeListener(WeakReference<Context> weakReference, IAudioManager iAudioManager, ITanxPlayer iTanxPlayer) {
        this.contextReference = weakReference;
        this.iAudioManager = iAudioManager;
        this.iTanxPlayer = iTanxPlayer;
    }

    public int getCurrentVolume(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        return (int) ((audioManager.getStreamVolume(3) * 1.0f) / audioManager.getStreamMaxVolume(3));
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        Context context;
        if (this.iTanxPlayer == null || (context = this.contextReference.get()) == null) {
            return;
        }
        if (1 == i) {
            if (this.playOnAudioFocus && !this.iTanxPlayer.isPlaying()) {
                this.iTanxPlayer.start();
            } else if (this.iTanxPlayer.isPlaying()) {
                this.iTanxPlayer.setVolume(getCurrentVolume(context));
            }
            this.playOnAudioFocus = false;
            return;
        }
        if (-3 == i) {
            this.iTanxPlayer.setVolume(getCurrentVolume(context) * 0.8f);
            return;
        }
        if (-2 == i) {
            if (this.iTanxPlayer.isPlaying()) {
                this.playOnAudioFocus = true;
                this.iTanxPlayer.pause();
                return;
            }
            return;
        }
        if (-1 == i) {
            this.iAudioManager.abandonAudioFocus();
            this.playOnAudioFocus = false;
            this.iTanxPlayer.stop();
        }
    }
}
