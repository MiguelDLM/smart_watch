package com.baidu.navisdk.widget.naviimageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.widget.naviimageloader.b;
import com.baidu.navisdk.widget.naviimageloader.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class c {
    private static volatile c g;
    public static HashMap<String, Bitmap> h = new HashMap<>();
    private static final String i = m0.j().b() + "/ImageCache/ugcurliview";

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.widget.naviimageloader.b f9413a;
    private d b;
    private com.baidu.navisdk.widget.naviimageloader.a c;
    private e d;
    public i e;
    private final Handler f = new b(this, "IL");

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.loop.a {
        public b(c cVar, String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message == null) {
                return;
            }
            try {
                Map map = (Map) message.obj;
                String str = (String) map.get("key.url");
                ImageView imageView = (ImageView) map.get("key.imageview");
                Object obj = map.get("key.res");
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap != null && imageView != null) {
                        if (imageView.getTag() != null) {
                            if (imageView.getTag().equals(str)) {
                                imageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bitmap));
                            }
                        } else {
                            imageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bitmap));
                        }
                    }
                } else if (obj instanceof Drawable) {
                    Drawable drawable = (Drawable) obj;
                    if (imageView != null && drawable != null) {
                        imageView.setImageDrawable(drawable);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private com.baidu.navisdk.widget.naviimageloader.b c() {
        com.baidu.navisdk.widget.naviimageloader.b bVar = this.f9413a;
        if (bVar != null) {
            return bVar;
        }
        com.baidu.navisdk.widget.naviimageloader.b a2 = new b.C0513b().a();
        this.f9413a = a2;
        return a2;
    }

    public static c d() {
        if (g == null) {
            synchronized (c.class) {
                try {
                    if (g == null) {
                        g = new c();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    private boolean e() {
        if (this.b != null && this.e != null && h != null) {
            return true;
        }
        return false;
    }

    private void f() {
        if (this.e == null) {
            this.e = new i(i, 50);
        }
        if (h == null) {
            h = new HashMap<>();
        }
        if (this.b == null) {
            this.b = new d();
        }
    }

    public e b() {
        if (this.d == null) {
            this.d = new C0514c(this);
        }
        return this.d;
    }

    /* renamed from: com.baidu.navisdk.widget.naviimageloader.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0514c implements e {
        public C0514c(c cVar) {
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNImageLoader", "onLoadingStarted: " + str);
            }
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view, Bitmap bitmap, int i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNImageLoader", "onLoadingComplete imageUri: " + str + ",from: " + i);
            }
        }
    }

    public void a(String str, ImageView imageView) {
        a(str, imageView, null, null);
    }

    public void a(String str, ImageView imageView, com.baidu.navisdk.widget.naviimageloader.b bVar, e eVar) {
        if (imageView == null) {
            return;
        }
        if (bVar == null) {
            bVar = c();
        }
        if (eVar == null) {
            eVar = b();
        }
        e eVar2 = eVar;
        if (!e()) {
            f();
        }
        if (TextUtils.isEmpty(str)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNImageLoader", "displayImage uri is null, show failed icon");
            }
            if (eVar2 != null) {
                eVar2.a(str, imageView);
            }
            bVar.a().a((String) null, bVar.b(), imageView);
            if (eVar2 != null) {
                eVar2.a(str, imageView, null, 4);
                return;
            }
            return;
        }
        String b2 = this.e.b(str);
        Bitmap a2 = a(b2);
        if (eVar2 != null) {
            eVar2.a(str, imageView);
        }
        if (a2 != null && !a2.isRecycled()) {
            bVar.a().a(str, a2, imageView);
            if (eVar2 != null) {
                eVar2.a(str, imageView, a2, 0);
                return;
            }
            return;
        }
        bVar.a().a(str, bVar.c(), imageView);
        d.c cVar = new d.c(b2, this.e.a(str), str, imageView, bVar, eVar2, this.e);
        if (bVar.g()) {
            cVar.i = 3;
            cVar.run();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNImageLoader", "displayImage 走同步逻辑");
                return;
            }
            return;
        }
        if (!this.b.a(str, cVar)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNImageLoader", "displayImage 如果是正在下载的图片，那么并入等待队列并返回: ");
            }
            cVar.i = 2;
        } else {
            cVar.i = 3;
            this.b.a(cVar);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNImageLoader", "displayImage engine.submit(displayTask)");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.widget.naviimageloader.a {
        public a() {
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.a
        public void a(String str, Drawable drawable, ImageView imageView) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                if (imageView == null || drawable == null) {
                    return;
                }
                imageView.setImageDrawable(drawable);
                return;
            }
            if (c.this.f != null) {
                Message obtainMessage = c.this.f.obtainMessage();
                HashMap hashMap = new HashMap(5);
                hashMap.put("key.url", str);
                hashMap.put("key.imageview", imageView);
                hashMap.put("key.res", drawable);
                obtainMessage.obj = hashMap;
                c.this.f.sendMessage(obtainMessage);
            }
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.a
        public void a(String str, Bitmap bitmap, ImageView imageView) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                if (c.this.f != null) {
                    Message obtainMessage = c.this.f.obtainMessage();
                    HashMap hashMap = new HashMap(5);
                    hashMap.put("key.url", str);
                    hashMap.put("key.imageview", imageView);
                    hashMap.put("key.res", bitmap);
                    obtainMessage.obj = hashMap;
                    c.this.f.sendMessage(obtainMessage);
                    return;
                }
                return;
            }
            if (bitmap == null || imageView == null) {
                return;
            }
            if (imageView.getTag() != null) {
                if (imageView.getTag().equals(str)) {
                    imageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bitmap));
                    return;
                }
                return;
            }
            imageView.setImageDrawable(new BitmapDrawable(JarUtils.getResources(), bitmap));
        }
    }

    private Bitmap a(String str) {
        Bitmap bitmap = this.e.get((Object) str);
        Bitmap bitmap2 = null;
        if (bitmap != null && bitmap.isRecycled()) {
            this.e.remove(str);
            bitmap = null;
        }
        Bitmap bitmap3 = h.get(str);
        if (bitmap3 == null || bitmap == null || !bitmap.isRecycled()) {
            bitmap2 = bitmap3;
        } else {
            h.remove(str);
        }
        return bitmap == null ? bitmap2 : bitmap;
    }

    public com.baidu.navisdk.widget.naviimageloader.a a() {
        if (this.c == null) {
            this.c = new a();
        }
        return this.c;
    }
}
