package com.bytedance.msdk.adapter.gdt;

import OOxOOxIO.Oxx0IOOO;
import OOxOOxIO.xoIox;
import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;

/* loaded from: classes8.dex */
public class GdtFullVideoLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        int i;
        String str;
        if (context instanceof Activity) {
            MediationApiLog.i("TTMediationSDK", "GdtFullVideoLoader realLoader adnId:" + getAdnId());
            if (mediationAdSlotValueSet != null) {
                Oxx0IOOO.oIX0oI(context, mediationAdSlotValueSet, this.mGmAdLoader, new xoIox(), new Oxx0IOOO.oIX0oI() { // from class: com.bytedance.msdk.adapter.gdt.GdtFullVideoLoader.1
                    @Override // OOxOOxIO.Oxx0IOOO.oIX0oI
                    public void useOriginLoader() {
                        new xxIXOIIO.Oxx0IOOO(mediationAdSlotValueSet, GdtFullVideoLoader.this.getGMBridge(), GdtFullVideoLoader.this).oxoX(context);
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
