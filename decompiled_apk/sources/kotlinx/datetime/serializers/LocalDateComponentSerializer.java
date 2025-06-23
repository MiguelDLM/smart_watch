package kotlinx.datetime.serializers;

import IOI.xoxXI;
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

@XX({"SMAP\nLocalDateSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalDateSerializers.kt\nkotlinx/datetime/serializers/LocalDateComponentSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n+ 3 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n1#1,80:1\n570#2,4:81\n475#3,4:85\n*S KotlinDebug\n*F\n+ 1 LocalDateSerializers.kt\nkotlinx/datetime/serializers/LocalDateComponentSerializer\n*L\n52#1:81,4\n72#1:85,4\n*E\n"})
/* loaded from: classes6.dex */
public final class LocalDateComponentSerializer implements kotlinx.serialization.Oxx0IOOO<xoxXI> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final LocalDateComponentSerializer f30522oIX0oI = new LocalDateComponentSerializer();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30521II0xO0 = SerialDescriptorsKt.I0Io("LocalDate", new kotlinx.serialization.descriptors.XO[0], new oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.datetime.serializers.LocalDateComponentSerializer$descriptor$1
        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
            invoke2(oix0oi);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildClassSerialDescriptor) {
            IIX0o.x0xO0oo(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            buildClassSerialDescriptor.oIX0oI("year", OI0.f30649oIX0oI.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), false);
            List<? extends Annotation> ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
            xx0X0 xx0x0 = xx0X0.f30770oIX0oI;
            buildClassSerialDescriptor.oIX0oI("month", xx0x0.oIX0oI(), ooXIXxIX2, false);
            buildClassSerialDescriptor.oIX0oI("day", xx0x0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), false);
        }
    });

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo xoxXI value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI2);
        LocalDateComponentSerializer localDateComponentSerializer = f30522oIX0oI;
        beginStructure.encodeIntElement(localDateComponentSerializer.oIX0oI(), 0, value.x0XOIxOo());
        beginStructure.encodeShortElement(localDateComponentSerializer.oIX0oI(), 1, (short) value.oOoXoXO());
        beginStructure.encodeShortElement(localDateComponentSerializer.oIX0oI(), 2, (short) value.Oxx0IOOO());
        beginStructure.endStructure(oIX0oI2);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public xoxXI oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        Integer num = null;
        Short sh = null;
        Short sh2 = null;
        while (true) {
            LocalDateComponentSerializer localDateComponentSerializer = f30522oIX0oI;
            int decodeElementIndex = beginStructure.decodeElementIndex(localDateComponentSerializer.oIX0oI());
            if (decodeElementIndex != -1) {
                if (decodeElementIndex != 0) {
                    if (decodeElementIndex != 1) {
                        if (decodeElementIndex == 2) {
                            sh2 = Short.valueOf(beginStructure.decodeShortElement(localDateComponentSerializer.oIX0oI(), 2));
                        } else {
                            throw new SerializationException("Unexpected index: " + decodeElementIndex);
                        }
                    } else {
                        sh = Short.valueOf(beginStructure.decodeShortElement(localDateComponentSerializer.oIX0oI(), 1));
                    }
                } else {
                    num = Integer.valueOf(beginStructure.decodeIntElement(localDateComponentSerializer.oIX0oI(), 0));
                }
            } else {
                if (num != null) {
                    if (sh != null) {
                        if (sh2 != null) {
                            xoxXI xoxxi = new xoxXI(num.intValue(), sh.shortValue(), sh2.shortValue());
                            beginStructure.endStructure(oIX0oI2);
                            return xoxxi;
                        }
                        throw new MissingFieldException("day");
                    }
                    throw new MissingFieldException("month");
                }
                throw new MissingFieldException("year");
            }
        }
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30521II0xO0;
    }
}
