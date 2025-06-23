package com.baidu.navisdk.util.cache;

import android.graphics.Bitmap;
import com.baidu.navisdk.k;
import com.baidu.navisdk.util.common.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class a extends LinkedHashMap<String, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private int f9216a;
    private boolean b;
    protected Object c;
    private String d;

    public a(String str, int i) {
        super(i, 0.75f, true);
        this.b = true;
        this.c = new Object();
        this.f9216a = i;
        this.d = str;
        File file = new File(this.d);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public boolean a(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        synchronized (this.c) {
            File file = new File(str);
            if (file.exists() && file.length() > 0) {
                return true;
            }
            try {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArrayOutputStream.writeTo(fileOutputStream);
                try {
                    byteArrayOutputStream.close();
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap put(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        synchronized (this.c) {
            bitmap2 = (Bitmap) super.put(str, bitmap);
        }
        return bitmap2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0121 A[Catch: all -> 0x0011, IOException -> 0x011d, TRY_LEAVE, TryCatch #27 {IOException -> 0x011d, blocks: (B:128:0x0119, B:121:0x0121), top: B:127:0x0119, outer: #22 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f3 A[Catch: all -> 0x0011, IOException -> 0x00ef, TRY_LEAVE, TryCatch #6 {IOException -> 0x00ef, blocks: (B:73:0x00eb, B:67:0x00f3), top: B:72:0x00eb, outer: #22 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010c A[Catch: all -> 0x0011, IOException -> 0x0108, TRY_LEAVE, TryCatch #7 {IOException -> 0x0108, blocks: (B:84:0x0104, B:78:0x010c), top: B:83:0x0104, outer: #22 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00da A[Catch: all -> 0x0011, IOException -> 0x00d6, TRY_LEAVE, TryCatch #17 {IOException -> 0x00d6, blocks: (B:95:0x00d2, B:89:0x00da), top: B:94:0x00d2, outer: #22 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap c(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.cache.a.c(java.lang.String):android.graphics.Bitmap");
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        synchronized (this.c) {
            try {
                if (this.b) {
                    Iterator<Map.Entry<String, Bitmap>> it = entrySet().iterator();
                    while (it.hasNext()) {
                        Bitmap value = it.next().getValue();
                        if (k.f6861a && value != null && !value.isRecycled()) {
                            value.recycle();
                        }
                    }
                }
                super.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
        if (size() > this.f9216a) {
            if (this.b) {
                Bitmap value = entry.getValue();
                if (k.f6861a && value != null && !value.isRecycled()) {
                    value.recycle();
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Bitmap get(Object obj) {
        try {
            return (Bitmap) super.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String b(String str) {
        return v.b(str);
    }

    public String a(String str) {
        return this.d + File.separator + b(str);
    }
}
