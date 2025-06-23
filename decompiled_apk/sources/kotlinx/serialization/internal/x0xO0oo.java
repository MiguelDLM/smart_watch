package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.o0
/* loaded from: classes6.dex */
public final class x0xO0oo extends I0<char[]> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30751II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public char[] f30752oIX0oI;

    public x0xO0oo(@OXOo.OOXIXo char[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30752oIX0oI = bufferWithData;
        this.f30751II0xO0 = bufferWithData.length;
        II0xO0(10);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        char[] cArr = this.f30752oIX0oI;
        if (cArr.length < i) {
            char[] copyOf = Arrays.copyOf(cArr, X0.IIXOooo.OxxIIOOXO(i, cArr.length * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30752oIX0oI = copyOf;
        }
    }

    public final void X0o0xo(char c) {
        I0.I0Io(this, 0, 1, null);
        char[] cArr = this.f30752oIX0oI;
        int oxoX2 = oxoX();
        this.f30751II0xO0 = oxoX2 + 1;
        cArr[oxoX2] = c;
    }

    @Override // kotlinx.serialization.internal.I0
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public char[] oIX0oI() {
        char[] copyOf = Arrays.copyOf(this.f30752oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30751II0xO0;
    }
}
