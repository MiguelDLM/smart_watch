package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public final class StringReaderImpl implements X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f15764I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f15765II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final String f15766oIX0oI;

    public StringReaderImpl(@OOXIXo String data) {
        IIX0o.x0xO0oo(data, "data");
        this.f15766oIX0oI = data;
        this.f15764I0Io = -1;
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.X0o0xo
    public void close() {
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.X0o0xo
    public void oIX0oI(int i) {
        this.f15764I0Io = this.f15765II0xO0;
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.X0o0xo
    public int read() {
        if (this.f15765II0xO0 == this.f15766oIX0oI.length()) {
            return -1;
        }
        String str = this.f15766oIX0oI;
        int i = this.f15765II0xO0;
        this.f15765II0xO0 = i + 1;
        return str.charAt(i);
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.X0o0xo
    public void reset() {
        this.f15765II0xO0 = this.f15764I0Io;
    }
}
