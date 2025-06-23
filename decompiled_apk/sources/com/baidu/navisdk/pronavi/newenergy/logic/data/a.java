package com.baidu.navisdk.pronavi.newenergy.logic.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private String f7804a;
    private int b;

    @oOoXoXO
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    /* renamed from: com.baidu.navisdk.pronavi.newenergy.logic.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0328a {
        private C0328a() {
        }

        public /* synthetic */ C0328a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0328a(null);
    }

    public final void a(@oOoXoXO String str) {
        this.c = str;
    }

    public final void b(@oOoXoXO String str) {
        this.f7804a = str;
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.b;
    }

    @oOoXoXO
    public final String h() {
        return this.f7804a;
    }

    @OOXIXo
    public String toString() {
        return "RGCsTipData(uid=" + this.f7804a + ", type=" + this.b + ", name=" + this.c + ", fastTotal=" + this.d + ", fastFree=" + this.e + ", slowTotal=" + this.f + ", slowFree=" + this.g + ", backupCsNum=" + this.h + ", distance=" + this.i + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final int a() {
        return this.h;
    }

    public final int b() {
        return this.i;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void d(int i) {
        this.d = i;
    }

    public final void e(int i) {
        this.g = i;
    }

    public final void f(int i) {
        this.f = i;
    }

    public final void g(int i) {
        this.b = i;
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void b(int i) {
        this.i = i;
    }
}
