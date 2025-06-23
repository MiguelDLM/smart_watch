package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn;

import java.io.IOException;

/* loaded from: classes10.dex */
public interface ConnectionReleaseTrigger {
    void abortConnection() throws IOException;

    void releaseConnection() throws IOException;
}
