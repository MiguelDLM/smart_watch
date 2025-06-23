package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes11.dex */
public class DeflatedChunksSet {
    protected byte[] aLN;
    private int aLO;
    private int aLP;
    private int aLQ;
    State aLR;
    private final boolean aLS;
    private d aLT;
    private long aLU;
    private long aLV;
    int aLW;
    int aLX;
    public final String aLY;
    protected final boolean aLx;
    private Inflater inf;

    /* loaded from: classes11.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            if (this == CLOSED) {
                return true;
            }
            return false;
        }

        public final boolean isDone() {
            if (this != DONE && this != CLOSED) {
                return false;
            }
            return true;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        State state = State.WAITING_FOR_INPUT;
        this.aLR = state;
        this.aLU = 0L;
        this.aLV = 0L;
        this.aLW = -1;
        this.aLX = -1;
        this.aLY = str;
        this.aLx = z;
        this.aLP = i;
        if (i > 0 && i2 >= i) {
            if (inflater != null) {
                this.inf = inflater;
                this.aLS = false;
            } else {
                this.inf = new Inflater();
                this.aLS = true;
            }
            this.aLN = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
            this.aLQ = -1;
            this.aLR = state;
            try {
                dE(i);
                return;
            } catch (RuntimeException e) {
                close();
                throw e;
            }
        }
        throw new PngjException("bad inital row len " + i);
    }

    private boolean Ku() {
        State state;
        int i;
        try {
            if (this.aLR == State.ROW_READY) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("invalid state"));
            }
            if (this.aLR.isDone()) {
                return false;
            }
            byte[] bArr = this.aLN;
            if (bArr == null || bArr.length < this.aLP) {
                this.aLN = new byte[this.aLP];
            }
            if (this.aLO < this.aLP && !this.inf.finished()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr2 = this.aLN;
                    int i2 = this.aLO;
                    i = inflater.inflate(bArr2, i2, this.aLP - i2);
                } catch (DataFormatException e) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("error decompressing zlib stream ", e));
                    i = 0;
                }
                this.aLO += i;
                this.aLV += i;
            }
            if (this.aLO == this.aLP) {
                state = State.ROW_READY;
            } else if (!this.inf.finished()) {
                state = State.WAITING_FOR_INPUT;
            } else if (this.aLO > 0) {
                state = State.ROW_READY;
            } else {
                state = State.DONE;
            }
            this.aLR = state;
            if (state != State.ROW_READY) {
                return false;
            }
            Kv();
            return true;
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    public void Kv() {
    }

    public int Kw() {
        throw new PngjException("not implemented");
    }

    public final void Kx() {
        if (!isDone()) {
            this.aLR = State.DONE;
        }
    }

    public final int Ky() {
        return this.aLQ;
    }

    public final void a(d dVar) {
        if (!this.aLY.equals(dVar.Kh().ahY)) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.Kh().ahY + ", expected:" + this.aLY));
        }
        this.aLT = dVar;
        int i = this.aLW + 1;
        this.aLW = i;
        int i2 = this.aLX;
        if (i2 >= 0) {
            dVar.dD(i + i2);
        }
    }

    public final void c(byte[] bArr, int i, int i2) {
        this.aLU += i2;
        if (i2 > 0 && !this.aLR.isDone()) {
            if (this.aLR == State.ROW_READY) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
            }
            if (!this.inf.needsDictionary() && this.inf.needsInput()) {
                this.inf.setInput(bArr, i, i2);
                if (this.aLx) {
                    while (Ku()) {
                        dE(Kw());
                        isDone();
                    }
                    return;
                }
                Ku();
                return;
            }
            throw new RuntimeException("should not happen");
        }
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.aLR.isClosed()) {
                this.aLR = State.CLOSED;
            }
            if (this.aLS && (inflater = this.inf) != null) {
                inflater.end();
                this.inf = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void dE(int i) {
        this.aLO = 0;
        this.aLQ++;
        if (i <= 0) {
            this.aLP = 0;
            Kx();
        } else {
            if (this.inf.finished()) {
                this.aLP = 0;
                Kx();
                return;
            }
            this.aLR = State.WAITING_FOR_INPUT;
            this.aLP = i;
            if (!this.aLx) {
                Ku();
            }
        }
    }

    public final boolean gq(String str) {
        if (this.aLR.isClosed()) {
            return false;
        }
        if (str.equals(this.aLY)) {
            return true;
        }
        if (this.aLR.isDone()) {
            if (!this.aLR.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.aLY + " set is not done");
    }

    public final boolean isClosed() {
        return this.aLR.isClosed();
    }

    public final boolean isDone() {
        return this.aLR.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.aLT.Kh().ahY + " state=" + this.aLR + " rows=" + this.aLQ + " bytes=" + this.aLU + "/" + this.aLV).toString();
    }
}
