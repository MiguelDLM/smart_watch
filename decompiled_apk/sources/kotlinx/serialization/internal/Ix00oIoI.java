package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class Ix00oIoI implements kotlinx.serialization.Oxx0IOOO<kotlin.XI0oooXX> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Ix00oIoI f30638oIX0oI = new Ix00oIoI();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30637II0xO0 = xII.oIX0oI("kotlin.ULong", xx.oOoXoXO.xI(kotlin.jvm.internal.oo0xXOI0I.f29344oIX0oI));

    @Override // kotlinx.serialization.Oxx0xo
    public /* bridge */ /* synthetic */ void II0xO0(xIXoO0Xx.II0XooXoX iI0XooXoX, Object obj) {
        Oxx0IOOO(iI0XooXoX, ((kotlin.XI0oooXX) obj).OO());
    }

    public void Oxx0IOOO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        encoder.encodeInline(oIX0oI()).encodeLong(j);
    }

    public long XO(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        return kotlin.XI0oooXX.oOoXoXO(decoder.decodeInline(oIX0oI()).decodeLong());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30637II0xO0;
    }

    @Override // kotlinx.serialization.I0Io
    public /* bridge */ /* synthetic */ Object oxoX(xIXoO0Xx.XO xo2) {
        return kotlin.XI0oooXX.oxoX(XO(xo2));
    }
}
