package com.huawei.openalliance.ad.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bumptech.glide.Registry;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.ds;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.ca;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class z {
    private static final String Code = "ImageUtil";
    private static final byte[] V = new byte[0];
    private static final Map<String, Set<an>> I = new HashMap();

    private static Set<an> B(String str) {
        return I.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(String str) {
        synchronized (V) {
            try {
                Set<an> B = B(str);
                if (B != null) {
                    Iterator<an> it = B.iterator();
                    while (it.hasNext()) {
                        it.next().Code();
                    }
                }
                Z(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static int Code(InputStream inputStream) {
        try {
            String Code2 = r.Code(inputStream);
            if (com.huawei.openalliance.ad.constant.x.aq.equals(Code2)) {
                return 4;
            }
            return Code2 != null ? 2 : 100;
        } catch (Resources.NotFoundException unused) {
            fb.Z(Code, "resId is not found");
            return 100;
        }
    }

    private static Pair<Drawable, String> I(BitmapFactory.Options options, String str, Context context) {
        String str2;
        BitmapDrawable bitmapDrawable = null;
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), Integer.parseInt(str.substring(ca.RES.toString().length())), options);
            if (decodeResource == null) {
                fb.V(Code, "Image decode fail");
                aq.Code(context).V((Integer) 0);
            }
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), decodeResource);
            str2 = null;
            bitmapDrawable = bitmapDrawable2;
        } catch (Resources.NotFoundException e) {
            fb.I(Code, "loadImage " + e.getClass().getSimpleName());
            str2 = "loadResImg Resources.NotFoundException";
        } catch (NumberFormatException e2) {
            fb.I(Code, "loadImage " + e2.getClass().getSimpleName());
            str2 = "loadResImg NumberFormatException";
        }
        return new Pair<>(bitmapDrawable, str2);
    }

    private static Drawable S(String str) {
        return y.Code().Code(au.Code(str));
    }

    public static Bitmap V(Drawable drawable) {
        Bitmap Code2;
        if (drawable == null || (Code2 = Code(drawable)) == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(Code2, 0, 0, Code2.getWidth(), Code2.getHeight(), matrix, false);
    }

    private static void Z(String str) {
        synchronized (V) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                I.remove(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Bitmap Code(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            fb.V(Code, Registry.BUCKET_BITMAP_DRAWABLE);
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth > 0 ? intrinsicWidth : 1, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Code(drawable, createBitmap);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(String str) {
        boolean containsKey;
        synchronized (V) {
            containsKey = I.containsKey(str);
        }
        return containsKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    private static Pair<Drawable, String> V(BitmapFactory.Options options, String str, Context context) {
        InputStream inputStream;
        String str2;
        String substring = str.substring(ca.ASSET.toString().length());
        ?? r1 = 0;
        BitmapDrawable bitmapDrawable = null;
        try {
            try {
                inputStream = context.getAssets().open(substring);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    if (decodeStream == null) {
                        fb.V(Code, "Image decode fail");
                        aq.Code(context).V((Integer) 0);
                    }
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), decodeStream);
                    ax.Code((Closeable) inputStream);
                    str2 = null;
                    bitmapDrawable = bitmapDrawable2;
                } catch (IOException e) {
                    e = e;
                    str2 = "loadAssetImg " + e.getClass().getSimpleName();
                    fb.I(Code, "lAI " + e.getClass().getSimpleName());
                    ax.Code((Closeable) inputStream);
                    return new Pair<>(bitmapDrawable, str2);
                }
            } catch (Throwable th) {
                th = th;
                r1 = substring;
                ax.Code((Closeable) r1);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            ax.Code((Closeable) r1);
            throw th;
        }
        return new Pair<>(bitmapDrawable, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r7v13, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r7v16, types: [android.graphics.drawable.Drawable] */
    private static Pair<Drawable, String> Code(Context context, String str) {
        Object obj;
        Object obj2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Object obj3 = null;
        try {
            options.inJustDecodeBounds = false;
        } catch (OutOfMemoryError unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
        } catch (OutOfMemoryError unused2) {
            obj3 = str;
            fb.I(Code, "OOM read image");
            obj = obj3;
            obj3 = "OOM read image";
            return new Pair<>(obj, obj3);
        } catch (Throwable th2) {
            th = th2;
            obj3 = str;
            Object obj4 = "loadImageFromDisk " + th.getClass().getSimpleName();
            fb.I(Code, "loadImageFromDisk " + th.getClass().getSimpleName());
            Object obj5 = obj3;
            obj3 = obj4;
            obj = obj5;
            return new Pair<>(obj, obj3);
        }
        if (str.startsWith(ca.RES.toString())) {
            Pair<Drawable, String> I2 = I(options, str, context);
            ?? r7 = (Drawable) I2.first;
            obj2 = I2.second;
            str = r7;
        } else if (str.startsWith(ca.ASSET.toString())) {
            Pair<Drawable, String> V2 = V(options, str, context);
            ?? r72 = (Drawable) V2.first;
            obj2 = V2.second;
            str = r72;
        } else {
            if (!str.startsWith(ca.CONTENT.toString())) {
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile == null) {
                    fb.V(Code, "Image decode fail");
                    aq.Code(context).V((Integer) 0);
                }
                obj = new BitmapDrawable(context.getResources(), decodeFile);
                return new Pair<>(obj, obj3);
            }
            Pair<Drawable, String> Code2 = Code(options, str, context);
            ?? r73 = (Drawable) Code2.first;
            obj2 = Code2.second;
            str = r73;
        }
        obj3 = (String) obj2;
        obj = str;
        return new Pair<>(obj, obj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, int i, SourceParam sourceParam, String str) {
        if (sourceParam == null || sourceParam.F() == null) {
            return;
        }
        cy.Code(context, i, str, sourceParam.F());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.Closeable] */
    private static Pair<Drawable, String> Code(BitmapFactory.Options options, String str, Context context) {
        ?? r9;
        InputStream inputStream;
        InputStream inputStream2;
        String str2;
        String str3;
        Uri parse;
        ContentResolver contentResolver;
        InputStream inputStream3 = null;
        try {
            try {
                parse = Uri.parse(str);
                contentResolver = context.getContentResolver();
                inputStream2 = contentResolver.openInputStream(parse);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (Code(inputStream2) == 4) {
                    Pair<Drawable, String> pair = new Pair<>(new ds(context, str), null);
                    ax.Code((Closeable) inputStream2);
                    ax.Code((Closeable) null);
                    return pair;
                }
                inputStream = contentResolver.openInputStream(parse);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    if (decodeStream == null) {
                        fb.V(Code, "Image decode fail");
                        aq.Code(context).V((Integer) 0);
                    }
                    Pair<Drawable, String> pair2 = new Pair<>(new BitmapDrawable(context.getResources(), decodeStream), null);
                    ax.Code((Closeable) inputStream2);
                    ax.Code((Closeable) inputStream);
                    return pair2;
                } catch (FileNotFoundException e) {
                    e = e;
                    str2 = "loadFromProvider FileNotFoundException";
                    str3 = "lfP " + e.getClass().getSimpleName();
                    fb.I(Code, str3);
                    ax.Code((Closeable) inputStream2);
                    ax.Code((Closeable) inputStream);
                    return new Pair<>(null, str2);
                } catch (Exception e2) {
                    e = e2;
                    str2 = "loadFromProvider " + e.getClass().getSimpleName();
                    str3 = "lfP " + e.getClass().getSimpleName();
                    fb.I(Code, str3);
                    ax.Code((Closeable) inputStream2);
                    ax.Code((Closeable) inputStream);
                    return new Pair<>(null, str2);
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                inputStream = null;
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                str = null;
                inputStream3 = inputStream2;
                r9 = str;
                ax.Code((Closeable) inputStream3);
                ax.Code((Closeable) r9);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            inputStream = null;
            inputStream2 = null;
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            r9 = 0;
            ax.Code((Closeable) inputStream3);
            ax.Code((Closeable) r9);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(final Context context, final SourceParam sourceParam, String str, String str2) {
        if (!ay.B(sourceParam.B())) {
            C(sourceParam.B());
            V(context, 2, sourceParam, "fromNet url is not http | " + sourceParam.D());
            return;
        }
        fb.V(Code, "loadImageFromNet");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", str);
            jSONObject.put("slotid", str2);
            jSONObject.put("content", aa.V(sourceParam));
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.L, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.z.2
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str3, CallResult<String> callResult) {
                    Context applicationContext;
                    SourceParam sourceParam2;
                    String str4;
                    int i;
                    String data = callResult.getData();
                    fb.V(z.Code, "get drawable from net, errorCode: %s filePath: %s", Integer.valueOf(callResult.getCode()), bh.Code(data));
                    if (data == null) {
                        z.C(SourceParam.this.B());
                        applicationContext = context.getApplicationContext();
                        sourceParam2 = SourceParam.this;
                        str4 = "filepath is null";
                        i = 3;
                    } else {
                        if (z.V(context.getApplicationContext(), SourceParam.this.B(), data, SourceParam.this)) {
                            return;
                        }
                        z.C(SourceParam.this.B());
                        applicationContext = context.getApplicationContext();
                        sourceParam2 = SourceParam.this;
                        str4 = "image not download";
                        i = 4;
                    }
                    z.V(applicationContext, i, sourceParam2, str4);
                }
            }, String.class);
        } catch (JSONException unused) {
            fb.I(Code, "loadImageInfo jsonex");
        }
    }

    public static void Code(Context context, SourceParam sourceParam, an anVar) {
        Code(context.getApplicationContext(), sourceParam, null, null, anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(String str, an anVar) {
        if (anVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (V) {
            try {
                Map<String, Set<an>> map = I;
                Set<an> set = map.get(str);
                if (set == null) {
                    set = new HashSet<>();
                    map.put(str, set);
                }
                set.add(anVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(Context context, String str, String str2, SourceParam sourceParam) {
        Integer c = aq.Code(context).c();
        if (c != null) {
            sourceParam.V(c.intValue());
        }
        Drawable S = S(str);
        if (S != null) {
            fb.V(Code, "get drawable from cache");
            Code(str, S);
            return true;
        }
        if (ay.B(str2)) {
            return false;
        }
        Pair<Drawable, String> Code2 = Code(context, str2);
        Drawable drawable = (Drawable) Code2.first;
        sourceParam.Z((String) Code2.second);
        if (drawable == null) {
            return false;
        }
        fb.V(Code, "get drawable from disk");
        y.Code().Code(au.Code(str), drawable);
        Code(str, drawable);
        return true;
    }

    public static void Code(Context context, final SourceParam sourceParam, final String str, final String str2, final an anVar) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        final Context context2 = context;
        if (sourceParam == null || sourceParam.B() == null) {
            anVar.Code();
            V(context2, 1, sourceParam, "url is null");
            return;
        }
        fb.V(Code, "load: " + bh.Code(sourceParam.B()));
        h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.z.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (z.V) {
                    try {
                        String B = SourceParam.this.B();
                        if (z.I(B)) {
                            z.V(B, anVar);
                            return;
                        }
                        z.V(B, anVar);
                        if (z.V(context2, SourceParam.this.B(), SourceParam.this.B(), SourceParam.this)) {
                            return;
                        }
                        h.V(new Runnable() { // from class: com.huawei.openalliance.ad.utils.z.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                z.V(context2, SourceParam.this, str, str2);
                            }
                        });
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    private static void Code(Drawable drawable, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
    }

    private static void Code(String str, Drawable drawable) {
        synchronized (V) {
            try {
                Set<an> B = B(str);
                if (B != null) {
                    Iterator<an> it = B.iterator();
                    while (it.hasNext()) {
                        it.next().Code(str, drawable);
                    }
                }
                Z(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
