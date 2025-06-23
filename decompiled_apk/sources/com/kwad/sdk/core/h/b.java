package com.kwad.sdk.core.h;

/* loaded from: classes11.dex */
public abstract class b implements c {
    private boolean aEV = false;
    private boolean MK = false;
    private boolean ML = false;

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.aEV = true;
        if (!this.ML) {
            ah();
            this.ML = true;
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        if (this.aEV && !this.MK) {
            ai();
            this.MK = true;
        }
    }

    public abstract void ah();

    public abstract void ai();
}
