package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.cb;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ac implements cb.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f6217a;

    public ac(aa aaVar) {
        this.f6217a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cb.c
    public void a(boolean z) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z) {
            try {
                cb cbVar = g.f6326a;
                if (cbVar != null) {
                    this.f6217a.b = cbVar.i();
                    iXAdContainerFactory = this.f6217a.b;
                    if (iXAdContainerFactory != null) {
                        this.f6217a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.f6217a.a("加载dex异常");
                return;
            }
        }
        g.f6326a = null;
        this.f6217a.a("加载dex失败");
    }
}
