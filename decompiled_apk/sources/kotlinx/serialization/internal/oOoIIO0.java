package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class oOoIIO0 implements kotlinx.serialization.Oxx0IOOO<kotlin.xxIO> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oOoIIO0 f30731oIX0oI = new oOoIIO0();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30730II0xO0 = xII.oIX0oI("kotlin.UInt", xx.oOoXoXO.ooXIXxIX(kotlin.jvm.internal.XxX0x0xxx.f29326oIX0oI));

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, ((kotlin.xxIO) obj).OO());
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        encoder.encodeInline(oIX0oI()).encodeInt(i);
    }

    public int XO(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return kotlin.xxIO.oOoXoXO(decoder.decodeInline(oIX0oI()).decodeInt());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30730II0xO0;
    }

    @Override // kotlinx.serialization.I0Io
    public /* bridge */ /* synthetic */ Object oxoX(xIXoO0Xx.XO xo2) {
        return kotlin.xxIO.oxoX(XO(xo2));
    }
}
