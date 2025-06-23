package com.baidu.platform.comapi.walknavi.widget.a;

import com.baidu.ar.OnReciveShakeListener;
import java.util.HashMap;

/* loaded from: classes8.dex */
class i implements OnReciveShakeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9865a;

    public i(a aVar) {
        this.f9865a = aVar;
    }

    @Override // com.baidu.ar.OnReciveShakeListener
    public void onShake(HashMap<String, Object> hashMap) {
        com.baidu.platform.comapi.wnplatform.p.j.a().b();
    }
}
