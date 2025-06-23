package com.kwad.sdk.pngencrypt;

/* loaded from: classes11.dex */
final class p {
    public final e aLu;
    public final boolean aMS;
    int aMT;
    int aMU;
    int aMV;
    int aMW;
    int aMX;
    int aMY;
    int aMZ;
    int aMa;
    int aMd;
    int aMe;
    int aMf;
    int aMg;
    public final k aMq;
    byte[] buf;

    public p(k kVar, e eVar) {
        boolean z;
        this.aMq = kVar;
        this.aLu = eVar;
        if (eVar != null) {
            z = true;
        } else {
            z = false;
        }
        this.aMS = z;
    }

    public final void h(byte[] bArr, int i) {
        this.buf = bArr;
        this.aMZ = i;
    }

    public final void update(int i) {
        this.aMT = i;
        if (this.aMS) {
            this.aMa = this.aLu.KC();
            e eVar = this.aLu;
            this.aMe = eVar.aMe;
            this.aMd = eVar.aMd;
            this.aMg = eVar.aMg;
            this.aMf = eVar.aMf;
            this.aMU = eVar.KB();
            this.aMV = this.aLu.KA();
            this.aMW = this.aLu.KD();
            int KE = this.aLu.KE();
            this.aMX = KE;
            this.aMY = ((this.aMq.aMA * KE) + 7) / 8;
            return;
        }
        this.aMa = 1;
        this.aMd = 1;
        this.aMe = 1;
        this.aMf = 0;
        this.aMg = 0;
        this.aMV = i;
        this.aMU = i;
        k kVar = this.aMq;
        this.aMW = kVar.aMb;
        this.aMX = kVar.aMc;
        this.aMY = kVar.aMC;
    }
}
