package com.baidu.navisdk.module.ar.view;

import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.navisdk.module.ar.listener.a;

/* loaded from: classes7.dex */
public class e implements a.c {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.ar.d f7024a;
    private com.baidu.navisdk.module.ar.listener.a b = null;
    private ViewGroup c = null;

    public e(com.baidu.navisdk.module.ar.d dVar) {
        this.f7024a = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a() {
        SurfaceView surfaceView;
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            return viewGroup;
        }
        this.c = new FrameLayout(this.f7024a.a());
        if (!TextUtils.isEmpty(this.f7024a.b)) {
            TextureView textureView = new TextureView(this.f7024a.a());
            com.baidu.navisdk.module.ar.tracker.d dVar = new com.baidu.navisdk.module.ar.tracker.d(this.f7024a);
            this.b = dVar;
            dVar.a(this.f7024a.a(), textureView, this);
            surfaceView = textureView;
        } else {
            SurfaceView surfaceView2 = new SurfaceView(this.f7024a.a());
            a aVar = new a(this.f7024a);
            this.b = aVar;
            aVar.a(this.f7024a.a(), surfaceView2, this);
            surfaceView = surfaceView2;
        }
        this.c.addView(surfaceView, new FrameLayout.LayoutParams(-1, -1));
        return this.c;
    }

    public void b() {
        this.b.b();
    }

    public void a(com.baidu.navisdk.module.ar.jni.a aVar) {
        View cVar;
        if (!TextUtils.isEmpty(this.f7024a.b)) {
            cVar = new b(this.f7024a.a(), aVar);
        } else {
            cVar = new c(this.f7024a.a(), aVar);
        }
        this.c.addView(cVar, new FrameLayout.LayoutParams(-1, -1));
    }

    public void a(int i) {
        this.b.a();
    }

    public void a(a.InterfaceC0216a interfaceC0216a) {
        this.b.a(interfaceC0216a);
    }
}
