package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.o;

/* loaded from: classes10.dex */
public class dn extends dj {
    public static final String I = "16";
    public static final String V = "15";
    private static final String Z = "AlertReminder";

    public dn(Context context) {
        super(context);
    }

    private void I(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo, final AdContentData adContentData, long j) {
        fb.V(Z, "showNonWifiAlert, context:" + Code());
        com.huawei.openalliance.ad.download.app.f.V(Code(), j, new o.a() { // from class: com.huawei.hms.ads.dn.1
            @Override // com.huawei.openalliance.ad.utils.o.a
            public void Code() {
                c.Code(dn.this.Code, "15", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.dn.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            fb.V(dn.Z, " traffic reminder accept");
                        }
                    }
                }, String.class);
                dn.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.o.a
            public void V() {
                c.Code(dn.this.Code, "16", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.dn.1.2
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            fb.V(dn.Z, " traffic reminder reject");
                        }
                    }
                }, String.class);
                dn.this.V(appInfo);
            }
        });
    }

    @Override // com.huawei.hms.ads.dj
    public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, long j) {
        if (appInfo != null && adContentData != null) {
            I(appInfo, adContentData, j);
        } else {
            fb.V(Z, "appInfo or contentRecord is empty");
            V(appInfo);
        }
    }
}
