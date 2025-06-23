package kotlinx.datetime.serializers;

import IOI.oOoXoXO;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlinx.serialization.Oxx0xo;
import kotlinx.serialization.SealedClassSerializer;

/* loaded from: classes6.dex */
public final class DateBasedDateTimeUnitSerializer extends kotlinx.serialization.internal.II0xO0<oOoXoXO.II0xO0> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final DateBasedDateTimeUnitSerializer f30504oIX0oI = new DateBasedDateTimeUnitSerializer();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0IIOO f30503II0xO0 = XIxXXX0x0.I0Io(LazyThreadSafetyMode.PUBLICATION, new Oox.oIX0oI<SealedClassSerializer<oOoXoXO.II0xO0>>() { // from class: kotlinx.datetime.serializers.DateBasedDateTimeUnitSerializer$impl$2
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final SealedClassSerializer<oOoXoXO.II0xO0> invoke() {
            return new SealedClassSerializer<>("kotlinx.datetime.DateTimeUnit.DateBased", IO.oxoX(oOoXoXO.II0xO0.class), new kotlin.reflect.oxoX[]{IO.oxoX(oOoXoXO.I0Io.class), IO.oxoX(oOoXoXO.oxoX.class)}, new kotlinx.serialization.Oxx0IOOO[]{DayBasedDateTimeUnitSerializer.f30512oIX0oI, MonthBasedDateTimeUnitSerializer.f30528oIX0oI});
        }
    });

    public static /* synthetic */ void oOoXoXO() {
    }

    @Override // kotlinx.serialization.internal.II0xO0
    @kotlinx.serialization.XO
    @OXOo.oOoXoXO
    public kotlinx.serialization.I0Io<oOoXoXO.II0xO0> II0XooXoX(@OXOo.OOXIXo xIXoO0Xx.oxoX decoder, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(decoder, "decoder");
        return ooOOo0oXI().II0XooXoX(decoder, str);
    }

    @Override // kotlinx.serialization.internal.II0xO0
    @kotlinx.serialization.XO
    @OXOo.oOoXoXO
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public Oxx0xo<oOoXoXO.II0xO0> xxIXOIIO(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo oOoXoXO.II0xO0 value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        return ooOOo0oXI().xxIXOIIO(encoder, value);
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return ooOOo0oXI().oIX0oI();
    }

    public final SealedClassSerializer<oOoXoXO.II0xO0> ooOOo0oXI() {
        return (SealedClassSerializer) f30503II0xO0.getValue();
    }

    @Override // kotlinx.serialization.internal.II0xO0
    @OXOo.OOXIXo
    public kotlin.reflect.oxoX<oOoXoXO.II0xO0> xoIox() {
        return IO.oxoX(oOoXoXO.II0xO0.class);
    }
}
