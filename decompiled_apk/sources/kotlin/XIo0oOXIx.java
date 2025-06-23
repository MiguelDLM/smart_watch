package kotlin;

/* loaded from: classes6.dex */
public final class XIo0oOXIx {
    @oI0IIXIo
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final byte[] II0xO0(byte... elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return elements;
    }

    @oI0IIXIo
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final byte[] oIX0oI(int i, Oox.oOoXoXO<? super Integer, x0xO> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = init.invoke(Integer.valueOf(i2)).I0oOIX();
        }
        return OO0x0xX.X0o0xo(bArr);
    }
}
