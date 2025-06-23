package com.baidu.navisdk.behavrules.condition;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b extends f {
    protected int d;
    protected int e;
    protected List<com.baidu.navisdk.behavrules.condition.c> f;
    private Runnable g;
    private Runnable h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.l() == com.baidu.navisdk.behavrules.d.SUCCESS) {
                b.this.r();
            }
            b bVar = b.this;
            if (bVar.d > 0) {
                bVar.s();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.behavrules.condition.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0172b implements Runnable {
        public RunnableC0172b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f6639a.run();
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements k {
        @Override // com.baidu.navisdk.behavrules.condition.k
        public j a(String str, com.baidu.navisdk.behavrules.scene.c cVar) {
            com.baidu.navisdk.behavrules.condition.c a2;
            try {
                b bVar = new b(cVar);
                JSONObject jSONObject = new JSONObject(str);
                bVar.e = jSONObject.optInt("delay_notify", 0) * 1000;
                bVar.d = jSONObject.optInt("looper_time", -1) * 1000;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.equals(next, "delay_notify") && !TextUtils.equals(next, "looper_time") && (a2 = com.baidu.navisdk.behavrules.condition.c.a(next, jSONObject.getString(next), cVar.a())) != null) {
                        bVar.f.add(a2);
                    }
                }
                return bVar;
            } catch (JSONException e) {
                com.baidu.navisdk.behavrules.util.b.a("BRuleDataCondition", "parse(), json = " + str + " e = " + e);
                return null;
            }
        }
    }

    public b(com.baidu.navisdk.behavrules.scene.c cVar) {
        super(cVar);
        this.d = -1;
        this.e = 0;
        this.f = new ArrayList();
        this.g = new a();
        this.h = new RunnableC0172b();
    }

    @Override // com.baidu.navisdk.behavrules.condition.j
    public com.baidu.navisdk.behavrules.d l() {
        Iterator<com.baidu.navisdk.behavrules.condition.c> it = this.f.iterator();
        while (it.hasNext()) {
            if (!it.next().a()) {
                return com.baidu.navisdk.behavrules.d.FALSE;
            }
        }
        return com.baidu.navisdk.behavrules.d.SUCCESS;
    }

    @Override // com.baidu.navisdk.behavrules.condition.f
    public void o() {
        if (this.d == -2000) {
            return;
        }
        s();
    }

    @Override // com.baidu.navisdk.behavrules.condition.f
    public void p() {
        q();
    }

    public void q() {
        com.baidu.navisdk.behavrules.util.c.a().b(this.g);
    }

    public void r() {
        com.baidu.navisdk.behavrules.util.c.a().a(this.h, this.e);
    }

    public void s() {
        com.baidu.navisdk.behavrules.util.c.a().b(this.g, this.d);
    }
}
