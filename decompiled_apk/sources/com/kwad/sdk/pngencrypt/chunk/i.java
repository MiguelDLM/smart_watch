package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* loaded from: classes11.dex */
public final class i extends p {
    private int aMb;
    private int aMc;
    private int aNA;
    private int aNw;
    private int aNx;
    private int aNy;
    private int aNz;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Lb();
        }
    }

    private int KD() {
        return this.aMb;
    }

    private int KE() {
        return this.aMc;
    }

    private int KX() {
        return this.aNw;
    }

    private int KY() {
        return this.aNx;
    }

    private int KZ() {
        return this.aNA;
    }

    private void Lb() {
        int i;
        dP(this.aMq.aMc);
        dQ(this.aMq.aMb);
        dR(this.aMq.aMu);
        com.kwad.sdk.pngencrypt.k kVar = this.aMq;
        if (kVar.aMw) {
            i = 4;
        } else {
            i = 0;
        }
        if (kVar.aMy) {
            i++;
        }
        if (!kVar.aMx) {
            i += 2;
        }
        dS(i);
        dT(0);
        dU(0);
        dV(0);
    }

    private void Ld() {
        if (this.aMc > 0 && this.aMb > 0 && this.aNy == 0 && this.aNz == 0) {
            int i = this.aNw;
            if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
            int i2 = this.aNA;
            if (i2 >= 0 && i2 <= 1) {
                int i3 = this.aNx;
                if (i3 != 0) {
                    if (i3 != 6 && i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new PngjException("bad IHDR: invalid colormodel");
                            }
                        } else {
                            if (i == 16) {
                                throw new PngjException("bad IHDR: bitdepth invalid");
                            }
                            return;
                        }
                    }
                    if (i != 8 && i != 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                }
                return;
            }
            throw new PngjException("bad IHDR: interlace invalid");
        }
        throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
    }

    private void dP(int i) {
        this.aMc = i;
    }

    private void dQ(int i) {
        this.aMb = i;
    }

    private void dR(int i) {
        this.aNw = i;
    }

    private void dS(int i) {
        this.aNx = i;
    }

    private void dT(int i) {
        this.aNy = 0;
    }

    private void dU(int i) {
        this.aNz = 0;
    }

    private void dV(int i) {
        this.aNA = 0;
    }

    public final boolean La() {
        if (KZ() == 1) {
            return true;
        }
        return false;
    }

    public final com.kwad.sdk.pngencrypt.k Lc() {
        boolean z;
        boolean z2;
        boolean z3;
        Ld();
        if ((KY() & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((KY() & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (KY() != 0 && KY() != 4) {
            z3 = false;
        } else {
            z3 = true;
        }
        return new com.kwad.sdk.pngencrypt.k(KE(), KD(), KX(), z, z3, z2);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 13) {
            ByteArrayInputStream KT = dVar.KT();
            this.aMc = com.kwad.sdk.pngencrypt.n.f(KT);
            this.aMb = com.kwad.sdk.pngencrypt.n.f(KT);
            this.aNw = com.kwad.sdk.pngencrypt.n.e(KT);
            this.aNx = com.kwad.sdk.pngencrypt.n.e(KT);
            this.aNy = com.kwad.sdk.pngencrypt.n.e(KT);
            this.aNz = com.kwad.sdk.pngencrypt.n.e(KT);
            this.aNA = com.kwad.sdk.pngencrypt.n.e(KT);
            return;
        }
        throw new PngjException("Bad IDHR len " + dVar.len);
    }
}
