package com.baidu.navisdk.ugc.report.data.datarepository;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<a> f8255a = null;
    private ArrayList<a> b = null;

    /* loaded from: classes8.dex */
    public static class a {
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final g f8256a = new g();
    }

    public static g c() {
        return b.f8256a;
    }

    public void a() {
        ArrayList<a> arrayList = this.f8255a;
        if (arrayList != null) {
            arrayList.clear();
            this.f8255a = null;
        }
        ArrayList<a> arrayList2 = this.b;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.b = null;
        }
    }

    public boolean b() {
        ArrayList<a> arrayList = this.f8255a;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public void a(com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        if (aVar == null || aVar.f8263a == -1 || aVar.b == null) {
            return;
        }
        a aVar2 = new a();
        int indexOf = aVar.b.indexOf(",");
        if (indexOf <= 0 || indexOf >= aVar.b.length() - 1) {
            return;
        }
        String substring = aVar.b.substring(0, indexOf);
        String str = aVar.b;
        String substring2 = str.substring(indexOf + 1, str.length());
        try {
            Double.parseDouble(substring);
            Double.parseDouble(substring2);
        } catch (Exception unused) {
        }
        if (com.baidu.navisdk.ui.util.b.f(c.c(aVar.e)) == null) {
            return;
        }
        if (this.f8255a == null) {
            this.f8255a = new ArrayList<>();
        }
        this.f8255a.add(aVar2);
    }
}
