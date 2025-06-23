package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public final class jy {
    private static final String Code = "ShareUtil";
    private static final int I = 100;
    private static final int V = 2000;
    private static final int Z = 5;

    private jy() {
    }

    public static Bitmap Code(Context context, jv jvVar) {
        InputStream inputStream;
        try {
            inputStream = context.getContentResolver().openInputStream(Uri.parse(V(context, jvVar)));
            try {
                return BitmapFactory.decodeStream(inputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    fb.I(Code, "decode url as bitmap failed, caused: %s", th.getClass().getSimpleName());
                    return null;
                } finally {
                    com.huawei.openalliance.ad.utils.ax.Code((Closeable) inputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    private static Bitmap I(Context context, jv jvVar) {
        Bitmap Code2 = Code(context, jvVar);
        return Code2 == null ? BitmapFactory.decodeStream(context.getResources().openRawResource(jvVar.B())) : Code2;
    }

    public static String V(final Context context, jv jvVar) {
        if (context == null || jvVar == null) {
            return "";
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", jvVar.C());
            jSONObject.put("templateId", jvVar.S());
            jSONObject.put("slotid", jvVar.F());
            jSONObject.put("content", com.huawei.openalliance.ad.utils.aa.V(Code(jvVar)));
        } catch (Throwable th) {
            fb.I(Code, "get image file provider uri failed, caused: %s", th.getClass().getSimpleName());
        }
        return (String) com.huawei.openalliance.ad.utils.ba.Code(new Callable<String>() { // from class: com.huawei.hms.ads.jy.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public String call() {
                String str = (String) com.huawei.openalliance.ad.ipc.b.Code(context).Code(com.huawei.openalliance.ad.constant.s.L, jSONObject.toString(), String.class).getData();
                return str == null ? "" : str;
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, null);
    }

    private static Bitmap Code(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            return bitmap;
        }
        int min = Math.min(width, height);
        return Bitmap.createBitmap(bitmap, (width - min) / 2, (height - min) / 2, min, min);
    }

    private static SourceParam Code(jv jvVar) {
        ImageInfo D = jvVar.D();
        if (D == null) {
            D = new ImageInfo();
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.V(D.S());
        sourceParam.V(D.I());
        sourceParam.I(jvVar.Code());
        return sourceParam;
    }

    public static String Code(String str, int i) {
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static boolean Code(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            fb.I(Code, "class not fount %s", str);
            return false;
        }
    }

    public static byte[] Code(Context context, jv jvVar, int i) {
        byte[] bArr = new byte[0];
        if (jvVar == null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Bitmap I2 = I(context, jvVar);
            if (I2 == null) {
                return bArr;
            }
            Bitmap Code2 = Code(I2);
            int i2 = 100;
            Code2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            while (byteArrayOutputStream.toByteArray().length > i) {
                byteArrayOutputStream.reset();
                Code2.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                i2 -= 5;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                fb.I(Code, "get bitmap arr failed, cause: %s", th.getClass().getSimpleName());
                return bArr;
            } finally {
                com.huawei.openalliance.ad.utils.ax.Code(byteArrayOutputStream);
            }
        }
    }
}
