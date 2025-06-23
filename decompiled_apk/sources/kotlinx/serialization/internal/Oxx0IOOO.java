package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.o0
/* loaded from: classes6.dex */
public final class Oxx0IOOO extends I0<boolean[]> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30662II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public boolean[] f30663oIX0oI;

    public Oxx0IOOO(@OXOo.OOXIXo boolean[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30663oIX0oI = bufferWithData;
        this.f30662II0xO0 = bufferWithData.length;
        II0xO0(10);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        boolean[] zArr = this.f30663oIX0oI;
        if (zArr.length < i) {
            boolean[] copyOf = Arrays.copyOf(zArr, X0.IIXOooo.OxxIIOOXO(i, zArr.length * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30663oIX0oI = copyOf;
        }
    }

    public final void X0o0xo(boolean z) {
        I0.I0Io(this, 0, 1, null);
        boolean[] zArr = this.f30663oIX0oI;
        int oxoX2 = oxoX();
        this.f30662II0xO0 = oxoX2 + 1;
        zArr[oxoX2] = z;
    }

    @Override // kotlinx.serialization.internal.I0
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public boolean[] oIX0oI() {
        boolean[] copyOf = Arrays.copyOf(this.f30663oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30662II0xO0;
    }
}
