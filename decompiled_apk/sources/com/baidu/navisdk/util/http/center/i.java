package com.baidu.navisdk.util.http.center;

/* loaded from: classes8.dex */
public class i implements l {

    /* renamed from: a, reason: collision with root package name */
    private String f9302a;
    private String b;

    public i(String str, String str2) {
        this.f9302a = str;
        this.b = str2;
    }

    @Override // com.baidu.navisdk.util.http.center.l
    public String a() {
        return this.f9302a;
    }

    @Override // com.baidu.navisdk.util.http.center.l
    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        String str = this.f9302a;
        if (str == null ? iVar.f9302a != null : !str.equals(iVar.f9302a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = iVar.b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        String str = this.f9302a;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * 31;
        String str2 = this.b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        return "BasicNameValuePair{name='" + this.f9302a + "', value='" + this.b + "'}";
    }
}
