package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.o0
/* loaded from: classes6.dex */
public final class xOoOIoI extends I0<short[]> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30759II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public short[] f30760oIX0oI;

    public xOoOIoI(@OXOo.OOXIXo short[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30760oIX0oI = bufferWithData;
        this.f30759II0xO0 = bufferWithData.length;
        II0xO0(10);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        short[] sArr = this.f30760oIX0oI;
        if (sArr.length < i) {
            short[] copyOf = Arrays.copyOf(sArr, X0.IIXOooo.OxxIIOOXO(i, sArr.length * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30760oIX0oI = copyOf;
        }
    }

    public final void X0o0xo(short s) {
        I0.I0Io(this, 0, 1, null);
        short[] sArr = this.f30760oIX0oI;
        int oxoX2 = oxoX();
        this.f30759II0xO0 = oxoX2 + 1;
        sArr[oxoX2] = s;
    }

    @Override // kotlinx.serialization.internal.I0
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public short[] oIX0oI() {
        short[] copyOf = Arrays.copyOf(this.f30760oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30759II0xO0;
    }
}
