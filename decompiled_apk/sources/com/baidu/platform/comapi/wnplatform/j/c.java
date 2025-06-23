package com.baidu.platform.comapi.wnplatform.j;

import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBRoutePlanListener f9925a;
    final /* synthetic */ a b;

    public c(a aVar, IBRoutePlanListener iBRoutePlanListener) {
        this.b = aVar;
        this.f9925a = iBRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a() {
        this.f9925a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void b() {
        this.f9925a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void c() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a(int i) {
        if (i == 16777214) {
            this.f9925a.onRoutePlanFail(BikeRoutePlanError.FORWARD_AK_ERROR);
            return;
        }
        if (i == 16777216) {
            this.f9925a.onRoutePlanFail(BikeRoutePlanError.SERVER_UNUSUAL);
            return;
        }
        if (i == 214000002) {
            this.f9925a.onRoutePlanFail(BikeRoutePlanError.DISTANCE_MORE_THAN);
        } else if (i != 805306368) {
            this.f9925a.onRoutePlanFail(BikeRoutePlanError.PARSE_FAIL);
        } else {
            this.f9925a.onRoutePlanFail(BikeRoutePlanError.NET_ERR);
        }
    }
}
