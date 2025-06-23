package com.bytedance.msdk.adapter.gdt;

import OOxOOxIO.Oxx0IOOO;
import OOxOOxIO.oO;
import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xxIXOIIO.xxIXOIIO;

/* loaded from: classes8.dex */
public class GdtNativeLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            Oxx0IOOO.oIX0oI(context, mediationAdSlotValueSet, this.mGmAdLoader, new oO(), new Oxx0IOOO.oIX0oI() { // from class: com.bytedance.msdk.adapter.gdt.GdtNativeLoader.1
                @Override // OOxOOxIO.Oxx0IOOO.oIX0oI
                public void useOriginLoader() {
                    new xxIXOIIO(GdtNativeLoader.this).oxoX(context, mediationAdSlotValueSet);
                }
            });
        }
    }
}
