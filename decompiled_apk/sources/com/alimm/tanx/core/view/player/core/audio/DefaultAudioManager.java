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

/* loaded from: classes.dex */
public class DefaultAudioManager implements IAudioManager {
    private final AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
    private AudioFocusRequest audioFocusRequest;
    private final AudioManager audioManager;
    private final Context context;
    private final ITanxPlayer iTanxPlayer;
    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    public DefaultAudioManager(Context context, ITanxPlayer iTanxPlayer) {
        this.context = context;
        this.iTanxPlayer = iTanxPlayer;
        this.audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.onAudioFocusChangeListener = new DefaultAudioFocusChangeListener(new WeakReference(context), this, iTanxPlayer);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void abandonAudioFocus() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
            if (audioFocusRequest != null) {
                this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
                return;
            }
            return;
        }
        this.audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(3);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public int getVolume() {
        return this.audioManager.getStreamVolume(3);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void mute() {
        this.audioManager.setStreamVolume(3, 0, 4);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void requestAudioFocus() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        if (Build.VERSION.SDK_INT >= 26) {
            audioAttributes = Oxx0IOOO.oIX0oI(1).setAudioAttributes(this.audioAttributes);
            acceptsDelayedFocusGain = audioAttributes.setAcceptsDelayedFocusGain(false);
            onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.onAudioFocusChangeListener);
            build = onAudioFocusChangeListener.build();
            this.audioFocusRequest = build;
            this.audioManager.requestAudioFocus(build);
            return;
        }
        this.audioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void setVolume(int i) {
        this.audioManager.setStreamVolume(3, i % this.audioManager.getStreamMaxVolume(3), 4);
    }
}
