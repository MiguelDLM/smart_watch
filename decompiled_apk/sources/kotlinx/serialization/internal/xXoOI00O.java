package kotlinx.serialization.internal;

@kotlin.o0
/* loaded from: classes6.dex */
public final class xXoOI00O implements kotlinx.serialization.Oxx0IOOO<kotlin.oXIO0o0XI> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xXoOI00O f30764II0xO0 = new xXoOI00O();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ ObjectSerializer<kotlin.oXIO0o0XI> f30765oIX0oI = new ObjectSerializer<>("kotlin.Unit", kotlin.oXIO0o0XI.f29392oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo kotlin.oXIO0o0XI value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f30765oIX0oI.II0xO0(encoder, value);
    }

    public void XO(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        this.f30765oIX0oI.oxoX(decoder);
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return this.f30765oIX0oI.oIX0oI();
    }

    @Override // kotlinx.serialization.I0Io
    public /* bridge */ /* synthetic */ Object oxoX(xIXoO0Xx.XO xo2) {
        XO(xo2);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }
}
