package com.baidu.navisdk.module.ar.listener;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.SurfaceView;
import android.view.TextureView;

/* loaded from: classes7.dex */
public interface a {

    /* renamed from: com.baidu.navisdk.module.ar.listener.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0216a {
        void a(Bitmap bitmap, long j);

        void a(byte[] bArr, long j, a aVar);
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f6990a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public float g;
        public float h;
        public float i;
        public int j;
    }

    /* loaded from: classes7.dex */
    public interface c {
    }

    void a();

    void a(Context context, SurfaceView surfaceView, c cVar);

    void a(Context context, TextureView textureView, c cVar);

    void a(InterfaceC0216a interfaceC0216a);

    void a(b bVar);

    void a(byte[] bArr);

    void b();
}
