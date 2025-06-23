package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.o0
/* loaded from: classes6.dex */
public final class X0IIOO extends I0<double[]> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30692II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public double[] f30693oIX0oI;

    public X0IIOO(@OXOo.OOXIXo double[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30693oIX0oI = bufferWithData;
        this.f30692II0xO0 = bufferWithData.length;
        II0xO0(10);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        double[] dArr = this.f30693oIX0oI;
        if (dArr.length < i) {
            double[] copyOf = Arrays.copyOf(dArr, X0.IIXOooo.OxxIIOOXO(i, dArr.length * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30693oIX0oI = copyOf;
        }
    }

    public final void X0o0xo(double d) {
        I0.I0Io(this, 0, 1, null);
        double[] dArr = this.f30693oIX0oI;
        int oxoX2 = oxoX();
        this.f30692II0xO0 = oxoX2 + 1;
        dArr[oxoX2] = d;
    }

    @Override // kotlinx.serialization.internal.I0
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public double[] oIX0oI() {
        double[] copyOf = Arrays.copyOf(this.f30693oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30692II0xO0;
    }
}
