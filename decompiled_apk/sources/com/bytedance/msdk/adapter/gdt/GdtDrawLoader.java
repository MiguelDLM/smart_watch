package com.bytedance.msdk.adapter.gdt;

import OOxOOxIO.Oxx0IOOO;
import OOxOOxIO.X0o0xo;
import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xxIXOIIO.XO;

/* loaded from: classes8.dex */
public class GdtDrawLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            Oxx0IOOO.oIX0oI(context, mediationAdSlotValueSet, this.mGmAdLoader, new X0o0xo(), new Oxx0IOOO.oIX0oI() { // from class: com.bytedance.msdk.adapter.gdt.GdtDrawLoader.1
                @Override // OOxOOxIO.Oxx0IOOO.oIX0oI
                public void useOriginLoader() {
                    new XO(GdtDrawLoader.this).II0xO0(context, mediationAdSlotValueSet);
                }
            });
        }
    }
}
