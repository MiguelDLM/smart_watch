package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class eh extends ag {
    public eh() {
        super(aj.F);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (fb.Code()) {
            fb.Code("JsbClickComplianceEle", "start");
        }
        final String optString = new JSONObject(str).optString(com.huawei.openalliance.ad.constant.aw.aT, "");
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.eh.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                String str2;
                int i = 3002;
                if (adContentData != null) {
                    com.huawei.openalliance.ad.inter.data.AppInfo y = adContentData.y();
                    if (y != null) {
                        String str3 = optString;
                        str3.hashCode();
                        char c = 65535;
                        switch (str3.hashCode()) {
                            case -1891164985:
                                if (str3.equals("privacyUrl")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -1431863008:
                                if (str3.equals("permissionUrl")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -262766019:
                                if (str3.equals("appDetailUrl")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                y.Code(context);
                                break;
                            case 1:
                                y.V(context);
                                break;
                            case 2:
                                com.huawei.openalliance.ad.inter.data.l lVar = new com.huawei.openalliance.ad.inter.data.l(adContentData);
                                MaterialClickInfo materialClickInfo = (MaterialClickInfo) com.huawei.openalliance.ad.utils.aa.V(str, MaterialClickInfo.class, new Class[0]);
                                if (materialClickInfo != null && com.huawei.openalliance.ad.utils.ay.L(materialClickInfo.I()) && materialClickInfo.Code() != null) {
                                    lVar.Code(eh.this.Code(context), materialClickInfo);
                                    break;
                                } else {
                                    lVar.V(eh.this.Code(context));
                                    break;
                                }
                                break;
                        }
                        i = 1000;
                        ag.Code(remoteCallResultCallback, eh.this.Code, i, null, true);
                    }
                    str2 = "appInfo not exist";
                } else {
                    str2 = "ad not exist";
                }
                fb.Code("JsbClickComplianceEle", str2);
                ag.Code(remoteCallResultCallback, eh.this.Code, i, null, true);
            }
        });
    }
}
