package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class MaterialClickInfo {
    private Long clickDTime;
    private Long clickUTime;
    private Integer clickX;
    private Integer clickY;
    private String creativeSize;
    private Float density;
    private String eventType;
    private String jsVersion;
    private Integer mark;
    private String shakeAngle;
    private Integer sld;
    private Integer upX;
    private Integer upY;

    /* loaded from: classes10.dex */
    public static final class a {
        private Integer B;
        private Integer C;
        private Integer Code;
        private Long D;
        private String F = com.huawei.openalliance.ad.constant.s.B;
        private String I;
        private Long L;
        private Float S;
        private Integer V;
        private Integer Z;

        /* renamed from: a, reason: collision with root package name */
        private String f17394a;
        private String b;

        public a B(Integer num) {
            this.C = num;
            return this;
        }

        public a Code(Float f) {
            this.S = f;
            return this;
        }

        public a I(Integer num) {
            this.Z = num;
            return this;
        }

        public a V(Integer num) {
            this.V = num;
            return this;
        }

        public a Z(Integer num) {
            this.B = num;
            return this;
        }

        public a Code(Integer num) {
            this.Code = num;
            return this;
        }

        public a I(String str) {
            this.F = str;
            return this;
        }

        public a V(Long l) {
            this.L = l;
            return this;
        }

        public a Z(String str) {
            this.f17394a = str;
            return this;
        }

        public a Code(Long l) {
            this.D = l;
            return this;
        }

        public a V(String str) {
            this.I = str;
            return this;
        }

        public a Code(String str) {
            this.b = str;
            return this;
        }

        public MaterialClickInfo Code() {
            return new MaterialClickInfo(this);
        }
    }

    public MaterialClickInfo() {
        this.eventType = com.huawei.openalliance.ad.constant.s.B;
    }

    public Integer B() {
        return this.upX;
    }

    public Integer C() {
        return this.upY;
    }

    public Integer Code() {
        return this.clickX;
    }

    public Long D() {
        return this.clickUTime;
    }

    public String F() {
        return this.eventType;
    }

    public String I() {
        return this.creativeSize;
    }

    public Long L() {
        return this.clickDTime;
    }

    public Float S() {
        return this.density;
    }

    public Integer V() {
        return this.clickY;
    }

    public Integer Z() {
        return this.sld;
    }

    public Integer a() {
        return this.mark;
    }

    public String b() {
        return this.shakeAngle;
    }

    public String c() {
        return this.jsVersion;
    }

    public String toString() {
        return "MaterialClickInfo{clickX=" + this.clickX + ", clickY=" + this.clickY + ", clickDTime=" + this.clickDTime + ", creativeSize='" + this.creativeSize + "', sld=" + this.sld + ", density=" + this.density + ", upX=" + this.upX + ", upY=" + this.upY + ", clickUTime=" + this.clickUTime + '}';
    }

    public MaterialClickInfo(a aVar) {
        this.eventType = com.huawei.openalliance.ad.constant.s.B;
        this.clickX = aVar.Code;
        this.clickY = aVar.V;
        this.creativeSize = aVar.I;
        this.sld = aVar.Z;
        this.density = aVar.S;
        this.upX = aVar.B;
        this.upY = aVar.C;
        this.eventType = aVar.F;
        this.clickDTime = aVar.L;
        this.clickUTime = aVar.D;
        this.shakeAngle = aVar.f17394a;
        this.jsVersion = aVar.b;
    }

    public void B(Integer num) {
        this.mark = num;
    }

    public void Code(Float f) {
        this.density = f;
    }

    public void I(Integer num) {
        this.upX = num;
    }

    public void V(Integer num) {
        this.sld = num;
    }

    public void Z(Integer num) {
        this.upY = num;
    }

    public MaterialClickInfo(Integer num, Integer num2, String str) {
        this.eventType = com.huawei.openalliance.ad.constant.s.B;
        this.clickX = num;
        this.clickY = num2;
        this.creativeSize = str;
    }

    public void Code(Integer num) {
        this.clickY = num;
    }

    public void I(String str) {
        this.shakeAngle = str;
    }

    public void V(Long l) {
        this.clickDTime = l;
    }

    public void Z(String str) {
        this.jsVersion = str;
    }

    public void Code(Long l) {
        this.clickUTime = l;
    }

    public void V(String str) {
        this.eventType = str;
    }

    public void Code(String str) {
        this.creativeSize = str;
    }
}
