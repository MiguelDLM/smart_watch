package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import java.io.BufferedReader;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public final class ReaderJvmImpl implements X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final BufferedReader f15763oIX0oI;

    public ReaderJvmImpl(@OOXIXo BufferedReader reader) {
        IIX0o.x0xO0oo(reader, "reader");
        this.f15763oIX0oI = reader;
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.X0o0xo
    public void close() {
        this.f15763oIX0oI.close();
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.X0o0xo
    public void oIX0oI(int i) {
        this.f15763oIX0oI.mark(i);
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.X0o0xo
    public int read() {
        return this.f15763oIX0oI.read();
    }

    @Override // com.github.doyaaaaaken.kotlincsv.client.X0o0xo
    public void reset() {
        this.f15763oIX0oI.reset();
    }
}
