package com.baidu.navisdk.ugc.report.data.datarepository;

import androidx.annotation.Nullable;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<b> f8252a;
    private b b;
    private ArrayList<b> c;

    public e(ArrayList<b> arrayList, b bVar, int i) {
        this(arrayList, null, bVar, i);
    }

    public ArrayList<b> a() {
        ArrayList<b> arrayList;
        b bVar = this.b;
        if (bVar == null || (arrayList = bVar.j) == null) {
            return null;
        }
        return arrayList;
    }

    public int b() {
        ArrayList<b> arrayList;
        b bVar = this.b;
        if (bVar == null || (arrayList = bVar.j) == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<b> c() {
        ArrayList<b> arrayList;
        b bVar = this.b;
        if (bVar == null || (arrayList = bVar.i) == null) {
            return null;
        }
        return arrayList;
    }

    public int d() {
        ArrayList<b> arrayList;
        b bVar = this.b;
        if (bVar == null || (arrayList = bVar.i) == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<b> e() {
        ArrayList<b> arrayList = this.f8252a;
        return arrayList == null ? new ArrayList<>(0) : arrayList;
    }

    public ArrayList<b> f() {
        ArrayList<b> arrayList = this.c;
        if (arrayList != null && arrayList.size() != 0) {
            return this.c;
        }
        return new ArrayList<>(0);
    }

    public ArrayList<b> g() {
        ArrayList<b> arrayList;
        b bVar = this.b;
        if (bVar == null || (arrayList = bVar.h) == null) {
            return null;
        }
        return arrayList;
    }

    public int h() {
        ArrayList<b> arrayList;
        b bVar = this.b;
        if (bVar == null || (arrayList = bVar.h) == null) {
            return 0;
        }
        return arrayList.size();
    }

    public String i() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.f8246a;
        }
        return null;
    }

    public int j() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.b;
        }
        return -1;
    }

    public e(ArrayList<b> arrayList, ArrayList<b> arrayList2, b bVar, int i) {
        this.f8252a = arrayList;
        this.b = bVar;
        this.c = arrayList2;
    }

    @Nullable
    private b g(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            b bVar = this.c.get(i2);
            if (bVar != null && bVar.b == i) {
                return bVar;
            }
        }
        return null;
    }

    public b a(int i) {
        if (i < 0 || i >= b()) {
            return null;
        }
        return this.b.j.get(i);
    }

    public String c(int i) {
        b h = h(i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("getMainItemsTitleByType: ");
            sb.append(i);
            sb.append(",dataModel:");
            sb.append(h == null ? "null" : h.toString());
            gVar.e("UgcLayout", sb.toString());
        }
        return h != null ? h.f8246a : "";
    }

    @Nullable
    private b h(int i) {
        for (int i2 = 0; i2 < this.f8252a.size(); i2++) {
            b bVar = this.f8252a.get(i2);
            if (bVar != null && bVar.b == i) {
                return bVar;
            }
        }
        return null;
    }

    public b b(int i) {
        if (i < 0 || i >= d()) {
            return null;
        }
        return this.b.i.get(i);
    }

    public String d(int i) {
        b g = g(i);
        if (g != null) {
            return g.f8246a;
        }
        return null;
    }

    public int e(int i) {
        if (i < 0 || i >= h() || this.b.h.get(i) == null) {
            return -1;
        }
        return this.b.h.get(i).b;
    }

    public boolean f(int i) {
        ArrayList<b> arrayList = this.c;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                if (this.c.get(i2).b == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
