package com.kwad.framework.filedownloader.download;

/* loaded from: classes11.dex */
public final class a {
    final long agE;
    final long agF;
    final long agG;
    final long contentLength;

    public a(long j, long j2, long j3, long j4) {
        this.agE = j;
        this.agF = j2;
        this.agG = j3;
        this.contentLength = j4;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.b("range[%d, %d) current offset[%d]", Long.valueOf(this.agE), Long.valueOf(this.agG), Long.valueOf(this.agF));
    }
}
