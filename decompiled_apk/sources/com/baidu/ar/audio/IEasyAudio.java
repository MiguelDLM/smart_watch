package com.baidu.ar.audio;

/* loaded from: classes7.dex */
public interface IEasyAudio {
    void release();

    void removeVolumeListener(VolumeListener volumeListener);

    void setVolumeListener(VolumeListener volumeListener);

    void startAudio(AudioParams audioParams, EasyAudioCallback easyAudioCallback);

    void stopAudio(EasyAudioCallback easyAudioCallback);
}
