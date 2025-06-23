package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xoIox.xoIox;

/* loaded from: classes8.dex */
public class KsNativeLoader extends KsBaseLoader {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            new xoIox().oIX0oI(context, mediationAdSlotValueSet, this);
        }
    }
}
