package com.baidu.navisdk.behavrules.scene;

import android.text.TextUtils;
import com.baidu.navisdk.behavrules.scene.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public String f6654a;
    public String b;
    private com.baidu.navisdk.behavrules.a d;
    private List<c> c = new ArrayList();
    private boolean e = false;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6655a;

        public a(String str) {
            this.f6655a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.behavrules.util.b.b("BRuleSceneSet", "resumeScenies() sceneType = " + this.f6655a);
            for (c cVar : b.this.c) {
                if (TextUtils.equals(this.f6655a, cVar.f())) {
                    cVar.a(c.a.TIME_DIFF);
                }
            }
        }
    }

    public b(com.baidu.navisdk.behavrules.a aVar) {
        this.d = aVar;
    }

    @Override // com.baidu.navisdk.behavrules.life.a
    public void b() {
        if (!this.e) {
            return;
        }
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        com.baidu.navisdk.behavrules.util.b.b("BRuleSceneSet", "stop id = " + this.f6654a + " mSeneies = " + this.c);
        com.baidu.navisdk.behavrules.c.c().b(this);
        this.e = false;
    }

    @Override // com.baidu.navisdk.behavrules.life.a
    public void c() {
        if (this.e) {
            return;
        }
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        com.baidu.navisdk.behavrules.util.b.b("BRuleSceneSet", "will running id = " + this.f6654a + " mSeneies = " + this.c);
        com.baidu.navisdk.behavrules.c.c().a(this);
        this.e = true;
    }

    public List<c> e() {
        return this.c;
    }

    public void a(c cVar) {
        this.c.add(cVar);
    }

    @Override // com.baidu.navisdk.behavrules.scene.d
    public void a(String str) {
        int a2 = this.d.a(str);
        com.baidu.navisdk.behavrules.util.b.b("BRuleSceneSet", "pauseSceines(),id = " + this.f6654a + "sceneType = " + str + " timeDiff = " + a2);
        for (c cVar : this.c) {
            if (TextUtils.equals(str, cVar.f())) {
                cVar.b(c.a.TIME_DIFF);
            }
        }
        com.baidu.navisdk.behavrules.util.c.a().a(new a(str), a2);
    }

    public static b a(String str, com.baidu.navisdk.behavrules.a aVar) {
        try {
            b bVar = new b(aVar);
            JSONObject jSONObject = new JSONObject(str);
            bVar.f6654a = jSONObject.optString("id", "naviVoice");
            bVar.b = jSONObject.optString("version", "1");
            return bVar;
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleSceneSet", "parseBNAsrSceneSet(), json = " + str + " e = " + e);
            return null;
        }
    }

    public com.baidu.navisdk.behavrules.a a() {
        return this.d;
    }
}
