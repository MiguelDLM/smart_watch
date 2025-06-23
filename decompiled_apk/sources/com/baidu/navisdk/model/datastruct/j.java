package com.baidu.navisdk.model.datastruct;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private String f6933a;
    private int b;
    private ArrayList<h> c;
    private ArrayList<h> d;
    private ArrayList<h> e;

    public void a(String str) {
        this.f6933a = str;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.f6933a;
    }

    public ArrayList<h> d() {
        if (this.d == null) {
            return null;
        }
        return new ArrayList<>(this.d);
    }

    public ArrayList<h> e() {
        if (this.e == null) {
            return null;
        }
        return new ArrayList<>(this.e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.b != jVar.b) {
            return false;
        }
        String str = this.f6933a;
        if (str == null ? jVar.f6933a != null : !str.equals(jVar.f6933a)) {
            return false;
        }
        ArrayList<h> arrayList = this.c;
        if (arrayList == null ? jVar.c != null : !arrayList.equals(jVar.c)) {
            return false;
        }
        ArrayList<h> arrayList2 = this.e;
        if (arrayList2 == null ? jVar.e != null : !arrayList2.equals(jVar.e)) {
            return false;
        }
        ArrayList<h> arrayList3 = this.d;
        if (arrayList3 != null) {
            return arrayList3.equals(jVar.d);
        }
        if (jVar.d == null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        ArrayList<h> arrayList = this.c;
        if (arrayList != null && !arrayList.isEmpty()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        String str = this.f6933a;
        int i4 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i5 = ((i * 31) + this.b) * 31;
        ArrayList<h> arrayList = this.c;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        ArrayList<h> arrayList2 = this.e;
        if (arrayList2 != null) {
            i3 = arrayList2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        ArrayList<h> arrayList3 = this.d;
        if (arrayList3 != null) {
            i4 = arrayList3.hashCode();
        }
        return i7 + i4;
    }

    public String toString() {
        return "MeteorsSingleRoute{routeMrsl='" + this.f6933a + ", routeLen=" + this.b + ", allMeteorList=" + this.c + ", seriousPavementMeteorList=" + this.e + ", seriousMeteorList=" + this.d + '}';
    }

    public void a(int i) {
        this.b = i;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public j m91clone() {
        j jVar = new j();
        jVar.f6933a = this.f6933a;
        jVar.b = this.b;
        jVar.d = new ArrayList<>(this.d);
        jVar.e = new ArrayList<>(this.e);
        jVar.c = new ArrayList<>(this.c);
        return jVar;
    }

    public ArrayList<h> a() {
        if (this.c == null) {
            return null;
        }
        return new ArrayList<>(this.c);
    }

    public void a(ArrayList<h> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.c = new ArrayList<>(arrayList);
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        Iterator<h> it = this.c.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next.e()) {
                this.d.add(next);
            }
            if (next.f()) {
                this.e.add(next);
            }
        }
        if (this.d.isEmpty()) {
            return;
        }
        this.d.get(0).c.f = Integer.MIN_VALUE;
    }
}
