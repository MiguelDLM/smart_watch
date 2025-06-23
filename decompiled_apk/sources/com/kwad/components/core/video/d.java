package com.kwad.components.core.video;

/* loaded from: classes11.dex */
public final class d {
    private boolean Vn = false;
    private boolean Vo = false;
    private boolean Vp = false;
    private boolean Vq = false;
    private boolean Vr = false;
    private int Vs = -1;

    public final void aN(int i) {
        this.Vs = i;
    }

    public final void aR(boolean z) {
        this.Vp = z;
    }

    public final void setAd(boolean z) {
        this.Vo = z;
    }

    public final void setFillXY(boolean z) {
        this.Vr = z;
    }

    public final void setForce(boolean z) {
        this.Vn = z;
    }

    public final void setHorizontalVideo(boolean z) {
        this.Vq = z;
    }

    public final boolean sf() {
        if (this.Vs > 0) {
            return true;
        }
        return false;
    }

    public final int sg() {
        return this.Vs;
    }

    public final boolean sh() {
        return this.Vn;
    }

    public final boolean si() {
        return this.Vo;
    }

    public final boolean sj() {
        return this.Vp;
    }

    public final boolean sk() {
        return this.Vq;
    }

    public final boolean sl() {
        return this.Vr;
    }
}
