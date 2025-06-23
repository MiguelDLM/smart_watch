package com.baidu.platform.comapi.wnplatform.j;

import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class j implements g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IWRoutePlanListener f9928a;
    final /* synthetic */ h b;

    public j(h hVar, IWRoutePlanListener iWRoutePlanListener) {
        this.b = hVar;
        this.f9928a = iWRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a() {
        this.f9928a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void b() {
        this.f9928a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void c() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a(int i) {
        if (i == 16777214) {
            this.f9928a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
            return;
        }
        if (i == 16777216) {
            this.f9928a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
        } else if (i != 805306368) {
            this.f9928a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
        } else {
            this.f9928a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
        }
    }
}
