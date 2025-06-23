package com.univocity.parsers.common;

import java.io.Reader;

/* loaded from: classes13.dex */
public class oOoXoXO extends Reader {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f27081IXxxXO = 0;

    /* renamed from: Oo, reason: collision with root package name */
    public int f27082Oo;

    /* renamed from: XO, reason: collision with root package name */
    public String f27083XO;

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f27083XO = null;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return false;
    }

    public void oIX0oI(String str) {
        this.f27083XO = str;
        this.f27082Oo = str.length();
        this.f27081IXxxXO = 0;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f27081IXxxXO;
        int i4 = this.f27082Oo;
        if (i3 >= i4) {
            return -1;
        }
        int min = Math.min(i4 - i3, i2);
        String str = this.f27083XO;
        int i5 = this.f27081IXxxXO;
        str.getChars(i5, i5 + min, cArr, i);
        this.f27081IXxxXO += min;
        return min;
    }

    @Override // java.io.Reader
    public boolean ready() {
        if (this.f27083XO != null) {
            return true;
        }
        return false;
    }

    @Override // java.io.Reader
    public long skip(long j) {
        return 0L;
    }
}
