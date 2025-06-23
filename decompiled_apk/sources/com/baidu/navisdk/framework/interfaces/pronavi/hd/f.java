package com.baidu.navisdk.framework.interfaces.pronavi.hd;

import OXOo.OOXIXo;
import XO0OX.XO;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    @XO
    public int f6817a;

    @XO
    public int b;

    @XO
    public int c;

    @XO
    public int d;

    @XO
    public int e;

    @XO
    public int f;

    public f() {
        this(0, 1, null);
    }

    public int a() {
        return 0;
    }

    public int b(boolean z) {
        return 14;
    }

    public final boolean c(boolean z) {
        if (d()) {
            return true;
        }
        return d(z);
    }

    public boolean d(boolean z) {
        return true;
    }

    public final boolean e(boolean z) {
        if (d()) {
            return false;
        }
        return f(z);
    }

    public boolean f(boolean z) {
        return false;
    }

    public final boolean g(boolean z) {
        if (d()) {
            return false;
        }
        return h(z);
    }

    public boolean h(boolean z) {
        return false;
    }

    @OOXIXo
    public String toString() {
        return "RGHDUiSwitchParams{uiSwitchNaviType=" + this.f + ", uiState=" + this.f6817a + ", portraitMultiMapViewHeight=" + this.b + ", landMultiMapViewHeight=" + this.c + '}';
    }

    public f(int i) {
        this.f = i;
    }

    public final int a(boolean z) {
        if (d()) {
            return 14;
        }
        return b(z);
    }

    public final boolean b() {
        return this.f6817a == 2;
    }

    public final boolean d() {
        int i = this.f6817a;
        return i == 0 || i == -1;
    }

    public /* synthetic */ f(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final boolean c() {
        return this.f == 1;
    }
}
