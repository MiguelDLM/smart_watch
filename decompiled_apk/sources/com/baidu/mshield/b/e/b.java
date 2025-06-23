package com.baidu.mshield.b.e;

import android.content.Context;
import android.net.NetworkInfo;
import com.baidu.sec.privacy.c.i;

/* loaded from: classes7.dex */
public class b {
    public static NetworkInfo a(Context context) {
        com.baidu.mshield.b.c.a.a("---privacy getActiveNetworkInfo---" + System.currentTimeMillis());
        return i.a(context).a();
    }
}
