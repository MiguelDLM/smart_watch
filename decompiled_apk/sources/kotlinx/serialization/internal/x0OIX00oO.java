package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class x0OIX00oO implements kotlinx.serialization.Oxx0IOOO<kotlin.x0xO> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0OIX00oO f30746oIX0oI = new x0OIX00oO();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30745II0xO0 = xII.oIX0oI("kotlin.UByte", xx.oOoXoXO.xxX(kotlin.jvm.internal.x0XOIxOo.f29360oIX0oI));

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, ((kotlin.x0xO) obj).I0oOIX());
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, byte b) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        encoder.encodeInline(oIX0oI()).encodeByte(b);
    }

    public byte XO(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return kotlin.x0xO.oOoXoXO(decoder.decodeInline(oIX0oI()).decodeByte());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30745II0xO0;
    }

    @Override // kotlinx.serialization.I0Io
    public /* bridge */ /* synthetic */ Object oxoX(xIXoO0Xx.XO xo2) {
        return kotlin.x0xO.oxoX(XO(xo2));
    }
}
