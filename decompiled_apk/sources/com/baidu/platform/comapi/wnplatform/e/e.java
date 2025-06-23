package com.baidu.platform.comapi.wnplatform.e;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f9908a;
    private HashMap<String, String> b = new LinkedHashMap(32);
    private HashMap<String, String> c = new LinkedHashMap(32);
    private int d = -1;
    private boolean e = true;
    private b f = b.GET;
    private a g = a.PROTOBUF;
    private int h = -1;
    private boolean i = true;
    private boolean j = true;
    private boolean k = true;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private int o;

    /* loaded from: classes8.dex */
    public enum a {
        PROTOBUF("pb"),
        JSON("json"),
        UNKNOWN("unknown");

        private String d;

        a(String str) {
            this.d = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.d;
        }
    }

    /* loaded from: classes8.dex */
    public enum b {
        GET("get"),
        POST("post");

        private String c;

        b(String str) {
            this.c = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.c;
        }
    }

    public e() {
        this.f9908a = "";
        this.f9908a = "https://newclient.map.baidu.com/client/phpui2/";
    }

    public e a(String str, String str2) {
        this.b.put(str, str2);
        return this;
    }

    public void b(boolean z) {
        this.l = z;
    }

    public String toString() {
        com.baidu.platform.comapi.wnplatform.e.a.a aVar = new com.baidu.platform.comapi.wnplatform.e.a.a();
        aVar.a();
        int indexOf = this.f9908a.indexOf(63);
        if (indexOf != -1) {
            String[] split = this.f9908a.substring(indexOf + 1).split("&");
            if (split != null) {
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    int indexOf2 = split[i].indexOf(61);
                    if (indexOf2 != -1) {
                        a(split[i].substring(0, indexOf2), split[i].substring(indexOf2 + 1));
                    }
                }
            }
            this.f9908a = this.f9908a.substring(0, indexOf);
        }
        aVar.a(ClientCookie.DOMAIN_ATTR).b(this.f9908a);
        if (this.m) {
            aVar.a("OFFLINE_SEARCH").a(1);
        }
        if (this.b.size() > 0 || (this.f == b.GET && this.c.size() > 0)) {
            aVar.a("uri_param").a();
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                aVar.a(entry.getKey()).b(entry.getValue());
            }
            if (this.f == b.GET && this.c.size() > 0) {
                for (Map.Entry<String, String> entry2 : this.c.entrySet()) {
                    aVar.a(entry2.getKey()).b(entry2.getValue());
                }
            }
            aVar.b();
        }
        if (this.f == b.POST && this.c.size() > 0) {
            aVar.a("query_param").a();
            for (Map.Entry<String, String> entry3 : this.c.entrySet()) {
                aVar.a(entry3.getKey()).b(entry3.getValue());
            }
            aVar.b();
        }
        aVar.a("ext_param").a();
        aVar.a("data_format").a(this.g);
        aVar.a("b_cache").a(this.e);
        aVar.a("method").a(this.f);
        aVar.a("businessid").a(this.o);
        aVar.a("b_user_param").a(this.i);
        aVar.a("b_sign").a(this.j);
        aVar.a("b_encode").a(this.k);
        aVar.b();
        aVar.b();
        return aVar.toString();
    }

    public e a(String str, int i) {
        return a(str, String.valueOf(i));
    }

    public void b(int i) {
        this.o = i;
    }

    public e a(int i) {
        this.d = i;
        return this;
    }

    public e a(boolean z) {
        this.e = z;
        return this;
    }

    public e a(a aVar) {
        if (aVar == null) {
            return this;
        }
        this.g = aVar;
        return this;
    }

    public e a(b bVar) {
        if (bVar == null) {
            return this;
        }
        this.f = bVar;
        return this;
    }
}
