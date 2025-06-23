package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public enum d implements Const {
    TEXT_GENERATION(0),
    IMAGE_GENERATION(1),
    IMAGE_UNDERSTANDING(2);


    /* renamed from: a, reason: collision with root package name */
    private final int f17462a;

    d(int i) {
        this.f17462a = i;
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.f17462a;
    }
}
