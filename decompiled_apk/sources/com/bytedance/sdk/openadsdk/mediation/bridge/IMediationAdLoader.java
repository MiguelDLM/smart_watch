package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: classes8.dex */
public interface IMediationAdLoader extends Bridge {
    void load(Context context, ValueSet valueSet);
}
