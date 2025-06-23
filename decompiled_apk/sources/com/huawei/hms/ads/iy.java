package com.huawei.hms.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class iy {
    public static int Code = 0;
    private static final String V = "AdRequester";

    /* loaded from: classes10.dex */
    public static class a<T> implements RemoteCallResultCallback<T> {
        private RemoteCallResultCallback<T> Code;
        private Context V;

        public a(Context context, RemoteCallResultCallback<T> remoteCallResultCallback) {
            this.Code = remoteCallResultCallback;
            this.V = context.getApplicationContext();
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<T> callResult) {
            if (callResult.getCode() == 201) {
                try {
                    ed.Code(this.V).I(new JSONObject(callResult.getMsg()).optInt(com.huawei.openalliance.ad.constant.bb.c, 0));
                    return;
                } catch (JSONException unused) {
                    fb.I(iy.V, "parse ad config JSONException");
                    return;
                }
            }
            RemoteCallResultCallback<T> remoteCallResultCallback = this.Code;
            if (remoteCallResultCallback != null) {
                remoteCallResultCallback.onRemoteCallResult(str, callResult);
            }
        }
    }

    private static List<String> I() {
        try {
            if (g.V() != null) {
                return g.V().Code((Bundle) null);
            }
        } catch (Throwable th) {
            fb.V(V, "get blackTptIdList err: %s", th.getClass().getSimpleName());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long V(Context context) {
        int i;
        ed Code2 = ed.Code(context);
        if (Z(context) && (i = Code) <= 10) {
            Code = i + 1;
            return 0L;
        }
        long i2 = Code2.i();
        if (I(context)) {
            i2 = Code2.v();
        }
        return i2 * 60000;
    }

    private static boolean Z(Context context) {
        return HiAd.Code(context).Z();
    }

    private static Boolean Code(Boolean bool, Context context) {
        boolean z = false;
        boolean z2 = com.huawei.openalliance.ad.utils.f.Code(context) && ck.Code(context).B();
        if (bool == null) {
            return Boolean.valueOf(z2);
        }
        if (bool.booleanValue() && z2) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private static boolean I(Context context) {
        return !TextUtils.isEmpty(ed.Code(context).u());
    }

    public static /* synthetic */ List V() {
        return I();
    }

    public static void Code() {
        Code = 0;
    }

    private static void Code(final Context context, final AdSlotParam adSlotParam) {
        com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.hms.ads.iy.1
            @Override // java.lang.Runnable
            public void run() {
                List<String> Code2;
                String jSONObject;
                AdSlotParam adSlotParam2 = AdSlotParam.this;
                if (adSlotParam2 == null || (Code2 = adSlotParam2.Code()) == null || Code2.size() <= 0) {
                    return;
                }
                if (System.currentTimeMillis() - ed.Code(context).j() > iy.V(context)) {
                    try {
                        if (!com.huawei.openalliance.ad.utils.w.I() && !com.huawei.openalliance.ad.utils.w.D(context)) {
                            jSONObject = Code2.get(0);
                            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.Code, jSONObject, new RemoteCallResultCallback<AppConfigRsp>() { // from class: com.huawei.hms.ads.iy.1.1
                                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                                public void onRemoteCallResult(String str, CallResult<AppConfigRsp> callResult) {
                                    if (callResult.getData() != null) {
                                        AppConfigRsp data = callResult.getData();
                                        if (data.Code() == 206) {
                                            ed.Code(context).Code(System.currentTimeMillis());
                                        } else {
                                            ed.Code(context).Code(data);
                                        }
                                    }
                                }
                            }, AppConfigRsp.class);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("slotid", Code2.get(0));
                        jSONObject2.put("sdk_type", d.d(context));
                        jSONObject2.put(com.huawei.openalliance.ad.constant.bb.Code, g.Code());
                        jSONObject2.put("sha256", ed.Code(context).al());
                        jSONObject2.put(com.huawei.openalliance.ad.constant.bb.V, com.huawei.openalliance.ad.utils.aa.V(iy.V()));
                        jSONObject = jSONObject2.toString();
                        com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.Code, jSONObject, new RemoteCallResultCallback<AppConfigRsp>() { // from class: com.huawei.hms.ads.iy.1.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, CallResult<AppConfigRsp> callResult) {
                                if (callResult.getData() != null) {
                                    AppConfigRsp data = callResult.getData();
                                    if (data.Code() == 206) {
                                        ed.Code(context).Code(System.currentTimeMillis());
                                    } else {
                                        ed.Code(context).Code(data);
                                    }
                                }
                            }
                        }, AppConfigRsp.class);
                    } catch (Throwable th) {
                        fb.I(iy.V, "requestConfig err: %s", th.getClass().getSimpleName());
                    }
                }
            }
        });
    }

    public static <T> void Code(Context context, String str, AdSlotParam adSlotParam, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        Context applicationContext = context.getApplicationContext();
        JSONObject jSONObject = new JSONObject();
        a aVar = new a(applicationContext, remoteCallResultCallback);
        try {
            adSlotParam.Code(ed.Code(applicationContext).r());
            adSlotParam.V(ed.Code(applicationContext).g());
            adSlotParam.D(HiAd.Code(context).I());
            adSlotParam.a(d.d(context));
            adSlotParam.Z(g.Code());
            RequestOptions B = adSlotParam.B();
            if (B == null) {
                B = new RequestOptions();
                adSlotParam.Code(B);
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
            if (TextUtils.isEmpty(B.getConsent())) {
                B.V(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.x.ci, ""));
            }
            B.I(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.x.cj, ""));
            B.Z(defaultSharedPreferences.getString(com.huawei.openalliance.ad.constant.x.ck, ""));
            Location Code2 = com.huawei.openalliance.ad.utils.af.Code(applicationContext, B, adSlotParam.Z() != null ? adSlotParam.Z().Code() : null);
            adSlotParam.Code(Code2);
            com.huawei.openalliance.ad.beans.inner.b S = Code2.S();
            adSlotParam.C(Integer.valueOf(S.Code()));
            adSlotParam.S(Integer.valueOf(S.V()));
            adSlotParam.F(Integer.valueOf(S.I()));
            if (!Code(applicationContext, applicationContext.getPackageName())) {
                adSlotParam.Code((App) null);
            }
            if (ck.Code(context).V()) {
                adSlotParam.I(com.huawei.openalliance.ad.utils.a.Code(context));
            }
            if (ed.Code(context).ae() && !TextUtils.equals(str, com.huawei.openalliance.ad.constant.x.cl)) {
                adSlotParam.B(iz.Code(context).Code());
            }
            B.Code(Code(B.L(), context));
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.I, com.huawei.openalliance.ad.utils.aa.V(adSlotParam));
            jSONObject.put("content", str2);
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.N, System.currentTimeMillis());
            com.huawei.openalliance.ad.ipc.g.V(applicationContext).Code(str, jSONObject.toString(), aVar, cls);
        } catch (JSONException unused) {
            fb.I(V, "requestAd JSONException");
            CallResult<T> callResult = new CallResult<>();
            callResult.setCode(-1);
            callResult.setMsg("requestAd JSONException");
            aVar.onRemoteCallResult(str, callResult);
        }
        Code(applicationContext, adSlotParam);
    }

    private static boolean Code(Context context, String str) {
        return com.huawei.openalliance.ad.constant.cy.Code(str, com.huawei.openalliance.ad.utils.g.Z(context, str));
    }
}
