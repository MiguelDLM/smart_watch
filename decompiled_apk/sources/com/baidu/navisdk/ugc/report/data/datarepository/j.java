package com.baidu.navisdk.ugc.report.data.datarepository;

import java.util.Arrays;

/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private int f8262a;
    private String b = null;
    private String[] c;

    public String a() {
        return this.b;
    }

    public int b() {
        return this.f8262a;
    }

    public int c() {
        String[] strArr = this.c;
        if (strArr == null) {
            return 0;
        }
        return strArr.length;
    }

    public boolean d() {
        String[] strArr = this.c;
        if (strArr != null && strArr.length > 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "UgcSugResponseData{requestIndex=" + this.f8262a + ", originalWord='" + this.b + "', tags=" + Arrays.toString(this.c) + '}';
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(int i) {
        this.f8262a = i;
    }

    public void a(String[] strArr) {
        this.c = strArr;
    }

    public String a(int i) {
        String[] strArr = this.c;
        if (strArr == null || i < 0 || i >= strArr.length) {
            return null;
        }
        return strArr[i];
    }
}
