package com.baidu.navisdk.ugc.report.data.datarepository;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f8246a;
    public int b;
    public String c;
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public ArrayList<b> h = null;
    public ArrayList<b> i = null;
    public ArrayList<b> j = null;

    public b(String str, int i, String str2) {
        this.f8246a = str;
        this.b = i;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass() && this.b == ((b) obj).b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.b;
    }

    public String toString() {
        return "UgcBaseDataModel{title='" + this.f8246a + "', type=" + this.b + ", iconUrl='" + this.c + "', link='" + this.d + "', markerTxt= " + this.f + "', markerColor= " + this.g + "', description= " + this.e + "'}";
    }

    public b() {
    }
}
