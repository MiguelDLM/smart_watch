package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import xoIox.OOXIXo;

/* loaded from: classes8.dex */
public class KsRewardLoader extends KsBaseLoader {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            new OOXIXo(this).oIX0oI(context, mediationAdSlotValueSet);
        }
    }
}
