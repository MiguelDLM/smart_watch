package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class am extends ag {
    private static final int B = -1;
    private static final int Z = 0;

    public am() {
        super(aj.v);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.am.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    ag.Code(remoteCallResultCallback, am.this.Code, 3002, null, true);
                } else {
                    ag.Code(remoteCallResultCallback, am.this.Code, 1000, Integer.valueOf(com.huawei.openalliance.ad.utils.w.Code(context, adContentData) ? 0 : -1), true);
                }
            }
        });
    }
}
