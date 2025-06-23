package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public class et {
    public static final String Code = "true";
    private static final String I = "LinkedAdConfiguration";
    public static final String V = "false";

    /* renamed from: a, reason: collision with root package name */
    private String f17286a;
    private String b;
    private String c;
    private VideoConfiguration d;
    private int Z = 0;
    private String B = null;
    private int C = 0;
    private String S = Boolean.FALSE.toString();
    private String F = "n";
    private boolean D = false;
    private boolean L = false;

    public void B(String str) {
        this.b = str;
    }

    public int C() {
        return this.Z;
    }

    public int Code() {
        return this.C;
    }

    public String D() {
        return this.b;
    }

    public String F() {
        return this.f17286a;
    }

    public String I() {
        return this.F;
    }

    public String L() {
        return this.c;
    }

    public String S() {
        return this.B;
    }

    public String V() {
        return this.S;
    }

    public void Z(String str) {
        this.f17286a = str;
    }

    public VideoConfiguration a() {
        return this.d;
    }

    public boolean B() {
        return this.L;
    }

    public void C(String str) {
        this.c = str;
    }

    public void Code(int i) {
        this.C = i;
    }

    public void I(String str) {
        this.B = str;
    }

    public void V(int i) {
        fb.Code(I, "setLinkedVideoMode %s", Integer.valueOf(i));
        this.Z = i;
    }

    public boolean Z() {
        return this.D;
    }

    public void Code(VideoConfiguration videoConfiguration) {
        this.d = videoConfiguration;
    }

    public void V(String str) {
        this.F = str;
    }

    public void Code(String str) {
        this.S = str;
    }

    public void V(boolean z) {
        this.L = z;
    }

    public void Code(boolean z) {
        this.D = z;
    }
}
