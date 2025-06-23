package com.baidu.navisdk.asr;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public abstract class a {
    public abstract com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar);

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.B().a(str, this);
            return;
        }
        throw new IllegalArgumentException();
    }
}
