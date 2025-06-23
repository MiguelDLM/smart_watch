package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private String f8938a;
    private String b;
    private String c;
    private boolean d;
    private int e;
    private int f;
    private String g;
    private String h;
    private boolean i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private int n;

    public static final d0 a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        d0 d0Var = new d0();
        if (bundle.containsKey("jstrBtnTitleKey")) {
            d0Var.b(bundle.getString("jstrBtnTitleKey", ""));
        }
        if (bundle.containsKey("jstrBtnLabelKey")) {
            d0Var.a(bundle.getString("jstrBtnLabelKey", ""));
        }
        if (bundle.containsKey("jstrEndInputkey")) {
            d0Var.d(bundle.getString("jstrEndInputkey", ""));
        }
        if (bundle.containsKey("jstrHasShowPointkey")) {
            d0Var.d(bundle.getBoolean("jstrHasShowPointkey", false));
        }
        if (bundle.containsKey("jstrPointXKey")) {
            d0Var.d(bundle.getInt("jstrPointXKey", 0));
        }
        if (bundle.containsKey("jstrPointYKey")) {
            d0Var.e(bundle.getInt("jstrPointYKey", 0));
        }
        if (bundle.containsKey("jstrUidkey")) {
            d0Var.e(bundle.getString("jstrUidkey"));
        }
        if (bundle.containsKey("jstrCityNamekey")) {
            d0Var.c(bundle.getString("jstrCityNamekey"));
        }
        if (bundle.containsKey("jstrHasCityIdkey")) {
            d0Var.c(bundle.getBoolean("jstrHasCityIdkey", false));
        }
        if (bundle.containsKey("jstrCityIdkey")) {
            d0Var.c(bundle.getInt("jstrCityIdkey", 0));
        }
        if (bundle.containsKey("jstrHasBorderColor")) {
            d0Var.b(bundle.getBoolean("jstrHasBorderColor", false));
        }
        if (bundle.containsKey("jstrBorderColor")) {
            d0Var.b(bundle.getInt("jstrBorderColor", -16776961));
        }
        if (bundle.containsKey("jstrHasBackgroundColor")) {
            d0Var.a(bundle.getBoolean("jstrHasBackgroundColor", false));
        }
        if (bundle.containsKey("jstrBackgroundColor")) {
            d0Var.a(bundle.getInt("jstrBackgroundColor", -1));
        }
        return d0Var;
    }

    public d0 b(String str) {
        this.f8938a = str;
        return this;
    }

    public int c() {
        return this.f;
    }

    public d0 d(String str) {
        this.c = str;
        return this;
    }

    public d0 e(int i) {
        this.f = i;
        return this;
    }

    public String toString() {
        return "RGYellowTipPoiReviseModel{btnTitle='" + this.f8938a + ", btnLabel='" + this.b + ", endInput='" + this.c + ", hasShowPoint=" + this.d + ", pointX=" + this.e + ", pointY=" + this.f + ", uid='" + this.g + ", cityName='" + this.h + ", cityId=" + this.j + ", hasCityId=" + this.i + ", hasBorderColor=" + this.k + ", borderColor=" + this.l + ", hasBackgroundColor=" + this.m + ", backgroundColor=" + this.n + '}';
    }

    public int b() {
        return this.e;
    }

    public d0 c(String str) {
        this.h = str;
        return this;
    }

    public d0 d(boolean z) {
        this.d = z;
        return this;
    }

    public d0 e(String str) {
        this.g = str;
        return this;
    }

    public d0 b(boolean z) {
        this.k = z;
        return this;
    }

    public d0 c(int i) {
        this.j = i;
        return this;
    }

    public d0 d(int i) {
        this.e = i;
        return this;
    }

    public d0 b(int i) {
        this.l = i;
        return this;
    }

    public d0 c(boolean z) {
        this.i = z;
        return this;
    }

    public String d() {
        return this.g;
    }

    public d0 a(String str) {
        this.b = str;
        return this;
    }

    public String a() {
        return this.c;
    }

    public d0 a(boolean z) {
        this.m = z;
        return this;
    }

    public d0 a(int i) {
        this.n = i;
        return this;
    }
}
