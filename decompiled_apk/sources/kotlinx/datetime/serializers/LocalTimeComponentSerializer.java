package kotlinx.datetime.serializers;

import IOI.x0OIX00oO;
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

@XX({"SMAP\nLocalTimeSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalTimeSerializers.kt\nkotlinx/datetime/serializers/LocalTimeComponentSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n+ 3 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n1#1,85:1\n570#2,4:86\n475#3,4:90\n*S KotlinDebug\n*F\n+ 1 LocalTimeSerializers.kt\nkotlinx/datetime/serializers/LocalTimeComponentSerializer\n*L\n52#1:86,4\n73#1:90,4\n*E\n"})
/* loaded from: classes6.dex */
public final class LocalTimeComponentSerializer implements kotlinx.serialization.Oxx0IOOO<x0OIX00oO> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final LocalTimeComponentSerializer f30526oIX0oI = new LocalTimeComponentSerializer();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30525II0xO0 = SerialDescriptorsKt.I0Io("LocalTime", new kotlinx.serialization.descriptors.XO[0], new oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.datetime.serializers.LocalTimeComponentSerializer$descriptor$1
        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
            invoke2(oix0oi);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildClassSerialDescriptor) {
            IIX0o.x0xO0oo(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            List<? extends Annotation> ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
            xx0X0 xx0x0 = xx0X0.f30770oIX0oI;
            buildClassSerialDescriptor.oIX0oI("hour", xx0x0.oIX0oI(), ooXIXxIX2, false);
            buildClassSerialDescriptor.oIX0oI("minute", xx0x0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), false);
            buildClassSerialDescriptor.oIX0oI("second", xx0x0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
            buildClassSerialDescriptor.oIX0oI("nanosecond", OI0.f30649oIX0oI.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
        }
    });

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo x0OIX00oO value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI2);
        LocalTimeComponentSerializer localTimeComponentSerializer = f30526oIX0oI;
        beginStructure.encodeShortElement(localTimeComponentSerializer.oIX0oI(), 0, (short) value.Oxx0IOOO());
        beginStructure.encodeShortElement(localTimeComponentSerializer.oIX0oI(), 1, (short) value.II0XooXoX());
        if (value.OOXIXo() != 0 || value.xoIox() != 0) {
            beginStructure.encodeShortElement(localTimeComponentSerializer.oIX0oI(), 2, (short) value.OOXIXo());
            if (value.xoIox() != 0) {
                beginStructure.encodeIntElement(localTimeComponentSerializer.oIX0oI(), 3, value.xoIox());
            }
        }
        beginStructure.endStructure(oIX0oI2);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public x0OIX00oO oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        Short sh = null;
        Short sh2 = null;
        short s = 0;
        int i = 0;
        while (true) {
            LocalTimeComponentSerializer localTimeComponentSerializer = f30526oIX0oI;
            int decodeElementIndex = beginStructure.decodeElementIndex(localTimeComponentSerializer.oIX0oI());
            if (decodeElementIndex != -1) {
                if (decodeElementIndex != 0) {
                    if (decodeElementIndex != 1) {
                        if (decodeElementIndex != 2) {
                            if (decodeElementIndex == 3) {
                                i = beginStructure.decodeIntElement(localTimeComponentSerializer.oIX0oI(), 3);
                            } else {
                                throw new SerializationException("Unexpected index: " + decodeElementIndex);
                            }
                        } else {
                            s = beginStructure.decodeShortElement(localTimeComponentSerializer.oIX0oI(), 2);
                        }
                    } else {
                        sh2 = Short.valueOf(beginStructure.decodeShortElement(localTimeComponentSerializer.oIX0oI(), 1));
                    }
                } else {
                    sh = Short.valueOf(beginStructure.decodeShortElement(localTimeComponentSerializer.oIX0oI(), 0));
                }
            } else {
                if (sh != null) {
                    if (sh2 != null) {
                        x0OIX00oO x0oix00oo = new x0OIX00oO(sh.shortValue(), sh2.shortValue(), s, i);
                        beginStructure.endStructure(oIX0oI2);
                        return x0oix00oo;
                    }
                    throw new MissingFieldException("minute");
                }
                throw new MissingFieldException("hour");
            }
        }
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30525II0xO0;
    }
}
