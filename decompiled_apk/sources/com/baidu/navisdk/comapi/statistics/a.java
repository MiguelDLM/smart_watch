package com.baidu.navisdk.comapi.statistics;

import com.baidu.navisdk.util.common.l0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f6730a;
    private List<String> b;
    private List<String> c;
    private List<String> d;
    private int e;
    private int f;
    private List<String> g;

    public a() {
        h();
    }

    private void h() {
        b(7);
        c(5);
        a(10);
        c("50001,50002,50003,50006,50007");
    }

    public void a(String str) {
        List<String> e = e(str);
        if (e == null || e.isEmpty()) {
            return;
        }
        this.c = e;
    }

    public void b(int i) {
        this.f6730a = i * 1024;
    }

    public void c(String str) {
        List<String> e = e(str);
        if (e == null || e.isEmpty()) {
            return;
        }
        this.d = e;
    }

    public int d() {
        return this.f6730a;
    }

    public List<String> e() {
        return this.d;
    }

    public List<String> f() {
        return this.b;
    }

    public int g() {
        return this.f;
    }

    public String toString() {
        return "BNStatisticsConfig{mMaxContentSize=" + this.f6730a + ", mRealTimeUploadIds=" + this.b + ", mBatchUploadIds=" + this.c + ", mNaviFinishUploadIds=" + this.d + ", mBatchMaxCount=" + this.e + ", mUserOpMaxContentSize=" + this.f + '}';
    }

    private List<String> e(String str) {
        if (l0.c(str)) {
            return null;
        }
        String[] split = str.split(",");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        return arrayList;
    }

    public List<String> b() {
        return this.c;
    }

    public void d(String str) {
        List<String> e = e(str);
        if (e == null || e.isEmpty()) {
            return;
        }
        this.b = e;
    }

    public void b(String str) {
        List<String> e = e(str);
        if (e == null || e.isEmpty()) {
            return;
        }
        this.g = e;
    }

    public int a() {
        return this.e;
    }

    public List<String> c() {
        return this.g;
    }

    public void a(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.f = i * 1024;
    }
}
