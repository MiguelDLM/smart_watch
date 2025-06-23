package com.kwad.sdk.pngencrypt;

/* loaded from: classes11.dex */
public final class e {
    final k aLZ;
    private int aMb;
    private int aMc;
    int aMd;
    int aMe;
    int aMf;
    int aMg;
    int aMh;
    int aMi;
    private int aMa = 0;
    private int aMj = -1;
    private int aMk = -1;
    private int aMl = 0;
    private boolean aMn = false;
    int aMm = 0;

    public e(k kVar) {
        this.aLZ = kVar;
        dG(1);
        dF(0);
    }

    private int KF() {
        return KE();
    }

    private void dF(int i) {
        this.aMj = i;
        int i2 = (i * this.aMd) + this.aMf;
        this.aMk = i2;
        if (i2 >= 0 && i2 < this.aLZ.aMb) {
        } else {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void dG(int i) {
        int i2;
        int i3;
        if (this.aMa == i) {
            return;
        }
        this.aMa = i;
        byte[] dH = dH(i);
        byte b = dH[0];
        this.aMe = b;
        byte b2 = dH[1];
        this.aMd = b2;
        byte b3 = dH[2];
        this.aMg = b3;
        byte b4 = dH[3];
        this.aMf = b4;
        k kVar = this.aLZ;
        int i4 = kVar.aMb;
        if (i4 > b4) {
            i2 = (((i4 + b2) - 1) - b4) / b2;
        } else {
            i2 = 0;
        }
        this.aMb = i2;
        int i5 = kVar.aMc;
        if (i5 > b3) {
            i3 = (((i5 + b) - 1) - b3) / b;
        } else {
            i3 = 0;
        }
        this.aMc = i3;
        if (i3 == 0) {
            this.aMb = 0;
        }
        int i6 = kVar.aMv;
        this.aMi = b * i6;
        this.aMh = b3 * i6;
    }

    private static byte[] dH(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i);
        }
    }

    public final int KA() {
        return this.aMj;
    }

    public final int KB() {
        return this.aMk;
    }

    public final int KC() {
        return this.aMa;
    }

    public final int KD() {
        return this.aMb;
    }

    public final int KE() {
        return this.aMc;
    }

    public final int KG() {
        return ((this.aLZ.aMA * KF()) + 7) / 8;
    }

    public final boolean Kz() {
        int i;
        while (true) {
            this.aMl++;
            int i2 = this.aMb;
            if (i2 != 0 && (i = this.aMj) < i2 - 1) {
                dF(i + 1);
                break;
            }
            int i3 = this.aMa;
            if (i3 == 7) {
                this.aMn = true;
                return false;
            }
            dG(i3 + 1);
            if (this.aMb == 0) {
                this.aMl--;
            } else {
                dF(0);
                break;
            }
        }
        return true;
    }
}
