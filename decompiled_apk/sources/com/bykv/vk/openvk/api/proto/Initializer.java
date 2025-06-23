package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* loaded from: classes8.dex */
public interface Initializer {
    Manager getManager();

    void init(Context context, ValueSet valueSet);

    boolean isInitSuccess();
}
