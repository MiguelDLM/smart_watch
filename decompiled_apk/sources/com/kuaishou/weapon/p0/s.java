package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;

/* loaded from: classes11.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public int f18410a;
    public int b;
    public String c;
    public String d;
    public String e;
    public Context f;
    public ClassLoader g;
    public String h;
    public String i;
    public String j;
    public String k;
    public ActivityInfo[] l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public PackageInfo r;
    public long s;
    public int t;
    public int u;
    public boolean v;
    public int w;
    public int x = -1;
    public boolean y;

    public s() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        String str = this.c;
        if (str == null) {
            if (sVar.c != null) {
                return false;
            }
        } else if (!str.equals(sVar.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        String str = this.c;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode + 31;
    }

    public s(PackageInfo packageInfo, int i, String str, String str2, String str3, String str4) {
        this.r = packageInfo;
        this.f18410a = i;
        this.c = str;
        this.d = str2;
        this.i = str3;
        this.j = str4;
    }
}
