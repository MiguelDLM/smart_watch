package com.jd.ad.sdk.jad_mx;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.jd.ad.sdk.jad_ep.jad_ly;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes10.dex */
public final class jad_iv {
    public final int jad_an;
    public final int jad_bo;
    public final Context jad_cp;
    public final int jad_dq;

    /* loaded from: classes10.dex */
    public static final class jad_an {
        public static final int jad_er;
        public final Context jad_an;
        public ActivityManager jad_bo;
        public jad_cp jad_cp;
        public float jad_dq;

        static {
            jad_er = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public jad_an(Context context) {
            this.jad_dq = jad_er;
            this.jad_an = context;
            this.jad_bo = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            this.jad_cp = new jad_bo(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !jad_iv.jad_an(this.jad_bo)) {
                return;
            }
            this.jad_dq = 0.0f;
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo implements jad_cp {
        public final DisplayMetrics jad_an;

        public jad_bo(DisplayMetrics displayMetrics) {
            this.jad_an = displayMetrics;
        }

        public int jad_an() {
            return this.jad_an.heightPixels;
        }

        public int jad_bo() {
            return this.jad_an.widthPixels;
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_cp {
    }

    public jad_iv(jad_an jad_anVar) {
        this.jad_cp = jad_anVar.jad_an;
        int i = jad_an(jad_anVar.jad_bo) ? 2097152 : 4194304;
        this.jad_dq = i;
        int jad_an2 = jad_an(jad_anVar.jad_bo, 0.4f, 0.33f);
        float jad_an3 = ((jad_bo) jad_anVar.jad_cp).jad_an() * ((jad_bo) jad_anVar.jad_cp).jad_bo() * 4;
        int round = Math.round(jad_anVar.jad_dq * jad_an3);
        int round2 = Math.round(jad_an3 * 2.0f);
        int i2 = jad_an2 - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.jad_bo = round2;
            this.jad_an = round;
        } else {
            float f = i2 / (jad_anVar.jad_dq + 2.0f);
            this.jad_bo = Math.round(2.0f * f);
            this.jad_an = Math.round(f * jad_anVar.jad_dq);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder jad_an4 = jad_ly.jad_an("Calculation complete, Calculated memory cache size: ");
            jad_an4.append(jad_an(this.jad_bo));
            jad_an4.append(", pool size: ");
            jad_an4.append(jad_an(this.jad_an));
            jad_an4.append(", byte array size: ");
            jad_an4.append(jad_an(i));
            jad_an4.append(", memory class limited? ");
            jad_an4.append(i3 > jad_an2);
            jad_an4.append(", max size: ");
            jad_an4.append(jad_an(jad_an2));
            jad_an4.append(", memoryClass: ");
            jad_an4.append(jad_anVar.jad_bo.getMemoryClass());
            jad_an4.append(", isLowMemoryDevice: ");
            jad_an4.append(jad_an(jad_anVar.jad_bo));
            Logger.d("MemorySizeCalculator", jad_an4.toString());
        }
    }

    public static int jad_an(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (jad_an(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    public final String jad_an(int i) {
        return Formatter.formatFileSize(this.jad_cp, i);
    }

    @TargetApi(19)
    public static boolean jad_an(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
