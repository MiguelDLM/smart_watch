package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bh extends ag {
    private static final String Z = "JsbUnregisterAppStatusProxy";

    public bh() {
        super(aj.z);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, false, new ac() { // from class: com.huawei.hms.ads.bh.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                if (adContentData == null || adContentData.y() == null) {
                    return;
                }
                com.huawei.hms.ads.jsb.a.Code(context).Code(adContentData.a());
            }
        });
    }
}
