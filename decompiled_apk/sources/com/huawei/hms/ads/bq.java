package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bq extends bi {
    private static final String Z = "JsbReportPraiseEvent";

    public bq() {
        super(aj.H);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, "start");
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.bq.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                cy.Code(context, adContentData);
                bq.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
