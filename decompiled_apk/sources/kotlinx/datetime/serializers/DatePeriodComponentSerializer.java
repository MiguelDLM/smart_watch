package kotlinx.datetime.serializers;

import Oox.oOoXoXO;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.internal.OI0;
import kotlinx.serialization.internal.Xo0;

@XX({"SMAP\nDateTimePeriodSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTimePeriodSerializers.kt\nkotlinx/datetime/serializers/DatePeriodComponentSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n+ 3 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n1#1,181:1\n570#2,4:182\n475#3,4:186\n*S KotlinDebug\n*F\n+ 1 DateTimePeriodSerializers.kt\nkotlinx/datetime/serializers/DatePeriodComponentSerializer\n*L\n124#1:182,4\n145#1:186,4\n*E\n"})
/* loaded from: classes6.dex */
public final class DatePeriodComponentSerializer implements kotlinx.serialization.Oxx0IOOO<IOI.II0XooXoX> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final DatePeriodComponentSerializer f30506oIX0oI = new DatePeriodComponentSerializer();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30505II0xO0 = SerialDescriptorsKt.I0Io("DatePeriod", new kotlinx.serialization.descriptors.XO[0], new oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.datetime.serializers.DatePeriodComponentSerializer$descriptor$1
        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
            invoke2(oix0oi);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildClassSerialDescriptor) {
            IIX0o.x0xO0oo(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            List<? extends Annotation> ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
            OI0 oi0 = OI0.f30649oIX0oI;
            buildClassSerialDescriptor.oIX0oI("years", oi0.oIX0oI(), ooXIXxIX2, true);
            buildClassSerialDescriptor.oIX0oI("months", oi0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
            buildClassSerialDescriptor.oIX0oI("days", oi0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
            buildClassSerialDescriptor.oIX0oI("hours", oi0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
            buildClassSerialDescriptor.oIX0oI("minutes", oi0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
            buildClassSerialDescriptor.oIX0oI("seconds", oi0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
            buildClassSerialDescriptor.oIX0oI("nanoseconds", Xo0.f30710oIX0oI.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
        }
    });

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: II0XooXoX, reason: merged with bridge method [inline-methods] */
    public IOI.II0XooXoX oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            DatePeriodComponentSerializer datePeriodComponentSerializer = f30506oIX0oI;
            int decodeElementIndex = beginStructure.decodeElementIndex(datePeriodComponentSerializer.oIX0oI());
            switch (decodeElementIndex) {
                case -1:
                    IOI.II0XooXoX iI0XooXoX = new IOI.II0XooXoX(i, i2, i3);
                    beginStructure.endStructure(oIX0oI2);
                    return iI0XooXoX;
                case 0:
                    i = beginStructure.decodeIntElement(datePeriodComponentSerializer.oIX0oI(), 0);
                    break;
                case 1:
                    i2 = beginStructure.decodeIntElement(datePeriodComponentSerializer.oIX0oI(), 1);
                    break;
                case 2:
                    i3 = beginStructure.decodeIntElement(datePeriodComponentSerializer.oIX0oI(), 2);
                    break;
                case 3:
                    datePeriodComponentSerializer.xoIox("hours", beginStructure.decodeIntElement(datePeriodComponentSerializer.oIX0oI(), 3));
                    break;
                case 4:
                    datePeriodComponentSerializer.xoIox("minutes", beginStructure.decodeIntElement(datePeriodComponentSerializer.oIX0oI(), 4));
                    break;
                case 5:
                    datePeriodComponentSerializer.xoIox("seconds", beginStructure.decodeIntElement(datePeriodComponentSerializer.oIX0oI(), 5));
                    break;
                case 6:
                    datePeriodComponentSerializer.OOXIXo("nanoseconds", beginStructure.decodeLongElement(datePeriodComponentSerializer.oIX0oI(), 6));
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + decodeElementIndex);
            }
        }
    }

    public final void OOXIXo(String str, long j) {
        if (j == 0) {
            return;
        }
        throw new SerializationException("DatePeriod should have non-date components be zero, but got " + j + " in '" + str + '\'');
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30505II0xO0;
    }

    public final void xoIox(String str, int i) {
        OOXIXo(str, i);
    }

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo IOI.II0XooXoX value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI2);
        if (value.xoIox() != 0) {
            beginStructure.encodeIntElement(DateTimePeriodComponentSerializer.f30508oIX0oI.oIX0oI(), 0, value.xoIox());
        }
        if (value.X0o0xo() != 0) {
            beginStructure.encodeIntElement(DateTimePeriodComponentSerializer.f30508oIX0oI.oIX0oI(), 1, value.X0o0xo());
        }
        if (value.II0xO0() != 0) {
            beginStructure.encodeIntElement(DateTimePeriodComponentSerializer.f30508oIX0oI.oIX0oI(), 2, value.II0xO0());
        }
        beginStructure.endStructure(oIX0oI2);
    }
}
