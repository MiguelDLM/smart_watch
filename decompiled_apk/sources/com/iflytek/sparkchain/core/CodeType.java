package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public enum CodeType implements Const {
    CODEC_ENCODE(0),
    CODEC_DECODE(1);


    /* renamed from: a, reason: collision with root package name */
    private final int f17452a;

    CodeType(int i) {
        this.f17452a = i;
    }

    public static CodeType valueOf(int i) {
        if (i == 0) {
            return CODEC_ENCODE;
        }
        if (i == 1) {
            return CODEC_DECODE;
        }
        return null;
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.f17452a;
    }
}
