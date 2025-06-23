package IXxxXO;

import XXO0.oIX0oI;

/* loaded from: classes.dex */
public class I0Io {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int[] f760II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final float[] f761oIX0oI;

    public I0Io(float[] fArr, int[] iArr) {
        this.f761oIX0oI = fArr;
        this.f760II0xO0 = iArr;
    }

    public int I0Io() {
        return this.f760II0xO0.length;
    }

    public float[] II0xO0() {
        return this.f761oIX0oI;
    }

    public int[] oIX0oI() {
        return this.f760II0xO0;
    }

    public void oxoX(I0Io i0Io, I0Io i0Io2, float f) {
        if (i0Io.f760II0xO0.length == i0Io2.f760II0xO0.length) {
            for (int i = 0; i < i0Io.f760II0xO0.length; i++) {
                this.f761oIX0oI[i] = IIXOooo.xxIXOIIO.OOXIXo(i0Io.f761oIX0oI[i], i0Io2.f761oIX0oI[i], f);
                this.f760II0xO0[i] = IIXOooo.oxoX.I0Io(f, i0Io.f760II0xO0[i], i0Io2.f760II0xO0[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + i0Io.f760II0xO0.length + " vs " + i0Io2.f760II0xO0.length + oIX0oI.I0Io.f4095I0Io);
    }
}
