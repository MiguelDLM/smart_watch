package com.huawei.openalliance.ad.jsb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ad;
import com.huawei.hms.ads.ag;
import com.huawei.hms.ads.ai;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.ej;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.h;

@AllApi
/* loaded from: classes10.dex */
public class JsbInterstitialProxy extends ag {
    @AllApi
    public JsbInterstitialProxy() {
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    @AllApi
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String V = ai.V(str);
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(V)) {
            fb.Z("JsbInterstitialProxy", "param is invalid, please check it!");
            ag.Code(remoteCallResultCallback, V, -1, null, true);
            return;
        }
        ad Code = ej.Code().Code(V);
        if (Code != null) {
            if (ai.Code().Code(V, Code(context))) {
                Code.Code((Activity) Code(context));
            }
            Code.Code(this.V);
        }
        h.Code(new ai.a(context, Code, V, str, remoteCallResultCallback));
    }
}
