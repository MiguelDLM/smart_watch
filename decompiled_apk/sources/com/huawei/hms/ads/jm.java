package com.huawei.hms.ads;

import O0IoXXOx.XO;
import android.content.Context;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jm {
    private static final String Code = "DcServiceCmdManager";
    private static final int V = 10001;

    public static void Code(final Context context, final jn jnVar) {
        if (jnVar == null) {
            return;
        }
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.jm.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String F = ed.Code(context).F(com.huawei.openalliance.ad.constant.w.aw);
                    fb.Code(jm.Code, "redirectionAppList from configMap : %s", F);
                    List<String> V2 = com.huawei.openalliance.ad.utils.ay.V(F, ",");
                    if (!com.huawei.openalliance.ad.utils.ad.Code(V2) && V2.contains(jnVar.I())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("dc_service_cmd", 10001);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("taskId", jnVar.V());
                        jSONObject2.put("contentId", jnVar.Code());
                        jSONObject2.put("pkgName", jnVar.I());
                        jSONObject2.put("activityName", jnVar.Z());
                        jSONObject2.put("triggerTime", System.currentTimeMillis());
                        jSONObject.put(XO.f1160OOXIXo, jSONObject2);
                        fb.Code(jm.Code, "send direction match record : %s", jSONObject2.toString());
                        jm.Code(context, jSONObject);
                        return;
                    }
                    fb.Code(jm.Code, "%s is not in app list", jnVar.I());
                } catch (JSONException e) {
                    fb.Z(jm.Code, "json exception sendRedirectionMatchRecord : %s", e.getClass().getSimpleName());
                }
            }
        });
    }

    public static void Code(Context context, JSONObject jSONObject) {
        com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(com.huawei.openalliance.ad.constant.s.M, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.jm.1
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String str2;
                if (callResult != null) {
                    try {
                        if (callResult.getCode() == 200) {
                            if (fb.Code()) {
                                str2 = "query DC_BRIDGE from hms success!";
                                fb.Code(jm.Code, str2);
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        fb.Z(jm.Code, "get DC_BRIDGE from hms err : %s", th.getClass().getSimpleName());
                        return;
                    }
                }
                if (fb.Code()) {
                    str2 = "failed to query DC_BRIDGE from hms";
                    fb.Code(jm.Code, str2);
                }
            }
        }, String.class);
    }
}
