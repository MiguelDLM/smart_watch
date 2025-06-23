package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public enum c implements Const {
    TEXT(0),
    AUDIO(1),
    IMAGE(2),
    VIDEO(3),
    PER(4),
    OTHER(-1);


    /* renamed from: a, reason: collision with root package name */
    private final int f17460a;

    c(int i) {
        this.f17460a = i;
    }

    public static c a(int i) {
        c cVar = TEXT;
        if (i == cVar.f17460a) {
            return cVar;
        }
        c cVar2 = AUDIO;
        if (i == cVar2.f17460a) {
            return cVar2;
        }
        c cVar3 = IMAGE;
        if (i == cVar3.f17460a) {
            return cVar3;
        }
        c cVar4 = VIDEO;
        if (i == cVar4.f17460a) {
            return cVar4;
        }
        c cVar5 = PER;
        if (i == cVar5.f17460a) {
            return cVar5;
        }
        c cVar6 = OTHER;
        if (i == cVar6.f17460a) {
            return cVar6;
        }
        throw new IllegalArgumentException("type not supported");
    }

    @Override // com.iflytek.sparkchain.core.Const
    public int getValue() {
        return this.f17460a;
    }
}
