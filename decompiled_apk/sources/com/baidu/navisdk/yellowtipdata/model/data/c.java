package com.baidu.navisdk.yellowtipdata.model.data;

import android.os.Bundle;
import com.baidu.navisdk.yellowtipdata.model.a;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f9463a;
    private int b;
    private String e;
    private int h;
    private String j;
    private String k;
    private String c = "";
    private String d = "";
    private int f = -1;
    private int g = -1;
    private int i = 10000;
    private int l = 2;
    private String m = null;

    public static final c a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        c cVar = new c();
        if (bundle.containsKey("tipId")) {
            cVar.g(bundle.getInt("tipId", 0));
        }
        if (bundle.containsKey("mainTitle")) {
            cVar.d(bundle.getString("mainTitle", ""));
        }
        if (bundle.containsKey("subTitle")) {
            cVar.e(bundle.getString("subTitle", ""));
        }
        if (bundle.containsKey("backColorId")) {
            cVar.b(bundle.getInt("backColorId", -1));
        }
        if (bundle.containsKey("iconId")) {
            cVar.d(bundle.getInt("iconId", -1));
        }
        a.d g = com.baidu.navisdk.yellowtipdata.model.a.c().g(cVar.l());
        if (bundle.containsKey("assistInfo")) {
            cVar.f(bundle.getString("assistInfo", ""));
        }
        if (bundle.containsKey("tipsBroad")) {
            cVar.a(bundle.getString("tipsBroad", null));
        }
        cVar.c(g.c());
        cVar.c(g.b());
        cVar.b(g.a());
        cVar.a(10000);
        cVar.e(2);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGYellowTipNoteModel", "change,model:" + cVar);
        }
        return cVar;
    }

    public int b() {
        return this.f;
    }

    public c c(int i) {
        if (i != 0 && i != 1 && i != 2) {
            i = 0;
        }
        this.b = i;
        return this;
    }

    public c d(String str) {
        this.c = str;
        return this;
    }

    public int e() {
        return this.b;
    }

    public c f(int i) {
        this.f9463a = i;
        return this;
    }

    public int g() {
        return this.g;
    }

    public String h() {
        return this.c;
    }

    public int i() {
        return this.l;
    }

    public int j() {
        return this.f9463a;
    }

    public String k() {
        return this.d;
    }

    public int l() {
        return this.h;
    }

    public String m() {
        return this.e;
    }

    public String toString() {
        return "RGYellowTipNoteModel{notifyMsgType=" + this.f9463a + ", clickAction=" + this.b + ", mainTitle='" + this.c + "', subTitle='" + this.d + "', url='" + this.e + "', backColorId=" + this.f + ", iconId=" + this.g + ", tipId=" + this.h + ", autoHideTime=" + this.i + ", confirmText='" + this.j + "', cancelText='" + this.k + "', mainTitleLine=" + this.l + ", broadcastContent=" + this.m + '}';
    }

    public c b(int i) {
        this.f = i;
        return this;
    }

    public c c(String str) {
        this.j = str;
        return this;
    }

    public c d(int i) {
        this.g = i;
        return this;
    }

    public c e(String str) {
        this.d = str;
        return this;
    }

    public c f(String str) {
        this.e = str;
        return this;
    }

    public c g(int i) {
        this.h = i;
        return this;
    }

    public c b(String str) {
        this.k = str;
        return this;
    }

    public String c() {
        return this.m;
    }

    public String d() {
        return this.k;
    }

    public c e(int i) {
        this.l = i;
        return this;
    }

    public String f() {
        return this.j;
    }

    public int a() {
        return this.i;
    }

    public c a(int i) {
        this.i = i;
        return this;
    }

    public void a(String str) {
        this.m = str;
    }
}
