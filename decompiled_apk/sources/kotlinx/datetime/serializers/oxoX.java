package kotlinx.datetime.serializers;

import IOI.Oxx0xo;
import IOI.X0xxXX0;
import kotlin.jvm.internal.IIX0o;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.X0o0xo;

/* loaded from: classes6.dex */
public final class oxoX implements kotlinx.serialization.Oxx0IOOO<Oxx0xo> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oxoX f30542oIX0oI = new oxoX();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30541II0xO0 = SerialDescriptorsKt.oIX0oI("FixedOffsetTimeZone", X0o0xo.xxIXOIIO.f30595oIX0oI);

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo Oxx0xo value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        encoder.encodeString(value.II0xO0());
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Oxx0xo oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        X0xxXX0 oxoX2 = X0xxXX0.Companion.oxoX(decoder.decodeString());
        if (oxoX2 instanceof Oxx0xo) {
            return (Oxx0xo) oxoX2;
        }
        throw new SerializationException("Timezone identifier '" + oxoX2 + "' does not correspond to a fixed-offset timezone");
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30541II0xO0;
    }
}
