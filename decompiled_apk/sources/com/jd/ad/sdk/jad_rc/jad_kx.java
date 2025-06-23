package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;

/* loaded from: classes10.dex */
public final class jad_kx {
    public static final com.jd.ad.sdk.jad_lw.jad_er jad_an = new jad_an();

    /* loaded from: classes10.dex */
    public class jad_an extends com.jd.ad.sdk.jad_lw.jad_fs {
        @Override // com.jd.ad.sdk.jad_lw.jad_fs, com.jd.ad.sdk.jad_lw.jad_er
        public void jad_an(Bitmap bitmap) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x00b1  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.jd.ad.sdk.jad_kv.jad_xk<android.graphics.Bitmap> jad_an(com.jd.ad.sdk.jad_lw.jad_er r8, android.graphics.drawable.Drawable r9, int r10, int r11) {
        /*
            r0 = 1
            android.graphics.drawable.Drawable r9 = r9.getCurrent()
            boolean r1 = r9 instanceof android.graphics.drawable.BitmapDrawable
            r2 = 0
            if (r1 == 0) goto L13
            android.graphics.drawable.BitmapDrawable r9 = (android.graphics.drawable.BitmapDrawable) r9
            android.graphics.Bitmap r9 = r9.getBitmap()
        L10:
            r0 = 0
            goto Lae
        L13:
            boolean r1 = r9 instanceof android.graphics.drawable.Animatable
            r3 = 0
            if (r1 != 0) goto Lab
            java.lang.String r1 = "Unable to draw "
            r4 = 5
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r6 = "DrawableToBitmap"
            if (r10 != r5) goto L49
            int r7 = r9.getIntrinsicWidth()
            if (r7 > 0) goto L49
            boolean r10 = android.util.Log.isLoggable(r6, r4)
            if (r10 == 0) goto L72
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            r10.append(r9)
            java.lang.String r9 = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.Object[] r10 = new java.lang.Object[r0]
            r10[r2] = r9
            com.jd.ad.sdk.logger.Logger.w(r6, r10)
            goto L72
        L49:
            if (r11 != r5) goto L74
            int r5 = r9.getIntrinsicHeight()
            if (r5 > 0) goto L74
            boolean r10 = android.util.Log.isLoggable(r6, r4)
            if (r10 == 0) goto L72
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            r10.append(r9)
            java.lang.String r9 = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.Object[] r10 = new java.lang.Object[r0]
            r10[r2] = r9
            com.jd.ad.sdk.logger.Logger.w(r6, r10)
        L72:
            r9 = r3
            goto Lae
        L74:
            int r1 = r9.getIntrinsicWidth()
            if (r1 <= 0) goto L7e
            int r10 = r9.getIntrinsicWidth()
        L7e:
            int r1 = r9.getIntrinsicHeight()
            if (r1 <= 0) goto L88
            int r11 = r9.getIntrinsicHeight()
        L88:
            java.util.concurrent.locks.Lock r1 = com.jd.ad.sdk.jad_rc.jad_vi.jad_bo
            r1.lock()
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = r8.jad_an(r10, r11, r4)
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch: java.lang.Throwable -> La6
            r5.<init>(r4)     // Catch: java.lang.Throwable -> La6
            r9.setBounds(r2, r2, r10, r11)     // Catch: java.lang.Throwable -> La6
            r9.draw(r5)     // Catch: java.lang.Throwable -> La6
            r5.setBitmap(r3)     // Catch: java.lang.Throwable -> La6
            r1.unlock()
            r9 = r4
            goto Lae
        La6:
            r8 = move-exception
            r1.unlock()
            throw r8
        Lab:
            r9 = r3
            goto L10
        Lae:
            if (r0 == 0) goto Lb1
            goto Lb3
        Lb1:
            com.jd.ad.sdk.jad_lw.jad_er r8 = com.jd.ad.sdk.jad_rc.jad_kx.jad_an
        Lb3:
            com.jd.ad.sdk.jad_rc.jad_er r8 = com.jd.ad.sdk.jad_rc.jad_er.jad_an(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_rc.jad_kx.jad_an(com.jd.ad.sdk.jad_lw.jad_er, android.graphics.drawable.Drawable, int, int):com.jd.ad.sdk.jad_kv.jad_xk");
    }
}
