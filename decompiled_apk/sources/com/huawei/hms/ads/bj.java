package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class bj extends bi {
    private static final String Z = "JsbReportClickEvent";

    public bj() {
        super(aj.n);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.aa.Code(str, AdEventReport.class, new Class[0]);
        final JSONObject jSONObject = new JSONObject(str);
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.bj.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                int i;
                String str2;
                String str3;
                int i2;
                int i3;
                int i4;
                if (adContentData == null) {
                    fb.V(bj.Z, "ad not exist");
                    i = 3002;
                } else if (bj.this.Code(adContentData)) {
                    adContentData.Code(bj.this.S(jSONObject.optString("versionCode")));
                    AdEventReport adEventReport2 = adEventReport;
                    boolean z = false;
                    String str4 = com.huawei.openalliance.ad.constant.v.f17382a;
                    if (adEventReport2 != null) {
                        int g = adEventReport2.g();
                        i3 = adEventReport.h();
                        if (!TextUtils.isEmpty(adEventReport.i())) {
                            str4 = adEventReport.i();
                        }
                        int intValue = adEventReport.L() != null ? adEventReport.L().intValue() : 13;
                        str3 = adEventReport.o();
                        i4 = intValue;
                        str2 = str4;
                        i2 = g;
                    } else {
                        str2 = com.huawei.openalliance.ad.constant.v.f17382a;
                        str3 = null;
                        i2 = 0;
                        i3 = 0;
                        i4 = 13;
                    }
                    MaterialClickInfo C = bj.this.C(str);
                    if (C.D() == null && C.L() == null) {
                        z = true;
                    }
                    if (13 == i4 && z) {
                        C.B(1);
                    }
                    Context context2 = context;
                    jc.Code(context2, adContentData, str3, i2, i3, str2, i4, com.huawei.openalliance.ad.utils.b.Code(context2), C);
                    i = 1000;
                } else {
                    fb.V(bj.Z, "ad is not in whitelist");
                    i = 3004;
                }
                ag.Code(remoteCallResultCallback, bj.this.Code, i, null, true);
            }
        });
    }
}
