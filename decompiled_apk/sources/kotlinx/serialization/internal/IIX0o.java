package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.o0
/* loaded from: classes6.dex */
public final class IIX0o extends I0<float[]> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30626II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public float[] f30627oIX0oI;

    public IIX0o(@OXOo.OOXIXo float[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30627oIX0oI = bufferWithData;
        this.f30626II0xO0 = bufferWithData.length;
        II0xO0(10);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        float[] fArr = this.f30627oIX0oI;
        if (fArr.length < i) {
            float[] copyOf = Arrays.copyOf(fArr, X0.IIXOooo.OxxIIOOXO(i, fArr.length * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30627oIX0oI = copyOf;
        }
    }

    public final void X0o0xo(float f) {
        I0.I0Io(this, 0, 1, null);
        float[] fArr = this.f30627oIX0oI;
        int oxoX2 = oxoX();
        this.f30626II0xO0 = oxoX2 + 1;
        fArr[oxoX2] = f;
    }

    @Override // kotlinx.serialization.internal.I0
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public float[] oIX0oI() {
        float[] copyOf = Arrays.copyOf(this.f30627oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30626II0xO0;
    }
}
