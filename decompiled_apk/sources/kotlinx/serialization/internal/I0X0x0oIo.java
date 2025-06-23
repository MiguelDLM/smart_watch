package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.o0
/* loaded from: classes6.dex */
public final class I0X0x0oIo extends I0<long[]> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30621II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public long[] f30622oIX0oI;

    public I0X0x0oIo(@OXOo.OOXIXo long[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30622oIX0oI = bufferWithData;
        this.f30621II0xO0 = bufferWithData.length;
        II0xO0(10);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        long[] jArr = this.f30622oIX0oI;
        if (jArr.length < i) {
            long[] copyOf = Arrays.copyOf(jArr, X0.IIXOooo.OxxIIOOXO(i, jArr.length * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30622oIX0oI = copyOf;
        }
    }

    public final void X0o0xo(long j) {
        I0.I0Io(this, 0, 1, null);
        long[] jArr = this.f30622oIX0oI;
        int oxoX2 = oxoX();
        this.f30621II0xO0 = oxoX2 + 1;
        jArr[oxoX2] = j;
    }

    @Override // kotlinx.serialization.internal.I0
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public long[] oIX0oI() {
        long[] copyOf = Arrays.copyOf(this.f30622oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30621II0xO0;
    }
}
