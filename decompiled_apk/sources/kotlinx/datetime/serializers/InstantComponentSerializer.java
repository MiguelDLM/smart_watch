package kotlinx.datetime.serializers;

import IOI.IIX0o;
import Oox.oOoXoXO;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.internal.Xo0;

@XX({"SMAP\nInstantSerializers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InstantSerializers.kt\nkotlinx/datetime/serializers/InstantComponentSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n+ 3 Encoding.kt\nkotlinx/serialization/encoding/EncodingKt\n*L\n1#1,76:1\n570#2,4:77\n475#3,4:81\n*S KotlinDebug\n*F\n+ 1 InstantSerializers.kt\nkotlinx/datetime/serializers/InstantComponentSerializer\n*L\n51#1:77,4\n67#1:81,4\n*E\n"})
/* loaded from: classes6.dex */
public final class InstantComponentSerializer implements kotlinx.serialization.Oxx0IOOO<IIX0o> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final InstantComponentSerializer f30520oIX0oI = new InstantComponentSerializer();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlinx.serialization.descriptors.XO f30519II0xO0 = SerialDescriptorsKt.I0Io("Instant", new kotlinx.serialization.descriptors.XO[0], new oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, oXIO0o0XI>() { // from class: kotlinx.datetime.serializers.InstantComponentSerializer$descriptor$1
        @Override // Oox.oOoXoXO
        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
            invoke2(oix0oi);
            return oXIO0o0XI.f29392oIX0oI;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildClassSerialDescriptor) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            List<? extends Annotation> ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
            Xo0 xo0 = Xo0.f30710oIX0oI;
            buildClassSerialDescriptor.oIX0oI("epochSeconds", xo0.oIX0oI(), ooXIXxIX2, false);
            buildClassSerialDescriptor.oIX0oI("nanosecondsOfSecond", xo0.oIX0oI(), CollectionsKt__CollectionsKt.ooXIXxIX(), true);
        }
    });

    @Override // kotlinx.serialization.Oxx0xo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo IIX0o value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.X0o0xo beginStructure = encoder.beginStructure(oIX0oI2);
        InstantComponentSerializer instantComponentSerializer = f30520oIX0oI;
        beginStructure.encodeLongElement(instantComponentSerializer.oIX0oI(), 0, value.xoIox());
        if (value.OOXIXo() != 0) {
            beginStructure.encodeIntElement(instantComponentSerializer.oIX0oI(), 1, value.OOXIXo());
        }
        beginStructure.endStructure(oIX0oI2);
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public IIX0o oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        Long l = null;
        int i = 0;
        while (true) {
            InstantComponentSerializer instantComponentSerializer = f30520oIX0oI;
            int decodeElementIndex = beginStructure.decodeElementIndex(instantComponentSerializer.oIX0oI());
            if (decodeElementIndex != -1) {
                if (decodeElementIndex != 0) {
                    if (decodeElementIndex == 1) {
                        i = beginStructure.decodeIntElement(instantComponentSerializer.oIX0oI(), 1);
                    } else {
                        throw new SerializationException("Unexpected index: " + decodeElementIndex);
                    }
                } else {
                    l = Long.valueOf(beginStructure.decodeLongElement(instantComponentSerializer.oIX0oI(), 0));
                }
            } else {
                if (l != null) {
                    IIX0o I0Io2 = IIX0o.Companion.I0Io(l.longValue(), i);
                    beginStructure.endStructure(oIX0oI2);
                    return I0Io2;
                }
                throw new MissingFieldException("epochSeconds");
            }
        }
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return f30519II0xO0;
    }
}
