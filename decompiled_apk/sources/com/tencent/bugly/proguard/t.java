package com.tencent.bugly.proguard;

import java.io.Serializable;

/* loaded from: classes13.dex */
public final class t implements Serializable, Comparable<t> {

    /* renamed from: a, reason: collision with root package name */
    public long f26631a;
    public String b;
    public long c;
    public int d;
    public String e;
    public String f;
    public long g;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(t tVar) {
        return (int) (this.c - tVar.c);
    }
}
