package com.huawei.openalliance.ad.msgnotify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.utils.SafeIntent;
import java.io.Serializable;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public abstract class c {
    private static final String Code = "MsgConverter";

    public static Intent Code(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Intent intent = new Intent();
            String optString = jSONObject.optString(bb.v);
            intent.setAction(jSONObject.optString(bb.y));
            intent.putExtra(bb.v, optString);
            JSONObject optJSONObject = jSONObject.optJSONObject(bb.w);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = optJSONObject.get(next);
                    if (obj instanceof Serializable) {
                        intent.putExtra(next, (Serializable) obj);
                    }
                }
            }
            return intent;
        } catch (JSONException unused) {
            fb.I(Code, "convertMsgJsonToIntent JSONException");
            return null;
        }
    }

    public static String Code(String str, String str2, Intent intent) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            Bundle extras = safeIntent.getExtras();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(bb.u, str);
                jSONObject2.put(bb.v, str2);
                jSONObject2.put(bb.y, safeIntent.getAction());
                if (extras != null) {
                    for (String str3 : extras.keySet()) {
                        try {
                            jSONObject.putOpt(str3, extras.get(str3));
                        } catch (JSONException unused) {
                            fb.I(Code, "convertMsgToJson - msg json set exception");
                        }
                    }
                    jSONObject2.put(bb.w, jSONObject);
                }
                return jSONObject2.toString();
            } catch (Throwable unused2) {
                fb.I(Code, "convertMsgToJson - param json set exception");
            }
        }
        return "";
    }
}
