package com.baidu.navisdk.module.dynamicui;

import com.baidu.navisdk.util.common.g;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c {
    public static String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (str2 == null) {
                return str;
            }
            JSONArray jSONArray = new JSONObject(str2).getJSONArray("cards");
            if (jSONArray != null) {
                jSONObject.put("cards", jSONArray);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            g gVar = g.DYNA_DATA;
            if (gVar.c()) {
                gVar.c("DynamUIDataFix", "fixData error, e = " + e);
                return null;
            }
            return null;
        }
    }
}
