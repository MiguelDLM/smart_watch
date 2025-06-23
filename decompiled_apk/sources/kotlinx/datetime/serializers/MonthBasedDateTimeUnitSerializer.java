package kotlinx.datetime.serializers;

import IOI.oOoXoXO;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.internal.OI0;

@XX({"SMAP\nDateTimeUnitSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTimeUnitSerializers.kt\nkotlinx/datetime/serializers/MonthBasedDateTimeUnitSerializer\n+ 2 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n+ 3 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n*L\n1#1,227:1\n475#2,4:228\n570#3,4:232\n*S KotlinDebug\n*F\n+ 1 DateTimeUnitSerializers.kt\nkotlinx/datetime/serializers/MonthBasedDateTimeUnitSerializer\n*L\n126#1:228,4\n136#1:232,4\n*E\n"})
/* loaded from: classes6.dex */
public final class MonthBasedDateTimeUnitSerializer implements kotlinx.serialization.Oxx0IOOO<oOoXoXO.oxoX> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final MonthBasedDateTimeUnitSerializer f30528oIX0oI = new MonthBasedDateTimeUnitSerializer();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0IIOO f30527II0xO0 = XIxXXX0x0.I0Io(LazyThreadSafetyMode.PUBLICATION, new Oox.oIX0oI<kotlinx.serialization.descriptors.XO>() { // from class: kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer$descriptor$2
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final kotlinx.serialization.descriptors.XO invoke() {
            return SerialDescriptorsKt.I0Io("MonthBased", new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer$descriptor$2.1
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
                    invoke2(oix0oi);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildClassSerialDescriptor) {
                    IIX0o.x0xO0oo(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                    buildClassSerialDescriptor.oIX0oI("months", OI0.f30649oIX0oI.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), false);
                }
            });
        }
    });

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo oOoXoXO.oxoX value) {
        IIX0o.x0xO0oo(encoder, "encoder");
        IIX0o.x0xO0oo(value, "value");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI2);
        beginStructure.encodeIntElement(f30528oIX0oI.oIX0oI(), 0, value.IXxxXO());
        beginStructure.endStructure(oIX0oI2);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public oOoXoXO.oxoX oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        int i;
        IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        boolean z = true;
        if (beginStructure.decodeSequentially()) {
            i = beginStructure.decodeIntElement(f30528oIX0oI.oIX0oI(), 0);
        } else {
            i = 0;
            boolean z2 = false;
            while (true) {
                MonthBasedDateTimeUnitSerializer monthBasedDateTimeUnitSerializer = f30528oIX0oI;
                int decodeElementIndex = beginStructure.decodeElementIndex(monthBasedDateTimeUnitSerializer.oIX0oI());
                if (decodeElementIndex != -1) {
                    if (decodeElementIndex == 0) {
                        i = beginStructure.decodeIntElement(monthBasedDateTimeUnitSerializer.oIX0oI(), 0);
                        z2 = true;
                    } else {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                } else {
                    z = z2;
                    break;
                }
            }
        }
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        beginStructure.endStructure(oIX0oI2);
        if (z) {
            return new oOoXoXO.oxoX(i);
        }
        throw new MissingFieldException("months");
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return (kotlinx.serialization.descriptors.XO) f30527II0xO0.getValue();
    }
}
