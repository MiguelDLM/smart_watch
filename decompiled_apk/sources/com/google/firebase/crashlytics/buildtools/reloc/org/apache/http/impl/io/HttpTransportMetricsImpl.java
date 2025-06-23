package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.io;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.HttpTransportMetrics;

/* loaded from: classes10.dex */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred = 0;

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.HttpTransportMetrics
    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void incrementBytesTransferred(long j) {
        this.bytesTransferred += j;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.io.HttpTransportMetrics
    public void reset() {
        this.bytesTransferred = 0L;
    }

    public void setBytesTransferred(long j) {
        this.bytesTransferred = j;
    }
}
