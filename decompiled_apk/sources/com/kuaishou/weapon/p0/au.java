package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f18314a;
    private boolean b;

    public au(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.g).intValue(), 0, 200, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f18314a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f18314a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public List b(String str) {
        JSONObject jSONObject = this.f18314a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string) && string.length() > 3) {
                    String a2 = i.a("98bb0a15913e0654348b", "0805");
                    JSONArray jSONArray = new JSONArray(string);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (string2.contains(a2)) {
                            this.b = true;
                        } else {
                            arrayList.add(string2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        return arrayList;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public boolean a() {
        return this.b;
    }
}
