package com.baidu.navisdk.module.ar;

import OXOo.OOXIXo;
import android.content.Context;
import android.hardware.Camera;
import com.baidu.ar.camera.CameraManager;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public com.baidu.navisdk.module.ar.tracker.e f6984a;
    public String b;
    public Camera.Size c;
    private int d;
    private double e;
    private double f;

    @OOXIXo
    private final Context g;

    public d(@OOXIXo Context appContext) {
        IIX0o.x0xO0oo(appContext, "appContext");
        this.g = appContext;
        this.d = 90;
        this.e = 116.46d;
        this.f = 39.92d;
    }

    @OOXIXo
    public final Context a() {
        return this.g;
    }

    public final int b() {
        return this.d;
    }

    public final double c() {
        return this.f;
    }

    public final double d() {
        return this.e;
    }

    public final int e() {
        Camera.Size size = this.c;
        if (size != null) {
            return size.height;
        }
        return CameraManager.DEFAULTHEIGHT;
    }

    public final int f() {
        Camera.Size size = this.c;
        if (size != null) {
            return size.width;
        }
        return 1280;
    }

    public final void a(@OOXIXo com.baidu.navisdk.module.ar.tracker.e eVar) {
        IIX0o.x0xO0oo(eVar, "<set-?>");
        this.f6984a = eVar;
    }

    public final void b(double d) {
        this.e = d;
    }

    public final void a(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.b = str;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(double d) {
        this.f = d;
    }
}
