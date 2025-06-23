package com.baidu.ar;

import com.baidu.ar.bean.FunctionType;
import com.baidu.ar.content.ARResourceInfo;
import com.baidu.ar.ihttp.HttpException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class ct {
    public static ARResourceInfo X(String str) {
        JSONObject jSONObject = new JSONObject(str);
        int optInt = jSONObject.optInt("err_code");
        if (optInt != 0) {
            throw new HttpException(optInt, jSONObject.optString("err_msg", "query case fail"));
        }
        ARResourceInfo aRResourceInfo = new ARResourceInfo();
        if (jSONObject.has("ret")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("ret");
            aRResourceInfo.arKey = jSONObject2.optString("ar_key", "");
            aRResourceInfo.resourceUrl = jSONObject2.optString("ar_resource");
            aRResourceInfo.redirectUrl = jSONObject2.optString("redirect_url");
            aRResourceInfo.versionCode = jSONObject2.optString("version_code");
            aRResourceInfo.acId = jSONObject2.optString("ac_id");
            aRResourceInfo.thumbnailUrl = jSONObject2.optString("image_url");
            if (jSONObject2.has("ar_type")) {
                aRResourceInfo.arType = Integer.parseInt(jSONObject2.getString("ar_type"));
            }
            aRResourceInfo.zipMd5 = jSONObject2.optString("md5");
            aRResourceInfo.hardwareSatisfied = jSONObject2.optBoolean("hardware_satisfied", true);
            if (jSONObject2.has("refused")) {
                aRResourceInfo.refused = Integer.parseInt(jSONObject2.getString("refused")) == 1;
            }
            if (jSONObject2.has("ar_resource_urls")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("ar_resource_urls");
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = jSONArray.getString(i);
                }
                aRResourceInfo.multiResourceUrl = strArr;
            }
            aRResourceInfo.showAudioDialog = jSONObject2.optBoolean("show_audio_dialog", false);
            JSONArray optJSONArray = jSONObject2.optJSONArray("power");
            if (optJSONArray != null) {
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(FunctionType.getValueOf(next), Boolean.valueOf(optJSONObject.getBoolean(next)));
                        }
                    }
                }
                aRResourceInfo.features = hashMap;
            }
        }
        return aRResourceInfo;
    }
}
