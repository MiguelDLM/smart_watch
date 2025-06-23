package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.constant.ca;
import java.io.Serializable;

/* loaded from: classes10.dex */
public class p implements Serializable {
    private int B;
    private int C;
    private int D;
    private String F;
    private String I;
    private int L;
    private String S;
    private String V;
    private long Z;

    /* renamed from: a, reason: collision with root package name */
    private int f17396a;
    private long b;
    private String c;

    public p() {
        this.B = 0;
        this.C = 0;
        this.F = "y";
        this.L = 0;
    }

    public String C() {
        return this.S;
    }

    public void Code(String str) {
        this.F = str;
    }

    public boolean I() {
        String str = this.I;
        if (str != null && str.startsWith(ca.CONTENT.toString())) {
            return true;
        }
        String str2 = this.c;
        return str2 != null && str2.startsWith(ca.CONTENT.toString());
    }

    public int L() {
        return this.D;
    }

    public String S() {
        return this.F;
    }

    public void V(String str) {
        this.c = str;
    }

    public String Z() {
        return this.I;
    }

    public String b() {
        return this.V;
    }

    public int c() {
        return this.f17396a;
    }

    public long d() {
        return this.b;
    }

    public String e() {
        String str = this.I;
        return (str == null || !str.startsWith(ca.CONTENT.toString())) ? this.c : this.I;
    }

    public Float f() {
        int i;
        int i2 = this.B;
        if (i2 <= 0 || (i = this.C) <= 0) {
            return null;
        }
        return Float.valueOf(i2 / i);
    }

    public p(MediaFile mediaFile, long j) {
        this.B = 0;
        this.C = 0;
        this.F = "y";
        this.L = 0;
        this.V = mediaFile.Code();
        this.I = mediaFile.B();
        this.Z = mediaFile.Z();
        this.D = mediaFile.S();
        this.L = mediaFile.F();
        this.B = mediaFile.V();
        this.C = mediaFile.I();
        this.S = mediaFile.C();
        this.f17396a = mediaFile.D();
        this.b = j;
    }

    public boolean V() {
        return "video/mp4".equals(this.V);
    }
}
