package com.baidu.navisdk.poisearch.model;

import com.baidu.navisdk.model.datastruct.n;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.module.pronavi.model.d;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class b {
    private static b l;

    /* renamed from: a, reason: collision with root package name */
    private GeoPoint f7637a = null;
    private s b = null;
    private n c = null;
    private com.baidu.navisdk.model.datastruct.chargestation.b d = null;
    private d e = null;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private GeoPoint j = null;
    private boolean k = false;

    private b() {
    }

    public static b m() {
        if (l == null) {
            l = new b();
        }
        return l;
    }

    public void a(String str) {
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public void e(boolean z) {
        this.k = z;
    }

    public n f() {
        return this.c;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.g;
    }

    public boolean i() {
        return this.i;
    }

    public boolean j() {
        return this.f;
    }

    public boolean k() {
        return this.k;
    }

    public void l() {
        LogUtil.e("BNPickPointModel", "reset");
        this.b = null;
        this.f7637a = null;
        this.f = false;
        this.g = false;
        this.i = false;
        this.j = null;
        this.k = false;
        this.d = null;
        this.e = null;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(GeoPoint geoPoint) {
        this.f7637a = geoPoint;
    }

    public com.baidu.navisdk.model.datastruct.chargestation.b c() {
        return this.d;
    }

    public GeoPoint d() {
        return this.f7637a;
    }

    public GeoPoint e() {
        return this.j;
    }

    public void a(s sVar) {
        this.b = sVar;
    }

    public d b() {
        return this.e;
    }

    public s a() {
        return this.b;
    }

    public void a(n nVar) {
        this.c = nVar;
    }

    public void a(com.baidu.navisdk.model.datastruct.chargestation.b bVar) {
        this.d = bVar;
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public void a(GeoPoint geoPoint) {
        this.j = geoPoint;
    }
}
