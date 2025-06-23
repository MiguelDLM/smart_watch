package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class bk implements aa.a {
    final /* synthetic */ bj c;

    public bk(bj bjVar) {
        this.c = bjVar;
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onFailure() {
        this.c.i.a(bj.b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.c.j();
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onSuccess() {
        this.c.i.a(bj.b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.c.i();
    }
}
