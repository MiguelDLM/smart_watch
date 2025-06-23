package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bn extends bi {
    private static final String Z = "JsbReportPlayResumeEvent";

    public bn() {
        super(aj.l);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, "start");
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.bn.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                jc.Code(context, adContentData, com.huawei.openalliance.ad.constant.ai.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
                bn.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
