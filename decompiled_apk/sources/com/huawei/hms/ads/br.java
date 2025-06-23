package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.jb;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class br extends bi {
    private static final String Z = "JsbReportShowEvent";

    public br() {
        super(aj.l);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.aa.Code(str, AdEventReport.class, new Class[0]);
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.br.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                int i;
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    if (adEventReport2.S()) {
                        jc.Code(context, adContentData, adEventReport.F().longValue(), adEventReport.D().intValue());
                    } else if (adContentData != null) {
                        adContentData.Code(br.this.S(jSONObject.optString("versionCode")));
                        if (br.this.Code(adContentData)) {
                            jc.Code(context, adContentData, new jb.a().Code(adEventReport.F()).Code(adEventReport.D()).V(adEventReport.L()).I(adEventReport.q()).Code(adEventReport.u()).Code());
                        } else {
                            fb.V(br.Z, "ad is not in whitelist");
                            i = 3004;
                        }
                    } else {
                        i = 3002;
                    }
                    i = 1000;
                } else {
                    i = 3001;
                }
                ag.Code(remoteCallResultCallback, br.this.Code, i, null, true);
            }
        });
    }
}
