package com.baidu.platform.comapi.walknavi.widget.a;

import com.baidu.ar.OnReciveFootBridgeFormLuaListener;
import java.util.HashMap;

/* loaded from: classes8.dex */
class k implements OnReciveFootBridgeFormLuaListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9867a;

    public k(a aVar) {
        this.f9867a = aVar;
    }

    @Override // com.baidu.ar.OnReciveFootBridgeFormLuaListener
    public void onReciveFootBridge(HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.util.j.a(new l(this), 0L);
    }
}
