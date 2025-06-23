package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class aq extends ag {
    private static final int B = 1;
    private static final int Z = 0;

    public aq() {
        super(aj.x);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).setUnderAgeOfPromise(new JSONObject(str).optInt(com.huawei.openalliance.ad.constant.aw.R, 0) == 1);
        V(remoteCallResultCallback, true);
    }
}
