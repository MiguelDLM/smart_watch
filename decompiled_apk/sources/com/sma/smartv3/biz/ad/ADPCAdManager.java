package com.sma.smartv3.biz.ad;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Application;
import com.adp.sdk.ADP;
import com.adp.sdk.dto.ADPConfig;
import com.adp.sdk.dto.AdpError;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ADPCAdManager {

    @OOXIXo
    public static final ADPCAdManager INSTANCE = new ADPCAdManager();

    @OOXIXo
    private static final String TAG = "ADPCAdManager";

    private ADPCAdManager() {
    }

    public final void initSdk(@OOXIXo Application context, @OOXIXo String appid) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(appid, "appid");
        oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI("ADPCAdManager initADPCAd");
        oix0oi.oIX0oI("ADPCAdManager initADPCAd -> appid: " + appid);
        ADP.initialize(new ADPConfig.Builder().disablePersonalRecommand(false).setDebug(true).build(), appid, context, new ADP.InitCallback() { // from class: com.sma.smartv3.biz.ad.ADPCAdManager$initSdk$1
            @Override // com.adp.sdk.ADP.InitCallback
            public void onError(@oOoXoXO AdpError adpError) {
                String str;
                oIX0oI oix0oi2 = oIX0oI.f1507oIX0oI;
                StringBuilder sb = new StringBuilder();
                sb.append("ADPCAdManager initADPCAd -> onError: ");
                String str2 = null;
                if (adpError != null) {
                    str = adpError.getCode();
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append(", ");
                if (adpError != null) {
                    str2 = adpError.getMessage();
                }
                sb.append(str2);
                oix0oi2.oIX0oI(sb.toString());
            }

            @Override // com.adp.sdk.ADP.InitCallback
            public void onSuccess() {
                oIX0oI.f1507oIX0oI.oIX0oI("ADPCAdManager initADPCAd -> onSuccess");
            }
        });
    }
}
