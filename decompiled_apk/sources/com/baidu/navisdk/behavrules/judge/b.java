package com.baidu.navisdk.behavrules.judge;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private String f6650a;

    public static f b(String str) {
        try {
            b bVar = new b();
            bVar.f6650a = new JSONObject(str).getString("equals");
            return bVar;
        } catch (JSONException e) {
            com.baidu.navisdk.behavrules.util.b.a("BRuleValueEquealsJudge", "parse(), json = " + str + " e = " + e);
            return null;
        }
    }

    @Override // com.baidu.navisdk.behavrules.judge.f
    public boolean a(String str) {
        if (TextUtils.equals(str, this.f6650a)) {
            return true;
        }
        return false;
    }
}
