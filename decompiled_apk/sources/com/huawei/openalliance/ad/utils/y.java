package com.huawei.openalliance.ad.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.huawei.hms.ads.ds;
import com.huawei.hms.ads.fb;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
public class y {
    private static final byte[] B = new byte[0];
    private static final int I = 31457280;
    private static final String V = "y";
    private static y Z;
    LruCache<String, WeakReference<Drawable>> Code;

    private y() {
        V();
    }

    private void V() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        this.Code = new LruCache<String, WeakReference<Drawable>>(Math.min(I, maxMemory > 0 ? maxMemory / 4 : I)) { // from class: com.huawei.openalliance.ad.utils.y.1
            @Override // android.util.LruCache
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, WeakReference<Drawable> weakReference) {
                Drawable drawable;
                if (weakReference == null || (drawable = weakReference.get()) == null) {
                    return 1;
                }
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof ds) {
                        return ((ds) drawable).I();
                    }
                    return 1;
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    return bitmap.getByteCount();
                }
                return 1;
            }
        };
    }

    public Drawable Code(String str) {
        try {
            WeakReference<Drawable> weakReference = this.Code.get(str);
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        } catch (Throwable th) {
            fb.I(V, "get cache encounter: " + th.getClass().getSimpleName());
            return null;
        }
    }

    public static y Code() {
        y yVar;
        synchronized (B) {
            try {
                if (Z == null) {
                    Z = new y();
                }
                yVar = Z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar;
    }

    public void Code(String str, Drawable drawable) {
        try {
            this.Code.put(str, new WeakReference<>(drawable));
        } catch (Throwable th) {
            fb.I(V, "put cache encounter: " + th.getClass().getSimpleName());
        }
    }
}
