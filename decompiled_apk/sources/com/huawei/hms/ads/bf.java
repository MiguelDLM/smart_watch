package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bf extends as {
    public bf() {
        super(aj.D);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.bf.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                final int[] iArr = {-1};
                if (adContentData != null) {
                    final com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                    com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.bf.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int[] iArr2 = iArr;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            iArr2[0] = bf.this.V(context, str).Z(context, sVar);
                        }
                    });
                }
                ag.Code(remoteCallResultCallback, bf.this.Code, 1000, Integer.toString(iArr[0]), true);
            }
        });
    }
}
