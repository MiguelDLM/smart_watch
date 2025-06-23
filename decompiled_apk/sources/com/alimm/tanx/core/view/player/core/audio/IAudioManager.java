package com.alimm.tanx.core.view.player.core.audio;

/* loaded from: classes.dex */
public interface IAudioManager {
    void abandonAudioFocus();

    int getMaxVolume();

    int getVolume();

    void mute();

    void requestAudioFocus();

    void setVolume(int i);
}
