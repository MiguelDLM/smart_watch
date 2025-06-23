package com.bytedance.sdk.openadsdk.live;

import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public interface ILiveAdCustomConfig {
    String convertToEnterFromMerge(int i);

    String convertToEnterMethod(int i, boolean z);

    Object invoke(int i, Bundle bundle);

    void onEventV3(String str, JSONObject jSONObject);

    int openLR(String str);
}
