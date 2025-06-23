package com.jd.ad.sdk.jad_zi;

import XXO0.oIX0oI;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_dq implements jad_mz {
    public final /* synthetic */ jad_na jad_an;
    public final /* synthetic */ InputStream jad_bo;

    public jad_dq(jad_na jad_naVar, InputStream inputStream) {
        this.jad_an = jad_naVar;
        this.jad_bo = inputStream;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.jad_bo.close();
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz
    public long jad_an(jad_an jad_anVar, long j) {
        if (j >= 0) {
            if (j == 0) {
                return 0L;
            }
            try {
                this.jad_an.jad_an();
                jad_jw jad_an = jad_anVar.jad_an(1);
                int read = this.jad_bo.read(jad_an.jad_an, jad_an.jad_cp, (int) Math.min(j, 8192 - jad_an.jad_cp));
                if (read == -1) {
                    return -1L;
                }
                jad_an.jad_cp += read;
                long j2 = read;
                jad_anVar.jad_bo += j2;
                return j2;
            } catch (AssertionError e) {
                if (e.getCause() != null && e.getMessage() != null && e.getMessage().contains("getsockname failed")) {
                    throw new IOException(e);
                }
                throw e;
            }
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public String toString() {
        StringBuilder jad_an = jad_pc.jad_an("source(");
        jad_an.append(this.jad_bo);
        jad_an.append(oIX0oI.I0Io.f4095I0Io);
        return jad_an.toString();
    }
}
