package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.io.IOException;

/* loaded from: classes10.dex */
public class ConnectionClosedException extends IOException {
    private static final long serialVersionUID = 617550366255636674L;

    public ConnectionClosedException(String str) {
        super(HttpException.clean(str));
    }
}
