package com.baidu.navisdk.behavrules.condition;

import android.text.TextUtils;
import com.baidu.navisdk.behavrules.util.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class i extends f implements a.b {
    private int d;
    private String[] e;
    private int f;
    private int g;
    private long h;
    private long i;
    private long j;
    private String[] k;
    private Runnable l;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f6639a.run();
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements k {
        @Override // com.baidu.navisdk.behavrules.condition.k
        public j a(String str, com.baidu.navisdk.behavrules.scene.c cVar) {
            try {
                i iVar = new i(cVar);
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("op_seq");
                if (!TextUtils.isEmpty(optString)) {
                    iVar.e = optString.split(">");
                }
                iVar.j = jSONObject.optInt("delay_notify") * 1000;
                iVar.f = jSONObject.optInt("overtime", 0) * 1000;
                iVar.g = jSONObject.optInt("seq_overtime", 0) * 1000;
                String optString2 = jSONObject.optString("reset_event");
                if (!TextUtils.isEmpty(optString2)) {
                    iVar.k = optString2.split("\\|");
                }
                return iVar;
            } catch (JSONException e) {
                com.baidu.navisdk.behavrules.util.b.a("BRuleUserOpCondition", "parse(), json = " + str + " e = " + e);
                return null;
            }
        }
    }

    public i(com.baidu.navisdk.behavrules.scene.c cVar) {
        super(cVar);
        this.d = 0;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.l = new a();
    }

    @Override // com.baidu.navisdk.behavrules.condition.a, com.baidu.navisdk.behavrules.condition.j
    public void d() {
        this.h = 0L;
        this.d = 0;
    }

    @Override // com.baidu.navisdk.behavrules.condition.j
    public com.baidu.navisdk.behavrules.d l() {
        if (this.d >= this.e.length) {
            return com.baidu.navisdk.behavrules.d.SUCCESS;
        }
        return com.baidu.navisdk.behavrules.d.FALSE;
    }

    @Override // com.baidu.navisdk.behavrules.condition.f
    public void o() {
        d();
        com.baidu.navisdk.behavrules.util.a.a().a(this, com.baidu.navisdk.behavrules.event.c.class, new Class[0]);
        com.baidu.navisdk.behavrules.util.a.a().a(this, com.baidu.navisdk.behavrules.event.b.class, new Class[0]);
    }

    @Override // com.baidu.navisdk.behavrules.util.a.b
    public void onEvent(Object obj) {
        int i;
        int i2;
        if (obj instanceof com.baidu.navisdk.behavrules.event.a) {
            String m = this.f6639a.m();
            String[] strArr = this.k;
            if (strArr != null) {
                for (String str : strArr) {
                    if (TextUtils.equals(str, ((com.baidu.navisdk.behavrules.event.a) obj).a())) {
                        com.baidu.navisdk.behavrules.util.b.b("BRuleUserOpCondition", "onEvent() matchResetEvent sceneId =" + m);
                        d();
                        return;
                    }
                }
            }
            String[] strArr2 = this.e;
            if (strArr2 != null && strArr2.length > this.d) {
                if (obj != null && TextUtils.equals(((com.baidu.navisdk.behavrules.event.a) obj).a(), this.e[this.d])) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i3 = this.d;
                    if (i3 != 0 && (i2 = this.f) != 0 && currentTimeMillis - this.h >= i2) {
                        com.baidu.navisdk.behavrules.util.b.a("BRuleUserOpCondition", "onEvent() out OverTime, sceneId = " + m);
                        d();
                    } else if (i3 != 0 && (i = this.g) != 0 && currentTimeMillis - this.i >= i) {
                        com.baidu.navisdk.behavrules.util.b.a("BRuleUserOpCondition", "onEvent() out SeqOverTime, sceneId = " + m);
                        d();
                    } else {
                        com.baidu.navisdk.behavrules.util.b.a("BRuleUserOpCondition", "onEvent() matched, sceneId = " + m + " index = " + this.d);
                        int i4 = this.d;
                        if (i4 == 0) {
                            this.i = currentTimeMillis;
                        }
                        this.h = currentTimeMillis;
                        this.d = i4 + 1;
                    }
                }
                if (l() == com.baidu.navisdk.behavrules.d.SUCCESS) {
                    com.baidu.navisdk.behavrules.util.c.a().a(this.l, this.j);
                    return;
                }
                return;
            }
            com.baidu.navisdk.behavrules.util.b.b("BRuleUserOpCondition", "onEvent() error, mOpIndex = " + this.d + " sceneId = " + m);
        }
    }

    @Override // com.baidu.navisdk.behavrules.condition.f
    public void p() {
        d();
        com.baidu.navisdk.behavrules.util.a.a().a((a.b) this);
        com.baidu.navisdk.behavrules.util.c.a().a(this.l);
    }
}
