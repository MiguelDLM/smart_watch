package com.baidu.platform.comapi.walknavi.widget.a;

import com.baidu.ar.OnReciveCrossStreetFormLuaListener;
import java.util.HashMap;

/* loaded from: classes8.dex */
class p implements OnReciveCrossStreetFormLuaListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9872a;

    public p(a aVar) {
        this.f9872a = aVar;
    }

    @Override // com.baidu.ar.OnReciveCrossStreetFormLuaListener
    public void onReciveCrossStreetHide(HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.walknavi.b.a().b("cross streect hide");
        com.baidu.platform.comapi.util.j.a(new r(this), 0L);
    }

    @Override // com.baidu.ar.OnReciveCrossStreetFormLuaListener
    public void onReciveCrossStreetShow(HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.walknavi.b.a().b("cross streect show");
        com.baidu.platform.comapi.util.j.a(new q(this), 0L);
    }
}
