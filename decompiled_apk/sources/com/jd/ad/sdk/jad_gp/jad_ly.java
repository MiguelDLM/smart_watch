package com.jd.ad.sdk.jad_gp;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import kotlin.text.II0XooXoX;

/* loaded from: classes10.dex */
public final class jad_ly {
    public static final char[] jad_an = II0XooXoX.f29508oIX0oI.toCharArray();
    public static final char[] jad_bo = new char[64];

    @Nullable
    public static volatile Handler jad_cp;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            Bitmap.Config config;
            int[] iArr = new int[Bitmap.Config.values().length];
            jad_an = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr2 = jad_an;
                config = Bitmap.Config.RGBA_F16;
                iArr2[config.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                jad_an[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int jad_an(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static Handler jad_bo() {
        if (jad_cp == null) {
            synchronized (jad_ly.class) {
                try {
                    if (jad_cp == null) {
                        jad_cp = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return jad_cp;
    }

    public static boolean jad_cp() {
        return !jad_dq();
    }

    public static boolean jad_dq() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static int jad_an(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = jad_an.jad_an[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    public static boolean jad_bo(int i, int i2) {
        return (i > 0 || i == Integer.MIN_VALUE) && (i2 > 0 || i2 == Integer.MIN_VALUE);
    }

    @TargetApi(19)
    public static int jad_an(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int jad_an(@Nullable Object obj, int i) {
        return jad_an(obj == null ? 0 : obj.hashCode(), i);
    }

    @NonNull
    public static <T> List<T> jad_an(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NonNull
    public static <T> Queue<T> jad_an(int i) {
        return new ArrayDeque(i);
    }

    public static void jad_an() {
        if (!jad_dq()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void jad_an(Runnable runnable) {
        jad_bo().post(runnable);
    }

    public static boolean jad_an(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }
}
