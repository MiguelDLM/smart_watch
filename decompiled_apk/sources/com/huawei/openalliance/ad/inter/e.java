package com.huawei.openalliance.ad.inter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.cg;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.constant.ca;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class e extends IGlobalUtil.b {
    private static final String D = "GlobalUtil";
    private static final byte[] L = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private static final String f17397a = "onActivityStartFinish";
    private static e b;
    private List<IPPSUiEngineCallback> c = new ArrayList();
    private Context d;

    /* loaded from: classes10.dex */
    public static class a implements RemoteCallResultCallback<String> {
        private Context Code;
        private String I;
        private final IPPSUiEngineCallback V;

        public a(Context context, IPPSUiEngineCallback iPPSUiEngineCallback, String str) {
            this.Code = context;
            this.V = iPPSUiEngineCallback;
            this.I = str;
        }

        private String Code() {
            if (!com.huawei.openalliance.ad.utils.g.Code(com.huawei.openalliance.ad.ipc.g.V(this.Code).Z())) {
                try {
                    if (TextUtils.isEmpty(this.I)) {
                        return null;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", this.I);
                        CallResult Code = com.huawei.openalliance.ad.ipc.b.Code(this.Code).Code(s.z, jSONObject.toString(), String.class, true);
                        if (Code != null && 200 == Code.getCode()) {
                            fb.V(e.D, "getFilePathFromKit success");
                            String optString = new JSONObject((String) Code.getData()).optString("filePath");
                            fb.V(e.D, "filepath from kit : %s", optString);
                            return optString;
                        }
                    } catch (Throwable th) {
                        fb.I(e.D, "getFilePathFromKit err: %s", th.getClass().getSimpleName());
                    }
                } catch (Throwable th2) {
                    fb.V(e.D, "get path err: %s", th2.getClass().getSimpleName());
                }
            }
            return null;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            try {
                if (!ay.Code(callResult.getData()) && callResult.getData().startsWith(ca.CONTENT.toString())) {
                    Code(callResult.getData());
                    return;
                }
                String Code = Code();
                if (TextUtils.isEmpty(Code)) {
                    this.V.onCallResult(bn.d.V, null);
                } else {
                    Code(Code);
                }
            } catch (Throwable th) {
                fb.V(e.D, "getFilePath err: %s", th.getClass().getSimpleName());
            }
        }

        private void Code(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("filePath", str);
            this.V.onCallResult(bn.d.V, bundle);
        }
    }

    private e(Context context) {
        this.d = context;
    }

    private static e V(Context context) {
        e eVar;
        synchronized (L) {
            try {
                if (b == null) {
                    b = new e(context);
                }
                eVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
        com.huawei.openalliance.ad.ipc.g.V(this.d).Code(s.x, str, new a(this.d, iPPSUiEngineCallback, str), String.class);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirect(final String str) {
        String str2;
        try {
            str2 = (String) ba.Code(new Callable<String>() { // from class: com.huawei.openalliance.ad.inter.e.1
                @Override // java.util.concurrent.Callable
                /* renamed from: Code, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return (String) com.huawei.openalliance.ad.ipc.b.Code(e.this.d).Code(s.x, str, String.class).getData();
                }
            }, null);
            fb.Code(D, "filePath = %s", str2);
        } catch (Throwable th) {
            fb.V(D, "getFilePath err: %s", th.getClass().getSimpleName());
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public String getFilePathDirectByCacheType(final String str, final int i) {
        String str2;
        try {
            str2 = (String) ba.Code(new Callable<String>() { // from class: com.huawei.openalliance.ad.inter.e.2
                @Override // java.util.concurrent.Callable
                /* renamed from: Code, reason: merged with bridge method [inline-methods] */
                public String call() {
                    CallResult Code;
                    if (w.L(e.this.d)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", str);
                            jSONObject.put("apiVer", i);
                        } catch (Throwable th) {
                            fb.V(e.D, "make param err: %s", th.getClass().getSimpleName());
                        }
                        Code = com.huawei.openalliance.ad.ipc.b.Code(e.this.d).Code(s.x, jSONObject.toString(), String.class);
                    } else {
                        Code = com.huawei.openalliance.ad.ipc.b.Code(e.this.d).Code(s.x, str, String.class);
                    }
                    return (String) Code.getData();
                }
            }, null);
            fb.Code(D, "filePath = %s", str2);
        } catch (Throwable th) {
            fb.V(D, "getFilePath err: %s", th.getClass().getSimpleName());
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public com.huawei.hms.ads.uiengine.b getMultiMediaPlayingManager() {
        cg.Code(this.d).Code(HiAd.Code(this.d).V());
        return cg.Code(this.d);
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
        try {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view == null) {
                fb.I(D, "remote view is null.");
                return false;
            }
            Activity g = bc.g(view.getContext());
            if (g != null) {
                return bc.Code(g);
            }
            fb.I(D, "activity is null.");
            return false;
        } catch (Throwable th) {
            fb.I(D, "is freedom window ex: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        fb.V(D, "registerActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.c.add(iPPSUiEngineCallback);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
    public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        fb.V(D, "unregisterActivityStartCallBack");
        if (iPPSUiEngineCallback != null) {
            this.c.remove(iPPSUiEngineCallback);
        }
    }

    public static e Code(Context context) {
        return V(context);
    }

    public void V() {
        for (IPPSUiEngineCallback iPPSUiEngineCallback : this.c) {
            if (iPPSUiEngineCallback != null) {
                try {
                    iPPSUiEngineCallback.onCallResult(f17397a, null);
                } catch (Throwable th) {
                    fb.V(D, "onCallResult err: %s", th.getClass().getSimpleName());
                }
            }
        }
    }
}
