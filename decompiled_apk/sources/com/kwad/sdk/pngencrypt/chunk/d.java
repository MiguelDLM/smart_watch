package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* loaded from: classes11.dex */
public final class d {
    public final byte[] aNh;
    private CRC32 aNk;
    public final String ahY;
    public final int len;
    public byte[] data = null;
    private long aNi = 0;
    public byte[] aNj = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.ahY = str;
        this.aNh = b.gr(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = this.aNh[i2];
            if (b < 65 || b > 122 || (b > 90 && b < 97)) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            KS();
        }
    }

    private void KS() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final ByteArrayInputStream KT() {
        return new ByteArrayInputStream(this.data);
    }

    public final long KU() {
        return this.aNi;
    }

    public final void aK(long j) {
        this.aNi = j;
    }

    public final void bI(boolean z) {
        int value = (int) this.aNk.getValue();
        int g = com.kwad.sdk.pngencrypt.n.g(this.aNj, 0);
        if (value != g) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.ahY, Long.valueOf(this.aNi), Integer.valueOf(g), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(format));
            } else {
                com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", format);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.ahY;
        if (str == null) {
            if (dVar.ahY != null) {
                return false;
            }
        } else if (!str.equals(dVar.ahY)) {
            return false;
        }
        if (this.aNi == dVar.aNi) {
            return true;
        }
        return false;
    }

    public final void f(byte[] bArr, int i, int i2) {
        if (this.aNk == null) {
            this.aNk = new CRC32();
        }
        this.aNk.update(bArr, i, i2);
    }

    public final int hashCode() {
        int hashCode;
        String str = this.ahY;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j = this.aNi;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.aNh) + " len=" + this.len;
    }
}
