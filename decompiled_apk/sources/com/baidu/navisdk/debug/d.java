package com.baidu.navisdk.debug;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.k;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.x;
import com.google.android.exoplayer2.ExoPlayer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class d {
    private static volatile d l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static final Object o = new Object();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private com.baidu.navisdk.util.worker.f<h, String> h;
    private h i;

    /* renamed from: a, reason: collision with root package name */
    public int f6780a = 0;
    public Bitmap b = null;
    public Bitmap c = null;
    public Bitmap d = null;
    private boolean e = false;
    public String f = m0.j().b() + "/ImageCache/naving/capture.png";
    public String g = m0.j().b() + "/ImageCache/naving/capture_result.png";
    public Handler j = new HandlerC0194d(Looper.getMainLooper());
    private final com.baidu.navisdk.util.worker.loop.b k = new e("UgcHttpsU");

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<h, String> {
        public a(String str, h hVar) {
            super(str, hVar);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            d.this.h = null;
            d.this.f(getInData());
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f6782a;
        final /* synthetic */ Bitmap b;

        public b(h hVar, Bitmap bitmap) {
            this.f6782a = hVar;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = this.f6782a.f6786a;
            if (gVar != null) {
                gVar.a(d.this.g, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.f<h, String> {
        public c(String str, h hVar) {
            super(str, hVar);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            d.this.h = null;
            d.this.g(getInData());
            return null;
        }
    }

    /* renamed from: com.baidu.navisdk.debug.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0194d extends Handler {
        public HandlerC0194d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNScreentShotUtils", "handleMessage type:" + message.what);
            }
            if (message.what == 261) {
                Object obj = message.obj;
                if (obj == null) {
                    d.this.b = null;
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "大屏截图失败");
                } else {
                    d.this.b = (Bitmap) obj;
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "大屏截图成功");
                }
                synchronized (d.o) {
                    d.o.notifyAll();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.worker.loop.b {
        public e(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4616);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNScreentShotUtils", "mMsgHandler:" + message.what);
            }
            if (message.what == 4616) {
                try {
                    JNIBaseMap jNIBaseMap = new JNIBaseMap();
                    Bundle bundle = new Bundle();
                    jNIBaseMap.getScreenShotImage(bundle);
                    int i = bundle.getInt("unImageWidth");
                    int i2 = bundle.getInt("unImageHeight");
                    d.this.b = Bitmap.createBitmap(bundle.getIntArray("pbtImageData"), i, i2, Bitmap.Config.ARGB_8888);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (d.o) {
                    try {
                        d.o.notifyAll();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
    }

    /* loaded from: classes7.dex */
    public interface g {
        void a(String str, Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public g f6786a = null;
        public ArrayList<Bitmap> b = null;
        public ArrayList<Rect> c = null;
        public boolean d = false;
        public int e = -1;
        public boolean f = false;
        public boolean g = false;
        private boolean h = false;

        public void a() {
            ArrayList<Bitmap> arrayList = this.b;
            if (arrayList == null || arrayList.isEmpty() || !k.f6861a) {
                return;
            }
            Iterator<Bitmap> it = this.b.iterator();
            while (it.hasNext()) {
                Bitmap next = it.next();
                if (next != null && !next.isRecycled()) {
                    next.recycle();
                }
            }
        }
    }

    private d() {
    }

    public static boolean c() {
        n n2;
        return n && (n2 = x.n()) != null && n2.a();
    }

    private Bitmap d(h hVar) {
        Bitmap createBitmap;
        Canvas canvas;
        ArrayList<Rect> arrayList;
        int size;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNScreentShotUtils", "mergeBitmap state is " + this.f6780a + "isCross is " + hVar.d);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (this.b == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNScreentShotUtils", "mergeBitmap mMapRenderBitmap is null");
            }
            this.b = BitmapFactory.decodeFile(this.f);
        }
        arrayList2.add(new BitmapDrawable(this.b));
        arrayList3.add(new Rect(0, 0, 0, 0));
        if (this.c != null) {
            arrayList2.add(new BitmapDrawable(this.c));
            arrayList3.add(new Rect(0, 0, b(hVar.d), a(hVar.d)));
        } else if (this.d != null) {
            arrayList2.add(new BitmapDrawable(this.d));
            arrayList3.add(new Rect(c(hVar.d), a(hVar.h, hVar.d), ScreenUtil.getInstance().dip2px(8), d(hVar.h)));
        }
        ArrayList<Bitmap> arrayList4 = hVar.b;
        if (arrayList4 != null && !arrayList4.isEmpty() && (arrayList = hVar.c) != null && !arrayList.isEmpty() && (size = hVar.b.size()) == hVar.c.size()) {
            for (int i = 0; i < size; i++) {
                Bitmap bitmap = hVar.b.get(i);
                if (bitmap != null && !bitmap.isRecycled()) {
                    arrayList2.add(new BitmapDrawable(bitmap));
                    arrayList3.add(hVar.c.get(i));
                }
            }
        }
        if (arrayList2.isEmpty() || arrayList3.isEmpty()) {
            return null;
        }
        int size2 = arrayList2.size();
        LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) arrayList2.toArray(new Drawable[size2]));
        for (int i2 = 0; i2 < size2; i2++) {
            Rect rect = (Rect) arrayList3.get(i2);
            layerDrawable.setLayerInset(i2, rect.left, rect.top, rect.right, rect.bottom);
        }
        if (hVar.d) {
            createBitmap = Bitmap.createBitmap(ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(createBitmap);
            layerDrawable.setBounds(0, 0, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels());
        } else {
            createBitmap = Bitmap.createBitmap(ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(createBitmap);
            layerDrawable.setBounds(0, 0, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels());
        }
        layerDrawable.draw(canvas);
        return createBitmap;
    }

    private void e() {
        LogUtil.e("BNScreentShotUtils", "start captureSwitchMapSurfaceView");
        n = true;
        if (!c()) {
            n = false;
            LogUtil.e("BNScreentShotUtils", "start captureSwitchMapSurfaceView return");
            return;
        }
        Object obj = p;
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        n = false;
        StringBuilder sb = new StringBuilder();
        sb.append("mSwitchBitmap is null:");
        sb.append(this.d == null);
        LogUtil.e("BNScreentShotUtils", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(h hVar) {
        Activity b2;
        int i = hVar.e;
        if (i == 0) {
            b2 = com.baidu.navisdk.framework.a.c().b();
        } else if (i != 1) {
            b2 = null;
        } else {
            if (hVar.g) {
                e();
            }
            if (hVar.f) {
                f();
            }
            b2 = x.j();
        }
        a(b2, hVar.d);
        if (this.e) {
            return;
        }
        Bitmap c2 = c(hVar);
        a(this.g, c2);
        this.j.post(new b(hVar, c2));
        e(hVar);
    }

    public static d g() {
        if (l == null) {
            synchronized (d.class) {
                l = new d();
            }
        }
        return l;
    }

    public void a(f fVar) {
    }

    private void b(h hVar) {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 == null) {
            return;
        }
        boolean z = false;
        hVar.d = a2.getResources().getConfiguration().orientation == 2;
        n n2 = x.n();
        if (n2 != null && n2.d()) {
            z = true;
        }
        hVar.h = z;
    }

    private Bitmap c(h hVar) {
        Bitmap createBitmap;
        Canvas canvas;
        ArrayList<Rect> arrayList;
        int size;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNScreentShotUtils", "mergeBitmap state is " + this.f6780a + "isCross is " + hVar.d);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (this.b == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNScreentShotUtils", "mergeBitmap mMapRenderBitmap is null");
            }
            this.b = BitmapFactory.decodeFile(this.f);
        }
        arrayList2.add(new BitmapDrawable(this.b));
        arrayList3.add(new Rect(0, 0, 0, 0));
        ArrayList<Bitmap> arrayList4 = hVar.b;
        if (arrayList4 != null && !arrayList4.isEmpty() && (arrayList = hVar.c) != null && !arrayList.isEmpty() && (size = hVar.b.size()) == hVar.c.size()) {
            for (int i = 0; i < size; i++) {
                Bitmap bitmap = hVar.b.get(i);
                if (bitmap != null && !bitmap.isRecycled()) {
                    arrayList2.add(new BitmapDrawable(bitmap));
                    arrayList3.add(hVar.c.get(i));
                }
            }
        }
        if (this.c != null) {
            arrayList2.add(new BitmapDrawable(this.c));
            arrayList3.add(new Rect(0, 0, b(hVar.d), a(hVar.d)));
        } else if (this.d != null) {
            arrayList2.add(new BitmapDrawable(this.d));
            arrayList3.add(new Rect(c(hVar.d), a(hVar.h, hVar.d), ScreenUtil.getInstance().dip2px(8), d(hVar.h)));
        }
        if (arrayList2.isEmpty() || arrayList3.isEmpty()) {
            return null;
        }
        int size2 = arrayList2.size();
        LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) arrayList2.toArray(new Drawable[size2]));
        for (int i2 = 0; i2 < size2; i2++) {
            Rect rect = (Rect) arrayList3.get(i2);
            layerDrawable.setLayerInset(i2, rect.left, rect.top, rect.right, rect.bottom);
        }
        if (hVar.d) {
            createBitmap = Bitmap.createBitmap(ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(createBitmap);
            layerDrawable.setBounds(0, 0, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels());
        } else {
            createBitmap = Bitmap.createBitmap(ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(createBitmap);
            layerDrawable.setBounds(0, 0, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels());
        }
        layerDrawable.draw(canvas);
        return createBitmap;
    }

    public void a(ArrayList<View> arrayList, int i, g gVar) {
        int widthPixels;
        int heightPixels;
        Bitmap a2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNScreentShotUtils", "screenShot: " + arrayList);
        }
        a(this.i);
        h hVar = new h();
        this.i = hVar;
        this.e = false;
        hVar.f6786a = gVar;
        hVar.e = i;
        b(hVar);
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            if (hVar.d) {
                widthPixels = ScreenUtil.getInstance().getHeightPixels();
                heightPixels = ScreenUtil.getInstance().getWidthPixels();
            } else {
                widthPixels = ScreenUtil.getInstance().getWidthPixels();
                heightPixels = ScreenUtil.getInstance().getHeightPixels();
            }
            hVar.b = new ArrayList<>(size);
            hVar.c = new ArrayList<>(size);
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                if (view != null && (a2 = a(view)) != null && !a2.isRecycled()) {
                    hVar.b.add(a2);
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int i3 = iArr[0];
                    hVar.c.add(new Rect(i3, iArr[1], (widthPixels - i3) - a2.getWidth(), (heightPixels - iArr[1]) - a2.getHeight()));
                }
            }
        }
        this.h = new a("mergeTask", hVar);
        com.baidu.navisdk.util.worker.c.a().c(this.h, new com.baidu.navisdk.util.worker.e(200, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(h hVar) {
        Activity b2;
        int i = hVar.e;
        if (i == 0) {
            b2 = com.baidu.navisdk.framework.a.c().b();
        } else if (i != 1) {
            b2 = null;
        } else {
            if (hVar.g) {
                e();
            }
            if (hVar.f) {
                f();
            }
            b2 = x.j();
        }
        a(b2, hVar.d);
        if (this.e) {
            return;
        }
        a(com.baidu.navisdk.util.drivertool.e.k(), d(hVar));
        e(hVar);
    }

    public static boolean b() {
        n n2;
        return m && (n2 = x.n()) != null && n2.b();
    }

    private int b(boolean z) {
        if (z) {
            return ScreenUtil.getInstance().getHeightPixels() / 2;
        }
        return 0;
    }

    private void e(h hVar) {
        Bitmap bitmap = this.b;
        if (bitmap != null && !bitmap.isRecycled() && k.f6861a) {
            this.b.recycle();
        }
        this.b = null;
        Bitmap bitmap2 = this.c;
        if (bitmap2 != null && !bitmap2.isRecycled() && k.f6861a) {
            this.c.recycle();
        }
        this.c = null;
        Bitmap bitmap3 = this.d;
        if (bitmap3 != null && !bitmap3.isRecycled() && k.f6861a) {
            this.d.recycle();
        }
        this.d = null;
        if (hVar != null) {
            hVar.a();
        }
        this.i = null;
    }

    private void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNScreentShotUtils", "start catpureCommonSurfaceView");
        }
        m = true;
        if (!b()) {
            m = false;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNScreentShotUtils", "start catpureCommonSurfaceView return");
                return;
            }
            return;
        }
        Object obj = q;
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        m = false;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("mCommonBitmap is null:");
            sb.append(this.c == null);
            LogUtil.e("BNScreentShotUtils", sb.toString());
        }
    }

    public void a(int i, g gVar) {
        a(this.i);
        h hVar = new h();
        hVar.f = true;
        hVar.g = true;
        this.i = hVar;
        this.e = false;
        hVar.e = i;
        hVar.f6786a = gVar;
        b(hVar);
        hVar.b = new ArrayList<>(1);
        hVar.c = new ArrayList<>(1);
        Bitmap d = d();
        if (d == null) {
            if (gVar != null) {
                gVar.a(null, null);
            }
        } else {
            hVar.b.add(d);
            hVar.c.add(new Rect(0, 0, 0, 0));
            this.h = new c("mergeTask", hVar);
            com.baidu.navisdk.util.worker.c.a().c(this.h, new com.baidu.navisdk.util.worker.e(200, 0));
        }
    }

    @Nullable
    private Bitmap d() {
        int i;
        int i2;
        int i3;
        Activity b2 = com.baidu.navisdk.framework.a.c().b();
        Bitmap bitmap = null;
        if (b2 == null) {
            return null;
        }
        View decorView = b2.getWindow().getDecorView();
        int color = ((ColorDrawable) decorView.getBackground()).getColor();
        LogUtil.e("BNScreentShotUtils", "colorid is, alph " + color);
        decorView.setBackgroundColor(0);
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        if (drawingCache != null) {
            i = drawingCache.getWidth();
            i2 = drawingCache.getHeight();
        } else {
            i = 0;
            i2 = 0;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
        if (gVar.d()) {
            gVar.e("BNScreentShotUtils", "captrueClientView: " + i + ":" + i2);
        }
        if (i != 0 && i2 != 0) {
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            int i4 = rect.top;
            int width = b2.getWindowManager().getDefaultDisplay().getWidth();
            int height = b2.getWindowManager().getDefaultDisplay().getHeight();
            if (gVar.d()) {
                gVar.e("BNScreentShotUtils", "captrueClientView getDefaultDisplay: " + width + ",height: " + height + ",statusHeight: " + i4);
            }
            int min = Math.min(i2, height);
            int min2 = Math.min(i, width);
            if (min2 > 0 && (i3 = min - i4) > 0) {
                bitmap = Bitmap.createBitmap(drawingCache, 0, i4, min2, i3);
            } else if (gVar.c()) {
                gVar.c("captrueClientView width or height < 0");
            }
            decorView.setBackgroundColor(color);
            decorView.destroyDrawingCache();
            decorView.setDrawingCacheEnabled(false);
            return bitmap;
        }
        decorView.setBackgroundColor(color);
        decorView.destroyDrawingCache();
        decorView.setDrawingCacheEnabled(false);
        if (gVar.d()) {
            gVar.a("bitmapWidth: " + i + ",bitmapHeight: " + i2, new Throwable());
        }
        return null;
    }

    private void a(Activity activity, boolean z) {
        int widthPixels;
        int heightPixels;
        int statusBarHeight;
        LogUtil.e("BNScreentShotUtils", "captureMapSurface start");
        com.baidu.navisdk.vi.b.a(this.k);
        JNIBaseMap jNIBaseMap = new JNIBaseMap();
        ScreenUtil screenUtil = ScreenUtil.getInstance();
        if (z) {
            widthPixels = screenUtil.getHeightPixels();
            heightPixels = screenUtil.getWidthPixels();
            statusBarHeight = screenUtil.getStatusBarHeight(activity);
        } else {
            widthPixels = screenUtil.getWidthPixels();
            heightPixels = screenUtil.getHeightPixels();
            statusBarHeight = screenUtil.getStatusBarHeight(activity);
        }
        if (jNIBaseMap.setScreenShotParam(4, widthPixels, heightPixels - statusBarHeight, 0L, 0L, 0)) {
            Object obj = o;
            synchronized (obj) {
                try {
                    obj.wait(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        com.baidu.navisdk.vi.b.b(this.k);
        LogUtil.e("BNScreentShotUtils", "captureMapSurface end");
    }

    private int c(boolean z) {
        int widthPixels;
        int dip2px;
        if (z) {
            widthPixels = ScreenUtil.getInstance().getHeightPixels();
            dip2px = ScreenUtil.getInstance().dip2px(96);
        } else {
            widthPixels = ScreenUtil.getInstance().getWidthPixels();
            dip2px = ScreenUtil.getInstance().dip2px(96);
        }
        return (widthPixels - dip2px) - ScreenUtil.getInstance().dip2px(8);
    }

    @Nullable
    private Bitmap a(View view) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNScreentShotUtils", "captureClientView: " + view);
        }
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, width, height);
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public void a(int i, int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNScreentShotUtils", "onCaptureSurfaceView");
        }
        if (i3 == 1) {
            m = false;
        } else if (i3 == 2) {
            n = false;
        }
        int i4 = i * i2;
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = iArr[(i5 * i) + i6];
                iArr2[(((i2 - i5) - 1) * i) + i6] = (i7 & (-16711936)) | ((i7 << 16) & 16711680) | ((i7 >> 16) & 255);
            }
        }
        Bitmap.Config config = Bitmap.Config.RGB_565;
        Bitmap.createBitmap(i, i2, config).copyPixelsFromBuffer(wrap);
        Bitmap createBitmap = Bitmap.createBitmap(iArr2, i, i2, config);
        if (i3 == 1) {
            this.c = createBitmap;
            Object obj = q;
            synchronized (obj) {
                try {
                    obj.notifyAll();
                } catch (Exception unused) {
                }
            }
        } else if (i3 == 2) {
            this.d = createBitmap;
            Object obj2 = p;
            synchronized (obj2) {
                try {
                    obj2.notifyAll();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        LogUtil.e("BNScreentShotUtils", "onCaptureSurfaceView end");
    }

    private int d(boolean z) {
        if (z) {
            return ScreenUtil.getInstance().dip2px(120);
        }
        return ScreenUtil.getInstance().dip2px(75);
    }

    private int a(boolean z) {
        if (z) {
            return 0;
        }
        return ScreenUtil.getInstance().getHeightPixels() / 2;
    }

    private int a(boolean z, boolean z2) {
        int heightPixels;
        int dip2px;
        int i = z ? 120 : 75;
        if (z2) {
            heightPixels = ScreenUtil.getInstance().getWidthPixels();
            dip2px = ScreenUtil.getInstance().dip2px(i + 96);
        } else {
            heightPixels = ScreenUtil.getInstance().getHeightPixels();
            dip2px = ScreenUtil.getInstance().dip2px(i + 96);
        }
        return heightPixels - dip2px;
    }

    public void a(h hVar) {
        if (hVar == null) {
            return;
        }
        this.e = true;
        hVar.f6786a = null;
        if (this.h != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.h, true);
            this.h = null;
        }
        Object obj = o;
        synchronized (obj) {
            try {
                obj.notifyAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Object obj2 = q;
        synchronized (obj2) {
            try {
                obj2.notifyAll();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        Object obj3 = p;
        synchronized (obj3) {
            try {
                obj3.notifyAll();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        com.baidu.navisdk.util.worker.loop.b bVar = this.k;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            com.baidu.navisdk.vi.b.b(this.k);
        }
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        e(hVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r4, android.graphics.Bitmap r5) {
        /*
            r3 = this;
            boolean r0 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r0 == 0) goto L1a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "savePicture : "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "BNScreentShotUtils"
            com.baidu.navisdk.util.common.LogUtil.e(r1, r0)
        L1a:
            if (r5 != 0) goto L1d
            return
        L1d:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.io.File r4 = r1.getParentFile()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            boolean r2 = r4.exists()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            if (r2 != 0) goto L35
            r4.mkdirs()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            goto L35
        L31:
            r4 = move-exception
            goto L70
        L33:
            r4 = move-exception
            goto L5c
        L35:
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            if (r4 != 0) goto L3e
            r1.createNewFile()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
        L3e:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r1 = 90
            r5.compress(r0, r1, r4)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r4.flush()     // Catch: java.lang.Exception -> L51
            r4.close()     // Catch: java.lang.Exception -> L51
            goto L6d
        L51:
            r4 = move-exception
            r4.printStackTrace()
            goto L6d
        L56:
            r5 = move-exception
            r0 = r4
            goto L6f
        L59:
            r5 = move-exception
            r0 = r4
            goto L5d
        L5c:
            r5 = r4
        L5d:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L6e
            if (r0 == 0) goto L6d
            r0.flush()     // Catch: java.lang.Exception -> L69
            r0.close()     // Catch: java.lang.Exception -> L69
            goto L6d
        L69:
            r4 = move-exception
            r4.printStackTrace()
        L6d:
            return
        L6e:
            r5 = move-exception
        L6f:
            r4 = r5
        L70:
            if (r0 == 0) goto L7d
            r0.flush()     // Catch: java.lang.Exception -> L79
            r0.close()     // Catch: java.lang.Exception -> L79
            goto L7d
        L79:
            r5 = move-exception
            r5.printStackTrace()
        L7d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.debug.d.a(java.lang.String, android.graphics.Bitmap):void");
    }
}
