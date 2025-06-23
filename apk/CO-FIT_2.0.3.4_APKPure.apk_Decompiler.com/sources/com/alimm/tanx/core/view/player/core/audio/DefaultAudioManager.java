package com.alimm.tanx.core.view.player.core.audio;

import O0xOxO.Oxx0IOOO;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

public class DefaultAudioManager implements IAudioManager {
    private final AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
    private AudioFocusRequest audioFocusRequest;
    private final AudioManager audioManager;
    private final Context context;
    private final ITanxPlayer iTanxPlayer;
    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    public DefaultAudioManager(Context context2, ITanxPlayer iTanxPlayer2) {
        this.context = context2;
        this.iTanxPlayer = iTanxPlayer2;
        this.audioManager = (AudioManager) context2.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.onAudioFocusChangeListener = new DefaultAudioFocusChangeListener(new WeakReference(context2), this, iTanxPlayer2);
    }

    public void abandonAudioFocus() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest2 = this.audioFocusRequest;
            if (audioFocusRequest2 != null) {
                int unused = this.audioManager.abandonAudioFocusRequest(audioFocusRequest2);
                return;
            }
            return;
        }
        this.audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
    }

    public int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(3);
    }

    public int getVolume() {
        return this.audioManager.getStreamVolume(3);
    }

    public void mute() {
        this.audioManager.setStreamVolume(3, 0, 4);
    }

    public void requestAudioFocus() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest oIX0oI2 = Oxx0IOOO.oIX0oI(1).setAudioAttributes(this.audioAttributes).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.onAudioFocusChangeListener).build();
            this.audioFocusRequest = oIX0oI2;
            int unused = this.audioManager.requestAudioFocus(oIX0oI2);
            return;
        }
        this.audioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
    }

    public void setVolume(int i) {
        this.audioManager.setStreamVolume(3, i % this.audioManager.getStreamMaxVolume(3), 4);
    }
}
