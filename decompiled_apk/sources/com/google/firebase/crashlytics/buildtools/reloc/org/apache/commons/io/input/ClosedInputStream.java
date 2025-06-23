package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.input;

import java.io.InputStream;

/* loaded from: classes10.dex */
public class ClosedInputStream extends InputStream {
    public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }
}
