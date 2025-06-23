package com.baidu.navisdk.pronavi.hd;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7722a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final boolean g;

    public c() {
        this(false, 1, null);
    }

    public final void a(boolean z) {
    }

    public final void b(boolean z) {
    }

    public final void c(boolean z) {
    }

    public final void d(boolean z) {
    }

    public final void e(boolean z) {
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this != obj) {
            return (obj instanceof c) && this.g == ((c) obj).g;
        }
        return true;
    }

    public final boolean f() {
        return this.c;
    }

    public final boolean g() {
        return this.f7722a;
    }

    public final void h(boolean z) {
        this.f = z;
    }

    public int hashCode() {
        boolean z = this.g;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final void i(boolean z) {
        this.b = z;
    }

    public final void j(boolean z) {
        this.c = z;
    }

    public final void k(boolean z) {
        this.f7722a = z;
    }

    public final void l(boolean z) {
    }

    @OOXIXo
    public String toString() {
        return "RGHDMapConfig(isEnableGesture=" + this.g + oIX0oI.I0Io.f4095I0Io;
    }

    public c(boolean z) {
        this.g = z;
        this.f7722a = true;
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.e;
    }

    public final boolean d() {
        return this.f;
    }

    public final boolean e() {
        return this.b;
    }

    public final void f(boolean z) {
        this.d = z;
    }

    public final void g(boolean z) {
        this.e = z;
    }

    public /* synthetic */ c(boolean z, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? false : z);
    }
}
