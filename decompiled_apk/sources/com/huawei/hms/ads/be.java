package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class be extends as {
    public be() {
        super(aj.L);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.be.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                if (adContentData != null) {
                    com.huawei.openalliance.ad.inter.data.s sVar = new com.huawei.openalliance.ad.inter.data.s(adContentData);
                    if (sVar.y() != null) {
                        com.huawei.openalliance.ad.download.app.b.Code(context).Code(be.this.Code(sVar.y(), adContentData));
                        be.this.V((RemoteCallResultCallback<String>) remoteCallResultCallback, true);
                        return;
                    }
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = be.this.Code;
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = be.this.Code;
                }
                ag.Code(remoteCallResultCallback2, str2, 3002, null, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData) {
        AppDownloadTask Code = new AppDownloadTask.a().Code(appInfo).Code();
        Code.C(adContentData.aF());
        Code.D(adContentData.M());
        Code.I(adContentData.D());
        Code.Z(adContentData.L());
        Code.C(adContentData.a());
        return Code;
    }
}
