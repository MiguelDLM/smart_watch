package com.baidu.navisdk.behavrules;

import android.text.TextUtils;
import com.baidu.navisdk.behavrules.condition.g;
import com.baidu.navisdk.behavrules.condition.j;
import com.baidu.navisdk.behavrules.condition.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e {

    /* loaded from: classes7.dex */
    public class a implements Comparator<com.baidu.navisdk.behavrules.scene.c> {
        public a(e eVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.baidu.navisdk.behavrules.scene.c cVar, com.baidu.navisdk.behavrules.scene.c cVar2) {
            return cVar2.j() - cVar.j();
        }
    }

    public com.baidu.navisdk.behavrules.scene.b a(String str, com.baidu.navisdk.behavrules.a aVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.navisdk.behavrules.util.b.b("BRuleParseHelper", "parseConfig(), content = " + jSONObject);
            com.baidu.navisdk.behavrules.scene.b a2 = com.baidu.navisdk.behavrules.scene.b.a(str, aVar);
            JSONObject optJSONObject = jSONObject.optJSONObject("frequency");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    aVar.a(g.a(next, optJSONObject.getString(next), aVar));
                }
            }
            boolean a3 = a(jSONObject.getJSONObject("scene_array").toString(), aVar, a2);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("bubble_array");
            if (optJSONObject2 != null) {
                a3 = a(optJSONObject2.toString(), aVar, a2);
            }
            if (!a3) {
                com.baidu.navisdk.behavrules.util.b.b("BRuleParseHelper", "parseSceneSet() fail, return null");
                return null;
            }
            a(a2.e());
            return a2;
        } catch (Exception e) {
            com.baidu.navisdk.behavrules.util.b.b("BRuleParseHelper", "parseConfig(), json = " + str + " e = " + e);
            return null;
        }
    }

    private void a(List<com.baidu.navisdk.behavrules.scene.c> list) {
        if (list != null) {
            Collections.sort(list, new a(this));
        }
    }

    private boolean a(String str, com.baidu.navisdk.behavrules.a aVar, com.baidu.navisdk.behavrules.scene.b bVar) {
        j a2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                com.baidu.navisdk.behavrules.scene.a a3 = com.baidu.navisdk.behavrules.scene.a.a(next, jSONObject2.toString(), aVar, bVar);
                if (a3 != null) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("stratgies");
                    Iterator<String> keys2 = jSONObject3.keys();
                    ArrayList arrayList = new ArrayList();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        j a4 = a(aVar, next2, jSONObject3.getJSONObject(next2).toString(), a3);
                        if (a4 != null) {
                            arrayList.add(a4);
                        }
                    }
                    if (!TextUtils.equals(a3.f(), "invalid") && (a2 = a(aVar, "scene_type", a3.f(), a3)) != null) {
                        arrayList.add(0, a2);
                    }
                    a3.a(arrayList);
                    bVar.a(a3);
                }
            }
            return true;
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.b("BRuleParseHelper", "parseSceneies() error, e = " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    private j a(com.baidu.navisdk.behavrules.a aVar, String str, String str2, com.baidu.navisdk.behavrules.scene.a aVar2) {
        k c;
        if (aVar == null || (c = aVar.c(str)) == null) {
            return null;
        }
        return c.a(str2, aVar2);
    }
}
