package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class xxOXOOoIX implements kotlinx.serialization.Oxx0IOOO<kotlin.OX00O0xII> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xxOXOOoIX f30775oIX0oI = new xxOXOOoIX();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30774II0xO0 = xII.oIX0oI("kotlin.UShort", xx.oOoXoXO.oo0xXOI0I(kotlin.jvm.internal.OI0.f29295oIX0oI));

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, ((kotlin.OX00O0xII) obj).I0oOIX());
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, short s) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        encoder.encodeInline(oIX0oI()).encodeShort(s);
    }

    public short XO(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return kotlin.OX00O0xII.oOoXoXO(decoder.decodeInline(oIX0oI()).decodeShort());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30774II0xO0;
    }

    @Override // kotlinx.serialization.I0Io
    public /* bridge */ /* synthetic */ Object oxoX(xIXoO0Xx.XO xo2) {
        return kotlin.OX00O0xII.oxoX(XO(xo2));
    }
}
