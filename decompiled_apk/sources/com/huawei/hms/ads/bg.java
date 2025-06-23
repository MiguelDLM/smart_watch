package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bg extends as {
    public bg() {
        super(aj.S);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.bg.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                int i;
                if (adContentData != null) {
                    final com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                    if (bg.this.Code(adContentData)) {
                        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.bg.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                int Code = bg.this.V(context, str).Code(context, sVar);
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                ag.Code(remoteCallResultCallback, bg.this.Code, 1000, Integer.valueOf(Code), true);
                            }
                        });
                        return;
                    } else {
                        remoteCallResultCallback2 = remoteCallResultCallback;
                        str2 = bg.this.Code;
                        i = 3004;
                    }
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = bg.this.Code;
                    i = 3002;
                }
                ag.Code(remoteCallResultCallback2, str2, i, null, true);
            }
        });
    }
}
