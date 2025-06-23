package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: classes10.dex */
public interface b {
    String getAppDetailUrl();

    String getPermissionUrl();

    String getPrivacyLink();

    void showPermissionPage(Context context);

    void showPrivacyPolicy(Context context);
}
