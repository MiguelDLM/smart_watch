package com.baidu.ar;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class jc {
    private String zS;
    private Map<String, jh> zT;

    public jc(String str) {
        this.zS = str;
    }

    private Map<String, jh> gh() {
        Map<String, jh> map = this.zT;
        if (map != null) {
            return map;
        }
        this.zT = new HashMap();
        File file = new File(this.zS.concat(File.separator).concat("res_config.json"));
        if (file.exists()) {
            try {
                JSONArray optJSONArray = new JSONObject(km.h(file)).optJSONArray("res");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            jh jhVar = new jh();
                            jhVar.Ah = optJSONObject.getString("resPath");
                            jhVar.Ai = optJSONObject.optString("resId");
                            jhVar.Aj = optJSONObject.optString("encoding");
                            jhVar.Ak = optJSONObject.optString("md5");
                            this.zT.put(jhVar.Ah, jhVar);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.zT;
    }

    public jh bN(String str) {
        Map<String, jh> gh = gh();
        if (gh.containsKey(str)) {
            return gh.get(str);
        }
        return null;
    }
}
