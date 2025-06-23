package com.baidu.navisdk.apicenter;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;

/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private String f6535a;
    private Object b;
    private Object c;
    private Object d;
    private Object e;
    private ArrayMap<String, Object> f;

    private h() {
    }

    public static h a() {
        return new h();
    }

    public h b(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 1097546692:
                if (str.equals("resultA")) {
                    c = 0;
                    break;
                }
                break;
            case 1097546693:
                if (str.equals("resultB")) {
                    c = 1;
                    break;
                }
                break;
            case 1097546694:
                if (str.equals("resultC")) {
                    c = 2;
                    break;
                }
                break;
            case 1097546695:
                if (str.equals("resultD")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.b = obj;
                return this;
            case 1:
                this.c = obj;
                return this;
            case 2:
                this.d = obj;
                return this;
            case 3:
                this.e = obj;
                return this;
            default:
                if (this.f == null) {
                    this.f = new ArrayMap<>();
                }
                this.f.put(str, obj);
                return this;
        }
    }

    public int c(String str) {
        return a(str, 0);
    }

    public String toString() {
        String simpleArrayMap;
        StringBuilder sb = new StringBuilder("Result{");
        sb.append("fromApiName='");
        sb.append(this.f6535a);
        sb.append('\'');
        sb.append(", resultA=");
        sb.append(this.b);
        sb.append(", resultB=");
        sb.append(this.c);
        sb.append(", resultC=");
        sb.append(this.d);
        sb.append(", resultD=");
        sb.append(this.e);
        sb.append(", moreResults=");
        ArrayMap<String, Object> arrayMap = this.f;
        if (arrayMap == null) {
            simpleArrayMap = "null";
        } else {
            simpleArrayMap = arrayMap.toString();
        }
        sb.append(simpleArrayMap);
        sb.append('}');
        return sb.toString();
    }

    public h a(Object obj) {
        return b("resultA", obj);
    }

    public <T> T a(@NonNull String str) {
        return (T) a(str, (String) null);
    }

    public <T> T a(@NonNull String str, T t) {
        T t2;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 1097546692:
                if (str.equals("resultA")) {
                    c = 0;
                    break;
                }
                break;
            case 1097546693:
                if (str.equals("resultB")) {
                    c = 1;
                    break;
                }
                break;
            case 1097546694:
                if (str.equals("resultC")) {
                    c = 2;
                    break;
                }
                break;
            case 1097546695:
                if (str.equals("resultD")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                t2 = (T) this.b;
                break;
            case 1:
                t2 = (T) this.c;
                break;
            case 2:
                t2 = (T) this.d;
                break;
            case 3:
                t2 = (T) this.e;
                break;
            default:
                t2 = (T) this.f.get(str);
                break;
        }
        return t2 == null ? t : t2;
    }

    public boolean b(String str) {
        return a(str, false);
    }

    public int a(String str, int i) {
        return ((Integer) a(str, (String) Integer.valueOf(i))).intValue();
    }

    public boolean a(String str, boolean z) {
        return ((Boolean) a(str, (String) Boolean.valueOf(z))).booleanValue();
    }
}
