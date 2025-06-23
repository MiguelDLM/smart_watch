package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.firebase.crashlytics.buildtools.api.net.proxy.Constants;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ai {
    public static JSONObject a(Context context) {
        try {
            String property = System.getProperty(Constants.HTTP_PROXY_HOST_PROP);
            String property2 = System.getProperty(Constants.HTTP_PROXY_PORT_PROP);
            if (property2 == null) {
                property2 = "-1";
            }
            int parseInt = Integer.parseInt(property2);
            if (!TextUtils.isEmpty(property) && parseInt != -1) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, property);
                jSONObject.put("p", parseInt);
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
