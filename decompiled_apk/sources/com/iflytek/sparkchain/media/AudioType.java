package com.iflytek.sparkchain.media;

import com.iflytek.sparkchain.core.ConstStr;

/* loaded from: classes10.dex */
public enum AudioType implements ConstStr {
    MP3("mp3"),
    WAV("wav"),
    AAC("aac"),
    PCM("pcm");

    private final String value;

    AudioType(String str) {
        this.value = str;
    }

    @Override // com.iflytek.sparkchain.core.ConstStr
    public String getValue() {
        return this.value;
    }
}
