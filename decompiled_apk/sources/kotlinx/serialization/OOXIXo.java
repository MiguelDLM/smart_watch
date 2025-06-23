package kotlinx.serialization;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;

/* loaded from: classes6.dex */
public final class OOXIXo {
    @OXOo.OOXIXo
    @XO
    public static final <T> Oxx0xo<T> II0xO0(@OXOo.OOXIXo kotlinx.serialization.internal.II0xO0<T> iI0xO0, @OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo T value) {
        IIX0o.x0xO0oo(iI0xO0, "<this>");
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        Oxx0xo<T> xxIXOIIO2 = iI0xO0.xxIXOIIO(encoder, value);
        if (xxIXOIIO2 != null) {
            return xxIXOIIO2;
        }
        kotlinx.serialization.internal.I0Io.II0xO0(IO.oxoX(value.getClass()), iI0xO0.xoIox());
        throw new KotlinNothingValueException();
    }

    @OXOo.OOXIXo
    @XO
    public static final <T> I0Io<T> oIX0oI(@OXOo.OOXIXo kotlinx.serialization.internal.II0xO0<T> iI0xO0, @OXOo.OOXIXo xIXoO0Xx.oxoX decoder, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(iI0xO0, "<this>");
        IIX0o.x0xO0oo(decoder, "decoder");
        I0Io<T> II0XooXoX2 = iI0xO0.II0XooXoX(decoder, str);
        if (II0XooXoX2 != null) {
            return II0XooXoX2;
        }
        kotlinx.serialization.internal.I0Io.oIX0oI(str, iI0xO0.xoIox());
        throw new KotlinNothingValueException();
    }
}
