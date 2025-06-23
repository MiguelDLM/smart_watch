package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlinx.serialization.oxoX
@kotlin.oI0IIXIo
@kotlin.o0
/* loaded from: classes6.dex */
public final class O0IxXx extends I0<kotlin.xX0IIXIx0> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30644II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public short[] f30645oIX0oI;

    public /* synthetic */ O0IxXx(short[] sArr, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(sArr);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        if (kotlin.xX0IIXIx0.ooOOo0oXI(this.f30645oIX0oI) < i) {
            short[] sArr = this.f30645oIX0oI;
            short[] copyOf = Arrays.copyOf(sArr, X0.IIXOooo.OxxIIOOXO(i, kotlin.xX0IIXIx0.ooOOo0oXI(sArr) * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30645oIX0oI = kotlin.xX0IIXIx0.X0o0xo(copyOf);
        }
    }

    public final void X0o0xo(short s) {
        I0.I0Io(this, 0, 1, null);
        short[] sArr = this.f30645oIX0oI;
        int oxoX2 = oxoX();
        this.f30644II0xO0 = oxoX2 + 1;
        kotlin.xX0IIXIx0.IXxxXO(sArr, oxoX2, s);
    }

    @OXOo.OOXIXo
    public short[] XO() {
        short[] copyOf = Arrays.copyOf(this.f30645oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return kotlin.xX0IIXIx0.X0o0xo(copyOf);
    }

    @Override // kotlinx.serialization.internal.I0
    public /* bridge */ /* synthetic */ kotlin.xX0IIXIx0 oIX0oI() {
        return kotlin.xX0IIXIx0.II0xO0(XO());
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30644II0xO0;
    }

    public O0IxXx(short[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30645oIX0oI = bufferWithData;
        this.f30644II0xO0 = kotlin.xX0IIXIx0.ooOOo0oXI(bufferWithData);
        II0xO0(10);
    }
}
