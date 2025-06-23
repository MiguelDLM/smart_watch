package com.baidu.tts;

import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public class e0 extends t4<e0> {
    public static Set<String> z;
    public String g;
    public String k;
    public String l;
    public String m;
    public String o;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public l2 h = l2.b;
    public m2 i = m2.OPUS_16K;
    public String j = "0";
    public int n = v2.DEFAULT.a();
    public int p = -1;
    public String q = "https";
    public String r = "2";

    static {
        HashSet hashSet = new HashSet();
        z = hashSet;
        q2 q2Var = q2.SPEED;
        hashSet.add(RouteGuideParams.RGKey.AssistInfo.Speed);
    }

    public String b() {
        return this.o;
    }

    public int c() {
        return this.p;
    }

    public String d() {
        return this.r;
    }

    public String e() {
        return this.s;
    }
}
