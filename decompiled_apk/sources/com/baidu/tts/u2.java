package com.baidu.tts;

import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes8.dex */
public enum u2 {
    HZ8K(8000, "8k"),
    HZ16K(16000, "16k"),
    HZ24K(ErrorCode.ERROR_TTS_INVALID_PARA, "24k");


    /* renamed from: a, reason: collision with root package name */
    public final int f10176a;

    u2(int i, String str) {
        this.f10176a = i;
    }

    public int a() {
        return this.f10176a;
    }
}
