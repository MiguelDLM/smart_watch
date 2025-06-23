package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.activity.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ei extends ag {
    public ei() {
        super(aj.J);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fb.Code("JsbClickShare", "start");
        final String optString = new JSONObject(str).optString("cshareUrl", "");
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.ei.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    fb.Code("JsbClickShare", "start dialog activity");
                    com.huawei.openalliance.ad.inter.data.l lVar = new com.huawei.openalliance.ad.inter.data.l(adContentData);
                    lVar.S(optString);
                    c.Code(context, lVar, adContentData);
                    i = 1000;
                } else {
                    fb.Code("JsbClickShare", "ad not exist");
                    i = 3002;
                }
                ag.Code(remoteCallResultCallback, ei.this.Code, i, null, true);
            }
        });
    }
}
