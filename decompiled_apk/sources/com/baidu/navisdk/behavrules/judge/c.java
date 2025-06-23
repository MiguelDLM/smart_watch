package com.baidu.navisdk.behavrules.judge;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c implements f {

    /* renamed from: a, reason: collision with root package name */
    boolean f6651a = true;
    public List<String> b = new ArrayList();

    public static f b(String str) {
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("in")) {
                cVar.f6651a = true;
                Iterator<String> keys = jSONObject.getJSONObject("in").keys();
                while (keys.hasNext()) {
                    cVar.b.add(keys.next());
                }
            } else if (jSONObject.has("no_in")) {
                cVar.f6651a = false;
                Iterator<String> keys2 = jSONObject.getJSONObject("no_in").keys();
                while (keys2.hasNext()) {
                    cVar.b.add(keys2.next());
                }
            }
            return cVar;
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleValueInJudge", "parse(), json = " + str + " e = " + e);
            return null;
        }
    }

    @Override // com.baidu.navisdk.behavrules.judge.f
    public boolean a(String str) {
        if (this.f6651a) {
            Iterator<String> it = this.b.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next(), str)) {
                    return true;
                }
            }
            return false;
        }
        Iterator<String> it2 = this.b.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(it2.next(), str)) {
                return false;
            }
        }
        return true;
    }
}
