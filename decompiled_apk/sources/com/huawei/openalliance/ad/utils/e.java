package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.ca;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class e {
    private static final String Code = "AdSourceUtil";

    /* loaded from: classes10.dex */
    public static class a implements RemoteCallResultCallback<String> {
        private final WeakReference<Context> Code;

        public a(Context context) {
            this.Code = new WeakReference<>(context);
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            String data = callResult.getData();
            Context context = this.Code.get();
            if (context == null || TextUtils.isEmpty(data) || !data.startsWith(ca.CONTENT.toString())) {
                return;
            }
            SourceParam sourceParam = new SourceParam();
            sourceParam.V(false);
            sourceParam.I(true);
            sourceParam.I(data);
            z.Code(context, sourceParam, (an) null);
        }
    }

    public static void Code(Context context, AdContentData adContentData) {
        AdSource Code2;
        if (adContentData != null) {
            try {
                if (adContentData.S() == null || adContentData.S().l() == null || (Code2 = AdSource.Code(adContentData.S().l())) == null || Code2.V() == null) {
                    return;
                }
                fb.V(Code, "preloadDspLogo");
                String V = Code2.V();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.bb.E, V);
                com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.i, jSONObject.toString(), new a(context), String.class);
            } catch (Throwable unused) {
                fb.I(Code, "preloadDspLogo error");
            }
        }
    }
}
