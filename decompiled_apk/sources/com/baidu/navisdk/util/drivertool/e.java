package com.baidu.navisdk.util.drivertool;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.d;
import com.baidu.navisdk.framework.interfaces.pronavi.i;
import com.baidu.navisdk.k;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.x;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.IntBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes8.dex */
public class e {
    private static e o = null;
    public static boolean p = false;
    public static int q;
    private g j;

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f9278a = null;
    public boolean b = false;
    public int c = 0;
    private View d = null;
    private boolean e = false;
    public Bitmap f = null;
    public Bitmap g = null;
    public Bitmap h = null;
    public String i = m0.j().b() + "/ImageCache/naving/capture.png";
    public Handler k = new a();
    private com.baidu.navisdk.util.worker.f l = new b("mergeTask", null);
    private com.baidu.navisdk.util.drivertool.view.a m = null;
    public boolean n = false;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 256) {
                if (com.baidu.navisdk.util.drivertool.d.f == com.baidu.navisdk.util.drivertool.d.b()) {
                    com.baidu.navisdk.util.drivertool.d.a(false);
                    com.baidu.navisdk.util.worker.c.a().a(e.this.l, new com.baidu.navisdk.util.worker.e(99, 0));
                    com.baidu.navisdk.util.drivertool.d.f = 0;
                    return;
                }
                return;
            }
            if (i == 261) {
                com.baidu.navisdk.util.drivertool.d.c = false;
                Object obj = message.obj;
                if (obj == null) {
                    e.this.f = null;
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "大屏截图失败");
                } else {
                    e.this.f = (Bitmap) obj;
                    com.baidu.navisdk.util.drivertool.d.f++;
                }
                if (com.baidu.navisdk.util.drivertool.d.f == com.baidu.navisdk.util.drivertool.d.b()) {
                    com.baidu.navisdk.util.drivertool.d.a(false);
                    com.baidu.navisdk.util.worker.c.a().a(e.this.l, new com.baidu.navisdk.util.worker.e(99, 0));
                    com.baidu.navisdk.util.drivertool.d.f = 0;
                    return;
                }
                return;
            }
            if (i == 258) {
                if (e.this.m != null) {
                    e.this.m.a(e.this.f9278a);
                    e.this.k.sendEmptyMessageDelayed(260, 1500L);
                    return;
                }
                return;
            }
            if (i == 257) {
                if (e.this.m != null) {
                    e.this.m.a(e.this.f9278a);
                    e.this.k.sendEmptyMessageDelayed(259, 1500L);
                    return;
                }
                return;
            }
            if (i == 260) {
                if (e.this.m != null) {
                    e.this.m.dismiss();
                }
            } else if (i == 259 && e.this.m != null) {
                e.this.m.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            e.this.q();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e.this.e();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e eVar = e.this;
            if (!eVar.n) {
                eVar.c();
            }
            e.this.n = false;
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0497e implements d.g {
        public C0497e(e eVar) {
        }

        @Override // com.baidu.navisdk.debug.d.g
        public void a(String str, Bitmap bitmap) {
        }
    }

    /* loaded from: classes8.dex */
    public class f extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f9283a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, String str, String str2, Bitmap bitmap) {
            super(str, str2);
            this.f9283a = bitmap;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(e.k()));
                this.f9283a.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a(String str, Handler handler, int i);
    }

    private e() {
    }

    private int i() {
        if (!this.b) {
            return ScreenUtil.getInstance().getHeightPixels() / 2;
        }
        return 0;
    }

    private int j() {
        if (this.b) {
            return ScreenUtil.getInstance().getHeightPixels() / 2;
        }
        return 0;
    }

    public static String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(m0.j().c());
        String str = File.separator;
        sb.append(str);
        sb.append("EnlargeDir");
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + str + new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date()) + ".png";
    }

    public static e l() {
        if (o == null) {
            o = new e();
        }
        return o;
    }

    private String m() {
        return com.baidu.navisdk.util.drivertool.d.b(3);
    }

    private int n() {
        int widthPixels;
        int dip2px;
        if (this.b) {
            widthPixels = ScreenUtil.getInstance().getHeightPixels();
            dip2px = ScreenUtil.getInstance().dip2px(136);
        } else {
            widthPixels = ScreenUtil.getInstance().getWidthPixels();
            dip2px = ScreenUtil.getInstance().dip2px(136);
        }
        return widthPixels - dip2px;
    }

    private int o() {
        int i;
        int heightPixels;
        int dip2px;
        if (this.e) {
            i = 112;
        } else {
            i = 0;
        }
        if (this.b) {
            heightPixels = ScreenUtil.getInstance().getWidthPixels();
            dip2px = ScreenUtil.getInstance().dip2px(i + 136);
        } else {
            heightPixels = ScreenUtil.getInstance().getHeightPixels();
            dip2px = ScreenUtil.getInstance().dip2px(i + 136);
        }
        return heightPixels - dip2px;
    }

    private int p() {
        if (this.e) {
            return ScreenUtil.getInstance().dip2px(120);
        }
        return ScreenUtil.getInstance().dip2px(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        LayerDrawable layerDrawable;
        Canvas canvas;
        LogUtil.e("drivingTool", "mergeBitmap state is " + this.c + "isCross is " + this.b);
        Bitmap s = l().s();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BitmapDrawable(this.f));
        arrayList.add(new BitmapDrawable(s));
        int i = this.c;
        if (i == 0) {
            layerDrawable = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]));
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            layerDrawable.setLayerInset(1, 0, 0, 0, 0);
        } else if (i == 1) {
            arrayList.add(new BitmapDrawable(this.g));
            layerDrawable = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]));
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            layerDrawable.setLayerInset(1, 0, 0, 0, 0);
            layerDrawable.setLayerInset(2, 0, 0, j(), i());
        } else if (i == 2) {
            arrayList.add(new BitmapDrawable(this.h));
            layerDrawable = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]));
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            layerDrawable.setLayerInset(1, 0, 0, 0, 0);
            layerDrawable.setLayerInset(2, n(), o(), ScreenUtil.getInstance().dip2px(8), p());
        } else {
            Bitmap bitmap = null;
            if (i == 3) {
                i i2 = x.i();
                if (i2 != null) {
                    bitmap = i2.w();
                }
                if (bitmap != null) {
                    LogUtil.e("drivingTool", "dingbin merge enlarge map");
                    arrayList.add(new BitmapDrawable(bitmap));
                    layerDrawable = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]));
                    layerDrawable.setLayerInset(0, 0, 0, 0, 0);
                    layerDrawable.setLayerInset(1, 0, 0, 0, 0);
                    layerDrawable.setLayerInset(2, n(), o(), ScreenUtil.getInstance().dip2px(8), p());
                } else {
                    layerDrawable = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[arrayList.size()]));
                    layerDrawable.setLayerInset(0, 0, 0, 0, 0);
                    layerDrawable.setLayerInset(1, 0, 0, 0, 0);
                }
            } else {
                layerDrawable = null;
            }
        }
        if (this.b) {
            this.f9278a = Bitmap.createBitmap(ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(this.f9278a);
            layerDrawable.setBounds(0, 0, ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels());
        } else {
            this.f9278a = Bitmap.createBitmap(ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(this.f9278a);
            layerDrawable.setBounds(0, 0, ScreenUtil.getInstance().getWidthPixels(), ScreenUtil.getInstance().getHeightPixels());
        }
        layerDrawable.draw(canvas);
        a(0);
    }

    private void r() {
        Bitmap bitmap;
        if (k.f6861a && (bitmap = this.f) != null && !bitmap.isRecycled() && k.f6861a) {
            this.f.recycle();
        }
        this.f = null;
        Bitmap bitmap2 = this.g;
        if (bitmap2 != null && !bitmap2.isRecycled() && k.f6861a) {
            this.g.recycle();
        }
        this.g = null;
        Bitmap bitmap3 = this.h;
        if (bitmap3 != null && !bitmap3.isRecycled() && k.f6861a) {
            this.h.recycle();
        }
        this.h = null;
    }

    private Bitmap s() {
        Activity b2 = com.baidu.navisdk.framework.a.c().b();
        if (b2 == null) {
            return null;
        }
        View decorView = b2.getWindow().getDecorView();
        this.d = decorView;
        int color = ((ColorDrawable) decorView.getBackground()).getColor();
        LogUtil.e("drivingTool", "colorid is, alph " + color);
        this.d.setBackgroundColor(0);
        this.d.setDrawingCacheEnabled(true);
        this.d.buildDrawingCache();
        Bitmap drawingCache = this.d.getDrawingCache();
        Rect rect = new Rect();
        this.d.getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, i, b2.getWindowManager().getDefaultDisplay().getWidth(), b2.getWindowManager().getDefaultDisplay().getHeight() - i);
        this.d.setBackgroundColor(color);
        return createBitmap;
    }

    public boolean e() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 != null) {
            com.baidu.navisdk.util.drivertool.b.n().a(a2);
            return true;
        }
        return true;
    }

    public void f() {
        if (this.f9278a == null) {
            BNSettingManager.setRootScreenshotState(false);
            r();
            com.baidu.navisdk.util.drivertool.b.n().a(true);
        } else {
            com.baidu.navisdk.util.drivertool.d.g = System.currentTimeMillis();
            com.baidu.navisdk.util.drivertool.view.b a2 = com.baidu.navisdk.util.drivertool.b.n().a(3);
            a2.show();
            this.n = false;
            a2.setOnCancelListener(new d());
        }
    }

    public void g() {
        if (q == 1) {
            com.baidu.navisdk.debug.d.g().a(1, new C0497e(this));
        }
        int i = q + 1;
        q = i;
        if (i == 4) {
            q = 0;
        }
    }

    public void h() {
        View view = this.d;
        if (view != null) {
            view.destroyDrawingCache();
            this.d.setDrawingCacheEnabled(false);
        }
    }

    public void a(int i) {
        com.baidu.navisdk.util.drivertool.view.a aVar = new com.baidu.navisdk.util.drivertool.view.a(com.baidu.navisdk.framework.a.c().b());
        this.m = aVar;
        aVar.show();
        this.m.setOnDismissListener(new c());
        if (i == 0) {
            this.k.sendEmptyMessage(258);
        } else if (i == 1) {
            this.k.sendEmptyMessage(257);
        }
    }

    public g b() {
        return this.j;
    }

    public void c() {
        h();
        r();
    }

    public void d() {
        this.f9278a = com.baidu.navisdk.util.drivertool.d.a(this.f9278a, com.baidu.navisdk.util.drivertool.d.e(), com.baidu.navisdk.util.drivertool.d.c(), null);
        a(m());
        LogUtil.e("drivingTool", "finish time is " + System.currentTimeMillis());
        this.n = true;
        c();
    }

    private void a(String str) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                this.f9278a.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception unused) {
                }
                Bitmap bitmap = this.f9278a;
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
            } catch (Exception unused2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                Bitmap bitmap2 = this.f9278a;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    return;
                }
                this.f9278a.recycle();
                this.f9278a = null;
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                Bitmap bitmap3 = this.f9278a;
                if (bitmap3 == null) {
                    throw th;
                }
                if (!bitmap3.isRecycled()) {
                    this.f9278a.recycle();
                    this.f9278a = null;
                    throw th;
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        this.f9278a.recycle();
        this.f9278a = null;
    }

    public void a() {
        q = 0;
    }

    public void a(Bitmap bitmap) {
        if (BNSettingManager.isShowJavaLog()) {
            com.baidu.navisdk.util.worker.c.a().c(new f(this, "RGEnlargeRoadMapModel-savImg", null, bitmap), new com.baidu.navisdk.util.worker.e(99, 0));
        }
    }

    public void a(int i, int i2, int i3) {
        if (i3 == 1) {
            if (b() != null) {
                b().a(this.i, this.k, 261);
                return;
            }
            return;
        }
        if (i3 == 2) {
            com.baidu.navisdk.util.drivertool.d.d = false;
        } else if (i3 == 3) {
            com.baidu.navisdk.util.drivertool.d.e = false;
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
        if (i3 == 2) {
            this.g = createBitmap;
        } else if (i3 == 3) {
            this.h = createBitmap;
        }
        com.baidu.navisdk.util.drivertool.d.f++;
        this.k.sendEmptyMessage(256);
    }
}
