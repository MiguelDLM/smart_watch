package com.baidu.platform.comapi.walknavi.h.c;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class aa implements IWNPCEngineInitListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9772a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;

    public aa(c cVar, String str, String str2) {
        this.c = cVar;
        this.f9772a = str;
        this.b = str2;
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onFail(String str) {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.c.ac;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.c.ac;
            iWNPCLoadAndInitListener2.onFail();
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onSuccess() {
        this.c.b(this.f9772a, this.b);
        com.baidu.platform.comapi.walknavi.b.a().O().b(this.f9772a, this.b);
    }
}
