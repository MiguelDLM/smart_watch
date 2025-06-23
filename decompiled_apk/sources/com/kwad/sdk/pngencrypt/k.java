package com.kwad.sdk.pngencrypt;

/* loaded from: classes11.dex */
public final class k {
    public final int aMA;
    public final int aMB;
    public final int aMC;
    public final int aMD;
    public final int aME;
    private long aMF = -1;
    private long aMG = -1;
    public final int aMb;
    public final int aMc;
    public final int aMu;
    public final int aMv;
    public final boolean aMw;
    public final boolean aMx;
    public final boolean aMy;
    public final boolean aMz;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        int i4;
        boolean z4;
        this.aMc = i;
        this.aMb = i2;
        this.aMw = z;
        this.aMy = z3;
        this.aMx = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        if (!z2 && !z3) {
            if (z) {
                i4 = 4;
            } else {
                i4 = 3;
            }
        } else if (z) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        this.aMv = i4;
        this.aMu = i3;
        if (i3 < 8) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.aMz = z4;
        int i5 = i4 * i3;
        this.aMA = i5;
        this.aMB = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.aMC = i6;
        int i7 = i4 * i;
        this.aMD = i7;
        this.aME = z4 ? i6 : i7;
        if (i3 != 1 && i3 != 2 && i3 != 4) {
            if (i3 != 8) {
                if (i3 == 16) {
                    if (z3) {
                        throw new PngjException("indexed can't have bitdepth=" + i3);
                    }
                } else {
                    throw new PngjException("invalid bitdepth=" + i3);
                }
            }
        } else if (!z3 && !z2) {
            throw new PngjException("only indexed or grayscale can have bitdepth=" + i3);
        }
        if (i > 0 && i <= 16777216) {
            if (i2 > 0 && i2 <= 16777216) {
                if (i7 > 0) {
                    return;
                } else {
                    throw new PngjException("invalid image parameters (overflow?)");
                }
            } else {
                throw new PngjException("invalid rows=" + i2 + " ???");
            }
        }
        throw new PngjException("invalid cols=" + i + " ???");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.aMw == kVar.aMw && this.aMu == kVar.aMu && this.aMc == kVar.aMc && this.aMx == kVar.aMx && this.aMy == kVar.aMy && this.aMb == kVar.aMb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3 = 1237;
        if (this.aMw) {
            i = 1231;
        } else {
            i = 1237;
        }
        int i4 = (((((i + 31) * 31) + this.aMu) * 31) + this.aMc) * 31;
        if (this.aMx) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        int i5 = (i4 + i2) * 31;
        if (this.aMy) {
            i3 = 1231;
        }
        return ((i5 + i3) * 31) + this.aMb;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.aMc + ", rows=" + this.aMb + ", bitDepth=" + this.aMu + ", channels=" + this.aMv + ", alpha=" + this.aMw + ", greyscale=" + this.aMx + ", indexed=" + this.aMy + "]";
    }
}
