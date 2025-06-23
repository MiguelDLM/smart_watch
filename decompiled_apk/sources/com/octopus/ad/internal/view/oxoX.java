package com.octopus.ad.internal.view;

import android.view.View;

/* loaded from: classes11.dex */
public class oxoX implements X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f19040I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public I0Io f19041II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public long f19042oIX0oI;

    public oxoX(I0Io i0Io, Long l, boolean z) {
        this.f19042oIX0oI = l.longValue();
        this.f19041II0xO0 = i0Io;
        this.f19040I0Io = z;
    }

    @Override // com.octopus.ad.internal.view.X0o0xo
    public long a() {
        return this.f19042oIX0oI;
    }

    @Override // com.octopus.ad.internal.view.X0o0xo
    public boolean b() {
        return this.f19040I0Io;
    }

    @Override // com.octopus.ad.internal.view.X0o0xo
    public View c() {
        I0Io i0Io = this.f19041II0xO0;
        if (i0Io == null) {
            return null;
        }
        return i0Io.getView();
    }
}
