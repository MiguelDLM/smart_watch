package com.kwad.components.offline.b;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* loaded from: classes11.dex */
public final class c implements com.kwad.sdk.core.e.a.a {
    private final IObiwanLogcat adD;

    public c(IObiwanLogcat iObiwanLogcat) {
        this.adD = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void d(String str, String str2) {
        this.adD.d(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void e(String str, String str2) {
        this.adD.e(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void i(String str, String str2) {
        this.adD.i(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void printStackTraceOnly(Throwable th) {
        this.adD.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2) {
        this.adD.v(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2) {
        this.adD.w(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2, boolean z) {
        this.adD.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2, boolean z) {
        this.adD.w(str, str2, z);
    }
}
