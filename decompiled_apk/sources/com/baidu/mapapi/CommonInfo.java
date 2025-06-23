package com.baidu.mapapi;

/* loaded from: classes7.dex */
public class CommonInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f5748a;
    private String b;

    /* loaded from: classes7.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f5749a = "";
        private String b = "";

        public Builder androidId(String str) {
            this.b = str;
            return this;
        }

        public CommonInfo build() {
            return new CommonInfo(this.b, this.f5749a);
        }

        public Builder oaid(String str) {
            this.f5749a = str;
            return this;
        }
    }

    public String getAndroidID() {
        return this.b;
    }

    public String getOAID() {
        return this.f5748a;
    }

    private CommonInfo(String str, String str2) {
        this.b = str;
        this.f5748a = str2;
    }
}
