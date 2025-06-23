package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public enum b implements Const {
    MEM(0),
    FILE(1),
    UNKNOWN(-1);


    /* renamed from: a, reason: collision with root package name */
    private final int f17459a;

    b(int i) {
        this.f17459a = i;
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.f17459a;
    }
}
