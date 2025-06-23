package com.jd.ad.sdk.jad_zi;

import java.io.InterruptedIOException;

/* loaded from: classes10.dex */
public class jad_na {
    public void jad_an() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
