package com.baidu.navisdk.widget.naviimageloader;

import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f9421a = false;

    public void a(Throwable th) {
        throw null;
    }

    public void b(Object obj) {
        throw null;
    }

    public void a(Object obj) {
        if (a()) {
            return;
        }
        LogUtil.e("BaseRspHandler", getClass().getName() + ":onSuccess");
        b(obj);
    }

    public boolean a() {
        return this.f9421a;
    }
}
