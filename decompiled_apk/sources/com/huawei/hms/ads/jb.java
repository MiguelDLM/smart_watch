package com.huawei.hms.ads;

/* loaded from: classes10.dex */
public class jb {
    Long B;
    Boolean C;
    Long Code;
    String D;
    String F;
    Integer I;
    String L;
    String S;
    Integer V;
    String Z;

    /* loaded from: classes10.dex */
    public static final class a {
        Long B;
        Boolean C;
        Long Code;
        String D;
        String F;
        Integer I;
        String L;
        String S;
        Integer V;
        String Z;

        public a B(String str) {
            this.F = str;
            return this;
        }

        public a Code(Boolean bool) {
            this.C = bool;
            return this;
        }

        public a I(String str) {
            this.Z = str;
            return this;
        }

        public a V(Integer num) {
            this.I = num;
            return this;
        }

        public a Z(String str) {
            this.S = str;
            return this;
        }

        public a Code(Integer num) {
            this.V = num;
            return this;
        }

        public a V(Long l) {
            this.B = l;
            return this;
        }

        public a Code(Long l) {
            this.Code = l;
            return this;
        }

        public a V(String str) {
            this.L = str;
            return this;
        }

        public a Code(String str) {
            this.D = str;
            return this;
        }

        public jb Code() {
            jb jbVar = new jb();
            jbVar.Code = this.Code;
            jbVar.V = this.V;
            jbVar.I = this.I;
            jbVar.B = this.B;
            jbVar.Z = this.Z;
            jbVar.C = this.C;
            jbVar.S = this.S;
            jbVar.F = this.F;
            jbVar.D = this.D;
            jbVar.L = this.L;
            return jbVar;
        }
    }

    public String B() {
        return this.Z;
    }

    public Long C() {
        return this.B;
    }

    public String Code() {
        return this.D;
    }

    public String D() {
        return this.F;
    }

    public String F() {
        return this.S;
    }

    public Integer I() {
        return this.V;
    }

    public String L() {
        return this.L;
    }

    public Boolean S() {
        return this.C;
    }

    public Long V() {
        return this.Code;
    }

    public Integer Z() {
        return this.I;
    }

    public void B(String str) {
        this.L = str;
    }

    public void Code(Boolean bool) {
        this.C = bool;
    }

    public void I(String str) {
        this.S = str;
    }

    public void V(Integer num) {
        this.I = num;
    }

    public void Z(String str) {
        this.F = str;
    }

    public void Code(Integer num) {
        this.V = num;
    }

    public void V(Long l) {
        this.B = l;
    }

    public void Code(Long l) {
        this.Code = l;
    }

    public void V(String str) {
        this.Z = str;
    }

    public void Code(String str) {
        this.D = str;
    }
}
