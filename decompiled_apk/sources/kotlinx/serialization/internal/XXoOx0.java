package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlinx.serialization.oxoX
@kotlin.oI0IIXIo
@kotlin.o0
/* loaded from: classes6.dex */
public final class XXoOx0 extends I0<kotlin.XX0xXo> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30707II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public int[] f30708oIX0oI;

    public /* synthetic */ XXoOx0(int[] iArr, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(iArr);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        if (kotlin.XX0xXo.ooOOo0oXI(this.f30708oIX0oI) < i) {
            int[] iArr = this.f30708oIX0oI;
            int[] copyOf = Arrays.copyOf(iArr, X0.IIXOooo.OxxIIOOXO(i, kotlin.XX0xXo.ooOOo0oXI(iArr) * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30708oIX0oI = kotlin.XX0xXo.X0o0xo(copyOf);
        }
    }

    public final void X0o0xo(int i) {
        I0.I0Io(this, 0, 1, null);
        int[] iArr = this.f30708oIX0oI;
        int oxoX2 = oxoX();
        this.f30707II0xO0 = oxoX2 + 1;
        kotlin.XX0xXo.IXxxXO(iArr, oxoX2, i);
    }

    @OXOo.OOXIXo
    public int[] XO() {
        int[] copyOf = Arrays.copyOf(this.f30708oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return kotlin.XX0xXo.X0o0xo(copyOf);
    }

    @Override // kotlinx.serialization.internal.I0
    public /* bridge */ /* synthetic */ kotlin.XX0xXo oIX0oI() {
        return kotlin.XX0xXo.II0xO0(XO());
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30707II0xO0;
    }

    public XXoOx0(int[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30708oIX0oI = bufferWithData;
        this.f30707II0xO0 = kotlin.XX0xXo.ooOOo0oXI(bufferWithData);
        II0xO0(10);
    }
}
