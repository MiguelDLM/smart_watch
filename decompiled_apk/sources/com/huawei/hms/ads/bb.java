package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bb extends as {
    public bb() {
        super(aj.c);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.bb.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    i = com.huawei.hms.ads.jsb.a.Code(context).Code().F(context, new com.huawei.openalliance.ad.inter.data.s(adContentData));
                } else {
                    i = 0;
                }
                ag.Code(remoteCallResultCallback, bb.this.Code, 1000, Integer.valueOf(i), true);
            }
        });
    }
}
