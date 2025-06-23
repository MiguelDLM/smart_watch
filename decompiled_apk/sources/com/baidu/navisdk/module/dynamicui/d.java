package com.baidu.navisdk.module.dynamicui;

import com.baidu.navisdk.l;
import com.baidu.navisdk.m;
import com.baidu.navisdk.n;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d {
    private static d e;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f7157a = new HashMap();
    private Map<String, String> b = new HashMap();
    private e c = e.a();
    private boolean d;

    /* loaded from: classes7.dex */
    public class a implements n {
        public a() {
        }

        @Override // com.baidu.navisdk.n
        public void a(boolean z, String str) {
            g gVar = g.DYNA_DATA;
            if (gVar.d()) {
                gVar.e("DynamicUIData", "onResult(), isSuccess = " + z + " data = " + str);
            }
            if (z) {
                d.this.a(str);
                d.this.c.a(d.this.f7157a, d.this.b);
            }
        }
    }

    public static d b() {
        if (e == null) {
            synchronized (d.class) {
                e = new d();
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            this.f7157a.clear();
            this.b.clear();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("ui");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.f7157a.put(next, jSONObject2.getString(next));
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("data");
            Iterator<String> keys2 = jSONObject3.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                this.b.put(next2, jSONObject3.getString(next2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            g gVar = g.DYNA_DATA;
            if (gVar.d()) {
                gVar.e("DynamicUIData", "parseUi(), data = " + str + " e = " + e2);
            }
            this.f7157a.clear();
            this.b.clear();
        }
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        l.a().b(m.UI, new a());
    }

    public String a(String str, String str2) {
        return c.a(this.f7157a.get(str), this.b.get(str2));
    }
}
