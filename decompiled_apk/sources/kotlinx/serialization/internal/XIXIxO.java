package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlinx.serialization.oxoX
@kotlin.oI0IIXIo
@kotlin.o0
/* loaded from: classes6.dex */
public final class XIXIxO extends I0<kotlin.OO0x0xX> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30697II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public byte[] f30698oIX0oI;

    public /* synthetic */ XIXIxO(byte[] bArr, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(bArr);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        if (kotlin.OO0x0xX.ooOOo0oXI(this.f30698oIX0oI) < i) {
            byte[] bArr = this.f30698oIX0oI;
            byte[] copyOf = Arrays.copyOf(bArr, X0.IIXOooo.OxxIIOOXO(i, kotlin.OO0x0xX.ooOOo0oXI(bArr) * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30698oIX0oI = kotlin.OO0x0xX.X0o0xo(copyOf);
        }
    }

    public final void X0o0xo(byte b) {
        I0.I0Io(this, 0, 1, null);
        byte[] bArr = this.f30698oIX0oI;
        int oxoX2 = oxoX();
        this.f30697II0xO0 = oxoX2 + 1;
        kotlin.OO0x0xX.IXxxXO(bArr, oxoX2, b);
    }

    @OXOo.OOXIXo
    public byte[] XO() {
        byte[] copyOf = Arrays.copyOf(this.f30698oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return kotlin.OO0x0xX.X0o0xo(copyOf);
    }

    @Override // kotlinx.serialization.internal.I0
    public /* bridge */ /* synthetic */ kotlin.OO0x0xX oIX0oI() {
        return kotlin.OO0x0xX.II0xO0(XO());
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30697II0xO0;
    }

    public XIXIxO(byte[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30698oIX0oI = bufferWithData;
        this.f30697II0xO0 = kotlin.OO0x0xX.ooOOo0oXI(bufferWithData);
        II0xO0(10);
    }
}
