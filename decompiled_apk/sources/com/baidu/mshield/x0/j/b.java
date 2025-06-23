package com.baidu.mshield.x0.j;

import com.baidu.mshield.x0.b.d;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f6423a;
    public String b;
    public String c;
    public String d;
    public String e;

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f6423a = jSONObject.optString("0");
            bVar.c = jSONObject.optString("1");
            bVar.d = jSONObject.optString("2");
            bVar.e = jSONObject.optString("3");
            bVar.b = jSONObject.optString("4");
            return bVar;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            d.a(th);
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.d;
        if (str == null) {
            if (bVar.d != null) {
                return false;
            }
        } else if (!str.equals(bVar.d)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null) {
            if (bVar.e != null) {
                return false;
            }
        } else if (!str2.equals(bVar.e)) {
            return false;
        }
        String str3 = this.b;
        if (str3 == null) {
            if (bVar.b != null) {
                return false;
            }
        } else if (!str3.equals(bVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i = 1;
        try {
            String str = this.d;
            int i2 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i3 = (hashCode + 31) * 31;
            String str2 = this.e;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            i = hashCode2 + i3;
            int i4 = i * 31;
            String str3 = this.b;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return i4 + i2;
        } catch (Throwable th) {
            d.a(th);
            return i;
        }
    }
}
