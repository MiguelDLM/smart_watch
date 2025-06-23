package kotlinx.datetime.serializers;

import IOI.xOOOX;
import Oox.oOoXoXO;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.internal.OI0;
import kotlinx.serialization.internal.xx0X0;

@XX({"SMAP\nLocalDateTimeSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalDateTimeSerializers.kt\nkotlinx/datetime/serializers/LocalDateTimeComponentSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n+ 3 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n1#1,102:1\n570#2,4:103\n475#3,4:107\n*S KotlinDebug\n*F\n+ 1 LocalDateTimeSerializers.kt\nkotlinx/datetime/serializers/LocalDateTimeComponentSerializer\n*L\n56#1:103,4\n86#1:107,4\n*E\n"})
/* loaded from: classes6.dex */
public final class LocalDateTimeComponentSerializer implements kotlinx.serialization.Oxx0IOOO<xOOOX> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final LocalDateTimeComponentSerializer f30524oIX0oI = new LocalDateTimeComponentSerializer();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30523II0xO0 = SerialDescriptorsKt.I0Io("LocalDateTime", new kotlinx.serialization.descriptors.XO[0], new oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.datetime.serializers.LocalDateTimeComponentSerializer$descriptor$1
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
            buildClassSerialDescriptor.oIX0oI("year", oi0.oIX0oI(), ooXIXxIX2, false);
            List<? extends Annotation> ooXIXxIX3 = CollectionsKt__CollectionsKt.ooXIXxIX();
            xx0X0 xx0x0 = xx0X0.f30770oIX0oI;
            buildClassSerialDescriptor.oIX0oI("month", xx0x0.oIX0oI(), ooXIXxIX3, false);
            buildClassSerialDescriptor.oIX0oI("day", xx0x0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), false);
            buildClassSerialDescriptor.oIX0oI("hour", xx0x0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), false);
            buildClassSerialDescriptor.oIX0oI("minute", xx0x0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), false);
            buildClassSerialDescriptor.oIX0oI("second", xx0x0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
            buildClassSerialDescriptor.oIX0oI("nanosecond", oi0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
        }
    });

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo xOOOX value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI2);
        LocalDateTimeComponentSerializer localDateTimeComponentSerializer = f30524oIX0oI;
        beginStructure.encodeIntElement(localDateTimeComponentSerializer.oIX0oI(), 0, value.oI0IIXIo());
        beginStructure.encodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 1, (short) value.oO());
        beginStructure.encodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 2, (short) value.II0XooXoX());
        beginStructure.encodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 3, (short) value.oOoXoXO());
        beginStructure.encodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 4, (short) value.ooOOo0oXI());
        if (value.Oo() != 0 || value.x0xO0oo() != 0) {
            beginStructure.encodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 5, (short) value.Oo());
            if (value.x0xO0oo() != 0) {
                beginStructure.encodeIntElement(localDateTimeComponentSerializer.oIX0oI(), 6, value.x0xO0oo());
            }
        }
        beginStructure.endStructure(oIX0oI2);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public xOOOX oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        Integer num = null;
        Short sh = null;
        Short sh2 = null;
        Short sh3 = null;
        Short sh4 = null;
        short s = 0;
        int i = 0;
        while (true) {
            LocalDateTimeComponentSerializer localDateTimeComponentSerializer = f30524oIX0oI;
            int decodeElementIndex = beginStructure.decodeElementIndex(localDateTimeComponentSerializer.oIX0oI());
            switch (decodeElementIndex) {
                case -1:
                    if (num != null) {
                        if (sh != null) {
                            if (sh2 != null) {
                                if (sh3 != null) {
                                    if (sh4 != null) {
                                        xOOOX xooox = new xOOOX(num.intValue(), sh.shortValue(), sh2.shortValue(), sh3.shortValue(), sh4.shortValue(), s, i);
                                        beginStructure.endStructure(oIX0oI2);
                                        return xooox;
                                    }
                                    throw new MissingFieldException("minute");
                                }
                                throw new MissingFieldException("hour");
                            }
                            throw new MissingFieldException("day");
                        }
                        throw new MissingFieldException("month");
                    }
                    throw new MissingFieldException("year");
                case 0:
                    num = Integer.valueOf(beginStructure.decodeIntElement(localDateTimeComponentSerializer.oIX0oI(), 0));
                    break;
                case 1:
                    sh = Short.valueOf(beginStructure.decodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 1));
                    break;
                case 2:
                    sh2 = Short.valueOf(beginStructure.decodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 2));
                    break;
                case 3:
                    sh3 = Short.valueOf(beginStructure.decodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 3));
                    break;
                case 4:
                    sh4 = Short.valueOf(beginStructure.decodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 4));
                    break;
                case 5:
                    s = beginStructure.decodeShortElement(localDateTimeComponentSerializer.oIX0oI(), 5);
                    break;
                case 6:
                    i = beginStructure.decodeIntElement(localDateTimeComponentSerializer.oIX0oI(), 6);
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + decodeElementIndex);
            }
        }
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30523II0xO0;
    }
}
