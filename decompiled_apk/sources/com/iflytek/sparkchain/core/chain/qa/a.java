package com.iflytek.sparkchain.core.chain.qa;

import com.iflytek.sparkchain.core.Const;

/* loaded from: classes10.dex */
public enum a implements Const {
    UNKNOWN_TYPE(-1),
    REFINE(2);


    /* renamed from: a, reason: collision with root package name */
    private final int f17461a;

    a(int i) {
        this.f17461a = i;
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.f17461a;
    }
}
