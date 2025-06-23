package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes10.dex */
public class ds extends Drawable implements Animatable, Drawable.Callback {
    private static final int B = 2;
    private static final int C = 119;
    private static final String Code = "GifDrawable";
    private static final int D = 2;
    private static final int F = 5;
    private static final int I = 640;
    private static final int L = 4;
    private static final String S = "render_frame";
    private static final int V = 0;
    private static final int Z = 960;
    private Paint f;
    private String i;
    private int l;
    private int m;
    private dr o;
    private Context p;
    private dt r;
    private boolean s;
    private com.huawei.openalliance.ad.utils.t t;
    private du v;
    private a w;

    /* renamed from: a, reason: collision with root package name */
    private final String f17260a = S + hashCode();
    private Canvas b = new Canvas();
    private Rect c = new Rect();
    private Rect d = new Rect();
    private Rect e = new Rect();
    private boolean g = false;
    private int h = 0;
    private Queue<dt> j = new ConcurrentLinkedQueue();
    private Queue<Bitmap> k = new ConcurrentLinkedQueue();
    private boolean n = false;
    private long q = 0;
    private final WeakHashMap<Drawable.Callback, Void> u = new WeakHashMap<>();

    /* loaded from: classes10.dex */
    public interface a {
        void Code(Bitmap bitmap);
    }

    public ds(Context context, String str) {
        this.p = context.getApplicationContext();
        this.i = str;
        com.huawei.openalliance.ad.utils.t tVar = new com.huawei.openalliance.ad.utils.t("gif-thread");
        this.t = tVar;
        tVar.Code();
        setCallback(this);
    }

