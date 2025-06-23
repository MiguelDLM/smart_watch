package com.kwad.components.ad.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class a {
    private InterfaceC0727a cF;

    @Nullable
    private b cG;
    private boolean cH = false;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.b.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0727a {
        void aq();
    }

    /* loaded from: classes11.dex */
    public interface b {
        boolean ar();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0727a interfaceC0727a) {
        this.cF = interfaceC0727a;
    }

    public final void ap() {
        InterfaceC0727a interfaceC0727a;
        if (this.cH) {
            return;
        }
        this.cH = true;
        if (e.dS(this.mAdTemplate).status != 1 && e.dS(this.mAdTemplate).status != 2 && e.dS(this.mAdTemplate).status != 3) {
            b bVar = this.cG;
            if ((bVar == null || !bVar.ar()) && (interfaceC0727a = this.cF) != null) {
                interfaceC0727a.aq();
            }
        }
    }

    @MainThread
    public final void a(b bVar) {
        this.cG = bVar;
    }
}
