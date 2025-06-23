package kotlinx.datetime.serializers;

import IOI.xoxXI;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.X0o0xo;

/* loaded from: classes6.dex */
public final class XO implements kotlinx.serialization.Oxx0IOOO<xoxXI> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XO f30538oIX0oI = new XO();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30537II0xO0 = SerialDescriptorsKt.oIX0oI("LocalDate", X0o0xo.xxIXOIIO.f30595oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo xoxXI value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        encoder.encodeString(value.toString());
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public xoxXI oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        return xoxXI.Companion.oxoX(decoder.decodeString());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30537II0xO0;
    }
}
