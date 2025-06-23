package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class c {
    private static final String B = "getDownloadStatus";
    private static final String C = "trafficReminderExceptionEvent";
    private static final String Code = "ApDnApi";
    private static final String D = "AutoOpenForbidden";
    private static final String F = "reportFullScreenNotify";
    private static final String I = "pauseDownloadApp";
    private static final String L = "remoteSharedPrefSet";
    private static final String S = "syncAgProtocolStatus";
    private static final String V = "startDownloadApp";
    private static final String Z = "cancelDownloadApp";

    /* renamed from: a, reason: collision with root package name */
    private static final String f17388a = "reportInstallPermission";
    private static final String b = "reserveDownloadApp";

    public static <T> T Code(Context context, AppInfo appInfo, boolean z, Class<T> cls) {
        boolean z2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", aa.V(appInfo));
            com.huawei.openalliance.ad.ipc.b Code2 = com.huawei.openalliance.ad.ipc.b.Code(context);
            String jSONObject2 = jSONObject.toString();
            if (!z && !Code(appInfo)) {
                z2 = false;
                return Code2.Code(B, jSONObject2, cls, z2).getData();
            }
            z2 = true;
            return Code2.Code(B, jSONObject2, cls, z2).getData();
        } catch (JSONException unused) {
            fb.I(Code, "queryTask JSONException");
            return null;
        }
    }

    public static <T> void I(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", aa.V(appDownloadTask));
            AppInfo V2 = V(appDownloadTask);
            if (V2 != null) {
                jSONObject.put(bb.D, aa.V(V2));
            }
            com.huawei.openalliance.ad.ipc.h.Code(context, Code(appDownloadTask)).Code(Z, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            Code(remoteCallResultCallback, "cancelDownload JSONException", Z);
        }
    }

    private static AppInfo V(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null || appDownloadTask.L() == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.b(appDownloadTask.L().Code());
        appInfo.I(appDownloadTask.L().i());
        appInfo.d(appDownloadTask.j());
        appInfo.l(appDownloadTask.L().T());
        return appInfo;
    }

    public static <T> void Z(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(appDownloadTask, jSONObject);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(b, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            Code(remoteCallResultCallback, "reserveDownloadApp JSONException", b);
        }
    }

    public static <T> void Code(Context context, int i, String str, String str2, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bb.f, i);
            jSONObject.put(bb.h, str);
            jSONObject.put("ag_action_name", str2);
            com.huawei.openalliance.ad.ipc.b.Code(context).Code(S, jSONObject.toString(), cls, true);
        } catch (JSONException unused) {
            fb.I(Code, "syncAgProcolAgreeStatus JSONException");
        }
    }

    public static <T> void V(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", aa.V(appDownloadTask));
            AppInfo V2 = V(appDownloadTask);
            if (V2 != null) {
                jSONObject.put(bb.D, aa.V(V2));
            }
            com.huawei.openalliance.ad.ipc.h.Code(context, Code(appDownloadTask)).Code(I, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            Code(remoteCallResultCallback, "pauseDownload JSONException", I);
        }
    }

    public static <T> void Code(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(appDownloadTask, jSONObject);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(V, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            Code(remoteCallResultCallback, "startDownload JSONException", V);
        }
    }

    public static <T> void V(Context context, boolean z, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bb.ak, z);
            com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(f17388a, jSONObject.toString(), remoteCallResultCallback, cls);
            if (w.I()) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(f17388a, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException unused) {
            fb.I(Code, "reportInstallPermission JSONException");
        }
    }

    public static <T> void Code(Context context, String str, AdContentData adContentData, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        if (adContentData != null) {
            try {
                jSONObject.put("content_id", adContentData.a());
                jSONObject.put("templateId", adContentData.aE());
                jSONObject.put("slotid", adContentData.L());
                jSONObject.put("apiVer", adContentData.aF());
            } catch (JSONException unused) {
                Code(remoteCallResultCallback, "reportAnalysisEvent JSONException", C);
                return;
            }
        }
        jSONObject.put(bb.f17375a, str);
        com.huawei.openalliance.ad.ipc.g.V(context).Code(C, jSONObject.toString(), remoteCallResultCallback, cls);
    }

    public static <T> void Code(Context context, boolean z, int i, String str, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("full_screen_notify", z);
            jSONObject.put(bb.X, i);
            jSONObject.put(bb.Y, str);
            com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(F, jSONObject.toString(), remoteCallResultCallback, cls);
            if (w.I()) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(F, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException unused) {
            fb.I(Code, "reportFullScreenNotify JSONException");
        }
    }

    public static <T> void Code(Context context, boolean z, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bb.ac, D);
            jSONObject.put(bb.ad, z);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(L, jSONObject.toString(), remoteCallResultCallback, cls);
            if (w.I()) {
                com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(L, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException unused) {
            fb.I(Code, "setAutoOpenForbidden JSONException");
        }
    }

    private static void Code(AppDownloadTask appDownloadTask, JSONObject jSONObject) {
        String V2 = aa.V(appDownloadTask);
        fb.Code(Code, "appdownload=%s", V2);
        jSONObject.put("content", V2);
        jSONObject.put("unique_id", (appDownloadTask == null || appDownloadTask.L() == null || appDownloadTask.L().e() == null) ? "" : appDownloadTask.L().e());
    }

    private static <T> void Code(RemoteCallResultCallback<T> remoteCallResultCallback, String str, String str2) {
        fb.I(Code, str);
        if (remoteCallResultCallback != null) {
            CallResult<T> callResult = new CallResult<>();
            callResult.setCode(-1);
            callResult.setMsg(str);
            remoteCallResultCallback.onRemoteCallResult(str2, callResult);
        }
    }

    private static boolean Code(AppDownloadTask appDownloadTask) {
        return appDownloadTask != null && appDownloadTask.n();
    }

    private static boolean Code(AppInfo appInfo) {
        return appInfo != null && appInfo.w();
    }
}
