package com.ss.android.socialbase.appdownloader.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f26177a = 8;
    private static volatile c b;
    private a<Integer, Bitmap> c;

    /* loaded from: classes13.dex */
    public static class a<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: a, reason: collision with root package name */
        final int f26179a;

        public a(int i, int i2) {
            super(i2, 0.75f, true);
            this.f26179a = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            if (size() > this.f26179a) {
                return true;
            }
            return false;
        }
    }

    private c() {
        this.c = null;
        int i = f26177a;
        this.c = new a<>(i, i / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public Bitmap a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public void a(final int i, final String str) {
        if (TextUtils.isEmpty(str) || a(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.c.m().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.e.c.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStream;
                Exception e;
                i a2;
                int i2 = 4;
                i2 = 4;
                i2 = 4;
                i2 = 4;
                i2 = 4;
                try {
                    try {
                        a2 = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, str, null);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e = e2;
                    inputStream = null;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th3;
                    inputStream = null;
                }
                if (a2 == null) {
                    f.a(null, null, null, null);
                    return;
                }
                inputStream = a2.a();
                try {
                    byteArrayOutputStream = c.b(inputStream);
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                int a3 = com.ss.android.socialbase.appdownloader.c.a(com.ss.android.socialbase.downloader.downloader.c.O(), 44.0f);
                                options.inSampleSize = c.a(a3, a3, options);
                                options.inJustDecodeBounds = false;
                                c.this.c.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                Closeable[] closeableArr = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                                f.a(closeableArr);
                                i2 = closeableArr;
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                Closeable[] closeableArr2 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                                f.a(closeableArr2);
                                i2 = closeableArr2;
                            }
                        } catch (Exception e4) {
                            byteArrayInputStream2 = null;
                            e = e4;
                        } catch (Throwable th4) {
                            byteArrayInputStream2 = null;
                            th = th4;
                            Closeable[] closeableArr3 = new Closeable[i2];
                            closeableArr3[0] = inputStream;
                            closeableArr3[1] = byteArrayOutputStream;
                            closeableArr3[2] = byteArrayInputStream;
                            closeableArr3[3] = byteArrayInputStream2;
                            f.a(closeableArr3);
                            throw th;
                        }
                    } catch (Exception e5) {
                        byteArrayInputStream2 = null;
                        e = e5;
                        byteArrayInputStream = null;
                    } catch (Throwable th5) {
                        byteArrayInputStream2 = null;
                        th = th5;
                        byteArrayInputStream = null;
                    }
                } catch (Exception e6) {
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e = e6;
                    byteArrayOutputStream = null;
                } catch (Throwable th6) {
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th6;
                    byteArrayOutputStream = null;
                }
            }
        });
    }

    public static int a(int i, int i2, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return Math.min(Math.round(i3 / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
