package com.bytedance.pangle.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b {
    public static String b = "request_finish";
    public static String c = "download_start";
    public static String d = "download_finish";
    public static String e = "install_start";
    public static String f = "install_finish";
    public static String g = "7z_unzip_start";
    public static String h = "7z_unzip_finish";
    public static String i = "load_start";
    public static String j = "load_finish";
    public static String k = "rm_entry_finish";
    private static volatile b l;

    /* renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.pangle.c.a> f10520a = new ArrayList();

    /* loaded from: classes8.dex */
    public static class a {
        public static int A = 32007;
        public static int B = 32008;
        public static int C = 32999;
        public static int D = 40000;
        public static int E = 41000;
        public static int F = 42000;
        public static int G = 50000;
        public static int H = 50004;

        /* renamed from: a, reason: collision with root package name */
        public static int f10521a = 1;
        public static int b = 2;
        public static int c = -1;
        public static int d = -2;
        public static int e = 12000;
        public static int f = 12001;
        public static int g = 12002;
        public static int h = 12003;
        public static int i = 12004;
        public static int j = 20000;
        public static int k = 21000;
        public static int l = 21001;
        public static int m = 21002;
        public static int n = 22000;
        public static int o = 22001;
        public static int p = 22002;
        public static int q = 22999;
        public static int r = 30000;
        public static int s = 31000;
        public static int t = 32000;
        public static int u = 32001;
        public static int v = 32002;
        public static int w = 32003;
        public static int x = 32004;
        public static int y = 32005;
        public static int z = 32006;
    }

    private b() {
    }

    public static b a() {
        if (l == null) {
            synchronized (b.class) {
                l = new b();
            }
        }
        return l;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f10520a) {
            try {
                Iterator<com.bytedance.pangle.c.a> it = this.f10520a.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str, jSONObject, jSONObject2, jSONObject3);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
