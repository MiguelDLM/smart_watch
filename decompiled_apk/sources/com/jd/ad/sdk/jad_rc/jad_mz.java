package com.jd.ad.sdk.jad_rc;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.jad_gp.jad_an;
import com.jd.ad.sdk.jad_hs.jad_fs;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(27)
/* loaded from: classes10.dex */
public final class jad_mz implements com.jd.ad.sdk.jad_hs.jad_fs {
    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    @NonNull
    public jad_fs.jad_bo jad_an(@NonNull InputStream inputStream) {
        return jad_fs.jad_bo.UNKNOWN;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    @NonNull
    public jad_fs.jad_bo jad_an(@NonNull ByteBuffer byteBuffer) {
        return jad_fs.jad_bo.UNKNOWN;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    public int jad_an(@NonNull ByteBuffer byteBuffer, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        AtomicReference<byte[]> atomicReference = com.jd.ad.sdk.jad_gp.jad_an.jad_an;
        return jad_an(new jad_an.C0684jad_an(byteBuffer), jad_boVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    @Override // com.jd.ad.sdk.jad_hs.jad_fs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int jad_an(@androidx.annotation.NonNull java.io.InputStream r2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_lw.jad_bo r3) {
        /*
            r1 = this;
            com.jd.ad.sdk.jad_bo.jad_an r3 = new com.jd.ad.sdk.jad_bo.jad_an
            r0 = 0
            r3.<init>(r2, r0)
            java.lang.String r2 = "Orientation"
            com.jd.ad.sdk.jad_bo.jad_an$jad_cp r2 = r3.jad_bo(r2)
            if (r2 != 0) goto Lf
            goto L16
        Lf:
            java.nio.ByteOrder r3 = r3.jad_jt     // Catch: java.lang.NumberFormatException -> L16
            int r2 = r2.jad_bo(r3)     // Catch: java.lang.NumberFormatException -> L16
            goto L17
        L16:
            r2 = 1
        L17:
            if (r2 != 0) goto L1a
            r2 = -1
        L1a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_rc.jad_mz.jad_an(java.io.InputStream, com.jd.ad.sdk.jad_lw.jad_bo):int");
    }
}
