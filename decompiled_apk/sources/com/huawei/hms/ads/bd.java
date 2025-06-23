package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bd extends ag {
    private static final String Z = "JsbRegisterAppStatusProxy";

    public bd() {
        super(aj.y);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, false, new ac() { // from class: com.huawei.hms.ads.bd.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                if (adContentData != null) {
                    com.huawei.hms.ads.jsb.a.Code(context).Code(adContentData.a(), adContentData.y());
                }
            }
        });
    }
}
