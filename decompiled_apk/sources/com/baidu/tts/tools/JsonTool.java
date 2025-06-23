package com.baidu.tts.tools;

import java.util.Collection;
import java.util.Set;
import org.json.JSONArray;

/* loaded from: classes8.dex */
public class JsonTool {
    public static JSONArray fromSetToJson(Set<String> set) {
        if (set != null) {
            return new JSONArray((Collection) set);
        }
        return null;
    }

    public static String[] getStringarray(JSONArray jSONArray) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArray.optString(i);
            }
            return strArr;
        }
        return null;
    }
}
