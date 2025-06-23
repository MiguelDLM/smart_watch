package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public final class XO {
    public static /* synthetic */ X0o0xo II0xO0(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = kotlin.text.oxoX.f29581II0xO0;
        }
        return oIX0oI(inputStream, charset);
    }

    @OOXIXo
    public static final X0o0xo oIX0oI(@OOXIXo InputStream inputStream, @OOXIXo Charset charset) {
        IIX0o.x0xO0oo(inputStream, "<this>");
        IIX0o.x0xO0oo(charset, "charset");
        return new ReaderJvmImpl(new BufferedReader(new InputStreamReader(inputStream, charset), 8192));
    }
}
