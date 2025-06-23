package com.baidu.navisdk.pronavi.newenergy.logic.tips;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f7805a;

    @oOoXoXO
    private String b;

    @DrawableRes
    private int c;

    @oOoXoXO
    private String d;

    @ColorRes
    private int e;

    @DrawableRes
    private int f;

    @oOoXoXO
    private String g;

    @oOoXoXO
    private String h;

    @ColorRes
    private int i;

    @DrawableRes
    private int j;

    @oOoXoXO
    private String k;

    @ColorRes
    private int l;

    @oOoXoXO
    private String m;

    @ColorRes
    private int n;

    public final void a(@oOoXoXO String str) {
        this.h = str;
    }

    public final void b(@oOoXoXO String str) {
        this.b = str;
    }

    public final void c(int i) {
        this.c = i;
    }

    public final void d(int i) {
        this.f = i;
    }

    @oOoXoXO
    public final String e() {
        return this.b;
    }

    public final void f(@oOoXoXO String str) {
        this.d = str;
    }

    public final int g() {
        return this.c;
    }

    public final void h(int i) {
        this.f7805a = i;
    }

    @oOoXoXO
    public final String i() {
        return this.k;
    }

    public final int j() {
        return this.l;
    }

    @oOoXoXO
    public final String k() {
        return this.m;
    }

    public final int l() {
        return this.n;
    }

    @oOoXoXO
    public final String m() {
        return this.d;
    }

    public final int n() {
        return this.e;
    }

    public final int o() {
        return this.f7805a;
    }

    @OOXIXo
    public String toString() {
        return "RGChargeStationTipData(type=" + this.f7805a + ", chargeUid=" + this.b + ", iconResId=" + this.c + ", title=" + this.d + ", titleColorRes=" + this.e + ", mBgResId=" + this.f + ", distance=" + this.g + ", chargeStationCount=" + this.h + ", chargeStationCountColorRes=" + this.i + ", chargeStationCountBgRes=" + this.j + ", optionalChargeStation=" + this.k + ", optionalChargeStationColorRes=" + this.l + ", otherContent=" + this.m + ", otherContentColorRes=" + this.n + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void a(int i) {
        this.j = i;
    }

    @oOoXoXO
    public final String b() {
        return this.h;
    }

    public final void c(@oOoXoXO String str) {
        this.g = str;
    }

    public final int d() {
        return this.i;
    }

    public final void e(int i) {
        this.l = i;
    }

    @oOoXoXO
    public final String f() {
        return this.g;
    }

    public final void g(int i) {
        this.e = i;
    }

    public final int h() {
        return this.f;
    }

    public final void a(@oOoXoXO a aVar) {
        if (aVar == null) {
            a();
            return;
        }
        this.f7805a = aVar.f7805a;
        this.d = aVar.d;
        this.e = aVar.e;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.f = aVar.f;
        this.c = aVar.c;
        this.b = aVar.b;
    }

    public final void b(int i) {
        this.i = i;
    }

    public final int c() {
        return this.j;
    }

    public final void d(@oOoXoXO String str) {
        this.k = str;
    }

    public final void e(@oOoXoXO String str) {
        this.m = str;
    }

    public final void f(int i) {
        this.n = i;
    }

    public final void a() {
        this.f7805a = 0;
        this.d = null;
        this.e = 0;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = 0;
        this.f = 0;
        this.c = 0;
        this.b = null;
    }
}
