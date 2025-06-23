package com.kwad.sdk.collector;

import android.text.TextUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int aoF;
    private String aoE;
    private int state;

    public g(String str, int i) {
        this.aoE = str;
        this.state = i;
    }

    private String Bh() {
        int lastIndexOf;
        String str = this.aoE;
        if (!TextUtils.isEmpty(str)) {
            if ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (lastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
            return str;
        }
        return str;
    }

    public static JSONArray t(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", Bh());
            jSONObject.put("state", this.state);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        return jSONObject;
    }
}
