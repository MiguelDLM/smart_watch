package com.baidu.navisdk.behavrules;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navisdk.behavrules.condition.b;
import com.baidu.navisdk.behavrules.condition.d;
import com.baidu.navisdk.behavrules.condition.h;
import com.baidu.navisdk.behavrules.condition.i;
import com.baidu.navisdk.behavrules.condition.k;
import com.baidu.navisdk.behavrules.condition.l;
import com.baidu.navisdk.behavrules.condition.n;
import com.baidu.navisdk.behavrules.condition.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class a {
    private o d;
    private com.baidu.navisdk.behavrules.condition.e i;
    private com.baidu.navisdk.behavrules.sp.b j;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, com.baidu.navisdk.behavrules.data.c> f6635a = new ConcurrentHashMap();
    private Map<String, com.baidu.navisdk.behavrules.action.b> b = new HashMap();
    private List<l> c = new ArrayList();
    private Map<String, k> e = new HashMap();
    private int f = -1;
    private String g = null;
    private String h = "invalid";

    public a(Context context) {
        this.j = com.baidu.navisdk.behavrules.sp.b.a(context);
        h();
    }

    private void h() {
        a("data", new b.c());
        a("userop", new i.b());
        a("scene_type", new h.a());
        a("frequency", new d.a());
    }

    public void a(com.baidu.navisdk.behavrules.data.c cVar) {
        this.f6635a.put(cVar.a(), cVar);
    }

    public com.baidu.navisdk.behavrules.action.b b(String str) {
        return this.b.get(str);
    }

    public k c(String str) {
        return this.e.get(str);
    }

    public d d(String str) {
        if (this.d == null) {
            com.baidu.navisdk.behavrules.util.b.b("BNAsrSceneContext", "isMatchPage(),error not set MathPageJudge");
        }
        return this.d.a(str);
    }

    public void e(String str) {
        this.h = str;
    }

    public com.baidu.navisdk.behavrules.sp.b f() {
        return this.j;
    }

    public List<l> g() {
        return this.c;
    }

    public List<com.baidu.navisdk.behavrules.data.c> a() {
        return new ArrayList(this.f6635a.values());
    }

    public int b() {
        return this.f;
    }

    public String c() {
        return this.h;
    }

    public com.baidu.navisdk.behavrules.condition.e e() {
        return this.i;
    }

    public void f(String str) {
        this.g = str;
    }

    public void a(com.baidu.navisdk.behavrules.action.b bVar) {
        if (bVar == null) {
            return;
        }
        Iterator<String> it = bVar.a().iterator();
        while (it.hasNext()) {
            this.b.put(it.next(), bVar);
        }
    }

    public String d() {
        return this.g;
    }

    public void a(l lVar) {
        this.c.add(lVar);
    }

    public int a(String str) {
        for (l lVar : this.c) {
            if (TextUtils.equals(lVar.e(), str)) {
                return lVar.n();
            }
        }
        com.baidu.navisdk.behavrules.util.b.b("BNAsrSceneContext", "findFreTypeTimeDiff(),error not found key = " + str);
        return 60000;
    }

    public void a(n nVar) {
        if (this.d == null) {
            com.baidu.navisdk.behavrules.util.b.b("BNAsrSceneContext", "isMatchPage(),error not set MathPageJudge");
        }
        this.d.a(nVar);
    }

    public void a(o oVar) {
        this.d = oVar;
    }

    public void a(String str, k kVar) {
        this.e.put(str, kVar);
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(com.baidu.navisdk.behavrules.condition.e eVar) {
        this.i = eVar;
    }
}
