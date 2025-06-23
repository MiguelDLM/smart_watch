package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class av extends ax {
    public av() {
        super(aj.g);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        V().I(remoteCallResultCallback, this.Code, this.I);
    }
}
