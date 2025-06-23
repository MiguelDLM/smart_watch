package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.activity.a;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class cj {
    private static final String Code = "ActivityStarter";
    private static final int I = 1;
    private static final String V = "com.huawei.hms.pps.action.PPS_DETAIL";

    private static String Code() {
        return Build.VERSION.SDK_INT == 26 ? com.huawei.openalliance.ad.constant.x.cV : com.huawei.openalliance.ad.constant.x.cT;
    }

    private static void V(Context context, View view, int[] iArr, AdContentData adContentData) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a.ViewTreeObserverOnGlobalLayoutListenerC0658a(view, context, iArr2));
        int[] iArr3 = {view.getMeasuredWidth(), view.getMeasuredHeight()};
        try {
            Intent intent = new Intent();
            intent.setAction(com.huawei.openalliance.ad.constant.x.cU);
            intent.setPackage(com.huawei.openalliance.ad.utils.w.Z(context));
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.au, com.huawei.openalliance.ad.utils.aa.V(adContentData));
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.av, iArr);
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.ay, iArr3);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.huawei.openalliance.ad.utils.bc.Code(context, intent);
        } catch (Throwable th) {
            fb.Z(Code, "start ac failed: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, View view, AdContentData adContentData) {
        fb.V(Code, "jump to domestic dsa activity.");
        if (context == null) {
            fb.I(Code, "context is null");
            return;
        }
        if (adContentData == null || !adContentData.aQ() || com.huawei.openalliance.ad.utils.ay.Code(adContentData.aP())) {
            fb.V(Code, "start domestic dsa activity failed, switch close or empty url.");
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        fb.V(Code, "startDomesticDsaActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        V(context, view, iArr, adContentData);
    }

    public static void Code(Context context, View view, int[] iArr, AdContentData adContentData) {
        fb.V(Code, "jump to domestic dsa activity.");
        if (context == null) {
            fb.I(Code, "context is null");
        } else if (adContentData == null || !adContentData.aQ() || com.huawei.openalliance.ad.utils.ay.Code(adContentData.aP())) {
            fb.V(Code, "start domestic dsa activity failed, switch close or empty url.");
        } else {
            V(context, view, iArr, adContentData);
        }
    }

    private static void Code(Context context, AdContentData adContentData, Intent intent) {
        intent.putExtra("content_id", adContentData.a());
        intent.putExtra("sdk_version", "13.4.72.300");
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.e, adContentData.D());
        intent.putExtra("request_id", adContentData.M());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.A, context.getPackageName());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.P, adContentData.at());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.Q, adContentData.au());
        intent.putExtra("templateId", adContentData.aE());
        intent.putExtra("slotid", adContentData.L());
        intent.putExtra("apiVer", adContentData.aF());
    }

    private static void Code(Context context, AdContentData adContentData, et etVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(adContentData, jSONObject);
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.d, adContentData.x());
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.k, adContentData.A());
            jSONObject.put("unique_id", adContentData.aa());
            Code(jSONObject, etVar);
            com.huawei.openalliance.ad.ipc.h.Code(context, adContentData.ap()).Code(com.huawei.openalliance.ad.constant.s.f17380a, jSONObject.toString(), null, null);
        } catch (JSONException e) {
            fb.I(Code, "startAdActivityViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, AdContentData adContentData, et etVar, boolean z) {
        try {
            if (!(context instanceof Activity) || adContentData.ap()) {
                Code(context, adContentData, etVar);
                return;
            }
            fb.V(Code, "activity context");
            Intent intent = new Intent();
            intent.setAction(V);
            intent.setPackage(com.huawei.openalliance.ad.utils.w.Z(context));
            Code(context, adContentData, intent);
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.d, adContentData.x());
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.k, adContentData.A());
            intent.putExtra("unique_id", adContentData.aa());
            Code(intent, adContentData);
            Code(intent, etVar);
            if (z) {
                intent.addFlags(268959744);
            }
            intent.setClipData(com.huawei.openalliance.ad.constant.x.cM);
            ((Activity) context).startActivityForResult(intent, 1);
        } catch (Throwable th) {
            fb.Code(3, th);
            fb.V(Code, "startAdActivity error, %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, AdContentData adContentData, MaterialClickInfo materialClickInfo) {
        fb.V(Code, "jump to landing details start.");
        if (context == null) {
            fb.I(Code, "context is null");
            return;
        }
        if (adContentData == null || adContentData.y() == null || TextUtils.isEmpty(adContentData.y().u())) {
            fb.V(Code, "jump to landing details detailUrl is empty.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("content_id", adContentData.a());
            intent.putExtra("templateId", adContentData.aE());
            intent.putExtra("slotid", adContentData.L());
            intent.putExtra("apiVer", adContentData.aF());
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.A, context.getPackageName());
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.e, adContentData.D());
            intent.putExtra("request_id", adContentData.M());
            Code(intent, adContentData);
            if (materialClickInfo != null && com.huawei.openalliance.ad.utils.ay.L(materialClickInfo.I()) && materialClickInfo.Code() != null) {
                intent.putExtra("click_info", com.huawei.openalliance.ad.utils.aa.V(materialClickInfo));
            }
            intent.setAction(Code());
            intent.setPackage(com.huawei.openalliance.ad.utils.w.Z(context));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.huawei.openalliance.ad.inter.data.AppInfo y = adContentData.y();
            if (y != null) {
                intent.putExtra("unique_id", y.e());
            }
            com.huawei.openalliance.ad.utils.bc.Code(context, intent);
        } catch (Throwable th) {
            fb.Z(Code, "start ac failed: %s", th.getClass().getSimpleName());
        }
    }

    private static void Code(Intent intent, et etVar) {
        fb.Code(Code, "parseLinkedAdConfig");
        if (intent == null || etVar == null) {
            return;
        }
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.p, etVar.C());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.m, etVar.S());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.q, etVar.Code());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.aV, etVar.V());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.s, etVar.Z());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.r, etVar.I());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.aO, etVar.D());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.aP, etVar.L());
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.aQ, etVar.F());
        if (etVar.a() != null) {
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.n, etVar.a().getAutoPlayNetwork());
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.o, etVar.a().isStartMuted());
        }
    }

    private static void Code(Intent intent, AdContentData adContentData) {
        ApkInfo e;
        MetaData S = adContentData.S();
        if (S == null || (e = S.e()) == null) {
            return;
        }
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.aM, com.huawei.openalliance.ad.utils.ay.V(e.p()));
        intent.putExtra(com.huawei.openalliance.ad.constant.bb.aN, com.huawei.openalliance.ad.utils.ay.V(e.q()));
    }

    private static void Code(Intent intent, JSONObject jSONObject, Map<String, String> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        String V2 = com.huawei.openalliance.ad.utils.aa.V(map);
        if (com.huawei.openalliance.ad.utils.ay.Code(V2)) {
            return;
        }
        if (z) {
            intent.putExtra(com.huawei.openalliance.ad.constant.bb.R, V2);
            return;
        }
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.R, V2);
        } catch (JSONException e) {
            fb.Z(Code, "set ar linked params error," + e.getClass().getSimpleName());
        }
    }

    private static void Code(AdContentData adContentData, JSONObject jSONObject) {
        jSONObject.put("content_id", adContentData.a());
        jSONObject.put("sdk_version", "13.4.72.300");
        jSONObject.put(com.huawei.openalliance.ad.constant.bb.e, adContentData.D());
        jSONObject.put("request_id", adContentData.M());
        jSONObject.put(com.huawei.openalliance.ad.constant.bb.P, adContentData.at());
        jSONObject.put(com.huawei.openalliance.ad.constant.bb.Q, adContentData.au());
        jSONObject.put("templateId", adContentData.aE());
        jSONObject.put("slotid", adContentData.L());
        jSONObject.put("apiVer", adContentData.aF());
    }

    public static void Code(JSONObject jSONObject, et etVar) {
        if (jSONObject == null || etVar == null) {
            return;
        }
        fb.Code(Code, "parseLinkedAdConfigViaAid");
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.p, etVar.C());
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.m, etVar.S());
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.q, etVar.Code());
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.s, etVar.Z());
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.r, etVar.I());
        } catch (JSONException e) {
            fb.I(Code, "startAdActivityViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    public static boolean Code(Context context, String str) {
        fb.V(Code, "startTransparencyActivity");
        if (context == null || TextUtils.isEmpty(str)) {
            fb.I(Code, "param is null");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.huawei.openalliance.ad.constant.bb.aw, str);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.E, jSONObject.toString(), null, null);
            return true;
        } catch (JSONException e) {
            fb.I(Code, "startTransparencyActivity, ex:" + e.getClass().getSimpleName());
            return true;
        }
    }
}
