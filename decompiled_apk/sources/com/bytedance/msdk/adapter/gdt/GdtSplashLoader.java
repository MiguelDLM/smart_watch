package com.bytedance.msdk.adapter.gdt;

import OOxOOxIO.Oxx0IOOO;
import OOxOOxIO.oI0IIXIo;
import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xxIXOIIO.OOXIXo;

/* loaded from: classes8.dex */
public class GdtSplashLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        int i;
        String str;
        if (context instanceof Activity) {
            MediationApiLog.i("TTMediationSDK", "GdtSplashLoader realLoader adnId:" + getAdnId());
            if (context != null && mediationAdSlotValueSet != null) {
                final int loadTimeOut = getLoadTimeOut();
                final boolean isSplashPreLoad = isSplashPreLoad();
                Oxx0IOOO.oIX0oI(context, mediationAdSlotValueSet, this.mGmAdLoader, new oI0IIXIo(), new Oxx0IOOO.oIX0oI() { // from class: com.bytedance.msdk.adapter.gdt.GdtSplashLoader.1
                    @Override // OOxOOxIO.Oxx0IOOO.oIX0oI
                    public void useOriginLoader() {
                        new OOXIXo(mediationAdSlotValueSet, GdtSplashLoader.this.getGMBridge(), context, GdtSplashLoader.this).I0Io(context, loadTimeOut, isSplashPreLoad);
                    }
                });
                return;
            }
            i = 80001;
            str = "context is null or adSlotValueSet is null";
        } else {
            i = MediationConstant.ErrorCode.ADN_AD_CONTEXT;
            str = "context type error, context need activity";
        }
        notifyAdFailed(i, str);
    }
}
