package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public class v implements t {
    private VideoConfiguration C;
    private boolean Code;
    private AdSize D;
    private int I;
    private boolean S;
    private int V;
    private boolean Z;
    private int B = 1;
    private Integer F = 0;
    private int L = -1;

    @Override // com.huawei.hms.ads.t
    public int B() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.t
    public VideoConfiguration C() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.t
    public void Code(int i) {
        this.V = i;
        this.F = Integer.valueOf(B(i));
    }

    @Override // com.huawei.hms.ads.t
    public AdSize D() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.t
    public Integer F() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.t
    public int I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.t
    public int L() {
        return this.L;
    }

    @Override // com.huawei.hms.ads.t
    public boolean S() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.t
    public int V() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.t
    public void Z(int i) {
        this.L = i;
    }

    private int B(int i) {
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? 0 : 2;
            }
            return 3;
        }
        return 1;
    }

    @Override // com.huawei.hms.ads.t
    public void Code(AdSize adSize) {
        this.D = adSize;
    }

    @Override // com.huawei.hms.ads.t
    public void I(int i) {
        this.B = i;
    }

    @Override // com.huawei.hms.ads.t
    public void V(int i) {
        this.I = i;
        this.F = Integer.valueOf(i);
    }

    @Override // com.huawei.hms.ads.t
    public boolean Z() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.t
    public void Code(VideoConfiguration videoConfiguration) {
        this.C = videoConfiguration;
    }

    @Override // com.huawei.hms.ads.t
    public void I(boolean z) {
        this.S = z;
    }

    @Override // com.huawei.hms.ads.t
    public void V(boolean z) {
        this.Z = z;
    }

    @Override // com.huawei.hms.ads.t
    public void Code(boolean z) {
        this.Code = z;
    }

    @Override // com.huawei.hms.ads.t
    public boolean Code() {
        return this.Code;
    }
}
