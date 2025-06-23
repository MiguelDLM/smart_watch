package com.kwad.framework.filedownloader.a;

import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.kwad.framework.filedownloader.f.c;

/* loaded from: classes11.dex */
public final class a implements c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int O(long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
