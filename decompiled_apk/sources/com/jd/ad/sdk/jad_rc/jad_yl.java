package com.jd.ad.sdk.jad_rc;

import android.media.MediaDataSource;
import com.jd.ad.sdk.jad_rc.jad_xk;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class jad_yl extends MediaDataSource {
    public final /* synthetic */ ByteBuffer jad_an;

    public jad_yl(jad_xk.jad_dq jad_dqVar, ByteBuffer byteBuffer) {
        this.jad_an = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return this.jad_an.limit();
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (j >= this.jad_an.limit()) {
            return -1;
        }
        this.jad_an.position((int) j);
        int min = Math.min(i2, this.jad_an.remaining());
        this.jad_an.get(bArr, i, min);
        return min;
    }
}
