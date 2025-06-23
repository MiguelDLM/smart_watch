package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class al extends ag {
    private static final String Z = "JsbFeedbackClose";

    public al() {
        super(aj.G);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (fb.Code()) {
            fb.Code(Z, "start");
        }
        final String optString = new JSONObject(str).optString(com.huawei.openalliance.ad.constant.aw.aV, "3");
        Code(context, str, new ac() { // from class: com.huawei.hms.ads.al.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    cy.Code(context, adContentData, optString);
                    i = 1000;
                } else {
                    fb.Code(al.Z, "ad not exist");
                    i = 3002;
                }
                ag.Code(remoteCallResultCallback, al.this.Code, i, null, true);
            }
        });
    }
}
