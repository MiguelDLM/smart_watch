package com.kwad.sdk.pngencrypt.chunk;

import XXO0.oIX0oI;

/* loaded from: classes11.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k aMq;
    public final boolean aNq;
    public final boolean aNr;
    public final boolean aNs;
    protected d aNt;
    private boolean aNu = false;
    protected int aNv = -1;
    public final String ahY;

    /* loaded from: classes11.dex */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            if (this == BEFORE_IDAT) {
                if (i < 4) {
                    return true;
                }
                return false;
            }
            if (this == BEFORE_PLTE_AND_IDAT) {
                if (i < 2) {
                    return true;
                }
                return false;
            }
            if (this == AFTER_PLTE_BEFORE_IDAT) {
                if (z) {
                    if (i < 4) {
                        return true;
                    }
                    return false;
                }
                if (i < 4 && i > 2) {
                    return true;
                }
                return false;
            }
            if (this == AFTER_IDAT && i > 4) {
                return true;
            }
            return false;
        }

        public final boolean mustGoAfterIDAT() {
            if (this == AFTER_IDAT) {
                return true;
            }
            return false;
        }

        public final boolean mustGoAfterPLTE() {
            if (this != AFTER_PLTE_BEFORE_IDAT && this != AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED) {
                return false;
            }
            return true;
        }

        public final boolean mustGoBeforeIDAT() {
            if (this != BEFORE_IDAT && this != BEFORE_PLTE_AND_IDAT && this != AFTER_PLTE_BEFORE_IDAT) {
                return false;
            }
            return true;
        }

        public final boolean mustGoBeforePLTE() {
            if (this == BEFORE_PLTE_AND_IDAT) {
                return true;
            }
            return false;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.ahY = str;
        this.aMq = kVar;
        this.aNq = b.gs(str);
        this.aNr = b.gt(str);
        this.aNs = b.gu(str);
    }

    private long KU() {
        d dVar = this.aNt;
        if (dVar != null) {
            return dVar.KU();
        }
        return -1L;
    }

    private int KW() {
        d dVar = this.aNt;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    public abstract void a(d dVar);

    public final void b(d dVar) {
        this.aNt = dVar;
    }

    public final void dO(int i) {
        this.aNv = i;
    }

    public String toString() {
        return "chunk id= " + this.ahY + " (len=" + KW() + " offset=" + KU() + oIX0oI.I0Io.f4095I0Io;
    }
}
