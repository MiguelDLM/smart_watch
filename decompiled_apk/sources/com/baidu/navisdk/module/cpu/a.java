package com.baidu.navisdk.module.cpu;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f7147a;
    public String b;
    public long c;

    public a(int i, String str, long j) {
        this.f7147a = i;
        this.b = str;
        this.c = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f7147a != aVar.f7147a) {
            return false;
        }
        String str = this.b;
        String str2 = aVar.b;
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
        int i2 = this.f7147a * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public a(int i, String str, long j, int i2) {
        this.f7147a = i;
        this.b = str;
        this.c = j;
    }
}
