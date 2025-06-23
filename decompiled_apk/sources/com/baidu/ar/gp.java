package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.bean.DuMixRes;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class gp {
    public static DuMixRes aX(String str) {
        DuMixRes duMixRes = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            DuMixRes duMixRes2 = new DuMixRes();
            try {
                if (jSONObject.has("arType")) {
                    duMixRes2.setArType(jSONObject.getInt("arType"));
                }
                if (jSONObject.has(DuMixRes.JSON_SUPPORT_FRONT_CAMERA)) {
                    duMixRes2.setSupportFrontCamera(jSONObject.getBoolean(DuMixRes.JSON_SUPPORT_FRONT_CAMERA));
                }
                if (!jSONObject.has(DuMixRes.JSON_CONTAIN_MUSIC)) {
                    return duMixRes2;
                }
                duMixRes2.setContainMusic(jSONObject.getBoolean(DuMixRes.JSON_CONTAIN_MUSIC));
                return duMixRes2;
            } catch (Exception e) {
                e = e;
                duMixRes = duMixRes2;
                e.printStackTrace();
                return duMixRes;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
