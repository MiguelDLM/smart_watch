package com.baidu.navisdk.behavrules.scene;

import android.util.SparseArray;
import com.baidu.navisdk.behavrules.condition.j;
import com.baidu.navisdk.behavrules.condition.m;
import com.baidu.navisdk.behavrules.scene.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a implements c {
    protected com.baidu.navisdk.behavrules.a b;
    public String c;
    public String d;
    private com.baidu.navisdk.behavrules.action.a f;
    protected String g;
    protected String h;
    protected String i;
    protected int j;
    protected d l;
    private int m;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<Boolean> f6653a = new SparseArray<>();
    public List<j> e = new ArrayList();
    private boolean k = false;

    public a(com.baidu.navisdk.behavrules.a aVar, d dVar) {
        this.b = aVar;
        this.l = dVar;
    }

    private boolean o() {
        for (int i = 0; i < this.f6653a.size(); i++) {
            if (!this.f6653a.valueAt(i).booleanValue()) {
                return false;
            }
        }
        int a2 = c.a.ENTER_PAGE.a();
        if (this.j != -1 && !this.f6653a.get(a2, Boolean.FALSE).booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public void a(c.a aVar) {
        this.f6653a.put(aVar.a(), Boolean.TRUE);
        if (!this.k && o()) {
            for (j jVar : this.e) {
                if (jVar instanceof m) {
                    ((m) jVar).c();
                }
            }
            com.baidu.navisdk.behavrules.util.b.b("BRuleScene", "start() mSceneId = " + this.c);
            this.k = true;
        }
    }

    @Override // com.baidu.navisdk.behavrules.life.a
    public void b() {
        b(c.a.BY_SCENESET);
    }

    @Override // com.baidu.navisdk.behavrules.life.a
    public void c() {
        a(c.a.BY_SCENESET);
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public void d() {
        for (j jVar : this.e) {
            if (jVar != null) {
                jVar.d();
            }
        }
    }

    public void e() {
        if (this.b.f() != null) {
            this.b.f().e(this.d);
            this.b.f().n(this.h);
        }
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public String f() {
        return this.h;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public String g() {
        return this.d;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public String h() {
        return this.g;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public com.baidu.navisdk.behavrules.action.a i() {
        return this.f;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public int j() {
        return this.m;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public boolean k() {
        return this.k;
    }

    public boolean l() {
        com.baidu.navisdk.behavrules.action.b b = this.b.b(this.f.a());
        if (b == null) {
            return false;
        }
        Object a2 = b.a((c) this);
        if (!b.a(a2, this.b.a())) {
            com.baidu.navisdk.behavrules.util.b.b("BRuleScene", "handleAction() fixData error scene =" + this);
            return false;
        }
        b.a((com.baidu.navisdk.behavrules.action.b) a2);
        return true;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public String m() {
        return this.c;
    }

    public com.baidu.navisdk.behavrules.d n() {
        com.baidu.navisdk.behavrules.util.b.b("BRuleScene", "isAllMatched() mSceneId =" + this.c);
        if (!this.k) {
            com.baidu.navisdk.behavrules.util.b.b("BRuleScene", "isAllMatched() error, not running");
            return com.baidu.navisdk.behavrules.d.ERROR_WAIT;
        }
        com.baidu.navisdk.behavrules.d d = this.b.d(this.i);
        if (d == null) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleScene", "isAllMatched(), 当前场景的判断条件为空");
            return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
        }
        if (d != com.baidu.navisdk.behavrules.d.SUCCESS) {
            return d;
        }
        for (int i = 0; i < this.e.size(); i++) {
            com.baidu.navisdk.behavrules.d l = this.e.get(i).l();
            if (l != com.baidu.navisdk.behavrules.d.SUCCESS) {
                com.baidu.navisdk.behavrules.util.b.b("BRuleScene", "isAllMatched(), 策略不满足条件" + this.e.get(i));
                return l;
            }
        }
        return com.baidu.navisdk.behavrules.d.SUCCESS;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public void run() {
        com.baidu.navisdk.behavrules.d n = n();
        com.baidu.navisdk.behavrules.util.b.b("BRuleScene", "run(), result = " + n + " scene = " + this);
        if (n == com.baidu.navisdk.behavrules.d.SUCCESS) {
            if (l()) {
                e();
            } else {
                b(c.a.BY_ERROR);
            }
            this.l.a(this.h);
            return;
        }
        if (n == com.baidu.navisdk.behavrules.d.ERROR_STOP) {
            b(c.a.BY_ERROR);
            return;
        }
        if (n == com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE) {
            d();
        } else if (n != com.baidu.navisdk.behavrules.d.ERROR_WAIT && n == com.baidu.navisdk.behavrules.d.FALSE_MATCH_ONCE) {
            b(c.a.ENTER_PAGE);
        }
    }

    public String toString() {
        return "BNAsrScene{mSceneId='" + this.c + "'}";
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public void b(c.a aVar) {
        this.f6653a.put(aVar.a(), Boolean.FALSE);
        if (this.k) {
            for (j jVar : this.e) {
                if (jVar instanceof m) {
                    ((m) jVar).b();
                }
            }
            com.baidu.navisdk.behavrules.util.b.b("BRuleScene", "stop() mSceneId = " + this.c);
            this.k = false;
        }
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public void a(int i) {
        int i2 = this.j;
        if (i != i2 && ((i <= 0 || (i & i2) == 0) && i2 != -1)) {
            b(c.a.ENTER_PAGE);
        } else {
            a(c.a.ENTER_PAGE);
        }
    }

    public void a(List<j> list) {
        this.e = list;
    }

    @Override // com.baidu.navisdk.behavrules.scene.c
    public com.baidu.navisdk.behavrules.a a() {
        return this.b;
    }

    public void a(com.baidu.navisdk.behavrules.action.a aVar) {
        this.f = aVar;
    }

    public static a a(String str, String str2, com.baidu.navisdk.behavrules.a aVar, b bVar) {
        try {
            a aVar2 = new a(aVar, bVar);
            JSONObject jSONObject = new JSONObject(str2);
            aVar2.c = str;
            String optString = jSONObject.optString("scene_type", aVar.c());
            if (aVar.e() != null) {
                optString = aVar.e().a(optString);
            }
            aVar2.h = optString;
            aVar2.d = jSONObject.optString("statistics_key", aVar2.c);
            aVar2.i = jSONObject.optString("occur_type", aVar.d());
            aVar2.j = jSONObject.optInt("invoke_page", aVar.b());
            aVar2.m = jSONObject.optInt("sort", 0);
            com.baidu.navisdk.behavrules.action.a a2 = com.baidu.navisdk.behavrules.action.a.a(jSONObject.getString("action"), aVar2.b);
            if (a2 == null) {
                return null;
            }
            aVar2.a(a2);
            aVar2.g = jSONObject.optString("voice_recinfo");
            return aVar2;
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.b("BRuleScene", "parse(), key = " + str + " json = " + str2 + " e = " + e);
            return null;
        }
    }
}
