package com.bytedance.msdk.adapter.gdt;

import OOxOOxIO.IXxxXO;
import OOxOOxIO.Oxx0IOOO;
import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xxIXOIIO.xoIox;

/* loaded from: classes8.dex */
public class GdtRewardLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context == null || mediationAdSlotValueSet == null) {
            notifyAdFailed(80001, "context is null or adSlotValueSet is null");
        } else {
            Oxx0IOOO.oIX0oI(context, mediationAdSlotValueSet, this.mGmAdLoader, new IXxxXO(), new Oxx0IOOO.oIX0oI() { // from class: com.bytedance.msdk.adapter.gdt.GdtRewardLoader.1
                @Override // OOxOOxIO.Oxx0IOOO.oIX0oI
                public void useOriginLoader() {
                    new xoIox(mediationAdSlotValueSet, GdtRewardLoader.this.getGMBridge(), GdtRewardLoader.this).oxoX(context);
                }
            });
        }
    }
}
