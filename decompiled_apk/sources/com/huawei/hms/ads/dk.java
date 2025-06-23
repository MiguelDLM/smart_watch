package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.o;

/* loaded from: classes10.dex */
public class dk extends dj {
    private static final String B = "117";
    private static final String I = "115";
    private static final String V = "ConfirmDownloadAlertStrategy";
    private static final String Z = "116";

    /* loaded from: classes10.dex */
    public static class a implements RemoteCallResultCallback<String> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() != -1) {
                fb.V(dk.V, "confirm reminder reject");
            }
        }
    }

    public dk(Context context) {
        super(context);
    }

    private void Code(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo, final AdContentData adContentData) {
        fb.V(V, "showConfirmDownloadAlert, context:" + Code());
        Code(I, adContentData);
        com.huawei.openalliance.ad.download.app.f.Code(Code(), "11".equals(appInfo.y()), new o.a() { // from class: com.huawei.hms.ads.dk.1
            @Override // com.huawei.openalliance.ad.utils.o.a
            public void Code() {
                dk.this.Code(dk.Z, adContentData);
                dk.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.o.a
            public void V() {
                dk.this.Code(dk.B, adContentData);
                dk.this.V(appInfo);
            }
        });
    }

    @Override // com.huawei.hms.ads.dj
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        if (appInfo != null && adContentData != null) {
            Code(appInfo, adContentData);
        } else {
            fb.V(V, "appInfo or contentRecord is empty");
            V(appInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, AdContentData adContentData) {
        c.Code(this.Code, str, adContentData, new a(), String.class);
    }
}
