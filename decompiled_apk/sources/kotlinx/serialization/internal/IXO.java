package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlinx.serialization.oxoX
@kotlin.oI0IIXIo
@kotlin.o0
/* loaded from: classes6.dex */
public final class IXO extends I0<kotlin.OOXIxO0> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30631II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public long[] f30632oIX0oI;

    public /* synthetic */ IXO(long[] jArr, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(jArr);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        if (kotlin.OOXIxO0.ooOOo0oXI(this.f30632oIX0oI) < i) {
            long[] jArr = this.f30632oIX0oI;
            long[] copyOf = Arrays.copyOf(jArr, X0.IIXOooo.OxxIIOOXO(i, kotlin.OOXIxO0.ooOOo0oXI(jArr) * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30632oIX0oI = kotlin.OOXIxO0.X0o0xo(copyOf);
        }
    }

    public final void X0o0xo(long j) {
        I0.I0Io(this, 0, 1, null);
        long[] jArr = this.f30632oIX0oI;
        int oxoX2 = oxoX();
        this.f30631II0xO0 = oxoX2 + 1;
        kotlin.OOXIxO0.IXxxXO(jArr, oxoX2, j);
    }

    @OXOo.OOXIXo
    public long[] XO() {
        long[] copyOf = Arrays.copyOf(this.f30632oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return kotlin.OOXIxO0.X0o0xo(copyOf);
    }

    @Override // kotlinx.serialization.internal.I0
    public /* bridge */ /* synthetic */ kotlin.OOXIxO0 oIX0oI() {
        return kotlin.OOXIxO0.II0xO0(XO());
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30631II0xO0;
    }

    public IXO(long[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30632oIX0oI = bufferWithData;
        this.f30631II0xO0 = kotlin.OOXIxO0.ooOOo0oXI(bufferWithData);
        II0xO0(10);
    }
}
