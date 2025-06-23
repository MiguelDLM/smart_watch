package com.baidu.navisdk.module.pronavi.message.model;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f7458a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private int g;
    private String h;
    private int i;
    private String j;
    private int k;
    private boolean l;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static int f7459a = 1;
        public static int b = 2;
        public static int c = 3;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.f7458a = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.h = str;
    }

    public String toString() {
        return "HighWayModel{highWayName='" + this.f7458a + "', directionText='" + this.b + "', gateName='" + this.c + "', gateRemainDist=" + this.d + ", exitName='" + this.e + "', exitCode='" + this.f + "', exitRemainDist=" + this.g + ", serviceName='" + this.h + "', serviceRemainDist=" + this.i + ", service2Name='" + this.j + "', service2RemainDist=" + this.k + ", isAlongRoad=" + this.l + '}';
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(String str) {
        this.f = str;
    }

    public void c(int i) {
        this.k = i;
    }

    public void d(int i) {
        this.i = i;
    }

    public void a(boolean z) {
        this.l = z;
    }
}
