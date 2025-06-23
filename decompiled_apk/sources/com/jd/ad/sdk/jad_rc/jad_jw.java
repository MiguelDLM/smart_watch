package com.jd.ad.sdk.jad_rc;

import XXO0.oIX0oI;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_hs.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* loaded from: classes10.dex */
public final class jad_jw {
    public static final com.jd.ad.sdk.jad_hs.jad_iv<Boolean> jad_hu;
    public static final com.jd.ad.sdk.jad_hs.jad_iv<Boolean> jad_iv;
    public static final Set<String> jad_jw;
    public static final jad_bo jad_kx;
    public static final Set<jad_fs.jad_bo> jad_ly;
    public static final Queue<BitmapFactory.Options> jad_mz;
    public final com.jd.ad.sdk.jad_lw.jad_er jad_an;
    public final DisplayMetrics jad_bo;
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_cp;
    public final List<com.jd.ad.sdk.jad_hs.jad_fs> jad_dq;
    public final jad_na jad_er = jad_na.jad_an();
    public static final com.jd.ad.sdk.jad_hs.jad_iv<com.jd.ad.sdk.jad_hs.jad_bo> jad_fs = com.jd.ad.sdk.jad_hs.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.jd.ad.sdk.jad_hs.jad_bo.PREFER_ARGB_8888);
    public static final com.jd.ad.sdk.jad_hs.jad_iv<com.jd.ad.sdk.jad_hs.jad_kx> jad_jt = new com.jd.ad.sdk.jad_hs.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, com.jd.ad.sdk.jad_hs.jad_iv.jad_er);

    /* loaded from: classes10.dex */
    public class jad_an implements jad_bo {
        @Override // com.jd.ad.sdk.jad_rc.jad_jw.jad_bo
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_jw.jad_bo
        public void jad_an(com.jd.ad.sdk.jad_lw.jad_er jad_erVar, Bitmap bitmap) {
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_bo {
        void jad_an();

        void jad_an(com.jd.ad.sdk.jad_lw.jad_er jad_erVar, Bitmap bitmap);
    }

    static {
        com.jd.ad.sdk.jad_hs.jad_iv<jad_iv> jad_ivVar = jad_iv.jad_dq;
        Boolean bool = Boolean.FALSE;
        jad_hu = com.jd.ad.sdk.jad_hs.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        jad_iv = com.jd.ad.sdk.jad_hs.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        jad_jw = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        jad_kx = new jad_an();
        jad_ly = Collections.unmodifiableSet(EnumSet.of(jad_fs.jad_bo.JPEG, jad_fs.jad_bo.PNG_A, jad_fs.jad_bo.PNG));
        char[] cArr = com.jd.ad.sdk.jad_gp.jad_ly.jad_an;
        jad_mz = new ArrayDeque(0);
    }

    public jad_jw(List<com.jd.ad.sdk.jad_hs.jad_fs> list, DisplayMetrics displayMetrics, com.jd.ad.sdk.jad_lw.jad_er jad_erVar, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        this.jad_dq = list;
        this.jad_bo = (DisplayMetrics) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(displayMetrics);
        this.jad_an = (com.jd.ad.sdk.jad_lw.jad_er) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_erVar);
        this.jad_cp = (com.jd.ad.sdk.jad_lw.jad_bo) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_boVar);
    }

    public static int jad_an(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static int jad_bo(double d) {
        return (int) (d + 0.5d);
    }

    @Nullable
    @TargetApi(19)
    public static String jad_an(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an(" (");
        jad_an2.append(bitmap.getAllocationByteCount());
        jad_an2.append(oIX0oI.I0Io.f4095I0Io);
        String sb = jad_an2.toString();
        StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("[");
        jad_an3.append(bitmap.getWidth());
        jad_an3.append("x");
        jad_an3.append(bitmap.getHeight());
        jad_an3.append("] ");
        jad_an3.append(bitmap.getConfig());
        jad_an3.append(sb);
        return jad_an3.toString();
    }

    public static int[] jad_bo(jad_ob jad_obVar, BitmapFactory.Options options, jad_bo jad_boVar, com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        options.inJustDecodeBounds = true;
        jad_an(jad_obVar, options, jad_boVar, jad_erVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static void jad_an(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static boolean jad_an(int i) {
        return i == 90 || i == 270;
    }

    public final com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an(jad_ob jad_obVar, int i, int i2, com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar, jad_bo jad_boVar) {
        Queue<BitmapFactory.Options> queue;
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.jad_cp.jad_an(65536, byte[].class);
        synchronized (jad_jw.class) {
            queue = jad_mz;
            synchronized (queue) {
                options = (BitmapFactory.Options) ((ArrayDeque) queue).poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                jad_an(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        com.jd.ad.sdk.jad_hs.jad_bo jad_boVar2 = (com.jd.ad.sdk.jad_hs.jad_bo) jad_jwVar.jad_an(jad_fs);
        com.jd.ad.sdk.jad_hs.jad_kx jad_kxVar = (com.jd.ad.sdk.jad_hs.jad_kx) jad_jwVar.jad_an(jad_jt);
        jad_iv jad_ivVar = (jad_iv) jad_jwVar.jad_an(jad_iv.jad_dq);
        boolean booleanValue = ((Boolean) jad_jwVar.jad_an(jad_hu)).booleanValue();
        com.jd.ad.sdk.jad_hs.jad_iv<Boolean> jad_ivVar2 = jad_iv;
        try {
            jad_er jad_an2 = jad_er.jad_an(jad_an(jad_obVar, options2, jad_ivVar, jad_boVar2, jad_kxVar, jad_jwVar.jad_an(jad_ivVar2) != null && ((Boolean) jad_jwVar.jad_an(jad_ivVar2)).booleanValue(), i, i2, booleanValue, jad_boVar), this.jad_an);
            jad_an(options2);
            synchronized (queue) {
                ((ArrayDeque) queue).offer(options2);
            }
            this.jad_cp.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
            return jad_an2;
        } catch (Throwable th) {
            jad_an(options2);
            Queue<BitmapFactory.Options> queue2 = jad_mz;
            synchronized (queue2) {
                ((ArrayDeque) queue2).offer(options2);
                this.jad_cp.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0419, code lost:
    
        r0 = r37.outColorSpace;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0436, code lost:
    
        if (r0 >= 26) goto L175;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0349 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap jad_an(com.jd.ad.sdk.jad_rc.jad_ob r36, android.graphics.BitmapFactory.Options r37, com.jd.ad.sdk.jad_rc.jad_iv r38, com.jd.ad.sdk.jad_hs.jad_bo r39, com.jd.ad.sdk.jad_hs.jad_kx r40, boolean r41, int r42, int r43, boolean r44, com.jd.ad.sdk.jad_rc.jad_jw.jad_bo r45) {
        /*
            Method dump skipped, instructions count: 1502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_rc.jad_jw.jad_an(com.jd.ad.sdk.jad_rc.jad_ob, android.graphics.BitmapFactory$Options, com.jd.ad.sdk.jad_rc.jad_iv, com.jd.ad.sdk.jad_hs.jad_bo, com.jd.ad.sdk.jad_hs.jad_kx, boolean, int, int, boolean, com.jd.ad.sdk.jad_rc.jad_jw$jad_bo):android.graphics.Bitmap");
    }

    public static Bitmap jad_an(jad_ob jad_obVar, BitmapFactory.Options options, jad_bo jad_boVar, com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        if (!options.inJustDecodeBounds) {
            jad_boVar.jad_an();
            jad_obVar.jad_bo();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        Lock lock = jad_vi.jad_bo;
        lock.lock();
        try {
            try {
                Bitmap jad_an2 = jad_obVar.jad_an(options);
                lock.unlock();
                return jad_an2;
            } catch (IllegalArgumentException e) {
                IOException jad_an3 = jad_an(e, i, i2, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Logger.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", jad_an3);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw jad_an3;
                }
                try {
                    jad_erVar.jad_an(bitmap);
                    options.inBitmap = null;
                    Bitmap jad_an4 = jad_an(jad_obVar, options, jad_boVar, jad_erVar);
                    jad_vi.jad_bo.unlock();
                    return jad_an4;
                } catch (IOException unused) {
                    throw jad_an3;
                }
            }
        } catch (Throwable th) {
            jad_vi.jad_bo.unlock();
            throw th;
        }
    }

    public static IOException jad_an(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + jad_an(options.inBitmap), illegalArgumentException);
    }
}
