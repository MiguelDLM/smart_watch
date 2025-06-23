package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.X0o0xo;

@kotlin.o0
/* loaded from: classes6.dex */
public final class xI0oxI00 implements kotlinx.serialization.Oxx0IOOO<String> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xI0oxI00 f30756oIX0oI = new xI0oxI00();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30755II0xO0 = new xX0IIXIx0("kotlin.String", X0o0xo.xxIXOIIO.f30595oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo String value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        encoder.encodeString(value);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public String oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return decoder.decodeString();
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30755II0xO0;
    }
}
