package com.bytedance.msdk.adapter.gdt;

import OOxOOxIO.Oxx0IOOO;
import OOxOOxIO.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xxIXOIIO.II0XooXoX;

/* loaded from: classes8.dex */
public class GdtInterstitialLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        int i;
        String str;
        if (context instanceof Activity) {
            MediationApiLog.i("TTMediationSDK", "GdtInterstitialLoader realLoader adnId:" + getAdnId());
            if (mediationAdSlotValueSet != null) {
                Oxx0IOOO.oIX0oI(context, mediationAdSlotValueSet, this.mGmAdLoader, new oOoXoXO(), new Oxx0IOOO.oIX0oI() { // from class: com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader.1
                    @Override // OOxOOxIO.Oxx0IOOO.oIX0oI
                    public void useOriginLoader() {
                        new II0XooXoX(mediationAdSlotValueSet, GdtInterstitialLoader.this.getGMBridge(), GdtInterstitialLoader.this).oxoX(context);
                    }
                });
                return;
            } else {
                i = 80001;
                str = "context is null or adSlotValueSet is null";
            }
        } else {
            i = MediationConstant.ErrorCode.ADN_AD_CONTEXT;
            str = "context type error, context need activity";
        }
        notifyAdFailed(i, str);
    }
}
