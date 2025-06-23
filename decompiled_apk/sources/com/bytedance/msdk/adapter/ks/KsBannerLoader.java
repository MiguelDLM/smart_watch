package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xoIox.XO;

/* loaded from: classes8.dex */
public class KsBannerLoader extends KsBaseLoader {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            new XO(this).II0xO0(context, mediationAdSlotValueSet);
        }
    }
}
