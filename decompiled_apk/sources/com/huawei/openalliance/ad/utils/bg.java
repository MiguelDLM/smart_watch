package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class bg {
    private static final String Code = "HUAApi";
    private static final String V = "handleUriAction";

    public static <T> T Code(final Context context, final AdContentData adContentData, final int i, final Class<T> cls) {
        if (adContentData == null) {
            fb.V(Code, "contentRecord is null");
            return null;
        }
        return (T) ba.Code(new Callable<T>() { // from class: com.huawei.openalliance.ad.utils.bg.1
            @Override // java.util.concurrent.Callable
            public T call() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("content_id", AdContentData.this.a());
                    jSONObject.put("templateId", AdContentData.this.aE());
                    jSONObject.put("slotid", AdContentData.this.L());
                    jSONObject.put("apiVer", AdContentData.this.aF());
                    jSONObject.put(com.huawei.openalliance.ad.constant.bb.U, i);
                    jSONObject.put(com.huawei.openalliance.ad.constant.bb.aa, bg.V(AdContentData.this));
                    return com.huawei.openalliance.ad.ipc.b.Code(context).Code(bg.V, jSONObject.toString(), cls).getData();
                } catch (Throwable unused) {
                    fb.I(bg.Code, "handle harmony service enter action fail");
                    return null;
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject V(AdContentData adContentData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.ab, adContentData.D());
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.Q, adContentData.au());
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.P, adContentData.at());
        } catch (Throwable th) {
            fb.I(Code, "getParamContent ex:%s", th.getClass().getSimpleName());
        }
        return jSONObject;
    }
}
