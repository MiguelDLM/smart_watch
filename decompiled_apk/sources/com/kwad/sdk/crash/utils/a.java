package com.kwad.sdk.crash.utils;

import java.nio.charset.Charset;

/* loaded from: classes11.dex */
public final class a {
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Charset a(Charset charset) {
        if (charset == null) {
            return Charset.defaultCharset();
        }
        return charset;
    }
}
