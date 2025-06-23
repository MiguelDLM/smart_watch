package kotlinx.datetime.serializers;

import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.X0o0xo;

/* loaded from: classes6.dex */
public final class oIX0oI implements kotlinx.serialization.Oxx0IOOO<IOI.II0XooXoX> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f30540oIX0oI = new oIX0oI();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30539II0xO0 = SerialDescriptorsKt.oIX0oI("DatePeriod", X0o0xo.xxIXOIIO.f30595oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo IOI.II0XooXoX value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        encoder.encodeString(value.toString());
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public IOI.II0XooXoX oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        IOI.xxIXOIIO oIX0oI2 = IOI.xxIXOIIO.Companion.oIX0oI(decoder.decodeString());
        if (oIX0oI2 instanceof IOI.II0XooXoX) {
            return (IOI.II0XooXoX) oIX0oI2;
        }
        throw new SerializationException(oIX0oI2 + " is not a date-based period");
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30539II0xO0;
    }
}
