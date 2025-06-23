package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.X0o0xo;

@kotlin.o0
/* loaded from: classes6.dex */
public final class oOoXoXO implements kotlinx.serialization.Oxx0IOOO<Byte> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oOoXoXO f30733oIX0oI = new oOoXoXO();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30732II0xO0 = new xX0IIXIx0("kotlin.Byte", X0o0xo.II0xO0.f30589oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, ((Number) obj).byteValue());
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, byte b) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        encoder.encodeByte(b);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Byte oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return Byte.valueOf(decoder.decodeByte());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30732II0xO0;
    }
}
