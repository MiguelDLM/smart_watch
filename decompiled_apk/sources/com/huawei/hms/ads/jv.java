package com.huawei.hms.ads;

import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;

/* loaded from: classes10.dex */
public class jv {
    private String B;
    private String C;
    private String Code;
    private ImageInfo D;
    private String F;
    private String I;
    private AdContentData L;
    private String S;
    private String V;
    private Integer Z;

    public jv() {
    }

    public int B() {
        return this.Z.intValue();
    }

    public String C() {
        return this.C;
    }

    public String Code() {
        return this.I;
    }

    public ImageInfo D() {
        return this.D;
    }

    public String F() {
        return this.F;
    }

    public String I() {
        return this.V;
    }

    public AdContentData L() {
        return this.L;
    }

    public String S() {
        return this.S;
    }

    public String V() {
        return this.Code;
    }

    public String Z() {
        return this.B;
    }

    public jv(String str, String str2, String str3, String str4) {
        this.Code = str == null ? "" : str;
        this.V = str2 == null ? "" : str2;
        this.I = str3 == null ? "" : str3;
        this.B = str4 == null ? "" : str4;
    }

    public void B(String str) {
        this.C = str;
    }

    public void C(String str) {
        this.S = str;
    }

    public void Code(int i) {
        this.Z = Integer.valueOf(i);
    }

    public void I(String str) {
        if (str == null) {
            str = "";
        }
        this.V = str;
    }

    public void S(String str) {
        this.F = str;
    }

    public void V(String str) {
        if (str == null) {
            str = "";
        }
        this.Code = str;
    }

    public void Z(String str) {
        if (str == null) {
            str = "";
        }
        this.B = str;
    }

    public void Code(AdContentData adContentData) {
        this.L = adContentData;
    }

    public void Code(ImageInfo imageInfo) {
        this.D = imageInfo;
    }

    public void Code(String str) {
        if (str == null) {
            str = "";
        }
        this.I = str;
    }
}
