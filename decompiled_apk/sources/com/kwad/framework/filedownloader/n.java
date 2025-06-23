package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* loaded from: classes11.dex */
public final class n implements u {
    private final u afG;

    /* loaded from: classes11.dex */
    public static final class a {
        private static final n afH = new n(0);
    }

    public /* synthetic */ n(byte b) {
        this();
    }

    public static n vq() {
        return a.afH;
    }

    public static e.a vr() {
        if (vq().afG instanceof o) {
            return (e.a) vq().afG;
        }
        return null;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        return this.afG.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void av(Context context) {
        this.afG.av(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bd(int i) {
        return this.afG.bd(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte be(int i) {
        return this.afG.be(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bf(int i) {
        return this.afG.bf(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.afG.isConnected();
    }

    private n() {
        u pVar;
        if (com.kwad.framework.filedownloader.f.e.xr().ajf) {
            pVar = new o();
        } else {
            pVar = new p(FileDownloadService.SeparateProcessService.class);
        }
        this.afG = pVar;
    }
}
