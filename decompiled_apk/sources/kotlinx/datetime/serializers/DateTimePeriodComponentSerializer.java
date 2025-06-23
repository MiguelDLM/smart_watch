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

@XX({"SMAP\nDateTimePeriodSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTimePeriodSerializers.kt\nkotlinx/datetime/serializers/DateTimePeriodComponentSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n+ 3 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n1#1,181:1\n570#2,4:182\n475#3,4:186\n*S KotlinDebug\n*F\n+ 1 DateTimePeriodSerializers.kt\nkotlinx/datetime/serializers/DateTimePeriodComponentSerializer\n*L\n33#1:182,4\n58#1:186,4\n*E\n"})
/* loaded from: classes6.dex */
public final class DateTimePeriodComponentSerializer implements kotlinx.serialization.Oxx0IOOO<IOI.xxIXOIIO> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final DateTimePeriodComponentSerializer f30508oIX0oI = new DateTimePeriodComponentSerializer();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30507II0xO0 = SerialDescriptorsKt.I0Io("DateTimePeriod", new kotlinx.serialization.descriptors.XO[0], new oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.datetime.serializers.DateTimePeriodComponentSerializer$descriptor$1
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

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo IOI.xxIXOIIO value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI2);
        if (value.xoIox() != 0) {
            beginStructure.encodeIntElement(f30508oIX0oI.oIX0oI(), 0, value.xoIox());
        }
        if (value.X0o0xo() != 0) {
            beginStructure.encodeIntElement(f30508oIX0oI.oIX0oI(), 1, value.X0o0xo());
        }
        if (value.II0xO0() != 0) {
            beginStructure.encodeIntElement(f30508oIX0oI.oIX0oI(), 2, value.II0xO0());
        }
        if (value.I0Io() != 0) {
            beginStructure.encodeIntElement(f30508oIX0oI.oIX0oI(), 3, value.I0Io());
        }
        if (value.oxoX() != 0) {
            beginStructure.encodeIntElement(f30508oIX0oI.oIX0oI(), 4, value.oxoX());
        }
        if (value.Oxx0IOOO() != 0) {
            beginStructure.encodeIntElement(f30508oIX0oI.oIX0oI(), 5, value.Oxx0IOOO());
        }
        if (value.XO() != 0) {
            beginStructure.encodeLongElement(f30508oIX0oI.oIX0oI(), 6, value.XO());
        }
        beginStructure.endStructure(oIX0oI2);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public IOI.xxIXOIIO oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            DateTimePeriodComponentSerializer dateTimePeriodComponentSerializer = f30508oIX0oI;
            int decodeElementIndex = beginStructure.decodeElementIndex(dateTimePeriodComponentSerializer.oIX0oI());
            switch (decodeElementIndex) {
                case -1:
                    IOI.xxIXOIIO oIX0oI3 = IOI.OOXIXo.oIX0oI(i, i2, i3, i4, i5, i6, j);
                    beginStructure.endStructure(oIX0oI2);
                    return oIX0oI3;
                case 0:
                    i = beginStructure.decodeIntElement(dateTimePeriodComponentSerializer.oIX0oI(), 0);
                    break;
                case 1:
                    i2 = beginStructure.decodeIntElement(dateTimePeriodComponentSerializer.oIX0oI(), 1);
                    break;
                case 2:
                    i3 = beginStructure.decodeIntElement(dateTimePeriodComponentSerializer.oIX0oI(), 2);
                    break;
                case 3:
                    i4 = beginStructure.decodeIntElement(dateTimePeriodComponentSerializer.oIX0oI(), 3);
                    break;
                case 4:
                    i5 = beginStructure.decodeIntElement(dateTimePeriodComponentSerializer.oIX0oI(), 4);
                    break;
                case 5:
                    i6 = beginStructure.decodeIntElement(dateTimePeriodComponentSerializer.oIX0oI(), 5);
                    break;
                case 6:
                    j = beginStructure.decodeLongElement(dateTimePeriodComponentSerializer.oIX0oI(), 6);
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + decodeElementIndex);
            }
        }
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30507II0xO0;
    }
}
