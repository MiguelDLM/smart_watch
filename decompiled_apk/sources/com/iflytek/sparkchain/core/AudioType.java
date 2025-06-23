package com.iflytek.sparkchain.core;

@Deprecated
/* loaded from: classes10.dex */
public enum AudioType {
    MP3("mp3"),
    WAV("wav"),
    AAC("aac"),
    PCM("pcm");


    /* renamed from: a, reason: collision with root package name */
    private final String f17449a;

    AudioType(String str) {
        this.f17449a = str;
    }

    public String getValue() {
        return this.f17449a;
    }
}
