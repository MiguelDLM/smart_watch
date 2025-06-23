package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public class jad_cp implements com.jd.ad.sdk.jad_hs.jad_mz<Bitmap> {
    public static final com.jd.ad.sdk.jad_hs.jad_iv<Integer> jad_bo = com.jd.ad.sdk.jad_hs.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.jd.ad.sdk.jad_hs.jad_iv<Bitmap.CompressFormat> jad_cp = new com.jd.ad.sdk.jad_hs.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, com.jd.ad.sdk.jad_hs.jad_iv.jad_er);

    @Nullable
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_an;

    public jad_cp(@NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        this.jad_an = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_mz
    @NonNull
    public com.jd.ad.sdk.jad_hs.jad_cp jad_an(@NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_hs.jad_cp.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    @Override // com.jd.ad.sdk.jad_hs.jad_dq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_xk<android.graphics.Bitmap> r12, @androidx.annotation.NonNull java.io.File r13, @androidx.annotation.NonNull com.jd.ad.sdk.jad_hs.jad_jw r14) {
        /*
            r11 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            java.lang.String r3 = "BitmapEncoder"
            java.lang.Object r12 = r12.get()
            android.graphics.Bitmap r12 = (android.graphics.Bitmap) r12
            com.jd.ad.sdk.jad_hs.jad_iv<android.graphics.Bitmap$CompressFormat> r4 = com.jd.ad.sdk.jad_rc.jad_cp.jad_cp
            java.lang.Object r4 = r14.jad_an(r4)
            android.graphics.Bitmap$CompressFormat r4 = (android.graphics.Bitmap.CompressFormat) r4
            if (r4 == 0) goto L16
            goto L21
        L16:
            boolean r4 = r12.hasAlpha()
            if (r4 == 0) goto L1f
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG
            goto L21
        L1f:
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG
        L21:
            r12.getWidth()
            r12.getHeight()
            long r5 = com.jd.ad.sdk.jad_gp.jad_jt.jad_an()
            com.jd.ad.sdk.jad_hs.jad_iv<java.lang.Integer> r7 = com.jd.ad.sdk.jad_rc.jad_cp.jad_bo
            java.lang.Object r7 = r14.jad_an(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r8 = 0
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r9.<init>(r13)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            com.jd.ad.sdk.jad_lw.jad_bo r13 = r11.jad_an     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4f
            if (r13 == 0) goto L51
            com.jd.ad.sdk.jad_it.jad_cp r13 = new com.jd.ad.sdk.jad_it.jad_cp     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4f
            com.jd.ad.sdk.jad_lw.jad_bo r8 = r11.jad_an     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4f
            r10 = 65536(0x10000, float:9.1835E-41)
            r13.<init>(r9, r8, r10)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4f
            r8 = r13
            goto L52
        L4c:
            r12 = move-exception
            goto Lcf
        L4f:
            r13 = move-exception
            goto L64
        L51:
            r8 = r9
        L52:
            r12.compress(r4, r7, r8)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r8.close()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r8.close()     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L5d
        L5b:
            r13 = 1
            goto L7d
        L5d:
            r12 = move-exception
            goto Ld5
        L60:
            r12 = move-exception
            goto Lce
        L62:
            r13 = move-exception
            goto L65
        L64:
            r8 = r9
        L65:
            r7 = 3
            boolean r7 = android.util.Log.isLoggable(r3, r7)     // Catch: java.lang.Throwable -> L60
            if (r7 == 0) goto L77
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L60
            java.lang.String r9 = "Failed to encode Bitmap"
            r7[r1] = r9     // Catch: java.lang.Throwable -> L60
            r7[r2] = r13     // Catch: java.lang.Throwable -> L60
            com.jd.ad.sdk.logger.Logger.d(r3, r7)     // Catch: java.lang.Throwable -> L60
        L77:
            if (r8 == 0) goto L7c
            r8.close()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L7c
        L7c:
            r13 = 0
        L7d:
            boolean r0 = android.util.Log.isLoggable(r3, r0)
            if (r0 == 0) goto Lcd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r7 = "Compressed with type: "
            r0.append(r7)
            r0.append(r4)
            java.lang.String r4 = " of size "
            r0.append(r4)
            int r4 = com.jd.ad.sdk.jad_gp.jad_ly.jad_an(r12)
            r0.append(r4)
            java.lang.String r4 = " in "
            r0.append(r4)
            double r4 = com.jd.ad.sdk.jad_gp.jad_jt.jad_an(r5)
            r0.append(r4)
            java.lang.String r4 = ", options format: "
            r0.append(r4)
            com.jd.ad.sdk.jad_hs.jad_iv<android.graphics.Bitmap$CompressFormat> r4 = com.jd.ad.sdk.jad_rc.jad_cp.jad_cp
            java.lang.Object r14 = r14.jad_an(r4)
            r0.append(r14)
            java.lang.String r14 = ", hasAlpha: "
            r0.append(r14)
            boolean r12 = r12.hasAlpha()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.lang.Object[] r14 = new java.lang.Object[r2]
            r14[r1] = r12
            com.jd.ad.sdk.logger.Logger.v(r3, r14)
        Lcd:
            return r13
        Lce:
            r9 = r8
        Lcf:
            if (r9 == 0) goto Ld6
            r9.close()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> Ld6
            goto Ld6
        Ld5:
            throw r12
        Ld6:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_rc.jad_cp.jad_an(com.jd.ad.sdk.jad_kv.jad_xk, java.io.File, com.jd.ad.sdk.jad_hs.jad_jw):boolean");
    }
}
