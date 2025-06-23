package com.baidu.location.c;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes7.dex */
public class k {
    private static boolean d = false;
    private static g e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f5710a = true;
    private boolean b = true;
    private boolean c = false;

    /* loaded from: classes7.dex */
    public enum a {
        ONLY_CELL_MODE,
        ONLY_WIFI_MODE,
        GET_ALL_DATA
    }

    public static g h() {
        return e;
    }

    public void a(a aVar) {
        int i = l.f5712a[aVar.ordinal()];
        if (i == 1) {
            this.f5710a = true;
            this.b = false;
            return;
        }
        if (i == 2) {
            this.f5710a = false;
            this.b = true;
        } else if (i == 3) {
            this.f5710a = true;
            this.b = true;
        } else {
            throw new IllegalArgumentException("Illegal this mode : " + aVar);
        }
    }

    public void b(int i) {
        if (i >= 0) {
            com.baidu.location.c.a.d.a().a(i);
        }
    }

    public void c(int i) {
        com.baidu.location.c.a.a.a().b(Math.max(i, 29));
    }

    public com.baidu.location.c.a d(int i) {
        if (this.c && this.f5710a) {
            return com.baidu.location.c.a.a.a().c(i);
        }
        return null;
    }

    public p e(int i) {
        if (this.c && this.b) {
            return com.baidu.location.c.a.d.a().a(i);
        }
        return null;
    }

    public WifiInfo f() {
        return com.baidu.location.c.a.d.a().f();
    }

    public p g() {
        return com.baidu.location.c.a.d.a().d();
    }

    public void b(boolean z) {
        com.baidu.location.c.a.a.a().b(z);
    }

    public void b() {
        if (this.f5710a) {
            com.baidu.location.c.a.a.a().b();
        }
        if (this.b) {
            com.baidu.location.c.a.d.a().b();
        }
        this.c = false;
    }

    public long c() {
        return com.baidu.location.c.a.d.a().c();
    }

    public String c(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().b(aVar);
    }

    public boolean d() {
        return com.baidu.location.c.a.a.a().c();
    }

    public String e() {
        return com.baidu.location.c.a.d.a().e();
    }

    public HashSet<String> b(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().c(aVar);
    }

    public void a(int i) {
        if (i >= 0) {
            com.baidu.location.c.a.a.a().a(i);
        }
    }

    public void a(boolean z) {
        com.baidu.location.c.a.a.a().a(z);
    }

    public static boolean a() {
        return d;
    }

    public void a(Context context, List<String> list) {
        if (this.f5710a) {
            com.baidu.location.c.a.a.a().a(context);
        }
        if (this.b) {
            com.baidu.location.c.a.d.a().a(context, list);
        }
        this.c = true;
    }

    public String a(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().a(aVar);
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        return com.baidu.location.c.a.a.a().b(aVar, telephonyManager);
    }

    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        return com.baidu.location.c.a.a.a().a(aVar, aVar2);
    }

    public String a(int i, boolean z, p pVar, int i2) {
        return com.baidu.location.c.a.d.a().a(i, z, pVar, i2);
    }

    public String a(WifiInfo wifiInfo, String str) {
        return com.baidu.location.c.a.d.a().a(wifiInfo, str);
    }

    public String a(p pVar, int i, String str, boolean z, int i2) {
        return com.baidu.location.c.a.d.a().a(pVar, i, str, z, i2);
    }

    public void a(g gVar) {
        e = gVar;
    }
}
