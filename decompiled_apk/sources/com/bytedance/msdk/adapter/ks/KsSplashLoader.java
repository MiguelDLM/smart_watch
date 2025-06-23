package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xoIox.oOoXoXO;

/* loaded from: classes8.dex */
public class KsSplashLoader extends MediationAdLoaderImpl {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            new oOoXoXO(this).oIX0oI(context, mediationAdSlotValueSet);
        }
    }
}
