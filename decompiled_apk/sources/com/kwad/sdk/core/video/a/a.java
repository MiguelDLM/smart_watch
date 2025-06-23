package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;

/* loaded from: classes11.dex */
public abstract class a implements c {
    private c.e UN;
    private c.i UO;
    private c.b UP;
    private c.InterfaceC0859c UQ;
    private c.d UR;
    private c.a US;
    private c.f aCl;
    private c.g aCm;
    private c.h aCn;

    public static void h(float f) {
        if (f == 0.0f) {
            com.kwad.sdk.core.video.a.a.a.eF("autoMute");
        } else {
            com.kwad.sdk.core.video.a.a.a.eF("autoVoice");
        }
    }

    public final void GH() {
        c.f fVar = this.aCl;
        if (fVar != null) {
            fVar.sc();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.aCl = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.UN = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.UR = dVar;
    }

    public final void notifyOnBufferingUpdate(int i) {
        c.a aVar = this.US;
        if (aVar != null) {
            aVar.av(i);
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.UP;
        if (bVar != null) {
            bVar.py();
        }
    }

    public final boolean notifyOnError(int i, int i2) {
        com.kwad.sdk.core.video.a.a.a.eF("videoPlayError");
        c.InterfaceC0859c interfaceC0859c = this.UQ;
        if (interfaceC0859c != null && interfaceC0859c.l(i, i2)) {
            return true;
        }
        return false;
    }

    public final boolean notifyOnInfo(int i, int i2) {
        c.d dVar = this.UR;
        if (dVar != null && dVar.m(i, i2)) {
            return true;
        }
        return false;
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.UN;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnSeekComplete() {
        c.g gVar = this.aCm;
        if (gVar != null) {
            gVar.pz();
        }
    }

    public final void resetListeners() {
        this.aCl = null;
        this.UN = null;
        this.US = null;
        this.UP = null;
        this.aCm = null;
        this.UO = null;
        this.UQ = null;
        this.UR = null;
        this.aCn = null;
    }

    public final void w(int i, int i2) {
        c.i iVar = this.UO;
        if (iVar != null) {
            iVar.k(i, i2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.UP = bVar;
    }

    public final void b(TimedText timedText) {
        c.h hVar = this.aCn;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.US = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.aCm = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.UO = iVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC0859c interfaceC0859c) {
        this.UQ = interfaceC0859c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.aCn = hVar;
    }
}