    private InputStream B(String str) {
        String e;
        StringBuilder sb;
        try {
            return this.p.getResources().openRawResource(Integer.parseInt(str.substring(com.huawei.openalliance.ad.constant.ca.RES.toString().length())));
        } catch (Resources.NotFoundException e2) {
            e = e2;
            e = e();
            sb = new StringBuilder();
            sb.append("loadFile ");
            sb.append(e.getClass().getSimpleName());
            fb.I(e, sb.toString());
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
            e = e();
            sb = new StringBuilder();
            sb.append("loadFile ");
            sb.append(e.getClass().getSimpleName());
            fb.I(e, sb.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r11 > 640) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        r3 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        r4 = (int) (((r3 * r2) * 1.0f) / r11);
        com.huawei.hms.ads.fb.V(e(), "reduce image size to w: %d, h: %d src w: %d, h: %d", java.lang.Integer.valueOf(r3), java.lang.Integer.valueOf(r4), java.lang.Integer.valueOf(r11), java.lang.Integer.valueOf(r2));
        r2 = android.graphics.Bitmap.createBitmap(r3, r4, android.graphics.Bitmap.Config.RGB_565);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r11 > com.huawei.hms.ads.ds.Z) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap Code(android.graphics.Bitmap r10, boolean r11) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            boolean r2 = com.huawei.hms.ads.fb.Code()
            if (r2 == 0) goto L1f
            java.lang.String r2 = r9.e()
            java.util.Queue<android.graphics.Bitmap> r3 = r9.k
            int r3 = r3.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r0] = r3
            java.lang.String r3 = "image pool size: %d"
            com.huawei.hms.ads.fb.Code(r2, r3, r4)
        L1f:
            java.util.Queue<android.graphics.Bitmap> r2 = r9.k
            java.lang.Object r2 = r2.poll()
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            if (r2 != 0) goto L89
            java.lang.String r2 = r9.e()
            java.lang.String r3 = "cache bitmap null"
            com.huawei.hms.ads.fb.V(r2, r3)
            if (r11 == 0) goto L80
            int r11 = r10.getWidth()
            int r2 = r10.getHeight()
            if (r11 >= r2) goto L43
            r3 = 640(0x280, float:8.97E-43)
            if (r11 <= r3) goto L48
            goto L49
        L43:
            r3 = 960(0x3c0, float:1.345E-42)
            if (r11 <= r3) goto L48
            goto L49
        L48:
            r3 = r11
        L49:
            int r4 = r3 * r2
            float r4 = (float) r4
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 * r5
            float r5 = (float) r11
            float r4 = r4 / r5
            int r4 = (int) r4
            java.lang.String r5 = r9.e()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8 = 4
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r0] = r6
            r8[r1] = r7
            r0 = 2
            r8[r0] = r11
            r11 = 3
            r8[r11] = r2
            java.lang.String r11 = "reduce image size to w: %d, h: %d src w: %d, h: %d"
            com.huawei.hms.ads.fb.V(r5, r11, r8)
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.RGB_565
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r3, r4, r11)
            goto L89
        L80:
            android.graphics.Bitmap$Config r11 = r10.getConfig()
            android.graphics.Bitmap r10 = r10.copy(r11, r1)
            return r10
        L89:
            r9.Code(r10, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ds.Code(android.graphics.Bitmap, boolean):android.graphics.Bitmap");
    }

    public static /* synthetic */ int D(ds dsVar) {
        int i = dsVar.l;
        dsVar.l = i + 1;
        return i;
    }

    private Paint Z() {
        if (this.f == null) {
            this.f = new Paint(2);
        }
        return this.f;
    }

    private void b() {
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ds.6
            @Override // java.lang.Runnable
            public void run() {
                if (ds.this.v != null) {
                    ds.this.v.Code();
                }
            }
        });
    }

    private void c() {
        this.k.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        fb.V(e(), "on play end");
        c();
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ds.8
            @Override // java.lang.Runnable
            public void run() {
                if (ds.this.v != null) {
                    ds.this.v.I();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return "GifDrawable_" + hashCode();
    }

    public int I() {
        int size = (this.k.size() + this.j.size()) * getIntrinsicWidth() * getIntrinsicHeight() * 4;
        if (size > 0) {
            return size;
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        dt dtVar = this.r;
        if (dtVar == null || dtVar.V == null) {
            return;
        }
        if (fb.Code()) {
            fb.Code(e(), "draw frame: %d", Integer.valueOf(this.r.Code));
        }
        if (this.s) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.c);
            this.s = false;
        }
        canvas.drawBitmap(this.r.V, (Rect) null, this.c, Z());
    }

    public void finalize() {
        super.finalize();
        this.t.V();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        dt dtVar = this.r;
        return dtVar != null ? dtVar.V.getHeight() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        dt dtVar = this.r;
        return dtVar != null ? dtVar.V.getWidth() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.invalidateDrawable(drawable);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.s = true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Z().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Z().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        fb.V(e(), "setVisible " + z);
        if (!z) {
            stop();
        } else if (!this.g) {
            start();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        fb.V(e(), "start");
        this.g = true;
        Code();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        fb.V(e(), "stop");
        this.g = false;
        V();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        fb.V(e(), "replay " + com.huawei.openalliance.ad.utils.bh.Code(this.i));
        Code(this.i);
    }

    private InputStream C(String str) {
        try {
            return this.p.getAssets().open(str.substring(com.huawei.openalliance.ad.constant.ca.ASSET.toString().length()));
        } catch (IOException e) {
            fb.I(e(), "loadFile " + e.getClass().getSimpleName());
            return null;
        }
    }

    private void D() {
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ds.3
            @Override // java.lang.Runnable
            public void run() {
                if (ds.this.v != null) {
                    ds.this.v.V();
                }
                ds.this.V();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean F() {
        return this.n;
    }

    private InputStream I(String str) {
        try {
            return this.p.getContentResolver().openInputStream(Uri.parse(str));
        } catch (FileNotFoundException e) {
            fb.I(e(), "oPIs " + e.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        final dr drVar;
        if (F() || (drVar = this.o) == null || drVar.I()) {
            return;
        }
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.ds.4
            @Override // java.lang.Runnable
            public void run() {
                fb.V(ds.this.e(), "fetch next");
                long currentTimeMillis = System.currentTimeMillis();
                dt Code2 = drVar.Code();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                fb.Code(ds.this.e(), "frame fetch - decoding duration: %d gif: %s", Long.valueOf(currentTimeMillis2), Code2);
                ds dsVar = ds.this;
                if (Code2 == null) {
                    dt dtVar = (dt) dsVar.j.poll();
                    if (dtVar != null) {
                        ds.this.Code(dtVar);
                        return;
                    }
                    long currentTimeMillis3 = System.currentTimeMillis() - ds.this.q;
                    if (currentTimeMillis3 < ds.this.m) {
                        try {
                            Thread.sleep(ds.this.m - currentTimeMillis3);
                        } catch (InterruptedException unused) {
                            fb.Code(ds.this.e(), "InterruptedException");
                        }
                    }
                    ds.this.a();
                    return;
                }
                boolean Code3 = dsVar.Code(Code2, currentTimeMillis2);
                fb.Code(ds.this.e(), "need reduce size: %s", Boolean.valueOf(Code3));
                dt Code4 = Code2.Code();
                Code4.V = ds.this.Code(Code2.V, Code3);
                if (!ds.this.j.offer(Code4)) {
                    fb.I(ds.this.e(), "fail to add frame to cache");
                }
                int i = Code4.I;
                if (currentTimeMillis2 <= i) {
                    fb.V(ds.this.e(), "send to render directly");
                } else {
                    int i2 = (int) ((currentTimeMillis2 * 1.0d) / i);
                    if (i2 > 5) {
                        i2 = 5;
                    }
                    fb.Code(ds.this.e(), "preferred cached frame num: %d", Integer.valueOf(i2));
                    if (ds.this.j.size() < i2) {
                        ds.this.L();
                        return;
                    }
                }
                ds dsVar2 = ds.this;
                dsVar2.Code((dt) dsVar2.j.poll());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        dr drVar = this.o;
        if (drVar != null) {
            drVar.V();
            this.o = null;
        }
    }

    private InputStream Z(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            fb.I(e(), "loadFile " + e.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ds.5
            @Override // java.lang.Runnable
            public void run() {
                ds.D(ds.this);
                if (ds.this.h == 0 || ds.this.l < ds.this.h) {
                    ds.this.B();
                } else {
                    ds.this.V();
                    ds.this.d();
                }
            }
        });
    }

    private void C() {
        Code(false);
        this.l = 0;
        this.j.clear();
    }

    public void Code() {
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        fb.V(e(), "play " + com.huawei.openalliance.ad.utils.bh.Code(this.i));
        V();
        C();
        Code(this.i);
    }

    public void V() {
        fb.V(e(), "stop play " + com.huawei.openalliance.ad.utils.bh.Code(this.i));
        com.huawei.openalliance.ad.utils.bf.Code(this.f17260a);
        Code(true);
        this.j.clear();
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.ds.1
            @Override // java.lang.Runnable
            public void run() {
                ds.this.S();
            }
        });
    }

    private void I(dt dtVar) {
        if (dtVar == null || this.k.size() >= 2) {
            fb.V(e(), "drop frame");
        } else {
            if (this.k.contains(dtVar.V) || this.k.offer(dtVar.V)) {
                return;
            }
            fb.I(e(), "fail to release frame to pool");
        }
    }

    private void V(dt dtVar) {
        a aVar;
        I(this.r);
        this.r = dtVar;
        if (dtVar != null && (aVar = this.w) != null) {
            aVar.Code(dtVar.V);
        }
        this.m = dtVar.I;
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.ds.7
            @Override // java.lang.Runnable
            public void run() {
                if (ds.this.F()) {
                    ds.this.r = null;
                } else {
                    ds.this.invalidateSelf();
                    ds.this.L();
                }
            }
        }, this.f17260a, 0L);
        this.q = System.currentTimeMillis();
    }

    public void Code(int i) {
        this.h = i;
    }

    private void Code(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            this.b.setBitmap(bitmap2);
            this.b.drawColor(0, PorterDuff.Mode.CLEAR);
            this.d.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.e.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            this.b.drawBitmap(bitmap, this.d, this.e, (Paint) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        S();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InputStream C2 = str.startsWith(com.huawei.openalliance.ad.constant.ca.ASSET.toString()) ? C(str) : str.startsWith(com.huawei.openalliance.ad.constant.ca.RES.toString()) ? B(str) : str.startsWith(com.huawei.openalliance.ad.constant.ca.CONTENT.toString()) ? I(str) : Z(str);
        if (C2 != null) {
            try {
                this.o = new dr(C2, 100);
                L();
            } catch (Exception unused) {
                fb.I(e(), "exception in creating gif decoder");
                D();
            }
        }
    }

    public void Code(Drawable.Callback callback) {
        this.u.put(callback, null);
        setCallback(this);
    }

    public void Code(a aVar) {
        this.w = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(dt dtVar) {
        if (dtVar == null) {
            fb.V(e(), "invalid frame.");
            return;
        }
        fb.V(e(), "onFrameDecoded index: %d isstop: %s", Integer.valueOf(dtVar.Code), Boolean.valueOf(F()));
        if (F()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.q;
        if (fb.Code()) {
            fb.Code(e(), "onFrameDecoded decodeInterval: %d currentFrameDuration: %d", Long.valueOf(currentTimeMillis), Integer.valueOf(this.m));
        }
        if (dtVar.Code == 1) {
            b();
        } else {
            int i = this.m;
            if (currentTimeMillis < i) {
                try {
                    Thread.sleep(i - currentTimeMillis);
                } catch (InterruptedException unused) {
                    fb.Code(e(), "sleep InterruptedException");
                }
            }
        }
        V(dtVar);
    }

    public void Code(du duVar) {
        this.v = duVar;
    }

    private void Code(final String str) {
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.ds.2
            @Override // java.lang.Runnable
            public void run() {
                ds.this.V(str);
            }
        });
    }

    private synchronized void Code(boolean z) {
        this.n = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(dt dtVar, long j) {
        int i;
        long width = dtVar.V.getWidth() * dtVar.V.getHeight() * (dtVar.V.getConfig() == Bitmap.Config.RGB_565 ? 2 : 4);
        int i2 = dtVar.I;
        if (j > i2) {
            i = (int) Math.ceil((j * 1.0d) / i2);
            if (i > 5) {
                i = 5;
            }
        } else {
            i = 1;
        }
        long max = width * Math.max(i, this.j.size());
        long V2 = com.huawei.openalliance.ad.utils.w.V();
        if (fb.Code()) {
            fb.Code(e(), "max frame mem: %d unused memory: %d", Long.valueOf(max), Long.valueOf(V2));
        }
        return max >= V2;
    }
}
