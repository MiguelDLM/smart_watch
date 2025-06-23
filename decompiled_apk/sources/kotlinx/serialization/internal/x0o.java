package kotlinx.serialization.internal;

import java.util.Arrays;

@kotlin.o0
/* loaded from: classes6.dex */
public final class x0o extends I0<int[]> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f30747II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public int[] f30748oIX0oI;

    public x0o(@OXOo.OOXIXo int[] bufferWithData) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bufferWithData, "bufferWithData");
        this.f30748oIX0oI = bufferWithData;
        this.f30747II0xO0 = bufferWithData.length;
        II0xO0(10);
    }

    @Override // kotlinx.serialization.internal.I0
    public void II0xO0(int i) {
        int[] iArr = this.f30748oIX0oI;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, X0.IIXOooo.OxxIIOOXO(i, iArr.length * 2));
            kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
            this.f30748oIX0oI = copyOf;
        }
    }

    public final void X0o0xo(int i) {
        I0.I0Io(this, 0, 1, null);
        int[] iArr = this.f30748oIX0oI;
        int oxoX2 = oxoX();
        this.f30747II0xO0 = oxoX2 + 1;
        iArr[oxoX2] = i;
    }

    @Override // kotlinx.serialization.internal.I0
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public int[] oIX0oI() {
        int[] copyOf = Arrays.copyOf(this.f30748oIX0oI, oxoX());
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @Override // kotlinx.serialization.internal.I0
    public int oxoX() {
        return this.f30747II0xO0;
    }
}
