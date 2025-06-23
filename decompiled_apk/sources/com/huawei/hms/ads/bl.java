package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bl extends bi {
    private static final String Z = "JsbReportPlayEndEvent";

    public bl() {
        super(aj.l);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.aa.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.bl.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    jc.Code(context, adContentData, com.huawei.openalliance.ad.constant.ai.Z, Long.valueOf(adEventReport2.c() == null ? 0L : adEventReport.c().longValue()), Long.valueOf(adEventReport.d() != null ? adEventReport.d().longValue() : 0L), Integer.valueOf(adEventReport.e() == null ? 0 : adEventReport.e().intValue()), Integer.valueOf(adEventReport.f() != null ? adEventReport.f().intValue() : 0));
                }
                bl.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
