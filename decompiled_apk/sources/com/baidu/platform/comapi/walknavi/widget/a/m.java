package com.baidu.platform.comapi.walknavi.widget.a;

import com.baidu.ar.OnReciveTunnelFormLuaListener;
import java.util.HashMap;

/* loaded from: classes8.dex */
class m implements OnReciveTunnelFormLuaListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9869a;

    public m(a aVar) {
        this.f9869a = aVar;
    }

    @Override // com.baidu.ar.OnReciveTunnelFormLuaListener
    public void onReciveTunnel(HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.util.j.a(new n(this), 0L);
    }
}
