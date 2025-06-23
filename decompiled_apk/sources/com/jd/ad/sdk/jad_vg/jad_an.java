package com.jd.ad.sdk.jad_vg;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.jad_hs.jad_fs;
import com.jd.ad.sdk.jad_hs.jad_ly;
import com.jd.ad.sdk.jad_kv.jad_xk;
import com.jd.ad.sdk.jad_vg.jad_cp;
import com.jd.ad.sdk.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/* loaded from: classes10.dex */
public class jad_an implements jad_ly<ByteBuffer, jad_cp> {
    public static final C0718jad_an jad_fs = new C0718jad_an();
    public static final jad_bo jad_jt = new jad_bo();
    public final Context jad_an;
    public final List<com.jd.ad.sdk.jad_hs.jad_fs> jad_bo;
    public final jad_bo jad_cp;
    public final C0718jad_an jad_dq;
    public final com.jd.ad.sdk.jad_vg.jad_bo jad_er;

    @VisibleForTesting
    /* renamed from: com.jd.ad.sdk.jad_vg.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0718jad_an {
    }

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public static class jad_bo {
        public final Queue<com.jd.ad.sdk.jad_gr.jad_dq> jad_an = com.jd.ad.sdk.jad_gp.jad_ly.jad_an(0);
    }

    public jad_an(Context context, List<com.jd.ad.sdk.jad_hs.jad_fs> list, com.jd.ad.sdk.jad_lw.jad_er jad_erVar, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        this(context, list, jad_erVar, jad_boVar, jad_jt, jad_fs);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public jad_xk<jad_cp> jad_an(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_gr.jad_dq jad_dqVar;
        ByteBuffer byteBuffer2 = byteBuffer;
        jad_bo jad_boVar = this.jad_cp;
        synchronized (jad_boVar) {
            try {
                com.jd.ad.sdk.jad_gr.jad_dq poll = jad_boVar.jad_an.poll();
                if (poll == null) {
                    poll = new com.jd.ad.sdk.jad_gr.jad_dq();
                }
                jad_dqVar = poll;
                jad_dqVar.jad_bo = null;
                Arrays.fill(jad_dqVar.jad_an, (byte) 0);
                jad_dqVar.jad_cp = new com.jd.ad.sdk.jad_gr.jad_cp();
                jad_dqVar.jad_dq = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer2.asReadOnlyBuffer();
                jad_dqVar.jad_bo = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                jad_dqVar.jad_bo.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            jad_er jad_an = jad_an(byteBuffer2, i, i2, jad_dqVar, jad_jwVar);
            jad_bo jad_boVar2 = this.jad_cp;
            synchronized (jad_boVar2) {
                jad_dqVar.jad_bo = null;
                jad_dqVar.jad_cp = null;
                jad_boVar2.jad_an.offer(jad_dqVar);
            }
            return jad_an;
        } catch (Throwable th2) {
            jad_bo jad_boVar3 = this.jad_cp;
            synchronized (jad_boVar3) {
                jad_dqVar.jad_bo = null;
                jad_dqVar.jad_cp = null;
                jad_boVar3.jad_an.offer(jad_dqVar);
                throw th2;
            }
        }
    }

    @VisibleForTesting
    public jad_an(Context context, List<com.jd.ad.sdk.jad_hs.jad_fs> list, com.jd.ad.sdk.jad_lw.jad_er jad_erVar, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar, jad_bo jad_boVar2, C0718jad_an c0718jad_an) {
        this.jad_an = context.getApplicationContext();
        this.jad_bo = list;
        this.jad_dq = c0718jad_an;
        this.jad_er = new com.jd.ad.sdk.jad_vg.jad_bo(jad_erVar, jad_boVar);
        this.jad_cp = jad_boVar2;
    }

    @Nullable
    public final jad_er jad_an(ByteBuffer byteBuffer, int i, int i2, com.jd.ad.sdk.jad_gr.jad_dq jad_dqVar, com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        long jad_an = com.jd.ad.sdk.jad_gp.jad_jt.jad_an();
        try {
            com.jd.ad.sdk.jad_gr.jad_cp jad_bo2 = jad_dqVar.jad_bo();
            if (jad_bo2.jad_cp > 0 && jad_bo2.jad_bo == 0) {
                Bitmap.Config config = jad_jwVar.jad_an(jad_iv.jad_an) == com.jd.ad.sdk.jad_hs.jad_bo.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int jad_an2 = jad_an(jad_bo2, i, i2);
                C0718jad_an c0718jad_an = this.jad_dq;
                com.jd.ad.sdk.jad_vg.jad_bo jad_boVar = this.jad_er;
                c0718jad_an.getClass();
                com.jd.ad.sdk.jad_gr.jad_er jad_erVar = new com.jd.ad.sdk.jad_gr.jad_er(jad_boVar);
                jad_erVar.jad_an(jad_bo2, byteBuffer, jad_an2);
                jad_erVar.jad_an(config);
                jad_erVar.jad_kx = (jad_erVar.jad_kx + 1) % jad_erVar.jad_ly.jad_cp;
                Bitmap jad_fs2 = jad_erVar.jad_fs();
                if (jad_fs2 == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Decoded GIF from stream in ");
                        jad_an3.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(jad_an));
                        Logger.v("BufferGifDecoder", jad_an3.toString());
                    }
                    return null;
                }
                jad_er jad_erVar2 = new jad_er(new jad_cp(new jad_cp.jad_an(new jad_jt(com.jd.ad.sdk.jad_ep.jad_cp.jad_an(this.jad_an), jad_erVar, i, i2, (com.jd.ad.sdk.jad_qb.jad_bo) com.jd.ad.sdk.jad_qb.jad_bo.jad_bo, jad_fs2))));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    StringBuilder jad_an4 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Decoded GIF from stream in ");
                    jad_an4.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(jad_an));
                    Logger.v("BufferGifDecoder", jad_an4.toString());
                }
                return jad_erVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder jad_an5 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Decoded GIF from stream in ");
                jad_an5.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(jad_an));
                Logger.v("BufferGifDecoder", jad_an5.toString());
            }
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder jad_an6 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Decoded GIF from stream in ");
                jad_an6.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(jad_an));
                Logger.v("BufferGifDecoder", jad_an6.toString());
            }
            throw th;
        }
    }

    public static int jad_an(com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar, int i, int i2) {
        int min = Math.min(jad_cpVar.jad_jt / i2, jad_cpVar.jad_fs / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Logger.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + jad_cpVar.jad_fs + "x" + jad_cpVar.jad_jt + "]");
        }
        return max;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public boolean jad_an(@NonNull ByteBuffer byteBuffer, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return !((Boolean) jad_jwVar.jad_an(jad_iv.jad_bo)).booleanValue() && com.jd.ad.sdk.jad_hs.jad_jt.jad_an(this.jad_bo, byteBuffer) == jad_fs.jad_bo.GIF;
    }
}
