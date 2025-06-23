package com.baidu.navisdk.widget.naviimageloader;

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
public class i extends LinkedHashMap<String, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private int f9422a;
    private boolean b;
    protected Object c;
    private String d;

    public i(String str, int i) {
        super(i, 0.75f, true);
        this.b = true;
        this.c = new Object();
        this.f9422a = i;
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
        if (size() > this.f9422a) {
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
