package com.baidu.navisdk.pronavi.data;

import OXOo.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f7645a = -1;
    private int b = -99;
    private int c = -1;
    private int d = -1;
    private int e = -1;

    /* renamed from: com.baidu.navisdk.pronavi.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0308a {
        private C0308a() {
        }

        public /* synthetic */ C0308a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0308a(null);
    }

    public final void a(int i) {
        this.f7645a = i;
    }

    public final int b() {
        return this.f7645a;
    }

    public final void c(int i) {
        this.b = i;
    }

    public final int d() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    @OOXIXo
    public String toString() {
        return "RGPreloadData(activityHashcode=" + this.f7645a + ", orientation=" + this.b + ", vehicleType=" + this.c + ", sceneType=" + this.d + ", newGuideView=" + this.e + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final boolean a(int i, int i2, int i3, int i4, int i5) {
        return this.f7645a == i && this.b == i2 && this.c == i3 && this.d == i4 && this.e == i5;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final int c() {
        return this.e;
    }

    public final void d(int i) {
        this.d = i;
    }

    public final void e(int i) {
        this.c = i;
    }

    public final void a() {
        this.f7645a = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
    }
}
