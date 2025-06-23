package com.sina.weibo.sdk.openapi;

import android.content.Context;

/* loaded from: classes11.dex */
public class WBAPIFactory {
    public static IWBAPI createWBAPI(Context context) {
        return new a(context);
    }
}
