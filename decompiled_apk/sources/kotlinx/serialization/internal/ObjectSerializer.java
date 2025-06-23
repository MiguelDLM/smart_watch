package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.xxIXOIIO;

@kotlin.jvm.internal.XX({"SMAP\nObjectSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectSerializer.kt\nkotlinx/serialization/internal/ObjectSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n*L\n1#1,57:1\n570#2,4:58\n*S KotlinDebug\n*F\n+ 1 ObjectSerializer.kt\nkotlinx/serialization/internal/ObjectSerializer\n*L\n43#1:58,4\n*E\n"})
@kotlin.o0
/* loaded from: classes6.dex */
public final class ObjectSerializer<T> implements kotlinx.serialization.Oxx0IOOO<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.X0IIOO f30656I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<? extends Annotation> f30657II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T f30658oIX0oI;

    public ObjectSerializer(@OXOo.OOXIXo final String serialName, @OXOo.OOXIXo T objectInstance) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(objectInstance, "objectInstance");
        this.f30658oIX0oI = objectInstance;
        this.f30657II0xO0 = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.f30656I0Io = kotlin.XIxXXX0x0.I0Io(LazyThreadSafetyMode.PUBLICATION, new Oox.oIX0oI<kotlinx.serialization.descriptors.XO>() { // from class: kotlinx.serialization.internal.ObjectSerializer$descriptor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final kotlinx.serialization.descriptors.XO invoke() {
                final ObjectSerializer<T> objectSerializer = this;
                return SerialDescriptorsKt.X0o0xo(serialName, xxIXOIIO.oxoX.f30611oIX0oI, new kotlinx.serialization.descriptors.XO[0], new Oox.oOoXoXO<kotlinx.serialization.descriptors.oIX0oI, kotlin.oXIO0o0XI>() { // from class: kotlinx.serialization.internal.ObjectSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(kotlinx.serialization.descriptors.oIX0oI oix0oi) {
                        invoke2(oix0oi);
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo kotlinx.serialization.descriptors.oIX0oI buildSerialDescriptor) {
                        List<? extends Annotation> list;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        list = objectSerializer.f30657II0xO0;
                        buildSerialDescriptor.oOoXoXO(list);
                    }
                });
            }
        });
    }

    @Override // kotlinx.serialization.Oxx0xo
    public void II0xO0(@OXOo.OOXIXo xIXoO0Xx.II0XooXoX encoder, @OXOo.OOXIXo T value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(encoder, "encoder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        encoder.beginStructure(oIX0oI()).endStructure(oIX0oI());
    }

    @Override // kotlinx.serialization.Oxx0IOOO, kotlinx.serialization.Oxx0xo, kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public kotlinx.serialization.descriptors.XO oIX0oI() {
        return (kotlinx.serialization.descriptors.XO) this.f30656I0Io.getValue();
    }

    @Override // kotlinx.serialization.I0Io
    @OXOo.OOXIXo
    public T oxoX(@OXOo.OOXIXo xIXoO0Xx.XO decoder) {
        int decodeElementIndex;
        kotlin.jvm.internal.IIX0o.x0xO0oo(decoder, "decoder");
        kotlinx.serialization.descriptors.XO oIX0oI2 = oIX0oI();
        xIXoO0Xx.oxoX beginStructure = decoder.beginStructure(oIX0oI2);
        if (beginStructure.decodeSequentially() || (decodeElementIndex = beginStructure.decodeElementIndex(oIX0oI())) == -1) {
            kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
            beginStructure.endStructure(oIX0oI2);
            return this.f30658oIX0oI;
        }
        throw new SerializationException("Unexpected index " + decodeElementIndex);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.o0
    public ObjectSerializer(@OXOo.OOXIXo String serialName, @OXOo.OOXIXo T objectInstance, @OXOo.OOXIXo Annotation[] classAnnotations) {
        this(serialName, objectInstance);
        kotlin.jvm.internal.IIX0o.x0xO0oo(serialName, "serialName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(objectInstance, "objectInstance");
        kotlin.jvm.internal.IIX0o.x0xO0oo(classAnnotations, "classAnnotations");
        this.f30657II0xO0 = kotlin.collections.ooOOo0oXI.oI0IIXIo(classAnnotations);
    }
}
