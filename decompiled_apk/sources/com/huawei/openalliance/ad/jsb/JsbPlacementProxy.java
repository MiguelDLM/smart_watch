package com.huawei.openalliance.ad.jsb;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ag;
import com.huawei.hms.ads.ai;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.el;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.h;

@AllApi
/* loaded from: classes10.dex */
public class JsbPlacementProxy extends ag {
    @AllApi
    public JsbPlacementProxy() {
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    @AllApi
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String V = ai.V(str);
        if (context != null && !TextUtils.isEmpty(str)) {
            h.Code(new ai.a(context, el.Code().Code(V), V, str, remoteCallResultCallback));
        } else {
            fb.Z("JsbPlacementProxy", "param is invalid, please check it!");
            ag.Code(remoteCallResultCallback, V, -1, null, true);
        }
    }
}
