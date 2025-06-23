package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.h;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public abstract class ag implements ad {
    private static final byte[] B = new byte[0];
    private static WeakReference<Activity> C = null;
    private static final String Z = "JsbBaseCommand";
    protected String Code;
    protected String I;
    protected String V;

    public ag() {
    }

    public Integer B(String str) {
        try {
            int optInt = new JSONObject(str).optInt("source", -111111);
            if (optInt != -111111) {
                return Integer.valueOf(optInt);
            }
            return null;
        } catch (Throwable unused) {
            fb.Code(Z, "getDownloadSource error");
            return null;
        }
    }

    public MaterialClickInfo C(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.bb.al, -111111);
            Integer valueOf = Integer.valueOf(optInt);
            int optInt2 = jSONObject.optInt(com.huawei.openalliance.ad.constant.bb.am, -111111);
            Integer valueOf2 = Integer.valueOf(optInt2);
            String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.bb.an, "");
            Float Code = com.huawei.openalliance.ad.utils.ay.Code(jSONObject.optString(com.huawei.openalliance.ad.constant.bb.ar, "-111111"), Float.valueOf(-111111.0f));
            int optInt3 = jSONObject.optInt(com.huawei.openalliance.ad.constant.bb.ap, -111111);
            Integer valueOf3 = Integer.valueOf(optInt3);
            int optInt4 = jSONObject.optInt(com.huawei.openalliance.ad.constant.bb.aq, -111111);
            Integer valueOf4 = Integer.valueOf(optInt4);
            int optInt5 = jSONObject.optInt(com.huawei.openalliance.ad.constant.bb.ao, -111111);
            Integer valueOf5 = Integer.valueOf(optInt5);
            long optLong = jSONObject.optLong(com.huawei.openalliance.ad.constant.bb.aR);
            Long valueOf6 = Long.valueOf(optLong);
            long optLong2 = jSONObject.optLong(com.huawei.openalliance.ad.constant.bb.aS);
            Long valueOf7 = Long.valueOf(optLong2);
            String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.bb.aT, "");
            if (optInt == -111111) {
                valueOf = null;
            }
            if (optInt2 == -111111) {
                valueOf2 = null;
            }
            if (!com.huawei.openalliance.ad.utils.ay.L(optString)) {
                optString = null;
            }
            if (Code.floatValue() == -111111.0f) {
                i = -111111;
                Code = null;
            } else {
                i = -111111;
            }
            if (optInt3 == i) {
                valueOf3 = null;
            }
            if (optInt4 == i) {
                valueOf4 = null;
            }
            Integer num = optInt5 == i ? null : valueOf5;
            if (optLong == 0) {
                valueOf6 = null;
            }
            if (optLong2 == 0) {
                valueOf7 = null;
            }
            if (com.huawei.openalliance.ad.utils.ay.Code(optString2)) {
                optString2 = null;
            }
            return new MaterialClickInfo.a().Code(valueOf).V(valueOf2).V(optString).I(num).Code(Code).Z(valueOf3).B(valueOf4).V(valueOf6).Code(valueOf7).Z(optString2).Code(jSONObject.optString("versionCode")).Code();
        } catch (Throwable unused) {
            fb.Code(Z, "getClickInfo error");
            return null;
        }
    }

    @Override // com.huawei.hms.ads.ad
    public Context Code(Context context) {
        synchronized (B) {
            try {
                WeakReference<Activity> weakReference = C;
                if (weakReference == null || weakReference.get() == null) {
                    return context;
                }
                return C.get();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean F(String str) {
        return !com.huawei.openalliance.ad.utils.ay.Code(str) && com.huawei.openalliance.ad.utils.ay.Code(str.trim(), -111111) >= 10000301;
    }

    public boolean S(String str) {
        try {
            if (!com.huawei.openalliance.ad.utils.ay.Code(str)) {
                if (Integer.parseInt(str.trim()) >= 10000300) {
                    return true;
                }
            }
        } catch (Throwable th) {
            fb.Z("H5Ad", "isSupportImpCtrl() exception: %s", th.getClass().getSimpleName());
        }
        return false;
    }

    public void V(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z) {
        Code(remoteCallResultCallback, this.Code, 1000, "ok", z);
    }

    @Override // com.huawei.hms.ads.ad
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.I(Z, "async execute is not implemented!");
        throw new IllegalStateException("async execute is not implemented!");
    }

    public ag(String str) {
        this.Code = str;
    }

    @Override // com.huawei.hms.ads.ad
    public h.a Code() {
        return h.a.IO;
    }

    @Override // com.huawei.hms.ads.ad
    public void V(String str) {
        this.I = str;
    }

    @Override // com.huawei.hms.ads.ad
    public Object Code(Context context, String str) {
        fb.I(Z, "direct call is not implemented!");
        throw new IllegalStateException("direct call is not implemented!");
    }

    @Override // com.huawei.hms.ads.ad
    public void Code(Activity activity) {
        synchronized (B) {
            try {
                WeakReference<Activity> weakReference = C;
                if (weakReference != null) {
                    if (weakReference.get() == null) {
                    }
                }
                C = new WeakReference<>(activity);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(Context context, String str, ac acVar) {
        Code(context, str, false, acVar);
    }

    public void Code(Context context, final String str, boolean z, final ac acVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject.put("content_id", jSONObject2.optString("contentId"));
            jSONObject.put("unique_id", jSONObject2.optString(com.huawei.openalliance.ad.constant.aw.w));
            jSONObject.put(com.huawei.openalliance.ad.constant.aw.I, z);
            jSONObject.put(com.huawei.openalliance.ad.constant.aw.Z, this.V);
            if (!TextUtils.isEmpty(jSONObject2.optString("apiVer"))) {
                jSONObject.put("apiVer", jSONObject2.optString("apiVer"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("templateId"))) {
                jSONObject.put("templateId", jSONObject2.optString("templateId"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("slotid"))) {
                jSONObject.put("slotid", jSONObject2.optString("slotid"));
            }
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.s, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ag.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    if (callResult.getCode() != 200) {
                        fb.I(ag.Z, "request ad content, retCode: %s", Integer.valueOf(callResult.getCode()));
                        acVar.Code(null);
                        return;
                    }
                    AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.aa.V(callResult.getData(), AdContentData.class, new Class[0]);
                    ag.this.Code(adContentData, str);
                    if (adContentData == null) {
                        fb.I(ag.Z, "request ad content is null");
                    }
                    acVar.Code(adContentData);
                }
            }, String.class);
        } catch (Throwable unused) {
            fb.I(Z, "request ad content error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, String str) {
        if (adContentData != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = TextUtils.isEmpty(jSONObject.optString(com.huawei.openalliance.ad.constant.aw.C)) ? "" : jSONObject.optString(com.huawei.openalliance.ad.constant.aw.C);
                if (!TextUtils.isEmpty(optString)) {
                    adContentData.I(optString);
                }
                if (!TextUtils.isEmpty(jSONObject.optString(com.huawei.openalliance.ad.constant.aw.S))) {
                    adContentData.D(jSONObject.optString(com.huawei.openalliance.ad.constant.aw.S));
                }
                String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.u);
                String optString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.r);
                String optString4 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.w);
                if (!TextUtils.isEmpty(optString2)) {
                    adContentData.q(optString2);
                }
                if (!TextUtils.isEmpty(optString3)) {
                    adContentData.r(optString3);
                }
                if (!TextUtils.isEmpty(optString4)) {
                    adContentData.S(optString4);
                }
                long optLong = jSONObject.optLong(com.huawei.openalliance.ad.constant.aw.aX);
                Long valueOf = Long.valueOf(optLong);
                if (optLong == 0) {
                    valueOf = Long.valueOf(com.huawei.openalliance.ad.utils.ay.Code(optString, 0L));
                }
                if (valueOf.longValue() != 0) {
                    adContentData.Z(valueOf.longValue());
                }
            } catch (Throwable unused) {
                fb.I(Z, "update content failed");
            }
        }
    }

    public static void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i, JsbCallBackData jsbCallBackData) {
        if (remoteCallResultCallback != null) {
            CallResult<String> callResult = new CallResult<>();
            callResult.setCode(i);
            try {
                callResult.setData(com.huawei.openalliance.ad.utils.aa.V(jsbCallBackData));
            } catch (Throwable th) {
                fb.I(Z, "onCallResult " + th.getClass().getSimpleName());
            }
            remoteCallResultCallback.onRemoteCallResult(str, callResult);
        }
    }

    public static <T> void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, int i, T t, boolean z) {
        Code(remoteCallResultCallback, str, i, new JsbCallBackData(t, z, null));
    }

    public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, boolean z) {
        Code(remoteCallResultCallback, this.Code, 1011, "", z);
    }

    @Override // com.huawei.hms.ads.ad
    public void Code(String str) {
        this.V = str;
    }

    public boolean Code(AdContentData adContentData) {
        return adContentData != null && adContentData.aw() && ja.Z(adContentData.v());
    }
}
