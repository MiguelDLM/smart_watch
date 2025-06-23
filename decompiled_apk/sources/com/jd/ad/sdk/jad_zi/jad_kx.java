package com.jd.ad.sdk.jad_zi;

import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public final class jad_kx {

    @Nullable
    public static jad_jw jad_an;
    public static long jad_bo;

    public static jad_jw jad_an() {
        synchronized (jad_kx.class) {
            try {
                jad_jw jad_jwVar = jad_an;
                if (jad_jwVar == null) {
                    return new jad_jw();
                }
                jad_an = jad_jwVar.jad_fs;
                jad_jwVar.jad_fs = null;
                jad_bo -= 8192;
                return jad_jwVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void jad_an(jad_jw jad_jwVar) {
        if (jad_jwVar.jad_fs != null || jad_jwVar.jad_jt != null) {
            throw new IllegalArgumentException();
        }
        if (jad_jwVar.jad_dq) {
            return;
        }
        synchronized (jad_kx.class) {
            try {
                long j = jad_bo + 8192;
                if (j > 65536) {
                    return;
                }
                jad_bo = j;
                jad_jwVar.jad_fs = jad_an;
                jad_jwVar.jad_cp = 0;
                jad_jwVar.jad_bo = 0;
                jad_an = jad_jwVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
