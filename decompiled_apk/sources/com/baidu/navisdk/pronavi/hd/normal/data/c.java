package com.baidu.navisdk.pronavi.hd.normal.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7758a;
    private long b = 500;
    private int c;

    public c(int i) {
        this.c = i;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final int b() {
        return this.c;
    }

    public final boolean c() {
        return this.f7758a;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this != obj) {
            return (obj instanceof c) && this.c == ((c) obj).c;
        }
        return true;
    }

    public int hashCode() {
        return this.c;
    }

    @OOXIXo
    public String toString() {
        return "RGNormalHdUIData(uiState=" + this.c + oIX0oI.I0Io.f4095I0Io;
    }

    public final void a(boolean z) {
        this.f7758a = z;
    }

    public final long a() {
        return this.b;
    }

    public final void a(long j) {
        this.b = j;
    }
}
