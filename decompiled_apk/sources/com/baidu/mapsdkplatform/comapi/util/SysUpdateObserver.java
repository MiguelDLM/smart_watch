package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;

/* loaded from: classes7.dex */
public interface SysUpdateObserver {
    void init(String str);

    void updateCuid(String str);

    void updateNetworkInfo(Context context);

    void updateNetworkProxy(Context context);

    void updatePhoneInfo(String str);

    void updateZid(String str);
}
