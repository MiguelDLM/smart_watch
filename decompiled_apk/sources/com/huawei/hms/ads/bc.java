package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class bc extends as {
    public bc() {
        super(aj.d);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.bc.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                com.huawei.openalliance.ad.download.app.k kVar = com.huawei.openalliance.ad.download.app.k.DOWNLOAD;
                if (adContentData != null) {
                    kVar = com.huawei.hms.ads.jsb.a.Code(context).Code().S(context, new com.huawei.openalliance.ad.inter.data.s(adContentData));
                }
                ag.Code(remoteCallResultCallback, bc.this.Code, 1000, bc.this.Code(kVar), true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(com.huawei.openalliance.ad.download.app.k kVar) {
        return kVar == null ? com.huawei.openalliance.ad.download.app.k.DOWNLOAD.toString() : kVar.toString();
    }
}
