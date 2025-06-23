package IXxxXO;

import IIXOooo.oxoX;
import IIXOooo.xxIXOIIO;
import XXO0.oIX0oI;

public class I0Io {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final int[] f37II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final float[] f38oIX0oI;

    public I0Io(float[] fArr, int[] iArr) {
        this.f38oIX0oI = fArr;
        this.f37II0xO0 = iArr;
    }

    public int I0Io() {
        return this.f37II0xO0.length;
    }

    public float[] II0xO0() {
        return this.f38oIX0oI;
    }

    public int[] oIX0oI() {
        return this.f37II0xO0;
    }

    public void oxoX(I0Io i0Io, I0Io i0Io2, float f) {
        if (i0Io.f37II0xO0.length == i0Io2.f37II0xO0.length) {
            for (int i = 0; i < i0Io.f37II0xO0.length; i++) {
                this.f38oIX0oI[i] = xxIXOIIO.OOXIXo(i0Io.f38oIX0oI[i], i0Io2.f38oIX0oI[i], f);
                this.f37II0xO0[i] = oxoX.I0Io(f, i0Io.f37II0xO0[i], i0Io2.f37II0xO0[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + i0Io.f37II0xO0.length + " vs " + i0Io2.f37II0xO0.length + oIX0oI.I0Io.f17331I0Io);
    }
}
