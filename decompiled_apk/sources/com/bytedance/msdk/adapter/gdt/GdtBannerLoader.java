package com.bytedance.msdk.adapter.gdt;

import OOxOOxIO.II0xO0;
import OOxOOxIO.Oxx0IOOO;
import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xxIXOIIO.X0o0xo;

/* loaded from: classes8.dex */
public class GdtBannerLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context instanceof Activity) {
            Oxx0IOOO.oIX0oI(context, mediationAdSlotValueSet, this.mGmAdLoader, new II0xO0(), new Oxx0IOOO.oIX0oI() { // from class: com.bytedance.msdk.adapter.gdt.GdtBannerLoader.1
                @Override // OOxOOxIO.Oxx0IOOO.oIX0oI
                public void useOriginLoader() {
                    new X0o0xo(GdtBannerLoader.this).oxoX(context, mediationAdSlotValueSet);
                }
            });
        } else {
            notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_CONTEXT, "context type error, context need activity");
        }
    }
}
