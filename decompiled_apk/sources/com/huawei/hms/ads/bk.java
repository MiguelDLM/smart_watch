package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bk extends bi {
    private static final String Z = "JsbReportCloseEvent";

    public bk() {
        super(aj.o);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, Z);
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.aa.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.bk.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                if (adContentData != null) {
                    AdEventReport adEventReport2 = adEventReport;
                    jc.Code(context, adContentData, 0, 0, adEventReport2 != null ? adEventReport2.j() : null);
                    bk.this.V(remoteCallResultCallback, true);
                }
            }
        });
    }
}
