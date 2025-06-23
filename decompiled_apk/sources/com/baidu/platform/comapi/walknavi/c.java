package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements com.baidu.platform.comapi.walknavi.e.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IWNPCEngineInitListener f9704a;
    final /* synthetic */ b b;

    public c(b bVar, IWNPCEngineInitListener iWNPCEngineInitListener) {
        this.b = bVar;
        this.f9704a = iWNPCEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(boolean z, float f) {
    }

    @Override // com.baidu.platform.comapi.walknavi.e.c
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("downloadnpc:responseCode = " + i + ", responseMessage = " + str);
        if (i == 0) {
            this.b.S = true;
            this.f9704a.onSuccess();
            return;
        }
        if (i == 2 || i == 4 || i == 3) {
            this.b.S = false;
            this.f9704a.onFail("您的手机暂不支持3D模型导航");
            return;
        }
        if (i == 1) {
            this.b.S = false;
            this.f9704a.onFail("当前网络异常，请稍候再试");
        } else if (i == 6 || i == 5 || i == -1) {
            this.b.S = false;
            this.f9704a.onFail("初始化失败，请稍候再试");
        } else {
            this.b.S = false;
            this.f9704a.onFail("未知错误导致初始化失败");
        }
    }
}
