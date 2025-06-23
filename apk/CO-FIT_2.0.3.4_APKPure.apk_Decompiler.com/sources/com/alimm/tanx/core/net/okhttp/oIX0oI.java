package com.alimm.tanx.core.net.okhttp;

import com.alimm.tanx.core.net.callback.NetWorkCallBack;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ String f1165IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Object f1166Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ NetWorkCallBack f1167XO;

    public /* synthetic */ oIX0oI(NetWorkCallBack netWorkCallBack, Object obj, String str) {
        this.f1167XO = netWorkCallBack;
        this.f1166Oo = obj;
        this.f1165IXxxXO = str;
    }

    public final void run() {
        OkHttpNetWorkImpl.lambda$succCallBack$14(this.f1167XO, this.f1166Oo, this.f1165IXxxXO);
    }
}
