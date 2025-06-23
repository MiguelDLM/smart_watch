package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class bp extends bi {
    private static final String Z = "JsbReportPlayTimeEvent";

    public bp() {
        super(aj.l);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code(Z, "start");
        final long optLong = new JSONObject(str).optLong(com.huawei.openalliance.ad.constant.aw.bb, 0L);
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.bp.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                adContentData.B(optLong);
                jc.V(context, adContentData, com.huawei.openalliance.ad.constant.ai.h);
                bp.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
