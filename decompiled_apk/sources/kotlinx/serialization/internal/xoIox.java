package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.o0
/* loaded from: classes6.dex */
public final class xoIox extends I0<byte[]> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30766II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public byte[] f30767oIX0oI;

    public xoIox(@OXOo.OOXIXo byte[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30767oIX0oI = bufferWithData;
        this.f30766II0xO0 = bufferWithData.length;
        II0xO0(10);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        byte[] bArr = this.f30767oIX0oI;
        if (bArr.length < i) {
            byte[] copyOf = Arrays.copyOf(bArr, X0.IIXOooo.OxxIIOOXO(i, bArr.length * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30767oIX0oI = copyOf;
        }
    }

    public final void X0o0xo(byte b) {
        I0.I0Io(this, 0, 1, null);
        byte[] bArr = this.f30767oIX0oI;
        int oxoX2 = oxoX();
        this.f30766II0xO0 = oxoX2 + 1;
        bArr[oxoX2] = b;
    }

    @Override // kotlinx.serialization.internal.I0
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public byte[] oIX0oI() {
        byte[] copyOf = Arrays.copyOf(this.f30767oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30766II0xO0;
    }
}
