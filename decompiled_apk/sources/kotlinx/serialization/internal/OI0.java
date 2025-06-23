package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.X0o0xo;

@kotlin.o0
/* loaded from: classes6.dex */
public final class OI0 implements kotlinx.serialization.Oxx0IOOO<Integer> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OI0 f30649oIX0oI = new OI0();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30648II0xO0 = new xX0IIXIx0("kotlin.Int", X0o0xo.XO.f30592oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, ((Number) obj).intValue());
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        encoder.encodeInt(i);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Integer oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return Integer.valueOf(decoder.decodeInt());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30648II0xO0;
    }
}
