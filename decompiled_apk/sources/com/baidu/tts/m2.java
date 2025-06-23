package com.baidu.tts;

import XIXIX.OOXIXo;

/* loaded from: classes8.dex */
public enum m2 {
    OPUS_16K("OPUS_16K", "16", 16000.0d),
    OPUS_32K("OPUS_32K", "32", 32000.0d),
    OPUS_64K("OPUS_32K", "64", 64000.0d),
    OPUS_128K("OPUS_32K", "128", 128000.0d),
    PCM("PCM", "0", OOXIXo.f3760XO);


    /* renamed from: a, reason: collision with root package name */
    public final String f10135a;
    public final double b;

    m2(String str, String str2, double d) {
        this.f10135a = str2;
        this.b = d;
    }
}
