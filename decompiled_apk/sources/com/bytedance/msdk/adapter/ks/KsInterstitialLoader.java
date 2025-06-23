package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xoIox.xxIXOIIO;

/* loaded from: classes8.dex */
public class KsInterstitialLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            new xxIXOIIO(this).oIX0oI(context, mediationAdSlotValueSet);
        }
    }
}
