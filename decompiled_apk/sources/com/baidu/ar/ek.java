package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.filter.FilterNode;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class ek {
    private final String rv = FilterNode.highlightFilter.getNodeName();
    private boolean rw;

    public void ay(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (new File(str + "/property_list.json").exists()) {
            try {
                JSONArray jSONArray = new JSONObject(km.cm(str + "/property_list.json")).getJSONArray("FilterList");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (this.rv.equals(jSONObject.getString("FilterName"))) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("defaultUniformList");
                        int i2 = 0;
                        while (true) {
                            if (i2 < jSONArray2.length()) {
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                                if ("is_enable".equals(jSONObject2.getString("PropertyName"))) {
                                    boolean z = true;
                                    if (jSONObject2.getInt("PropertyValue") != 1) {
                                        z = false;
                                    }
                                    this.rw = z;
                                } else {
                                    i2++;
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String dF() {
        String str = this.rv;
        return str == null ? "" : str;
    }

    public boolean dG() {
        return this.rw;
    }
}
