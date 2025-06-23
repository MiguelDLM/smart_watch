package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.X0o0xo;

@kotlin.o0
/* loaded from: classes6.dex */
public final class Xo0 implements kotlinx.serialization.Oxx0IOOO<Long> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Xo0 f30710oIX0oI = new Xo0();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30709II0xO0 = new xX0IIXIx0("kotlin.Long", X0o0xo.Oxx0IOOO.f30590oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, ((Number) obj).longValue());
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        encoder.encodeLong(j);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Long oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return Long.valueOf(decoder.decodeLong());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30709II0xO0;
    }
}
