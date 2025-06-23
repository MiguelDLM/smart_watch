package com.baidu.navisdk.ugc.routereport.models;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8329a;
    public String b;
    public int c;
    public String d;
    public ArrayList<b> e;

    public b() {
        this.f8329a = false;
        this.b = null;
        this.c = -1;
        this.d = null;
        this.e = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f8329a != bVar.f8329a || this.c != bVar.c) {
            return false;
        }
        String str = this.b;
        String str2 = bVar.b;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = (this.f8329a ? 1 : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return ((i2 + i) * 31) + this.c;
    }

    public String toString() {
        int size;
        StringBuilder sb = new StringBuilder();
        sb.append("title: ");
        sb.append(this.b);
        sb.append(", type: ");
        sb.append(this.c);
        sb.append(", isSubType: ");
        sb.append(this.f8329a);
        sb.append(", subItemsSize: ");
        ArrayList<b> arrayList = this.e;
        if (arrayList == null) {
            size = 0;
        } else {
            size = arrayList.size();
        }
        sb.append(size);
        sb.append(", iconUrl: ");
        sb.append(this.d);
        return sb.toString();
    }

    public b(boolean z, String str, int i) {
        this.d = null;
        this.e = null;
        this.f8329a = z;
        this.b = str;
        this.c = i;
    }
}
