package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* loaded from: classes8.dex */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i);

    ValueSet values();
}
