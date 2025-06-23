package com.baidu.platform.comapi.walknavi;

import android.net.wifi.WifiManager;
import com.baidu.platform.comapi.walknavi.h.b;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WifiManager f9753a;
    final /* synthetic */ b.InterfaceC0537b b;
    final /* synthetic */ int c;
    final /* synthetic */ b d;

    public f(b bVar, WifiManager wifiManager, b.InterfaceC0537b interfaceC0537b, int i) {
        this.d = bVar;
        this.f9753a = wifiManager;
        this.b = interfaceC0537b;
        this.c = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.b.a
    public void a() {
        this.f9753a.setWifiEnabled(true);
        b.InterfaceC0537b interfaceC0537b = this.b;
        if (interfaceC0537b != null) {
            interfaceC0537b.a(this.c);
        }
    }
}
