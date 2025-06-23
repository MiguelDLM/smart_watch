package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* loaded from: classes11.dex */
public final class j extends DeflatedChunksSet {
    protected final e aLu;
    protected byte[] aMo;
    protected byte[] aMp;
    protected final k aMq;
    final p aMr;
    protected int[] aMs;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aMt;

        static {
            int[] iArr = new int[FilterType.values().length];
            aMt = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aMt[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aMt[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aMt[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aMt[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    private void KH() {
        dI(this.aMr.aMY);
    }

    private int KI() {
        int KG;
        e eVar = this.aLu;
        int i = 0;
        if (eVar == null) {
            int Ky = Ky();
            k kVar = this.aMq;
            if (Ky < kVar.aMb - 1) {
                KG = kVar.aMC;
                i = KG + 1;
            }
        } else if (eVar.Kz()) {
            KG = this.aLu.KG();
            i = KG + 1;
        }
        if (!this.aLx) {
            dE(i);
        }
        return i;
    }

    private void dI(int i) {
        byte[] bArr = this.aMo;
        if (bArr == null || bArr.length < this.aLN.length) {
            byte[] bArr2 = this.aLN;
            this.aMo = new byte[bArr2.length];
            this.aMp = new byte[bArr2.length];
        }
        if (this.aMr.aMV == 0) {
            Arrays.fill(this.aMo, (byte) 0);
        }
        byte[] bArr3 = this.aMo;
        this.aMo = this.aMp;
        this.aMp = bArr3;
        byte b = this.aLN[0];
        if (FilterType.isValidStandard(b)) {
            FilterType byVal = FilterType.getByVal(b);
            int[] iArr = this.aMs;
            iArr[b] = iArr[b] + 1;
            this.aMo[0] = this.aLN[0];
            int i2 = AnonymousClass1.aMt[byVal.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                dL(i);
                                return;
                            }
                            throw new PngjException("Filter type " + ((int) b) + " not implemented");
                        }
                        dJ(i);
                        return;
                    }
                    dN(i);
                    return;
                }
                dM(i);
                return;
            }
            dK(i);
            return;
        }
        throw new PngjException("Filter type " + ((int) b) + " invalid");
    }

    private void dJ(int i) {
        int i2;
        int i3 = 1;
        int i4 = 1 - this.aMq.aMB;
        while (i3 <= i) {
            if (i4 > 0) {
                i2 = this.aMo[i4] & 255;
            } else {
                i2 = 0;
            }
            this.aMo[i3] = (byte) (this.aLN[i3] + ((i2 + (this.aMp[i3] & 255)) / 2));
            i3++;
            i4++;
        }
    }

    private void dK(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aMo[i2] = this.aLN[i2];
        }
    }

    private void dL(int i) {
        int i2;
        int i3 = 1;
        int i4 = 1 - this.aMq.aMB;
        while (i3 <= i) {
            int i5 = 0;
            if (i4 > 0) {
                i2 = this.aMo[i4] & 255;
            } else {
                i2 = 0;
            }
            if (i4 > 0) {
                i5 = this.aMp[i4] & 255;
            }
            this.aMo[i3] = (byte) (this.aLN[i3] + n.b(i2, this.aMp[i3] & 255, i5));
            i3++;
            i4++;
        }
    }

    private void dM(int i) {
        int i2;
        int i3 = 1;
        while (true) {
            i2 = this.aMq.aMB;
            if (i3 > i2) {
                break;
            }
            this.aMo[i3] = this.aLN[i3];
            i3++;
        }
        int i4 = i2 + 1;
        int i5 = 1;
        while (i4 <= i) {
            byte[] bArr = this.aMo;
            bArr[i4] = (byte) (this.aLN[i4] + bArr[i5]);
            i4++;
            i5++;
        }
    }

    private void dN(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aMo[i2] = (byte) (this.aLN[i2] + this.aMp[i2]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void Kv() {
        super.Kv();
        this.aMr.update(Ky());
        KH();
        p pVar = this.aMr;
        pVar.h(this.aMo, pVar.aMY + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final int Kw() {
        return KI();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aMo = null;
        this.aMp = null;
    }

    private j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.KG() : kVar.aMC) + 1, kVar.aMC + 1, null, null);
        this.aMs = new int[5];
        this.aMq = kVar;
        this.aLu = eVar;
        this.aMr = new p(kVar, eVar);
        com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", "Creating IDAT set ");
    }
}
