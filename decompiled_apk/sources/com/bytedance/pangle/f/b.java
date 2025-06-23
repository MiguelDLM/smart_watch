package com.bytedance.pangle.f;

import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.d;

/* loaded from: classes8.dex */
public final class b extends d.a {

    /* renamed from: a, reason: collision with root package name */
    private final ZeusPluginInstallListener f10551a;

    public b(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.f10551a = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.d
    public final void a(String str, int i, String str2) {
        ZeusPluginInstallListener zeusPluginInstallListener = this.f10551a;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i, str2);
        }
    }
}
