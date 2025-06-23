package com.baidu.navisdk.pronavi.hd.normal.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f7757a;
    private int b;
    private int c = -1;
    private int d;

    public b(int i) {
        this.d = i;
    }

    public final void a(int i) {
        this.f7757a = i;
    }

    public final int b() {
        return this.f7757a;
    }

    public final int c() {
        return this.b;
    }

    public final void d(int i) {
        this.d = i;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this != obj) {
            return (obj instanceof b) && this.d == ((b) obj).d;
        }
        return true;
    }

    public int hashCode() {
        return this.d;
    }

    @OOXIXo
    public String toString() {
        return "RGNormalHdData(orientation=" + this.d + ", mEngineHdState=" + this.f7757a + ", mUiHdState=" + this.b + ", mUserSwitchState=" + this.c + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void a() {
        this.f7757a = 0;
        this.b = 0;
        this.c = -1;
        this.d = 0;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final void c(int i) {
        this.c = i;
    }

    public final int d() {
        return this.c;
    }
}
