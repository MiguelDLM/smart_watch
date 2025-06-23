package com.baidu.navisdk.apicenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.d0;

/* loaded from: classes7.dex */
public class a {
    private static final Object j = new Object();
    private static int k;
    private static a l;

    /* renamed from: a, reason: collision with root package name */
    private String f6532a;
    private int b;
    private Object c;
    private Object d;
    private Object e;
    private Object f;
    private ArrayMap<String, Object> g;
    a h;
    g i;

    public a a(int i) {
        this.b = i;
        return this;
    }

    public a b(Object obj) {
        return b("paramB", obj);
    }

    public String c() {
        return this.f6532a;
    }

    public int d() {
        return this.b;
    }

    public a e(String str) {
        this.f6532a = str;
        return this;
    }

    public String toString() {
        String simpleArrayMap;
        StringBuilder sb = new StringBuilder("Api{");
        sb.append("target=");
        sb.append(this.f6532a);
        sb.append(", what=");
        sb.append(this.b);
        sb.append(", apiCenter=");
        sb.append(this.i);
        sb.append(", paramA=");
        sb.append(this.c);
        sb.append(", paramB=");
        sb.append(this.d);
        sb.append(", paramC=");
        sb.append(this.e);
        sb.append(", paramD=");
        sb.append(this.f);
        sb.append(", moreParams=");
        ArrayMap<String, Object> arrayMap = this.g;
        if (arrayMap == null) {
            simpleArrayMap = "null";
        } else {
            simpleArrayMap = arrayMap.toString();
        }
        sb.append(simpleArrayMap);
        sb.append('}');
        return sb.toString();
    }

    @NonNull
    public static a e() {
        synchronized (j) {
            try {
                a aVar = l;
                if (aVar != null) {
                    l = aVar.h;
                    aVar.h = null;
                    k--;
                    return aVar;
                }
                return new a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public a a(Object obj) {
        return b("paramA", obj);
    }

    public a b(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -995428012:
                if (str.equals("paramA")) {
                    c = 0;
                    break;
                }
                break;
            case -995428011:
                if (str.equals("paramB")) {
                    c = 1;
                    break;
                }
                break;
            case -995428010:
                if (str.equals("paramC")) {
                    c = 2;
                    break;
                }
                break;
            case -995428009:
                if (str.equals("paramD")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.c = obj;
                return this;
            case 1:
                this.d = obj;
                return this;
            case 2:
                this.e = obj;
                return this;
            case 3:
                this.f = obj;
                return this;
            default:
                if (this.g == null) {
                    this.g = new ArrayMap<>();
                }
                this.g.put(str, obj);
                return this;
        }
    }

    public int c(String str) {
        return a(str, 0);
    }

    public String d(String str) {
        return a(str, (String) null);
    }

    public <T> T a(@NonNull String str) {
        return (T) a(str, (String) null);
    }

    public <T> T a(@NonNull String str, T t) {
        T t2;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -995428012:
                if (str.equals("paramA")) {
                    c = 0;
                    break;
                }
                break;
            case -995428011:
                if (str.equals("paramB")) {
                    c = 1;
                    break;
                }
                break;
            case -995428010:
                if (str.equals("paramC")) {
                    c = 2;
                    break;
                }
                break;
            case -995428009:
                if (str.equals("paramD")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                t2 = (T) this.c;
                break;
            case 1:
                t2 = (T) this.d;
                break;
            case 2:
                t2 = (T) this.e;
                break;
            case 3:
                t2 = (T) this.f;
                break;
            default:
                ArrayMap<String, Object> arrayMap = this.g;
                if (arrayMap != null) {
                    t2 = (T) arrayMap.get(str);
                    break;
                } else {
                    t2 = null;
                    break;
                }
        }
        return t2 == null ? t : t2;
    }

    public boolean b(String str) {
        return a(str, false);
    }

    public int a(String str, int i) {
        return ((Integer) a(str, (String) Integer.valueOf(i))).intValue();
    }

    public void b() {
        ArrayMap<String, Object> arrayMap = this.g;
        if (arrayMap != null) {
            arrayMap.clear();
        }
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.f6532a = null;
        synchronized (j) {
            try {
                int i = k;
                if (i < 50) {
                    this.h = l;
                    l = this;
                    k = i + 1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String a(String str, String str2) {
        return (String) a(str, str2);
    }

    public boolean a(String str, boolean z) {
        return ((Boolean) a(str, (String) Boolean.valueOf(z))).booleanValue();
    }

    @NonNull
    public static a a(g gVar) {
        a e = e();
        e.i = gVar;
        return e;
    }

    @Nullable
    public h a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Api", "call --> api = " + this + ", mApiCenter = " + this.i);
            d0.a(this.i, "mApiCenter could not be null!");
        }
        g gVar = this.i;
        if (gVar == null) {
            return null;
        }
        return gVar.a(this);
    }
}
